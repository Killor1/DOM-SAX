package sax.exemples;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler{
	boolean bFirstName= false;
	boolean bLastName = false;
	boolean bNickName = false;
	boolean bMarks = false;
	
	public void startElement(String uri, String localName, String qName, Attributes att ) throws SAXException{
		if (qName.equalsIgnoreCase("student")){
			String rollNo = att.getValue("rollno");
			System.out.println("Roll No: "+rollNo);
		}else if (qName.equalsIgnoreCase("firstname")){
			bFirstName=true;
		}else if (qName.equalsIgnoreCase("lastname")){
			bLastName=true;
		}else if (qName.equalsIgnoreCase("nickname")){
			bNickName=true;
		}else if (qName.equalsIgnoreCase("marks")){
			bMarks=true;
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		if(qName.equalsIgnoreCase("student")){
			System.out.println("End Element: "+qName);
		}
	}
	@Override
	public void characters(char ch[], int start, int lenght) throws SAXException{
		if(bFirstName){
			System.out.println("First Name: "+new String(ch,start,lenght));
			bFirstName= false;
		}else if(bLastName){
			System.out.println("Last Name: "+new String(ch,start,lenght));
			bLastName= false;
		}else if(bNickName){
			System.out.println("Nick Name: "+new String(ch,start,lenght));
			bNickName= false;
		}else if(bMarks){
			System.out.println("Marks: "+new String(ch,start,lenght));
			bMarks= false;
		}
	}
}
