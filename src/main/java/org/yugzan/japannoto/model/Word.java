package org.yugzan.japannoto.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author  yugzan
 * @date    2015年8月30日
 * @project japanno-to
 */
@Document(collection = "words" )
public class Word extends AbstractDocument{


	/**
	 * roma 指單字羅馬拼音 ex.(hikiukeru)
	 * */
	private String roma;
	/**
	 * word 指單字 ex.(引き受ける)
	 * */
	private String word;
	/**
	 * hiragana 指平假名(ひらがな)ex.(ひきうける)
	 * */
	private String hiragana;
	/**
	 * katakana 指片假名(カタカナ)ex.(ヒキウケル)
	 * */
	private String katakana;
	/**
	 * mean 指單字所代表的意思
	 * */
	private String mean;
	/**
	 * English 指單字所代表的英文
	 * */
	private String english;
	
	private PartOfSpeech partOfSpeech;
	
	private String [] tag;
	
	private String formation;
	
	private String relateWord;
	
	private String [] group ;
	
	private String [] example;
	
	private String situational;


	public String getRoma() {
		return roma;
	}

	public void setRoma(String roma) {
		this.roma = roma;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getHiragana() {
		return hiragana;
	}

	public void setHiragana(String hiragana) {
		this.hiragana = hiragana;
	}

	public String getKatakana() {
		return katakana;
	}

	public void setKatakana(String katakana) {
		this.katakana = katakana;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public PartOfSpeech getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(PartOfSpeech partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}

	public String[] getTag() {
		return tag;
	}

	public void setTag(String[] tag) {
		this.tag = tag;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getRelateWord() {
		return relateWord;
	}

	public void setRelateWord(String relateWord) {
		this.relateWord = relateWord;
	}

	public String[] getGroup() {
		return group;
	}

	public void setGroup(String[] group) {
		this.group = group;
	}

	public String[] getExample() {
		return example;
	}

	public void setExample(String[] example) {
		this.example = example;
	}

	public String getSituational() {
		return situational;
	}

	public void setSituational(String situational) {
		this.situational = situational;
	}

	@Override
	public String toString() {
		return "Word [roma=" + roma + ", word=" + word + ", hiragana=" + hiragana
				+ ", katakana=" + katakana + ", mean=" + mean + ", english=" + english
				+ ", partOfSpeech=" + partOfSpeech + ", tag=" + Arrays.toString(tag)
				+ ", formation=" + formation + ", relateWord=" + relateWord + ", group="
				+ Arrays.toString(group) + ", example=" + Arrays.toString(example)
				+ ", situational=" + situational + "]";
	}
	


}

