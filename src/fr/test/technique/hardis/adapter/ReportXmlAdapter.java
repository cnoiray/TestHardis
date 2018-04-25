package fr.test.technique.hardis.adapter;

import java.io.StringWriter;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller; 
import javax.xml.bind.JAXBContext;

import fr.test.technique.hardis.item.Report;

public class ReportXmlAdapter {
	public String toXml(final Report object) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    StringWriter sw = new StringWriter();
	    
	    //amelioration de l'output
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
	    jaxbMarshaller.marshal(object, sw);
		
	    return sw.toString();
    }
}
