package com.cap.qualstracker.transferobjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;


@XmlRootElement
public class User extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;

	protected UserRole userRole;
	protected String userName;
	protected String emailId;
	protected String phoneNo;
	protected List<Group> group = new ArrayList<Group>();
	
	public User(){
		super();
	}
	
	/**
	 * @param userRole
	 * @param userName
	 * @param emailId
	 * @param phoneNo
	 * @param group
	 */
	public User(UserRole userRole, String userName, String emailId,
			String phoneNo, List<Group> group) {
		put("userRole", userRole);
		put("userName", userName);
		put("emailId", emailId);
		put("phoneNo", phoneNo);
		put("group", group);
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the group
	 */
	public List<Group> getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(List<Group> group) {
		this.group = group;
	}	
}
