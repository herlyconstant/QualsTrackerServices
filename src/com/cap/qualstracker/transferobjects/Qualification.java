package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Qualification implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UserSearch userSearch;
	private QualificationAttribute qualificationAttribute;
	private QualificationAssociation qualificationAssociation;
	private GroupQualification groupQualification;
	private SearchKeywords keywords;

	public Qualification(){
		super();
	}

	/**
	 * @return the userSearch
	 */
	public UserSearch getUserSearch() {
		return userSearch;
	}

	/**
	 * @param userSearch the userSearch to set
	 */
	public void setUserSearch(UserSearch userSearch) {
		this.userSearch = userSearch;
	}

	/**
	 * @return the qualificationAttribute
	 */
	public QualificationAttribute getQualificationAttribute() {
		return qualificationAttribute;
	}

	/**
	 * @param qualificationAttribute the qualificationAttribute to set
	 */
	public void setQualificationAttribute(
			QualificationAttribute qualificationAttribute) {
		this.qualificationAttribute = qualificationAttribute;
	}

	/**
	 * @return the qualificationAssociation
	 */
	public QualificationAssociation getQualificationAssociation() {
		return qualificationAssociation;
	}

	/**
	 * @param qualificationAssociation the qualificationAssociation to set
	 */
	public void setQualificationAssociation(
			QualificationAssociation qualificationAssociation) {
		this.qualificationAssociation = qualificationAssociation;
	}

	/**
	 * @return the groupQualification
	 */
	public GroupQualification getGroupQualification() {
		return groupQualification;
	}

	/**
	 * @param groupQualification the groupQualification to set
	 */
	public void setGroupQualification(GroupQualification groupQualification) {
		this.groupQualification = groupQualification;
	}

	/**
	 * @return the keywords
	 */
	public SearchKeywords getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(SearchKeywords keywords) {
		this.keywords = keywords;
	}
}
