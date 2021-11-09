package com.atmax.dao.impl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.atmax.dao.DMLDao;
import com.atmax.model.AtmaxEmployee;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@Repository
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
		if (collection == null) {
			getConnectedWithMongoDB();
			DB db = client.getDB("atmaxdb");
			db.createCollection("atmaxdata", null);
			collection = db.getCollection("atmaxdata");
			return collection;
		}
		return collection;
	}

	@Override
	public int insert(AtmaxEmployee emp) {
		createDBConnection();
		BasicDBObject doc = new BasicDBObject();
		doc.put("Email", emp.getEmail());
		doc.put("Name", emp.getEmail());
		doc.put("Department", emp.getDept());
		collection.insert(doc);
		return 1;
	}

	@Override
	public int update(AtmaxEmployee emp) {

		BasicDBObject query = new BasicDBObject();
		query.put("Email", emp.getEmail());

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("Name", emp.getName());
		newDocument.put("Department", emp.getDept());

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);

		collection.update(query, updateObject);
		return 1;
	}

	@Override
	public int delete(String email) {
		// TODO Auto-generated method stub
		createDBConnection();
		BasicDBObject deleteQuery = new BasicDBObject();
		deleteQuery.put("Email", email);

		collection.remove(deleteQuery);

		return 1;
	}

	@Override
	public List<AtmaxEmployee> select(String email) {
		createDBConnection();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("Email", email);
		DBCursor cursor = collection.find(searchQuery);
		List<AtmaxEmployee> data = new ArrayList<>();
		while (cursor.hasNext()) {
			AtmaxEmployee emp = new AtmaxEmployee();
			DBObject dbo = cursor.next();
			emp.setEmail("" + dbo.get("Email"));
			emp.setName("" + dbo.get("Name"));
			emp.setDept("" + dbo.get("Department"));
			data.add(emp);
			// System.out.println(dbo.get("FirstName") + "\t" + dbo.get("LastName"));
		}
		return data;
	}

	@Override
	public List<AtmaxEmployee> selectAll() {
		createDBConnection();
		DBCursor cursor = collection.find();
		List<AtmaxEmployee> data = new ArrayList<>();
		while (cursor.hasNext()) {
			AtmaxEmployee emp = new AtmaxEmployee();
			DBObject dbo = cursor.next();
			emp.setEmail("" + dbo.get("Email"));
			emp.setName("" + dbo.get("Name"));
			emp.setDept("" + dbo.get("Department"));
			data.add(emp);
		}
		return data;
	}
}