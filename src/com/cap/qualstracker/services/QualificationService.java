package com.cap.qualstracker.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.cap.qualstracker.interfaces.QualificationServiceInterface;
import com.cap.qualstracker.transferobjects.Qualification;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

@Path("/qualificationservice")
public class QualificationService extends BaseService implements QualificationServiceInterface{

	private static final Logger logger = Logger.getLogger(QualificationService.class);
	
	DB database = getDB();
	
	ObjectId id = ObjectId.get();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getqualification/{keyWord}")
	public String search(@PathParam("keyWord") String keyword) {
	
		System.out.println("getqualification keyword: "+keyword);
		
		DBCursor cursor = null;
		
		try{
			
			DBCollection collection = database.getCollection("qualification");
			
			BasicDBObject query = new BasicDBObject();
			query.put("searchKeywords.keywordName", keyword.toUpperCase().trim());
			
			BasicDBObject fields = new BasicDBObject();
			fields.put("searchKeywords.$", 1);
			
			collection.ensureIndex(new BasicDBObject("searchKeywords.keywordName", 1));
			
			cursor = collection.find(query,fields);
			
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			logger.info("Qualfication retrieved for keyword "+keyword);
		}
		catch(MongoException mex){
			System.out.println("Error: "+mex);
			
			logger.error(mex);
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
			
			logger.info("list of maturity retrieved");
		} 
		catch (MongoException mex) {
			//mex.printStackTrace(System.out);
			logger.error(mex);
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
	public void addQualification(@PathParam("name") String username, @PathParam("qual") String qual,
			@PathParam("maturity") String maturity, @PathParam("account") String account,
			@PathParam("qualtype") String qualtype) {
		
		
		//Search each collection base on the incoming pathparam and set the variables for Qualification accordingly.

		/*DBRef myDbRef = new DBRef(database, "users", new ObjectId(
				"4b0552e4f0da7d1eb6f126a2"));
		DBObject doc = myDbRef.fetch();
		System.out.println("DBRef.fetch(): "+doc);*/
		
		DBCollection userColl = database.getCollection("users");
		DBObject userQuery = new BasicDBObject();
		userQuery.put("userName", username);
		
		BasicDBObject userField = new BasicDBObject();
		userField.put("userRole.roleType",1);
		userField.put("userRole.accessLevel",1);
		userField.put("userRole.searchAssociationWeightAge",1);
		
		userColl.find(userQuery,userField);

		Qualification userQual = new Qualification();
		
		try {
			
			DBCollection collection = database.getCollection("qualification");
			
			collection.setObjectClass(Qualification.class);
			
			collection.save(userQual);
			
			logger.info("qualification associated");
			
			
		} catch (MongoException mex) {
			//mex.printStackTrace(System.out);
			logger.error(mex);
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
			
			logger.info("qualification types retrieved");
		} 
		catch (MongoException mex) {
			//mex.printStackTrace(System.out);
			logger.error(mex);
		}
		finally{
			cursor.close();
		}
		
		return JSON.serialize(cursor);
	}

}
