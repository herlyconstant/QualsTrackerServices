package com.cap.qualstracker.enums;

import java.io.Serializable;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
public enum Maturity implements Serializable{

	BEGINNER, MODERATE, ADVANCED, EXPERT;
}
