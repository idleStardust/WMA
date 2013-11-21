package XMLLogic;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
 
public class XMLReader {
 
    private Document DocumentoXML;
    private XPath xPath;
 
    public XMLReader( String xmlFile ) {
	Init( xmlFile );
    }
	
    public XMLReader( Document xmlDoc ) {
	this.DocumentoXML = xmlDoc;
	initAtributos( xmlDoc );
    }
 
    private void Init( String xmlFile ) {
	try {
	    DocumentoXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( xmlFile );
	    xPath =  XPathFactory.newInstance().newXPath();
	} catch (IOException ex) {
	    ex.printStackTrace();
	} catch (SAXException ex) {
	    ex.printStackTrace();
	} catch (ParserConfigurationException ex) {
	    ex.printStackTrace();
	}
    }
	
    public Document getDocument() {
	return this.DocumentoXML;
    }
	
    private void initAtributos( Document xmlDoc ) {
	DocumentoXML = xmlDoc;
	xPath =  XPathFactory.newInstance().newXPath();   
    }
 
    
    public String Lectura( String expression ) {		
	try {
	    XPathExpression xPathExpression =  xPath.compile( expression );
	    
	   
	    return (String) xPathExpression.evaluate( DocumentoXML, XPathConstants.STRING );
	} catch ( XPathExpressionException ex ) {
	    ex.printStackTrace();			
	    return "";
	    
	}
    }
	
    
    public void LecturaAtributos( String expression,String input) {		
    	Node staff = DocumentoXML.getElementsByTagName(expression).item(0);
    	NamedNodeMap nl = staff.getAttributes();
    	int length = nl.getLength();
    	for( int i=0; i<length; i++) {
    		 Attr attr = (Attr) nl.item(i);
    		 String name = attr.getName();
    		    String value = attr.getValue();
    	
    	}
        }

    
	
    
    
	
    public Boolean ver_string( String expression, String match ) {
	boolean res = false;
	String value = "";
	try {
	    XPathExpression xPathExpression =  xPath.compile( expression );
	    value = (String) xPathExpression.evaluate( DocumentoXML, XPathConstants.STRING );
	} catch ( XPathExpressionException ex ) {
	    ex.printStackTrace();			
	}
	if ( value.equalsIgnoreCase( match ) ) res = true;
	    return res;
	}
    
    
	
    public NodeList lecturaNodo_lista( String expression ) {
	NodeList nl = null;
	try {
	    XPathExpression xPathExpression =  xPath.compile( expression );
	    nl = (NodeList) xPathExpression.evaluate( DocumentoXML, XPathConstants.NODESET );
	} catch ( XPathExpressionException ex ) {
	    ex.printStackTrace();			
	}
	return nl;
    }
}