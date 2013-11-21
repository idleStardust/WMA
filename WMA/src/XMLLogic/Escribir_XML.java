package XMLLogic;
import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

 
public class Escribir_XML {
    private String fileName;
    private Document xmlDocument;
    private XPath xPath;
    
 

   
    public Escribir_XML( String xmlFile ) {
        this.setFileName(xmlFile);
        cargarXML( xmlFile );
    }
	

    public Escribir_XML( Document xmlDoc ) {
        this.fileName = "default.xml";
        this.xmlDocument = xmlDoc;
        initObjects( xmlDocument );
    }
	
 
    public Escribir_XML( Document xmlDoc, String file ) {
        this.setFileName(file);
        this.xmlDocument = xmlDoc;
        initObjects( xmlDocument );
    }
 
    public void cargarXML( String xmlfile ){
        try {
            xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( xmlfile );
            xPath =  XPathFactory.newInstance().newXPath();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }
	
    private void initObjects( Document xmlDoc ) {
        xmlDocument = xmlDoc;
        xPath =  XPathFactory.newInstance().newXPath();
    }
 
    public void escribir_archivo( String expression, String theValue, String outFileName ) {
 
        Object result = null;		
        try {
            XPathExpression expr = xPath.compile( expression );
            result = expr.evaluate( xmlDocument , XPathConstants.NODESET );
        } catch ( XPathExpressionException e ) {
            e.printStackTrace();
        }
 
        NodeList nodes = (NodeList) result;
        Element el = (Element)nodes.item(0);
        el.setTextContent( theValue );
        
        DOMSource source = new DOMSource( xmlDocument );
        PrintStream ps = null;
		
        try {
            ps = new PrintStream( outFileName );
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        }
		
        StreamResult resultStr = new StreamResult( ps );
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
		
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); 
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, resultStr);
        } catch ( TransformerConfigurationException e ) {
            e.printStackTrace();
        } catch ( TransformerException e ) {
            e.printStackTrace();
        }
    }
	
    
    public void editarAtributo( String expression,String atributte,  String theValue,String outFileName) {
    	 System.out.println("expression"+expression);
    	 System.out.println("attribute"+atributte);
    	 System.out.println("value"+theValue);
    	Node staff = xmlDocument.getElementsByTagName(expression).item(0);
    	NamedNodeMap attr = staff.getAttributes();
		Node nodeAttr = attr.getNamedItem(atributte);
		nodeAttr.setNodeValue(theValue);
		DOMSource source = new DOMSource( xmlDocument );
	     PrintStream ps = null;
			
	        try {
	            ps = new PrintStream( outFileName );
	        } catch ( FileNotFoundException e ) {
	            e.printStackTrace();
	        }
			
	        StreamResult resultStr = new StreamResult( ps );
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = null;
			
	        try {
	            transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); 
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
	            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	            transformer.transform(source, resultStr);
	        } catch ( TransformerConfigurationException e ) {
	            e.printStackTrace();
	        } catch ( TransformerException e ) {
	            e.printStackTrace();
	        }
    }
    
    
    
    public Document writeTextByXPathToMemory( String expression, String theValue ) {
 
        Object result = null;		
        try {
            XPathExpression expr = xPath.compile( expression );
            result = expr.evaluate( xmlDocument , XPathConstants.NODESET );
        } catch ( XPathExpressionException e ) {
            e.printStackTrace();
        }
 
        NodeList nodes = (NodeList) result;
        Element el = (Element)nodes.item(0);
        el.setTextContent( theValue );
        DOMSource source = new DOMSource( xmlDocument );
		
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        DocumentBuilder builder = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        }
        Document resultDoc = builder.newDocument();
        Result resultDOM = new DOMResult( resultDoc );
		
        try {
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); 
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform( source, resultDOM );
        } catch ( TransformerConfigurationException e ) {
            e.printStackTrace();
        } catch ( TransformerException e ) {
            e.printStackTrace();
        }		
        return resultDoc;
    }
 
    public String obtenerNombre() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
        cargarXML( fileName );
    }
	
}