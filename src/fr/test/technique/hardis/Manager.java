package fr.test.technique.hardis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.FilenameUtils;

import fr.test.technique.hardis.adapter.ReportJsonAdapter;
import fr.test.technique.hardis.adapter.ReportXmlAdapter;
import fr.test.technique.hardis.factory.ReportFactory;
import fr.test.technique.hardis.item.Report;

public class Manager {
	
	public static void main(String[] args) {
		//récupération des param d'entrée
		String cheminTxt = args[0];
		String formatSortie = args[1];
		String cheminFichierSortie = args[2];
		
		String resultConvertion;
		Report report = null;
		ReportJsonAdapter jsonAdapter = new ReportJsonAdapter();
		ReportXmlAdapter xmlAdapter = new ReportXmlAdapter();
		
		File fileTxt = new File(cheminTxt);
		String newFileName = FilenameUtils.removeExtension(fileTxt.getName());
		
		try {
			//récupération contenu du fichier txt
			List<String> listLignes = Files.readAllLines(fileTxt.toPath());
			
			//conversion des lignes en object Report
			report = ReportFactory.buildReport(listLignes, fileTxt.getName());
			
			//convertion de l'object Report en xml ou json puis export
			switch (formatSortie) {
			case "JSON":
				resultConvertion = jsonAdapter.toJson(report);
				newFileName+=".json";
				break;
			case "XML":
				resultConvertion = xmlAdapter.toXml(report);
				newFileName+=".xml";
				break;
			default:
				//par défaut xml
				resultConvertion = xmlAdapter.toXml(report);
				newFileName+=".xml";
				break;
			}
			
			//create outpute file
			File outputFile = new File(cheminFichierSortie+"/"+newFileName);
			FileWriter fileWriter = new FileWriter(outputFile);
			fileWriter.write(resultConvertion);
			fileWriter.flush();
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
