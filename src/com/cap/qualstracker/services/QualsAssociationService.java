package com.cap.qualstracker.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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

@Path("/qualsassociationservice")
public class QualsAssociationService extends BaseService implements QualsAssociationServiceInterface{
	
	@Context
	UriInfo uriInfo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getqualsassc")
	public QualificationAssociation getQualsAssc(){
		
		QualificationAssociation qualsAssc = new QualificationAssociation();
		
		ObjectMapper mapper = new ObjectMapper();
		
		qualsAssc.setQualsAssociationId("99912");
		qualsAssc.setSearchPercentage("68");
		
		try{
			
			mapper.writeValueAsString(qualsAssc);
			
		}
		catch (JsonGenerationException e) {
			 
			e.printStackTrace();
	 
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
	 
		} catch (IOException e) {
	 
			e.printStackTrace();
	 
		}
				
		return qualsAssc;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addupdateusersearch/{qualId}/{associateQualId}/{associationlevel}")
	public Response addOrUpdateUserSearch(@PathParam("qualId") String qualId, @PathParam("associateQualId") String associatedQualId,
			@PathParam("associationlevel") AssociationLevel associationLevel) {
		
		System.out.println("Add or Update UserSearch Called..."+qualId);
		
		Response response = null;
		
		UserSearch userSearch = new UserSearch();
		userSearch.setClickedQualId(associatedQualId);
		userSearch.setSearchedQualId(qualId);
		userSearch.setAssociationLevel(associationLevel);
		
		try{
		DB database = getDB();
		
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.put("clickedqualid", associatedQualId);
		updateQuery.put("searchedqualid", qualId);
		updateQuery.put("associationlevel", associationLevel.toString().toUpperCase());
		
		DBCollection collection = database.getCollection("usersearch");
		collection.save(updateQuery);
		
		response = Response.ok(userSearch).build();
		}
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
		finally{
			
		}
		
		return response;
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
