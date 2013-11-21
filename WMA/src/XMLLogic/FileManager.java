package XMLLogic;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class FileManager {
	 static int i=1;
	
	static void crearXML(){
	    	String xml="test";
	    	xml=xml+i;
	    	i+=1;
	    	xml=xml+".xml";
	    	System.out.println("popo"+xml);
	    	
	    	try {		 
	    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	    		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	     
	    		// elementos de la raiz
	    		Document doc = docBuilder.newDocument();
	    		Element rootElement = doc.createElement("company");
	    		doc.appendChild(rootElement);
	     
	    		// staff elements
	    		Element staff = doc.createElement("Staff");
	    		rootElement.appendChild(staff);
	     
	    		// set attribute to staff element
	    		Attr attr = doc.createAttribute("id");
	    		attr.setValue("5");
	    		staff.setAttributeNode(attr);
	    
	    		
	     
	    		// firstname elements
	    		Element firstname = doc.createElement("firstname");
	    		firstname.appendChild(doc.createTextNode("yong"));
	    		staff.appendChild(firstname);
	     
	    		// lastname elements
	    		Element lastname = doc.createElement("lastname");
	    		lastname.appendChild(doc.createTextNode("mook kim"));
	    		staff.appendChild(lastname);
	     
	    		// nickname elements
	    		Element nickname = doc.createElement("nickname");
	    		nickname.appendChild(doc.createTextNode("mkyong"));
	    		staff.appendChild(nickname);
	     
	    		// salary elements
	    		Element salary = doc.createElement("salary");
	    		salary.appendChild(doc.createTextNode("100000"));
	    		staff.appendChild(salary);
	     
	    		
	    		// write the content into xml file
	    		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    		Transformer transformer = transformerFactory.newTransformer();
	    		DOMSource source = new DOMSource(doc);
	    		StreamResult result = new StreamResult(new File("/Users/macbook/Documents/workspace/3er_Proyecto/src/xml/"+xml));
	     
	    		
	     
	    		transformer.transform(source, result);
	     
	    	  } catch (ParserConfigurationException pce) {
	    		pce.printStackTrace();
	    	  } catch (TransformerException tfe) {
	    		tfe.printStackTrace();
	    	  }
	    	
	    	
	    	}

}
