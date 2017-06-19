package dom.exercicis;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
Exercici 3
Implementar un altre classe anomenada EmpleatsDOM2.java per llegir aquest XML creat i ensenyar els registres per pantalla (especificant les
 dades, per exemple “ID: XX,Cognom: XXXX, Departament: XX, Sou: XXXX”).

 * */
public class EmpleatsDOM2 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse("C:\\Users\\ManU\\Desktop\\prueba\\Treballadors.xml");
	    
	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getElementsByTagName("Treballador");
	    
	    for (int i=0; i<nList.getLength(); i++){
	    	Node nNode = nList.item(i);
	    	if(nNode.getNodeType()==Node.ELEMENT_NODE){
	    		
	    		Element eElement = (Element)nNode;
	    		
	    		
	    		System.out.println("Id: "+eElement.getElementsByTagName("Id").item(0).getTextContent());
	    		System.out.println("Cognom: "+eElement.getElementsByTagName("Cognom").item(0).getTextContent());
	    		System.out.println("Sou: "+eElement.getElementsByTagName("Sou").item(0).getTextContent());
	    		System.out.println("Departament: "+eElement.getElementsByTagName("Departament").item(0).getTextContent());
	        
	    		System.out.println(" ");
	      }
	    }
	  }
}