package fr.test.technique.hardis.item;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import fr.test.technique.hardis.utils.ColorEnum;

@XmlType(propOrder={"type", "price", "size", "numReference"})
public class Reference {
	private String numReference;
	private int size;
	private double price;
	private ColorEnum type;
	
	/**
	 * Constructeur classe Reference
	 * 
	 * @param type
	 * @param price
	 * @param size
	 * @param numReference
	 */
	public Reference(ColorEnum type, double price, int size, String numReference) {
		super();
		this.type = type;
		this.price = price;
		this.size = size;
		this.numReference = numReference;
	}
	
	
	/**
	 * @return the type
	 */
	@XmlAttribute (name = "color")
	public ColorEnum getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ColorEnum type) {
		this.type = type;
	}
	/**
	 * @return the price
	 */
	@XmlAttribute 
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the size
	 */
	@XmlAttribute 
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the numReference
	 */
	@XmlAttribute 
	public String getNumReference() {
		return numReference;
	}
	/**
	 * @param numReference the numReference to set
	 */
	public void setNumReference(String numReference) {
		this.numReference = numReference;
	}
}
