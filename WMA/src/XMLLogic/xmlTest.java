package XMLLogic;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;



public class xmlTest implements Constants{
	static int i=1;
    public static void main( String[] args ) {
		
	// Escribir en un xml
	Escribir_XML fileWriter = new Escribir_XML( pathXml );
    //fileWriter.escribir_archivo( "/root/result/child[3]/internal/unique[1]", "123WE",pathXml );
    
    //Escribir otro valor
    fileWriter.cargarXML( pathXml);
   // fileWriter.escribir_archivo( "/root/result/child[2]" , "ED", pathXml );
    fileWriter.editarAtributo("correspondence", "to", "probando123",pathXml);
        
    
	// leer de un xml
    XMLReader reader = new XMLReader( pathXml );
	reader.LecturaAtributos("correspondence",pathXml);
	
	//System.out.println( "fileReader: " + reader.Lectura( "/root/result/child[3]/internal/unique[1]" ) );
		
	// cargar la copia del xml
    Document myDocument = reader.getDocument();

	Escribir_XML memWriter = new Escribir_XML( myDocument );
	//myDocument = memWriter.writeTextByXPathToMemory( "/root/result/child[3]/internal/unique[1]", "ED");
		
	// leer de la memoria del xml
	XMLReader memReader = new XMLReader( myDocument );
	//System.out.println( "memoryReader: " + memReader.Lectura( "/root/result/child[3]/internal/unique[1]" ) );		
    
	
    }
    
    
   
}

