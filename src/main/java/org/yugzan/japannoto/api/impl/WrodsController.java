package org.yugzan.japannoto.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yugzan.japannoto.api.ApiController;
import org.yugzan.japannoto.model.Word;

/**
 * @author yugzan
 * @date 2015年8月30日
 * @project japanno-to
 */
@RestController
public class WrodsController extends ApiController {

	@RequestMapping(value = WORDS_URL, method = RequestMethod.GET)
	public List<Word> list() {
		ArrayList<Word> list= new ArrayList<Word>();
		list.add(new Word());
		return list;
	}
}
