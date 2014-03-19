package com.cap.qualstracker.interfaces;

public interface KeywordServiceInterface {

	public abstract String retrieveKeywords();
	
	abstract void addSearchKeyword(String keyWord, String id);
}
