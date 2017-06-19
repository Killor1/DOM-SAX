package dom.exercicis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

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

/*Exercici 2
Adaptar el codi de l'exemple pel cas de l'exercici d'accés aleatori. S'ha de treballar amb les dades inserides en aquell exercici, ID, cognom, 
departament i sou. Es demana implementar la classe EmpleatsDOM1.java  codi per crar un fitxer XML anomenat empleats.xml.
*/
public class EmpleatsDOM1 {
	  public static void loadTrebFromCsv() throws ParserConfigurationException, IOException, TransformerException{
	    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ManU\\Desktop\\prueba\\Treballadors.txt"));
	    String line;
	   
	    String id= null;
	    String cog = null;
	    String dept = null;
	    String sou = null;
	    
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.newDocument();
	    
	    Element root = doc.createElement("Treballadors");
	    doc.appendChild(root);
	    
	    while((line = br.readLine())!=null){
	      StringTokenizer stk = new StringTokenizer(line,",");
	      
	      while(stk.hasMoreElements()){
	    	   id = stk.nextToken();
	           cog = stk.nextToken();
	           dept = stk.nextToken();
	           sou= stk.nextToken();
	        }
	        Element treb = doc.createElement("Treballador");
		    root.appendChild(treb); 
		    	   
		    Attr idt = doc.createAttribute("Id");
	        idt.setValue(String.valueOf(id));
	        treb.setAttributeNode(idt);
	        
	        Element cogn = doc.createElement("Cognom");
	        treb.appendChild(cogn);
	        cogn.appendChild(doc.createTextNode(cog));
	        
	        Element salary = doc.createElement("Sou");
	        treb.appendChild(salary);
	        salary.appendChild(doc.createTextNode(String.valueOf(sou))); 
	        
	        Element deptt = doc.createElement("Departament");
	        treb.appendChild(deptt);
	        deptt.appendChild(doc.createTextNode(dept));
	        
	        
	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer trans = tf.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("C:\\Users\\ManU\\Desktop\\prueba\\Treballadors.xml"));
	        trans.transform(source, result);
	        
	        
	      }
	    }
	  public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
	    loadTrebFromCsv();
	  }
}