package com.cap.qualstracker.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.cap.qualstracker.interfaces.GroupServiceInterface;
import com.cap.qualstracker.transferobjects.Group;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

@SuppressWarnings("unused")
@Path("groupservice")
public class GroupService extends BaseService implements GroupServiceInterface{
	
	private static final Logger logger = Logger.getLogger(GroupService.class);

	DB database = getDB();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/retrievegroupforuser/{userId}")
	public String retrieveGroupsForUser(@PathParam("userId") String userId) {
	
		DBCursor cursor = null;
		
		try {
		
			DBCollection collection = database.getCollection("users");

			DBObject query = new BasicDBObject("userName", userId.trim());
			DBObject field = new BasicDBObject("groups.groupName", 1);
			field.put("_id", 0);

			cursor = collection.find(query, field);
			
			logger.info("groups retrieved for "+userId);
		}
		catch(MongoException mex){
			logger.error(mex);
		}
		finally {
			cursor.close();
		}
		
		return JSON.serialize(cursor);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/retrievegroups")
	public String retrieveGroups() {
		
		DBCursor cursor = null;

		try {

			DBCollection collection = database.getCollection("groups");

			cursor = collection.find();
			
		} catch (MongoException ex) {
			
			logger.error(ex);
			//ex.printStackTrace(System.out);
		}
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}
		
		logger.info("Groups retrieved.");

		return JSON.serialize(cursor);
	}

	
	public String retrieveGroupProfile(String groupId) {
		
		return null;
	}

}
