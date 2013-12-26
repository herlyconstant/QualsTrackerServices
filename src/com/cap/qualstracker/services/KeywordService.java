package com.cap.qualstracker.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.bson.types.ObjectId;

import com.cap.qualstracker.interfaces.KeywordServiceInterface;
import com.cap.qualstracker.transferobjects.SearchKeywords;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

@Path("/keywordservice")
public class KeywordService extends BaseService implements KeywordServiceInterface
{

	@Context
	UriInfo uriInfo;
	
	DB database = getDB();	
	ObjectId id = ObjectId.get();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/retrievekeywords")
	public String retrieveKeywords() {

		DBCollection collection = database.getCollection("searchedkeywords");

		DBCursor cursor = collection.find();

		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}

		return JSON.serialize(cursor);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addkeyword/{keyword}")
	public void addSearchKeyword(@PathParam("keyword") String keyWord) {

		System.out.println("KeyWord passed is " + keyWord);

		SearchKeywords searchKeyword = new SearchKeywords(id.toString(), keyWord);

		try {

			DBCollection collection = database.getCollection("searchedkeywords");

			collection.setObjectClass(SearchKeywords.class);
			
			collection.insert(searchKeyword);

		} catch (MongoException ex) {

			ex.printStackTrace(System.out);
		}
	}

}
