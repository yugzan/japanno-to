package org.yugzan.japannoto.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.core.convert.converter.Converter;

/**
 * @author  yugzan
 * @param <E>
 * @date    2015年9月18日
 * @project japanno-to
 */
public interface ResourceService<E> {
	
	public abstract Optional<E> 		create(E e);
	public abstract Optional<E> 		update(BigInteger id,E e);
	public abstract Optional<List<E>> 	list();
	public abstract Optional<E> 		get(BigInteger id);
	public abstract void 				delete(BigInteger id);

	public static enum BigIntegerToStringConverter implements Converter<BigInteger, String> {
		INSTANCE;

		public String convert(BigInteger source) {
			return source == null ? null : source.toString(16);
		}
	}
}

