package org.yugzan.japannoto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

/**
 * @author  yugzan
 * @date    2015年9月21日
 * @project japanno-to
 */
@Configuration
@EnableMongoRepositories("org.yugzan.japannoto")
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Value("${mongo.host:127.0.0.1}")
	private String host;

	@Value("${mongo.port:27017}")
	private int port;
	
	@Value("${mongo.dbname:test}")
	private String dbname;
	
	@Override
	protected String getDatabaseName() {
		return dbname;
	}


	@Override
	@Bean
	public Mongo mongo() throws Exception {
		MongoClient client = new MongoClient(host, port);
		client.setWriteConcern(WriteConcern.SAFE);
		return client;
	}

}

