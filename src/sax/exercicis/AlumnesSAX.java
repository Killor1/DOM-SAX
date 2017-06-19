/*Exercici 4 
Donat el xml obtingut en el primer exercici de DOM implementar la classe AlumnesSAX.java, utilitzant el parser SAX per ensenyar 
la informació dels alumnes (Nom i Edat) per pantalla.
*/


package sax.exercicis;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class AlumnesSAX {
	public static void main(String[] args) {
		try{
			File inputFile = new File ("C:\\Users\\ManU\\Desktop\\prueba\\Alumnes.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser =factory.newSAXParser();
			AlumnesHandler userhandler =new AlumnesHandler();
			saxParser.parse(inputFile, userhandler);
		}catch(Exception e ){
			e.printStackTrace();
		}

	}
}
