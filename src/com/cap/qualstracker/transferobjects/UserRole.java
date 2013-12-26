package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;


@XmlRootElement
public class UserRole extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;

	protected String roleType;
	protected String accessLevel;
	protected String searchAssociationWeightAge;
	
	public UserRole(String roleType, String accessLevel, String searchAssociationWeightAge){
		put("roleType", roleType);
		put("accessLevel", accessLevel);
		put("searchAssociationWeightAge",searchAssociationWeightAge);
	}

	/**
	 * @return the roleType
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType the roleType to set
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the accessLevel
	 */
	public String getAccessLevel() {
		return accessLevel;
	}

	/**
	 * @param accessLevel the accessLevel to set
	 */
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	/**
	 * @return the searchAssociationWeightAge
	 */
	public String getSearchAssociationWeightAge() {
		return searchAssociationWeightAge;
	}

	/**
	 * @param searchAssociationWeightAge the searchAssociationWeightAge to set
	 */
	public void setSearchAssociationWeightAge(String searchAssociationWeightAge) {
		this.searchAssociationWeightAge = searchAssociationWeightAge;
	}
	
}
