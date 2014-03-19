package com.cap.qualstracker.transferobjects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;


@XmlRootElement
public class QualificationAttribute extends BasicDBObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String value;
	private String type;
	
	public QualificationAttribute(){
		super();
	}

	/**
	 * @param name
	 * @param value
	 * @param type
	 */
	public QualificationAttribute(String name, String value, String type) {
		put("name", name);
		put("value", value);
		put("type", type);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
