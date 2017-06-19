package dom.examples;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;

public class QueryXMLFile {

	public static void main(String[] args) {
		try{
			File in=new File("cars.xml");
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc= db.parse(in);
			doc.getDocumentElement().normalize();
			System.out.print("Root Element: ");
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nList =doc.getElementsByTagName("supercars");
			System.out.println("____________________________________");
			for (int i=0;i<nList.getLength();i++){
				Node nNode=nList.item(i);
				System.out.print("Current Element: ");
				System.out.println(nNode.getNodeName());
				if(nNode.getNodeType()==Node.ELEMENT_NODE){
					Element eElem=(Element)nNode;
					System.out.print("Company :");
					System.out.println(eElem.getAttribute("company"));
					NodeList carList=eElem.getElementsByTagName("carname");
					for(int j=0;j<carList.getLength();j++){
						Node nodeC=carList.item(j);
						if(nodeC.getNodeType()==nodeC.ELEMENT_NODE){
							Element car=(Element)nodeC;
							System.out.print("Car Name: ");
							System.out.println(car.getTextContent());
							System.out.print("Car Type: ");
							System.out.println(car.getAttribute("type"));
						}
						
					}
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
