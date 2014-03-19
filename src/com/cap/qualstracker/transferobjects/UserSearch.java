package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.cap.qualstracker.enums.AssociationLevel;
import com.mongodb.BasicDBObject;

@XmlRootElement(name = "UserSearch")
public class UserSearch extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private UserRole userRole;
	private int numberOfHits;
	private String clickedQualId;
	private String searchedQualId;
	private AssociationLevel associationLevel;
	
	public UserSearch(){
		super();
	}

	/**
	 * @param userRole
	 * @param numberOfHits
	 * @param clickedQualId
	 * @param searchedQualId
	 * @param associationLevel
	 */
	public UserSearch(UserRole userRole, int numberOfHits,
			String clickedQualId, String searchedQualId,
			AssociationLevel associationLevel) {
		put("userRole", userRole);
		put("numberOfHits", numberOfHits);
		put("clickedQualId", clickedQualId);
		put("searchedQualId", searchedQualId);
		put("associationLevel", associationLevel);
	}


	/**
	 * @return the userRole
	 */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the numberOfHits
	 */
	public int getNumberOfHits() {
		return numberOfHits;
	}

	/**
	 * @param numberOfHits the numberOfHits to set
	 */
	public void setNumberOfHits(int numberOfHits) {
		this.numberOfHits = numberOfHits;
	}

	/**
	 * @return the clickedQualId
	 */
	public String getClickedQualId() {
		return clickedQualId;
	}

	/**
	 * @param clickedQualId the clickedQualId to set
	 */
	public void setClickedQualId(String clickedQualId) {
		this.clickedQualId = clickedQualId;
	}

	/**
	 * @return the searchedQualId
	 */
	public String getSearchedQualId() {
		return searchedQualId;
	}

	/**
	 * @param searchedQualId the searchedQualId to set
	 */
	public void setSearchedQualId(String searchedQualId) {
		this.searchedQualId = searchedQualId;
	}

	/**
	 * @return the associationLevel
	 */
	public AssociationLevel getAssociationLevel() {
		return associationLevel;
	}

	/**
	 * @param associationLevel the associationLevel to set
	 */
	public void setAssociationLevel(AssociationLevel associationLevel) {
		this.associationLevel = associationLevel;
	}
	
}
