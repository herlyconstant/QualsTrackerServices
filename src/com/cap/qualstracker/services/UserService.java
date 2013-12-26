package com.cap.qualstracker.services;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.types.ObjectId;

import com.cap.qualstracker.enums.GroupType;
import com.cap.qualstracker.enums.Status;
import com.cap.qualstracker.interfaces.UserServiceInterface;
import com.cap.qualstracker.transferobjects.Group;
import com.cap.qualstracker.transferobjects.User;
import com.cap.qualstracker.transferobjects.UserGroup;
import com.cap.qualstracker.transferobjects.UserRole;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

@Path("/userservice")
public class UserService extends BaseService implements UserServiceInterface{

	DB database = getDB();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findbyemailid/{emailId}")
	public String findByEmailId(@PathParam("emailId")String emailId) {
		
		User user = new User();
		user.setEmailId(emailId);	
		
		BasicDBObject query = new BasicDBObject();
		BasicDBObject emailField = new BasicDBObject();
		emailField.put("emailId", user.getEmailId());
		
		DBCollection collection = database.getCollection("users");
		DBCursor cursor = collection.find(query,emailField);	
		
		return JSON.serialize(cursor);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findbyname/{username}")
	public String findByName(@PathParam("username")String userName) {

		User user = new User();
		user.setUserName(userName);
		
		DB database = getDB();
		
		DBCollection collection = database.getCollection("users");
		BasicDBObject name = new BasicDBObject();
		name.put("username", userName);
		
		DBCursor cursor = collection.find();
		try{
		while(cursor.hasNext()){
			
			System.out.println(cursor.next());
		}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			cursor.close();
		}
	
		
		return JSON.serialize(cursor);
	}

	public void associateToGroup(String userId, String groupId) {
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/retrievependingusergroup/{userId}")
	public UserGroup retrievePendingUserGroupAssociations(@PathParam("userId") String userId) {

		UserGroup userGroup = new UserGroup();
		userGroup.setStatus(Status.PENDING);
		
		BasicDBObject pendingQuery = new BasicDBObject();
		pendingQuery.put("status", userGroup.getStatus());
		
		DBCollection collection = database.getCollection("usergroup");
		collection.find(pendingQuery);
		
		return userGroup;
	}

	@POST
	@Path("/usertogroup/{groupname}/{user}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void associateUserToGroup(@PathParam("groupname") String groupName,
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

				System.out.println(cursor.next());
				
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
			
			userColl.update(userQuery, update);
		} 
		finally{
			cursor.close();
		}
		System.out.println("GroupType: "+groupType);
		System.out.println("GroupName: "+groupName);

	}
	
	@POST
	@Path("/insertuser/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertUser(@PathParam("username") String username){
		
		User user = new User();
		user.setEmailId("hconstant@test.com");
		user.setGroup(new Group(GroupType.ORGANIZATION, "CSD East"));
		user.setPhoneNo("555-555-5555");
		user.setUserName(username);
		user.setUserRole(new UserRole("Developer", "Medium", "2"));
		
		ObjectId id = ObjectId.get();
		try {

			DBCollection collection = database.getCollection("users");
			BasicDBObject dbObject = new BasicDBObject();
			dbObject.put("_id", id);
			dbObject.put("name", user.getUserName());
			dbObject.put("email", user.getEmailId());
			dbObject.put("phone", user.getPhoneNo());
			dbObject.put("group", user.getGroup());
			dbObject.put("role", user.getUserRole());

			collection.insert(dbObject);
			
		} catch (MongoException ex) {

			System.out.println("Error: " + ex.getMessage());
		}
	}

}
