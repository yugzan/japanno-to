package org.yugzan.japannoto.api.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.yugzan.japannoto.api.ApiController;
import org.yugzan.japannoto.model.ResourceCollection;
import org.yugzan.japannoto.model.ResourceNotFoundException;
import org.yugzan.japannoto.model.Link;
import org.yugzan.japannoto.model.Link.REL;
import org.yugzan.japannoto.model.Resource;
import org.yugzan.japannoto.model.Word;
import org.yugzan.japannoto.service.WordResourceService;

/**
 * @author yugzan
 * @date 2015年8月30日
 * @project japanno-to
 */
@RestController
public class WrodsController extends ApiController {
	
	@Autowired
	private WordResourceService service; 
	
	/**
	 * FindByWord
	 * GET /api/v1/words?word=
	 * {@link WordResourceService#findByWord(String)}
	 * */
	@RequestMapping(value = WORDS_URL, method = RequestMethod.GET ,params ="word")
	@ResponseStatus(HttpStatus.OK)
	public Resource<Word> findByWord(@PathParam("word") String word,HttpServletRequest request) {
		try{
			return new Resource<Word>(service.findByWord(word).get(),request);
		}catch(Exception e){
			throw new ResourceNotFoundException(String.format(ResourceNotFoundException.REASON,word));
		}
	}	
	/**
	 * FindByRoma
	 * GET /api/v1/words?roma=
	 * {@link WordResourceService#findByRoma(String)}
	 * */
	@RequestMapping(value = WORDS_URL, method = RequestMethod.GET ,params ="roma")
	@ResponseStatus(HttpStatus.OK)
	public ResourceCollection<Word> findByRoma(@PathParam("roma") String roma,HttpServletRequest request) {
		try{
			//TODO fuzzy search
			return new ResourceCollection<Word>(service.findByRoma(roma).get(),request);
		}catch(Exception e){
			throw new ResourceNotFoundException(String.format(ResourceNotFoundException.REASON,roma));
		}
	}
	
	@RequestMapping(value = WORDS_URL, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResourceCollection<Word> list(HttpServletRequest request) {
		try{
			List<Link> links = new ArrayList<>();
			links.add( new Link().setRel(REL.item).setHref(service.count() ));
			return new ResourceCollection<Word>(service.list().get() , links,request);
		}catch(Exception e){
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = WORD_ID_URL, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Resource<Word> get(@PathVariable("id")BigInteger id, HttpServletRequest request) {
		try{
			return new Resource<Word>(service.get(id).get(),request);
		}catch(Exception e){
			throw new ResourceNotFoundException(String.format(ResourceNotFoundException.REASON,id));
		}
	}
	
	@RequestMapping(value = WORDS_URL, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Resource<Word> create(@RequestBody Word word) {
		try{
			
		return new Resource<Word>(service.create(word).get());
			
		}catch(Exception e){
			throw new ResourceNotFoundException(e.getMessage());
		}

	}
	
	
	@RequestMapping(value = WORD_ID_URL, method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Resource<Word> update(@PathVariable("id")BigInteger id, @RequestBody Word word) {
		try{
			
		return new Resource<Word>(service.update(id, word).get());
			
		}catch(Exception e){
			throw new ResourceNotFoundException(String.format(ResourceNotFoundException.REASON,word.getWord()));
		}

	}
	
	public void delete(@PathVariable BigInteger id) {

	}
}
