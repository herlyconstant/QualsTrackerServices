package com.cap.qualstracker.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.cap.qualstracker.enums.AssociationLevel;
import com.cap.qualstracker.interfaces.QualsAssociationServiceInterface;
import com.cap.qualstracker.transferobjects.GroupQualificationAssociation;
import com.cap.qualstracker.transferobjects.QualificationAssociation;
import com.cap.qualstracker.transferobjects.UserSearch;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@Path("/qualsassociationservice")
public class QualsAssociationService extends BaseService implements QualsAssociationServiceInterface{
	
	private static final Logger logger = Logger.getLogger(QualsAssociationService.class);

	DB database = getDB();
	
	@Context
	UriInfo uriInfo;
	
	@POST
	@Path("/addupdateusersearch/{qualId}/{associateQualId}/{associationlevel}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addOrUpdateUserSearch(@PathParam("qualId") String qualId, @PathParam("associateQualId") String associatedQualId,
			@PathParam("associationlevel") AssociationLevel associationLevel) {
		
		System.out.println("Add or Update UserSearch Called...");
		
		try{
			DBCollection collection = database.getCollection("usersearch");
			
			BasicDBObject query = new BasicDBObject();
			
			BasicDBObject update = new BasicDBObject();
			BasicDBObject fields = new BasicDBObject();
			fields.put("clickedQualId", qualId.toString());
			fields.put("searchedQualId", associatedQualId.toString());
			
			if(associationLevel.toString().toUpperCase().equals(AssociationLevel.INTERESTED.toString())){
				fields.put("associationLevel", AssociationLevel.INTERESTED.toString());
			}
			else if(associationLevel.toString().toUpperCase().equals(AssociationLevel.USEFUL.toString())){
				fields.put("associationLevel", AssociationLevel.USEFUL.toString());
			}
			
			update.put("$set", fields);
				
			collection.update(query, update);

		}
		catch(Exception ex){
			System.out.println("error: "+ex.getMessage());
			
			logger.error(ex);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/associatequalification/{qualId}/{associateQualId}")
	public void associateQualification(@PathParam("qualId") String qualId,
			@PathParam("associateQualId") String associatedQualId) {

		GroupQualificationAssociation groupQualAssc = new GroupQualificationAssociation();
		groupQualAssc.setGroupQualAssociationId(qualId);
		groupQualAssc.setQualificationAssociationId(associatedQualId);
		
		DB database = getDB();
		
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.put("groupqualassociationid", groupQualAssc.getGroupQualAssociationId());
		updateQuery.put("qualificationassociationid", groupQualAssc.getQualificationAssociationId());
		
		DBCollection collection = database.getCollection("groupqualificationassociation");
		collection.save(updateQuery);
		
	}

	public double calcAndUpdateSearchPercentage(String qualId,
			String associatedQualId) {

		return 0;
	}
}
