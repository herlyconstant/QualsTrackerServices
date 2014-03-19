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

import com.cap.qualstracker.interfaces.KeywordServiceInterface;
import com.cap.qualstracker.transferobjects.SearchKeywords;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
import com.cap.qualstracker.services.BaseService;

@Path("/keywordservice")
public class KeywordService extends BaseService implements KeywordServiceInterface
{
	private static final Logger logger = Logger.getLogger(KeywordService.class);
	
	DB db = getDB();

	ObjectId id = ObjectId.get();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/retrievekeywords")
	public String retrieveKeywords() {

		DBCollection collection = db.getCollection("searchedkeywords");
		
		collection.setObjectClass(SearchKeywords.class);

		DBCursor cursor = collection.find();

		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
				}
		} 
		catch(MongoException mex){
			logger.error(mex);
		}
		
		finally{
			cursor.close();
		}

		closeConn();
		
		logger.info("Keywords retrieved!!!");

		return JSON.serialize(cursor);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addkeyword/{id}/{keyword}")
	public void addSearchKeyword(@PathParam("keyword") String keyWord, @PathParam("id") String id) {

		System.out.println("KeyWordID passed is " + id);
		System.out.println("KeyWord passed is " + keyWord);
		
		int keywordId = 0;
		try{
			keywordId = Integer.parseInt(id);
		}
		catch(NumberFormatException nfe){
			//nfe.printStackTrace(System.out);
			logger.error(nfe);
		}
		SearchKeywords searchKeyword = new SearchKeywords(keywordId, keyWord.trim());

		try {

			DBCollection collection = db.getCollection("searchedkeywords");

			collection.setObjectClass(SearchKeywords.class);

			collection.ensureIndex(new BasicDBObject("keywordName", 1),
					new BasicDBObject("unique", true));

			collection.save(searchKeyword);

		} catch (Exception ex) {
			//ex.printStackTrace(System.out);
			logger.error(ex);
		}
	}

}
