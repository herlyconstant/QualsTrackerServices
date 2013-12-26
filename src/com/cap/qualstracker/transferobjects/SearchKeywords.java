package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;


@XmlRootElement
public class SearchKeywords extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String keywordId;
	private String keywordName;
	
	public SearchKeywords(String keywordId, String keywordName){
		put("_id", keywordId);
		put("keyWord", keywordName);
	}

	/**
	 * @return the keywordId
	 */
	public String getKeywordId() {
		return keywordId;
	}

	/**
	 * @param keywordId the keywordId to set
	 */
	public void setKeywordId(String keywordId) {
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
