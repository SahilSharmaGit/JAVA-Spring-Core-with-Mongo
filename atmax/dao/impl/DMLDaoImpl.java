package com.atmax.dao.impl;

import java.net.UnknownHostException;

import com.atmax.dao.DMLDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DMLDaoImpl implements DMLDao {

	static DBCollection collection;
	static MongoClient client;

	public void getConnectedWithMongoDB() {
		try {
			client = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public DBCollection createDBConnection() {
		getConnectedWithMongoDB();
		DB db = client.getDB("atmaxdb");
		db.createCollection("atmaxdata", null);
		collection = db.getCollection("atmaxdata");
		return collection;
	}

	@Override
	public int insert(String firstname, String lastname) {
		createDBConnection();
		BasicDBObject doc = new BasicDBObject();
		doc.put("FirstName", firstname);
		doc.put("LastName", lastname);
		collection.insert(doc);
		return 1;
	}

	@Override
	public int updateFN(String oldName, String newName) {

		BasicDBObject query = new BasicDBObject();
		query.put("FirstName", oldName);

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("FirstName", newName);

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);

		collection.update(query, updateObject);
		return 1;
	}


	@Override
	public int delete(String firstname) {
		// TODO Auto-generated method stub
		createDBConnection();		
		BasicDBObject deleteQuery = new BasicDBObject();
		deleteQuery.put("FirstName", firstname);

		collection.remove(deleteQuery);

		return 1;
	}

	@Override
	public void select(String firstname) {
		createDBConnection();		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("FirstName", firstname);
		DBCursor cursor = collection.find(searchQuery);
		System.out.println("First\tLast");
		while (cursor.hasNext()) {
			DBObject dbo = cursor.next();
			System.out.println(dbo.get("FirstName") + "\t" + dbo.get("LastName"));
		}
	}

	@Override
	public void selectAll() {
		createDBConnection();
		DBCursor cursor = collection.find();
		System.out.println("First\tLast");
		while (cursor.hasNext()) {
			DBObject dbo = cursor.next();
			System.out.println(dbo.get("FirstName") + "\t" + dbo.get("LastName"));
		}
	}
}
