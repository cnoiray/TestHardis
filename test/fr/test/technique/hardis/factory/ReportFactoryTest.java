package fr.test.technique.hardis.factory;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.test.technique.hardis.item.Reference;
import fr.test.technique.hardis.item.Report;
import fr.test.technique.hardis.constante.ConstanteTest;
import fr.test.technique.hardis.item.Error;
import fr.test.technique.hardis.utils.ColorEnum;

public class ReportFactoryTest {

	@Test
	public void testExemple() {
		Error errorExpected = new Error(5, "Incorrect value for color", "1462100403;A;100.1;9");
		Reference referenceExpected0 = new Reference(ColorEnum.R, 45.12, 27, "1460100040");
		Reference referenceExpected3 = new Reference(ColorEnum.B, 105.23, 97, "1462100403");
		List<String> listeLigne = Arrays.asList(ConstanteTest.expectedExempleTxt.split("\n"));
		
		Report result = ReportFactory.buildReport(listeLigne, "Ref_07102014.txt");
		
		Assert.assertNotNull(result);
		
		//test liste error
		Assert.assertNotNull(result.getErrors());
		Assert.assertTrue(result.getErrors().size()==1);
		testError(errorExpected, result.getErrors().get(0));
		
		//test liste reference
		Assert.assertNotNull(result.getReferences());
		Assert.assertTrue(result.getReferences().size()==4);
		testReference(referenceExpected0, result.getReferences().get(0));
		testReference(referenceExpected3, result.getReferences().get(3));
	}

	public void testError(Error expected, Error actual){
		Assert.assertEquals(expected.getLine(), actual.getLine());
		Assert.assertEquals(expected.getMessage(), actual.getMessage());
		Assert.assertEquals(expected.getValue(), actual.getValue());
	}
	
	public void testReference(Reference expected, Reference actual){
		Assert.assertEquals(expected.getNumReference(), actual.getNumReference());
		Assert.assertTrue(expected.getPrice()==actual.getPrice());
		Assert.assertEquals(expected.getSize(), actual.getSize());
		Assert.assertEquals(expected.getType(), actual.getType());
	}
}
