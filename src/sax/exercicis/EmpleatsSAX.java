package sax.exercicis;
/*
Exercici 5
Fer el mateix per al fitxer que vau crear en l'exercici 2 de DOM implementar la classe EmpleatsSAX.java,  */
import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class EmpleatsSAX {
	public static void main(String[] args) {
		try{
			File inputFile = new File ("C:\\Users\\ManU\\Desktop\\prueba\\Treballadors.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser =factory.newSAXParser();
			EmpleatsHandler userhandler =new EmpleatsHandler();
			saxParser.parse(inputFile, userhandler);
		}catch(Exception e ){
			e.printStackTrace();
		}

	}
}
