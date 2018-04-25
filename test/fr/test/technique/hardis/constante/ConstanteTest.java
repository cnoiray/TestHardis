package fr.test.technique.hardis.constante;

public class ConstanteTest {
	public static String expectedExempleJson = "{\"inputFile\":\"Ref_07102014.txt\",\"references\":"
			+ "[{\"numReference\":\"1460100040\",\"size\":27,\"price\":45.12,\"type\":\"R\"},"
			+ "{\"numReference\":\"1460900848\",\"size\":145,\"price\":12.0,\"type\":\"G\"},"
			+ "{\"numReference\":\"1462100044\",\"size\":19,\"price\":5.56,\"type\":\"G\"},"
			+ "{\"numReference\":\"1462100403\",\"size\":97,\"price\":105.23,\"type\":\"B\"}],"
			+ "\"errors\":["
			+ "{\"line\":5,\"message\":\"Incorrect value for color\",\"value\":\"1462100403;A;100.1;9\"}]}";
	
	public static String expectedExempleXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
			+ "<report>\n"
			+ "    <inputFile>Ref_07102014.txt</inputFile>\n"
			+ "    <references>\n"
			+ "        <reference color=\"R\" price=\"45.12\" size=\"27\" numReference=\"1460100040\"/>\n"
			+ "        <reference color=\"G\" price=\"12.0\" size=\"145\" numReference=\"1460900848\"/>\n"
			+ "        <reference color=\"G\" price=\"5.56\" size=\"19\" numReference=\"1462100044\"/>\n"
			+ "        <reference color=\"B\" price=\"105.23\" size=\"97\" numReference=\"1462100403\"/>\n"
			+ "    </references>\n"
			+ "    <errors>\n"
			+ "        <error line=\"5\" message=\"Incorrect value for color\">1462100403;A;100.1;9</error>\n"
			+ "    </errors>\n"
			+ "</report>\n";
	
	public static String expectedExempleTxt = "1460100040;R;45.12;27\n"
			+ "1460900848;G;12.0;145\n"
			+ "1462100044;G;5.56;19\n"
			+ "1462100403;B;105.23;97\n"
			+ "1462100403;A;100.1;9\n";
}
