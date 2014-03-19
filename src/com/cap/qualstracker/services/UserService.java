package com.cap.qualstracker.services;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.cap.qualstracker.enums.Status;
import com.cap.qualstracker.interfaces.UserServiceInterface;
import com.cap.qualstracker.transferobjects.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

@Path("/userservice")
public class UserService extends BaseService implements UserServiceInterface{
	
	private static final Logger logger = Logger.getLogger(UserService.class);

	DB database = getDB();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findbyemailid/{emailId}")
	public String findByEmailId(@PathParam("emailId")String emailId) {
		
		System.out.println("E-mail ID passed: " + emailId);

		DBCollection collection = database.getCollection("users");

		BasicDBObject query = new BasicDBObject();
		query.put("emailId", emailId.trim());

		collection.ensureIndex(new BasicDBObject("emailId", 1));

		collection.setObjectClass(User.class);

		DBCursor cursor = collection.find(query);

		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			logger.info("E-mail: " + emailId);
		}		
		catch(MongoException mex){
			logger.error(mex);
		}
		
		finally{
			cursor.close();
		}
		
		return JSON.serialize(cursor);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findbyname/{username}")
	public String findByName(@PathParam("username")String userName) {
		
		DB database = getDB();
		
		DBCollection collection = database.getCollection("users");
		
		BasicDBObject name = new BasicDBObject();
		name.put("userName", userName);
		
		DBCursor cursor = collection.find(name);
		
		try{
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
			logger.info("Name: "+userName);
		}
		catch(Exception ex){
			//System.out.println(ex.getMessage());
			logger.error(ex);
		}
		finally{
			cursor.close();
		}
	
		return JSON.serialize(cursor);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/retrievependingusergroup/{userId}")
	public String retrievePendingUserGroupAssociations(
			@PathParam("userId") String userId) {

		System.out.println("User: " + userId);

		DBCursor cursor = null;

		try {
			DBCollection collection = database.getCollection("qualification");

			BasicDBObject query = new BasicDBObject();
			query.put("userName", userId);
			query.put("groupQualification.status", Status.PENDING.toString());

			cursor = collection.find(query);

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
	
		} 
		catch (Exception mex) {
			
			//System.out.println("Error: " + mex);
			logger.error(mex);
		} 
		finally {
			cursor.close();
		}

		return JSON.serialize(cursor);
	}

	@POST
	@Path("/usertogroup/{groupname}/{user}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void associateToGroup(@PathParam("groupname") String groupName,
			@PathParam("user") String userId) {

		String groupType = "";
		
		DBCursor cursor = null;
		
		try {
			
			DBCollection collection = database.getCollection("groups");
			BasicDBObject query = new BasicDBObject();
			query.put("groupName", groupName);
			
			BasicDBObject field = new BasicDBObject();
			field.put("groupType", 1);
			field.put("_id", 0);
			
			cursor = collection.find(query,field);

			while(cursor.hasNext()){

				//System.out.println(cursor.next());				
				groupType = cursor.curr().get("groupType").toString();
			}
			
			DBCollection userColl = database.getCollection("users");
			BasicDBObject userQuery = new BasicDBObject();
			userQuery.put("userName", userId);
			
			BasicDBObject userField = new BasicDBObject();
			userField.put("groupType", groupType);
			userField.put("groupName", groupName);
			
			BasicDBObject update = new BasicDBObject();
			update.put("$push", new BasicDBObject("groups",userField));
			
			userColl.ensureIndex(new BasicDBObject("groups.groupName",1),new BasicDBObject("unique",true));
			
			userColl.update(userQuery, update);
			
			logger.info(userId+" is now associated with "+groupName);
			
		}
		catch(MongoException mex){
			//System.out.println(mex);
			logger.fatal(mex);
		}
		finally{
			cursor.close();
		}
	}
	
	@POST
	@Path("/updateuserassoc/{user}/{status}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUserGroupAssoc(@PathParam("user") String userId,@PathParam("status") String status){
		
		System.out.println("User: " + userId);
		System.out.println("Status: " + status);

		try {
			DBCollection collection = database.getCollection("qualification");

			BasicDBObject query = new BasicDBObject();
			query.put("userName", userId.trim());
			//query.put("groupQualification.status", Status.PENDING.toString());
			
			BasicDBObject update = new BasicDBObject();
			
			if(status.toUpperCase().equals(Status.APPROVED.toString())){
				update.put("$set", new BasicDBObject("groupQualification.status",Status.APPROVED.toString()));
			}
			if(status.toUpperCase().equals(Status.PENDING.toString())){
				update.put("$set", new BasicDBObject("groupQualification.status",Status.PENDING.toString()));
			}
			else if(status.toUpperCase().equals(Status.REJECTED.toString())){
				update.put("$set", new BasicDBObject("groupQualification.status",Status.REJECTED.toString()));
			}

			collection.update(query,update);
			
		} 
		catch (Exception mex) {
			
			//System.out.println("Error: " + mex);
			logger.error(mex);
		} 
	}
	
}
