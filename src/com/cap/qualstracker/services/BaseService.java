package com.cap.qualstracker.services;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

public class BaseService
{
	private final String QUALS_TRACKER_DB = "qualstracker";

	protected MongoClient getClient()
	{
		MongoClient client = null;
		try
		{
			//System.out.println("Mongo Client Called...");
			client = new MongoClient(new ServerAddress("localhost", 27017));
			
			//client.close();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		return client;
	}
	
	protected DBObject getDbObject(String entity) {
		
		DBObject dbObject = (DBObject)JSON.parse(entity);
		
		return dbObject;
	}
	
	protected DB getDB()
	{
		DB database = getClient().getDB(QUALS_TRACKER_DB);
		
		return database;
	}

}
