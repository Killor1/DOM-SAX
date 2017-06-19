package dom.examples;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;

public class ParseDocument {

	public static void main(String[] args) {
		try{
			File inputFile =new File("input.xml");
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root Element: "+doc.getDocumentElement().getNodeName());
			NodeList nList=doc.getElementsByTagName("student");
			System.out.println("--------------------------");
			for(int i=0; i<nList.getLength();i++){
				Node nNode=nList.item(i);
				System.out.println("Current Element: "+nNode.getNodeName());
				if(nNode.getNodeType()==Node.ELEMENT_NODE){
					Element eElem=(Element)nNode;
					System.out.println("Student roll no: "+eElem.getAttribute("rollno"));
					System.out.println("Firstname : "+eElem.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Lastname : "+eElem.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nickname : "+eElem.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Marks : "+eElem.getElementsByTagName("marks").item(0).getTextContent());
				}
			}
		}catch(Exception e){
				e.printStackTrace();
			}
		}

	}