package org.yugzan.japannoto.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yugzan.japannoto.model.ModelMapper;
import org.yugzan.japannoto.model.Word;
import org.yugzan.japannoto.repo.WordRepository;

/**
 * @author  yugzan
 * @date    2015年9月17日
 * @project japanno-to
 */
@Service
public class WordResourceService implements ResourceService<Word>{

	@Autowired
	private WordRepository repo;

	@Override
	public Optional<Word> create(Word word) {
		return Optional.ofNullable(repo.insert(word));
	}


	@Override
	public Optional<Word> update(BigInteger id, Word word) {
		Optional<Word> fromdb = get(id);
		
		return (fromdb.isPresent())?
				Optional.of(repo.save(ModelMapper.WordToMongoDB(word, fromdb.get())) ):
				Optional.empty();

	}


	@Override
	public Optional<List<Word>> list() {
		return Optional.ofNullable(repo.findAll());
	}
	
	public Long count() {
		return repo.count();
	}
	

	@Override
	public Optional<Word> get(BigInteger id) {
		String value = BigIntegerToStringConverter.INSTANCE.convert(id);

		return Optional.ofNullable(repo.findById(value ));
	}

	@Override
	public void delete(BigInteger integer) {
		repo.delete(BigIntegerToStringConverter.INSTANCE.convert(integer));
		
	}

	public Optional<Word> findByWord(String word){
		return Optional.ofNullable(repo.findByWord(word));
	}
	
	public Optional<List<Word>> findByRoma(String roma){
		return Optional.ofNullable(repo.findByRoma(roma));
	}
}

