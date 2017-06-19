package dom.examples;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;

public class ModifyXML {

	public static void main(String[] args) {
		try{
			File in=new File("input2.xml");
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc= db.parse(in);
			Node cars=doc.getFirstChild();
			Node supercars=doc.getElementsByTagName("supercars").item(0);
			
			NamedNodeMap atr =supercars.getAttributes();
			Node nodeAtr=atr.getNamedItem("company");
			nodeAtr.setTextContent("Lamborgini");
			
			NodeList list=supercars.getChildNodes();
			for (int i=0;i<list.getLength();i++) {
				Node n=list.item(i);
				if(n.getNodeType()==Node.ELEMENT_NODE){
					Element eElem=(Element)n;
					if ("carname".equals(eElem.getNodeName())){
						if ("Ferrari 101".equals(eElem.getTextContent())){
							eElem.setTextContent("Lamborgini 001");
						}
						if ("Ferrari 202".equals(eElem.getTextContent())){
							eElem.setTextContent("Lamborgini 002");
						}
					}
				}
				NodeList childNodes=cars.getChildNodes();
				for (int j=0;j<childNodes.getLength();j++){
					Node node=childNodes.item(j);
					if("luxury".equals(node.getNodeName())){
						cars.removeChild(node);
					}
				}
				TransformerFactory tf=TransformerFactory.newInstance();
				Transformer trans=tf.newTransformer();
				DOMSource source=new DOMSource(doc);
				System.out.println("_________FITXER MOFIDICAT__________");
				StreamResult consoleResult =new StreamResult(System.out);
				trans.transform(source, consoleResult);
				
			}			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
