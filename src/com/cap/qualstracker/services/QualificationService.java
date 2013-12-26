package com.cap.qualstracker.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;

import com.cap.qualstracker.interfaces.QualificationServiceInterface;
import com.cap.qualstracker.transferobjects.Qualification;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

@Path("/qualificationservice")
public class QualificationService extends BaseService implements QualificationServiceInterface{

	DB database = getDB();
	
	ObjectId id = ObjectId.get();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getqualification/{keyWord}")
	public String search(@PathParam("keyWord") String keyword) {
	
		System.out.println("getqualification keyword "+keyword);
		
		DBCursor cursor = null;
		
		try{
			
			DBCollection collection = database.getCollection("qualification");
			BasicDBObject dbObject = new BasicDBObject();
			dbObject.put("keyword", keyword);
			
			cursor = collection.find(dbObject);
			
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		}
		catch(MongoException mex){
			System.out.println("Error: "+mex);
		}
		finally{
			cursor.close();
		}

		return JSON.serialize(cursor);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/retrievematuritylevels")
	public String retrieveAllMaturityLevels() {

		DBCursor cursor = null;

		try {

			DBCollection collection = database.getCollection("maturity");

			DBObject query = new BasicDBObject();
			DBObject field = new BasicDBObject();
			field.put("_id", 0);

			cursor = collection.find(query, field);
		} 
		catch (MongoException ex) {
			ex.printStackTrace(System.out);
		}
		finally{
			cursor.close();
		}
		
		return JSON.serialize(cursor);
	}
	
	public Qualification searchOnlyQuals(String keyword) {
		
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addgroupqual/{name}/{qual}/{maturity}/{account}/{qualtype}")
	public void addQualification(@PathParam("name") String name, @PathParam("qual") String qual,
			@PathParam("maturity") String maturity, @PathParam("account") String account,
			@PathParam("qualtype") String qualtype) {
		
		try {
			
			DBCollection collection = database.getCollection("groupqualification");
			DBObject quals = new BasicDBObject();
			quals.put("_id", id.toString());
			quals.put("username", name.toUpperCase());
			quals.put("qual", qual.toUpperCase());
			quals.put("maturity", maturity.toUpperCase());
			quals.put("account", account.toUpperCase());
			quals.put("qualtype", qualtype.toUpperCase());

			collection.insert(quals);
			
		} catch (MongoException ex) {
			ex.printStackTrace(System.out);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/retrievequalstype")
	public String retrieveAllQualsType() {
		
		DBCursor cursor = null;

		try {
			
			DBCollection collection = database.getCollection("qualificationtypes");

			DBObject query = new BasicDBObject();
			DBObject field = new BasicDBObject();
			field.put("_id", 0);

			cursor = collection.find(query, field);
		} 
		catch (MongoException ex) {
			ex.printStackTrace(System.out);
		}
		finally{
			cursor.close();
		}
		
		return JSON.serialize(cursor);
	}

}
