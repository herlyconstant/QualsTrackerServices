package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.cap.qualstracker.enums.Status;
import com.mongodb.BasicDBObject;

@XmlRootElement
public class UserGroup extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;

	protected Status status;
	protected User user;

	public UserGroup(){
		super();
	}

	/**
	 * @param status
	 * @param user
	 */
	public UserGroup(Status status, User user) {
		put("status", status);
		put("user", user);
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
