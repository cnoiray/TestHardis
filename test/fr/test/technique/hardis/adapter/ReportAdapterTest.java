package fr.test.technique.hardis.adapter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.test.technique.hardis.constante.ConstanteTest;
import fr.test.technique.hardis.item.Error;
import fr.test.technique.hardis.item.Reference;
import fr.test.technique.hardis.item.Report;
import fr.test.technique.hardis.utils.ColorEnum;

public class ReportAdapterTest {
	public Report reportTestExemple;
	public ReportJsonAdapter jsonAdapter;
	public ReportXmlAdapter xmlAdapter;
	
	/**
	 * initialisation des report pour tester les formats 
	 */
	@Before
	public void initTest(){
		//test pour les valeurs de l'exemple
		List<Reference> referencesExemple = new ArrayList<>();
		referencesExemple.add(new Reference(ColorEnum.R, 45.12, 27, "1460100040"));
		referencesExemple.add(new Reference(ColorEnum.G, 12.0, 145, "1460900848"));
		referencesExemple.add(new Reference(ColorEnum.G, 5.56, 19, "1462100044"));
		referencesExemple.add(new Reference(ColorEnum.B, 105.23, 97, "1462100403"));
		
		List<Error> errorsExemple = new ArrayList<>();
		errorsExemple.add(new Error(5, "Incorrect value for color", "1462100403;A;100.1;9"));
		
		reportTestExemple=new Report("Ref_07102014.txt", referencesExemple, errorsExemple);
		
		//init adapter
		jsonAdapter = new ReportJsonAdapter();
		xmlAdapter = new ReportXmlAdapter();
	}
	
	/**
	 * test de la conversion des objects en json
	 */
	@Test
	public void testToJson() {
		String resultReportExemple = jsonAdapter.toJson(reportTestExemple);
		Assert.assertEquals(ConstanteTest.expectedExempleJson, resultReportExemple);
	}
	
	/**
	 * test de la conversion des objects en xml
	 */
	@Test
	public void testToXml() {
		String resultReportExemple;
		try {
			resultReportExemple = xmlAdapter.toXml(reportTestExemple);
			Assert.assertEquals(ConstanteTest.expectedExempleXml, resultReportExemple);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
