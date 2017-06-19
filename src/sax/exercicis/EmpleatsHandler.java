package sax.exercicis;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmpleatsHandler extends DefaultHandler{
	boolean cognom=false;
	boolean sou=false;
	boolean dept=false;
	
	@Override
	public void startElement (String uri, String localname, String qName, Attributes att ) throws SAXException{
		if(qName.equalsIgnoreCase("Treballador")){
			String id =att.getValue("Id");
			System.out.println(" ID: "+id);
		}else if(qName.equalsIgnoreCase("cognom")){
			cognom=true;
		}else if(qName.equalsIgnoreCase("sou")){
			sou=true;
		}else if(qName.equalsIgnoreCase("departament")){
			dept=true;
		}
	}
	@Override
	public void endElement (String uri, String localName, String qName) throws SAXException{
		if(qName.equalsIgnoreCase("Treballador")){
			System.out.println("End Element: "+qName);
		}
	}
	@Override
	public void characters(char ch[], int start, int lenght) throws SAXException{
		if(cognom){
			System.out.println("Last Name: "+new String(ch,start,lenght));
			cognom= false;
	}else if(sou){
		System.out.println("Salari: "+new String(ch,start,lenght));
		sou= false;
	}else if(dept){
		System.out.println("Departament: "+new String(ch,start,lenght));
		dept= false;
	}	
}
}