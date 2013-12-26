package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.cap.qualstracker.enums.GroupType;
import com.mongodb.BasicDBObject;


@XmlRootElement
public class Group extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 3010245107362536631L;
	
	private GroupType groupType;
	private String groupName;
	
	public Group(){
		
	}
	public Group(GroupType groupType, String groupName){
		put("groupType", groupType);
		put("groupName", groupName);
	}

	/**
	 * @return the groupType
	 */
	public GroupType getGroupType() {
		return groupType;
	}

	/**
	 * @param groupType the groupType to set
	 */
	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}


	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
