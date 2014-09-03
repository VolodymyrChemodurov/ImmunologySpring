package com.immunology.logic.utils.config.spring;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.DB;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

@Configuration
public class MongoDBConnectionConfig {

	@Bean
	public DB getDb() throws UnknownHostException, MongoException {
		MongoURI mongoURI = new MongoURI(System.getenv("MONGOHQ_URL"));
        DB db = mongoURI.connectDB();
        db.authenticate(mongoURI.getUsername(), mongoURI.getPassword());
    
        return db;
	}
}
