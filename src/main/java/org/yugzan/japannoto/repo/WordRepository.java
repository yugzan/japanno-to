package org.yugzan.japannoto.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.yugzan.japannoto.model.Word;

/**
 * @author  yugzan
 * @date    2015年9月17日
 * @project japanno-to
 */
public interface WordRepository extends MongoRepository<Word, String>{
	
	public Word findById(String id);
	
	public Word findByWord(String word);
	
	public List<Word> findByRoma(String roma);
}

