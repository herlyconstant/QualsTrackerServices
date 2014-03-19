package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;


@XmlRootElement
public class QualificationAssociation extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String qualsAssociationId;
	private String searchPercentage;
	private Qualification qualification;
	
	public QualificationAssociation(){
		super();
	}

	/**
	 * @param qualsAssociationId
	 * @param searchPercentage
	 * @param qualification
	 */
	public QualificationAssociation(String qualsAssociationId,
			String searchPercentage, Qualification qualification) {

		put("qualsAssociationId", qualsAssociationId);
		put("searchPercentage", searchPercentage);
		put("qualification", qualification);
	}


	/**
	 * @return the qualsAssociationId
	 */
	public String getQualsAssociationId() {
		return qualsAssociationId;
	}

	/**
	 * @param qualsAssociationId the qualsAssociationId to set
	 */
	public void setQualsAssociationId(String qualsAssociationId) {
		this.qualsAssociationId = qualsAssociationId;
	}

	/**
	 * @return the searchPercentage
	 */
	public String getSearchPercentage() {
		return searchPercentage;
	}

	/**
	 * @param searchPercentage the searchPercentage to set
	 */
	public void setSearchPercentage(String searchPercentage) {
		this.searchPercentage = searchPercentage;
	}

	/**
	 * @return the qualification
	 */
	public Qualification getQualification() {
		return qualification;
	}

	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}
	
	
}
