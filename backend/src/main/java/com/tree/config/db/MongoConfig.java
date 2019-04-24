package com.tree.config.db;

import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

	@Value("${host-mongo}")
	private String hostMongo;

	@Value("${db-name}")
	private String dbName;

	@Bean
	public MongoClient mongo() {
		return new MongoClient(this.hostMongo);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), this.dbName);
	}

}
