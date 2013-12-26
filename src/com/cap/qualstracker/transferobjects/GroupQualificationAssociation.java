package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.cap.qualstracker.enums.Status;


@XmlRootElement
public class GroupQualificationAssociation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String groupQualAssociationId;
	private String qualificationAssociationId;
	private String groupId;
	private Status status;
	private String approvedBy;
	
	public GroupQualificationAssociation(){
		super();
	}

	/**
	 * @return the groupQualAssociationId
	 */
	public String getGroupQualAssociationId() {
		return groupQualAssociationId;
	}

	/**
	 * @param groupQualAssociationId the groupQualAssociationId to set
	 */
	public void setGroupQualAssociationId(String groupQualAssociationId) {
		this.groupQualAssociationId = groupQualAssociationId;
	}

	/**
	 * @return the qualificationAssociationId
	 */
	public String getQualificationAssociationId() {
		return qualificationAssociationId;
	}

	/**
	 * @param qualificationAssociationId the qualificationAssociationId to set
	 */
	public void setQualificationAssociationId(String qualificationAssociationId) {
		this.qualificationAssociationId = qualificationAssociationId;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

}
