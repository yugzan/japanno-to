package org.yugzan.japannoto.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yugzan.japannoto.api.ApiController;
import org.yugzan.japannoto.model.ResourceCollection;
import org.yugzan.japannoto.model.Link;
import org.yugzan.japannoto.model.Link.REL;
import org.yugzan.japannoto.model.Word;

/**
 * @author yugzan
 * @date 2015年8月30日
 * @project japanno-to
 */
@RestController
public class WrodsController extends ApiController {

	 
	@RequestMapping(value = WORDS_URL, method = RequestMethod.GET)
	public ResourceCollection<Word> list(HttpServletRequest request) {
		
		List<Word> list= new ArrayList<>();
		list.add(new Word());
		
		List<Link> links = new ArrayList<>();
		links.add( new Link().setRel(REL.last).setHref("url:last"));
		
		return new ResourceCollection<Word>(list, links,request);
	}
}
