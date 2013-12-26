package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class QualificationAssociation implements Serializable{

	private static final long serialVersionUID = 1L;

	private String qualsAssociationId;
	private String searchPercentage;
	private Qualification qualification;
	
	public QualificationAssociation(){
		super();
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
