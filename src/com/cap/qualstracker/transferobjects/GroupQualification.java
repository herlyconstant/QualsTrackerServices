package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.cap.qualstracker.enums.Maturity;
import com.cap.qualstracker.enums.Status;


@XmlRootElement
public class GroupQualification implements Serializable {

	private static final long serialVersionUID = 1L;

	private Maturity maturity;
	private Status status;
	private String approvedBy;
	
	public GroupQualification(){
		super();
	}
	
	/**
	 * @return the maturity
	 */
	public Maturity getMaturity() {
		return maturity;
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
	 * @param maturity the maturity to set
	 */
	public void setMaturity(Maturity maturity) {
		this.maturity = maturity;
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
