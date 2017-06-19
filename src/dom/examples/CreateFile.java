package dom.examples;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

public class CreateFile {
		
	public static void main(String[] args) {
		try{
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc= db.newDocument();
			
			Element root =doc.createElement("FP");
			doc.appendChild(root);
			
			Element grauSup=doc.createElement("CFGS");
			root.appendChild(grauSup);
			
			Attr atr =doc.createAttribute("familia");
			atr.setValue("Informatica");
			grauSup.setAttributeNode(atr);
			
			Element name=doc.createElement("cicle");
			Attr attrT=doc.createAttribute("id");
			attrT.setValue("ASIX");
			name.setAttributeNode(attrT);
			name.appendChild(doc.createTextNode("Administracio de Sistemes Informatics"));
			grauSup.appendChild(name);
			
			Element name1=doc.createElement("cicle");
			Attr attrT1=doc.createAttribute("id");
			attrT1.setValue("DAM");
			name1.setAttributeNode(attrT1);
			name1.appendChild(doc.createTextNode("Desenvolupament Aplicacions Multiplataforma"));
			grauSup.appendChild(name1);
			
			TransformerFactory tf=TransformerFactory.newInstance();
			Transformer trans=tf.newTransformer();
			DOMSource source=new DOMSource(doc);
			StreamResult result=new StreamResult(new File("cicles.xml"));
			trans.transform(source, result);
			
			StreamResult consResult=new StreamResult(System.out);
			trans.transform(source, consResult);
					
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
