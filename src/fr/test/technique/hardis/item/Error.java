package fr.test.technique.hardis.item;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Error {
	private int line;
	private String message;
	private String value;
	
	/**
	 * Constructeur classe Error
	 * 
	 * @param line
	 * @param message
	 * @param value
	 */
	public Error(int line, String message, String value) {
		super();
		this.line = line;
		this.message = message;
		this.value = value;
	}
	/**
	 * @return the line
	 */
	@XmlAttribute
	public int getLine() {
		return line;
	}
	/**
	 * @param line the line to set
	 */
	public void setLine(int line) {
		this.line = line;
	}
	/**
	 * @return the message
	 */
	@XmlAttribute 
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the value
	 */
	@XmlValue
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
