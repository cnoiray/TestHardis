/**
 * 
 */
package fr.test.technique.hardis.factory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.test.technique.hardis.item.Error;
import fr.test.technique.hardis.item.Reference;
import fr.test.technique.hardis.item.Report;
import fr.test.technique.hardis.utils.ColorEnum;

/**
 * @author clément
 *
 */
public class ReportFactory {
	public static Report buildReport(List<String> listLigne, String inputFileName){
		Report result = new Report(inputFileName);
		
		int index = 0;
		for (String ligne : listLigne) {
			index++;
			String[] elements = ligne.split(";");
			
			String numReference = "";
			int size = 0;
			double price = 0;
			ColorEnum type = null;
			
			//vérification du nombre de parametre dans la ligne
			if(elements.length!=4){
				result.getErrors().add(buildErrorElementsNbr(index, ligne));
				continue;
			}
			
			//vérification de la taille du numero de référence
			Pattern pattern = Pattern.compile("[0-9]{10}");
			Matcher matcher = pattern.matcher(elements[0]);
			if(matcher.find() && matcher.groupCount()==0){
				numReference=matcher.group(0);
			}else{
				result.getErrors().add(buildErrorReferenceNumSize(index, ligne));
				continue;
			}
			
			//vérification de la valeur de la couleur
			try {
				type = ColorEnum.valueOf(elements[1].toUpperCase());
			} catch (IllegalArgumentException e) {
				result.getErrors().add(buildErrorColorType(index, ligne));
				continue;
			}
			
			try {
				//convertion du prix
				price = Double.parseDouble(elements[2]);
				
				//convertion de la taille
				size = Integer.valueOf(elements[3]);
	        } catch(NumberFormatException e) {
	        	result.getErrors().add(buildErrorConvertionNumeric(index, ligne));
				continue;
	        }
			
			result.getReferences().add(new Reference(type, price, size, numReference));
		}
		
		return result;
	}
	
	private static Error buildErrorElementsNbr(int index, String ligne){
		return new Error(index, "Incorrect number of values", ligne);
	}
	
	private static Error buildErrorReferenceNumSize(int index, String ligne){
		return new Error(index, "Incorrect size of reference num", ligne);
	}
	
	private static Error buildErrorColorType(int index, String ligne){
		return new Error(index, "Incorrect value for color", ligne);
	}
	
	private static Error buildErrorConvertionNumeric(int index, String ligne){
		return new Error(index, "Incorrect numeric value for size or price", ligne);
	}
}
