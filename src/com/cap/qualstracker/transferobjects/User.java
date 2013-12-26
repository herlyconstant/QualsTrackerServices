package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	protected UserRole userRole;
	protected String userName;
	protected String emailId;
	protected String phoneNo;
	protected Group group;
	
	public User(){
		
		
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
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}	
}
