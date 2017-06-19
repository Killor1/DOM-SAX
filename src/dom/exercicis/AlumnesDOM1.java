/*Exercici 1
Utilitzar el codi de l'exemple per crea-ne una classe anomenada AlumnesDOM1.java  que crei un fitxer XML amb Alumnes, que guardi els elements
 de cada <Alumne> que conté els nodes <DNI>, <Nom>, <Cognom1>, <Cognom2>, <Ciutat> i <Assignatures> en el node arrel anomenat Alumnes, així com 
 el valor de l'atribut Edat de cada <Alumne>.
*/
package dom.exercicis;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

public class AlumnesDOM1 {
	static int op;
	
	
	public static void main(String[] args) throws ParserConfigurationException, NumberFormatException, IOException, TransformerException {
		DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc= db.newDocument();
		op=1;
		Element root =doc.createElement("Alumnes");
		doc.appendChild(root);
		while(op!=0){
			op=menu();
			if(op==1){
				String[] datos=cogerDatos();
				createXML(root,doc,datos);
				saveInFile(doc);
			}else if(op==2){
				System.out.println("");
				System.out.println("Esto en futuras entregas.........");
				System.out.println("");
			}
		}
	}
	public static void createXML(Element root,Document doc,String[] datos){
	
			Element alumne=doc.createElement("Alumne");
			root.appendChild(alumne);
			
			Attr edat =doc.createAttribute("Edat");
			edat.setValue(datos[0]);
			alumne.setAttributeNode(edat);
			
			Element dni=doc.createElement("DNI");
			dni.appendChild(doc.createTextNode(datos[1]));
			alumne.appendChild(dni);
			
			
			Element name=doc.createElement("Nom");
			name.appendChild(doc.createTextNode(datos[2]));
			alumne.appendChild(name);
			
			Element cog1=doc.createElement("cogNom1");
			cog1.appendChild(doc.createTextNode(datos[3]));
			alumne.appendChild(cog1);
			
			Element cog2=doc.createElement("cogNom2");
			cog2.appendChild(doc.createTextNode(datos[4]));
			alumne.appendChild(cog2);
			
			Element city=doc.createElement("Ciutat");
			city.appendChild(doc.createTextNode(datos[6]));
			alumne.appendChild(city);
			
			Element asig=doc.createElement("Asignatures");
			asig.appendChild(doc.createTextNode(datos[5]));
			alumne.appendChild(asig);
		
	}	
	public static void saveInFile(Document doc) throws TransformerException{
		TransformerFactory tf=TransformerFactory.newInstance();
		Transformer trans=tf.newTransformer();
		DOMSource source=new DOMSource(doc);
		StreamResult result=new StreamResult(new File("C:\\Users\\ManU\\Desktop\\prueba\\Alumnes.xml"));
		trans.transform(source, result);
		
		
	}
	public static String[] cogerDatos() throws IOException{
		String[] datos = new String[7];
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce la edad del alumno: ");
		String edad=br.readLine();
		datos[0]=edad;
		System.out.println("Introduce el DNI: ");
		String dni=br.readLine();
		datos[1]=dni;
		System.out.println("Introduce el nombre del alumno: ");
		String nom=br.readLine();
		datos[2]=nom;
		System.out.println("Introduce el primer apellido: ");
		String cog1=br.readLine();
		datos[3]=cog1;
		System.out.println("Introduce el segudno apellido: ");
		String cog2=br.readLine();
		datos[4]=cog2;
		System.out.println("Introduce las asignaturas del alumno: ");
		String asig=br.readLine();
		datos[5]=asig;
		System.out.println("Introduce la ciudad del alumno: ");
		String city=br.readLine();
		datos[6]=city;
		return datos;
	}
	public static int menu() throws NumberFormatException, IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("1)-Introducir Alumno");
		System.out.println("2)-Mostrar Alumnos");
		System.out.println("0)-Salir");
		op=Integer.parseInt(br.readLine());
		return op;
	}
}