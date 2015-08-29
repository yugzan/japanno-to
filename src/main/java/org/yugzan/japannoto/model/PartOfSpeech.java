package org.yugzan.japannoto.model;

import java.util.Objects;
import java.util.Arrays;

/**
 * @author yugzan
 * @date 2015年8月30日
 * @project japanno-to
 */
public enum PartOfSpeech {
	N("名詞"), 
	V("動詞"), 
	iADJ("い形容詞"), 
	naADJ("な形容詞"), 
	ADV("副詞");

	private String value;

	PartOfSpeech(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
	public static PartOfSpeech of(String value){
	    Objects.requireNonNull(value, "value is null");
	    return Arrays.stream(PartOfSpeech.values()).filter(speech -> speech.value().equals(value))
	        .findAny().get();
	}
}
