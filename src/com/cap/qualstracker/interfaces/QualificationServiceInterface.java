package com.cap.qualstracker.interfaces;

import com.cap.qualstracker.transferobjects.Qualification;

public interface QualificationServiceInterface {

	public String search(String keyword);
	public String retrieveAllMaturityLevels();
	public Qualification searchOnlyQuals(String keyword);
	public void addQualification(String name, String qual,
			 String maturity, String account, String qualtype);
	public String retrieveAllQualsType();
}
