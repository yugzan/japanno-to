package org.yugzan.japannoto.api;

/**
 * @author  yugzan
 * @date    2015年8月30日
 * @project japanno-to
 */
public abstract class ApiController {
	private static final String API_PATH = "/api/v1";
	
	public static final String WORDS_URL = API_PATH + "/words";
	
	public static final String GRAMMERS_URL = API_PATH + "/grammars";
}

