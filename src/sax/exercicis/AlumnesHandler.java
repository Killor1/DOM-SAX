package sax.exercicis;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AlumnesHandler extends DefaultHandler{
	boolean nom=false;
	
	@Override
	public void startElement (String uri, String localname, String qName, Attributes att ) throws SAXException{
		if(qName.equalsIgnoreCase("Alumne")){
			String edat =att.getValue("Edat");
			System.out.println(" Edat: "+edat);
		}else if(qName.equalsIgnoreCase("nom")){
			nom=true;
		}
	}
	@Override
	public void endElement (String uri, String localName, String qName) throws SAXException{
		if(qName.equalsIgnoreCase("Alumne")){
			System.out.println("End Element: "+qName);
		}
	}
	@Override
	public void characters(char ch[], int start, int lenght) throws SAXException{
		if(nom){
			System.out.println("First Name: "+new String(ch,start,lenght));
			nom= false;
	}	
}
}
