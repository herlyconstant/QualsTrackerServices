package com.cap.qualstracker.services;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class BaseService
{
	private static final Logger logger = Logger.getLogger(BaseService.class);
	
	//private static final BaseService INSTANCE = new BaseService();
	
	private final String QUALS_TRACKER_DB = "qualstracker";
	
/*	private BaseService(){
		//getDB();
	}
	
	public static final BaseService getInstance(){
		return INSTANCE;
	}*/
	
	MongoClient client = null; 
	
	private MongoClient getClient()
	{
		
		try
		{
			client = new MongoClient(new ServerAddress("localhost", 27017));
			
			//logger.info("Connection initialized successfully for "+QUALS_TRACKER_DB+" database");
		}
		catch (UnknownHostException e)
		{
			//client.close();
			
			//System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			
			logger.fatal("Error initializing MongoDB", e);
			
			throw new RuntimeException("Error initialising MongoDB", e);
		}
		catch(Exception ex){
			System.out.println("Exception occured: "+ex.getMessage());
		}
		/*WriteConcern wc = new WriteConcern(1, 1200);
		client.setWriteConcern(wc);*/
		
		return client;
	}
	/*
	protected DBObject getDbObject(String entity) {
		
		DBObject dbObject = (DBObject)JSON.parse(entity);
		
		return dbObject;
	}
	*/
	protected DB getDB()
	{
		DB database = getClient().getDB(QUALS_TRACKER_DB);
		
		return database;
	}
	
	protected void closeConn(){
		
		getClient().close();
	}

}
