package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

@XmlRootElement
public class SearchKeywords extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private int keywordId;
	private String keywordName;
	
	/**
	 * Empty constructor
	 */
	public SearchKeywords(){
		super();
	}
	
	/**
	 * Constructor taking the following params
	 * 
	 * @param keywordId
	 * @param keywordName
	 */
	public SearchKeywords(int keywordId, String keywordName){
		put("keywordId", keywordId);
		put("keywordName", keywordName);
	}

	/**
	 * @return the keywordId
	 */
	public int getKeywordId() {
		return keywordId;
	}

	/**
	 * @param keywordId the keywordId to set
	 */
	public void setKeywordId(int keywordId) {
		this.keywordId = keywordId;
	}

	/**
	 * @return the keywordName
	 */
	public String getKeywordName() {
		return keywordName;
	}

	/**
	 * @param keywordName the keywordName to set
	 */
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}
}
