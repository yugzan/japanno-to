package org.yugzan.japannoto.model;

/**
 * @author  yugzan
 * @date    2015年9月21日
 * @project japanno-to
 */
public class ModelMapper {
	public static Word WordToMongoDB(Word word,Word db){
		db.setEnglish(word.getEnglish());
		db.setExample(word.getExample());
		db.setFormation(word.getFormation());
		db.setGroup(word.getGroup());
		db.setHiragana(word.getHiragana());
		db.setKatakana(word.getKatakana());
		db.setMean(word.getMean());
		db.setPartOfSpeech(word.getPartOfSpeech());
		db.setRelateWord(word.getRelateWord());
		db.setRoma(word.getRoma());
		db.setSituational(word.getSituational());
		db.setTag(word.getTag());
		db.setWord(word.getWord());
		return db;
	}
}

