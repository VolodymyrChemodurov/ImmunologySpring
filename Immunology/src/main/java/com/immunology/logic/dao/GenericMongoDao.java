package com.immunology.logic.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;

@Repository
public abstract class GenericMongoDao<T> {

	@Autowired
	private MongoDbFactory mongoFactory;
	
	protected MongoCollection collection;

	protected void init(String collectionName) {
		DB db = mongoFactory.getDb();
		Jongo jongo = new Jongo(db);
		collection = jongo.getCollection(collectionName);
	}

	protected List<T> convertToList(Iterable<T> templates) {
		List<T> items = new ArrayList<T>();
		Iterator<T> iterator = templates.iterator();
		while (iterator.hasNext()) {
			items.add(iterator.next());
		}
		return items;
	}
}
