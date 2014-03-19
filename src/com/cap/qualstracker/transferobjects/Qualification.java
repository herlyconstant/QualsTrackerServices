package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;

@XmlRootElement
public class Qualification extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UserSearch userSearch;
	private QualificationAttribute qualificationAttribute;
	private GroupQualification groupQualification;
	private SearchKeywords keywords;

	public Qualification(){
		super();
	}
	
	/**
	 * @param userSearch
	 * @param qualificationAttribute
	 * @param groupQualification
	 * @param keywords
	 */
	public Qualification(UserSearch userSearch,
			QualificationAttribute qualificationAttribute,
			GroupQualification groupQualification, SearchKeywords keywords) {

		put("userSearch", userSearch);
		put("qualificationAttribute", qualificationAttribute);
		put("groupQualification", groupQualification);
		put("keywords", keywords);
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
