package fr.test.technique.hardis.item;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"inputFile", "references", "errors"})
public class Report {
	private String inputFile;
	private List<Reference> references;
	private List<Error> errors;
	
	
	/**
	 * Constructeur vide
	 */
	public Report() {
		references = new ArrayList<>();
		errors = new ArrayList<>();
		inputFile = "";
	}
	
	/**
	 * Constructeur pour factory
	 * 
	 * @param inputFile
	 */
	public Report(String inputFile) {
		this.inputFile = inputFile;
		references = new ArrayList<>();
		errors = new ArrayList<>();
	}
	/**
	 * Constructeur classe Report
	 * 
	 * @param inputFile
	 * @param references
	 * @param errors
	 */
	public Report(String inputFile, List<Reference> references,
			List<Error> errors) {
		super();
		this.inputFile = inputFile;
		this.references = references;
		this.errors = errors;
	}
	/**
	 * @return the inputFile
	 */
	public String getInputFile() {
		return inputFile;
	}
	/**
	 * @param inputFile the inputFile to set
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	/**
	 * @return the references
	 */
	@XmlElementWrapper(name="references")
	@XmlElement(name="reference")
	public List<Reference> getReferences() {
		return references;
	}
	/**
	 * @param references the references to set
	 */
	public void setReferences(List<Reference> references) {
		this.references = references;
	}
	/**
	 * @return the errors
	 */
	@XmlElementWrapper(name="errors")
	@XmlElement(name="error")
	public List<Error> getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
