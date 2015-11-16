package xml;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class xmlParser {
	/**
	 * 
	 * @param args[0] Nombre del fichero XML a procesar
	 * @throws SAXException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, SAXException {
		// TODO Auto-generated method stub
		try {
			//DocumentBuilder factoria=DomUtil.newBuilder(false);
			if (args.length==1) {
				Document midocumento=DomUtil.parse(args[0], false);
				//recursiveXMLMalker(midocumento.getDocumentElement(), 0);
				Element elementoraiz=midocumento.getDocumentElement();
				System.out.println("El elemento raiz del XMl es: "+elementoraiz.getTagName());
				NodeList listaplantas=elementoraiz.getElementsByTagName("PLANT");
				System.out.println("Hay "+listaplantas.getLength()+" plantas");
				NodeList listaespecies=elementoraiz.getElementsByTagName("BOTANICAL");
				System.out.println("Primera especie "+listaespecies.item(0).getTextContent());
				Set<String> especies=new HashSet<String>();
				for (int i = 0; i < listaespecies.getLength(); i++) {
					especies.add(listaespecies.item(i).getFirstChild().getTextContent());
				}
				System.out.println("Especies distintas: "+especies.size());
				
				NodeList listaprecios=elementoraiz.getElementsByTagName("PRICE");
				double suma=0;
				for (int i = 0; i < listaprecios.getLength(); i++) {
					suma+=Double.parseDouble(listaprecios.item(i).getFirstChild().getTextContent().replace("$", "").trim());
				}
				System.out.println("Precio total "+suma);
			}
			else{
				System.out.println("Sin argumentos");
			}	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No se puede procesar el archivo XML :( "+e.toString());
		}
		
	}
	public static int recursiveXMLMalker(Node nodo,int ident){
		int total=1;
		Element elemento;
		do {
			if (nodo.getNodeType()==1) {
				for (int i = 0; i < ident; i++) {
					System.out.print(" ");
				}
				System.out.print("Encontrado elemento. "+nodo.getNodeName());
				elemento=(Element) nodo;
				if (elemento.getChildNodes().getLength()<=1) {
					System.out.println("\t Contenido: "+elemento.getTextContent());
				}
				System.out.println(".");
			}
				if (nodo.hasChildNodes()) {
					total+=recursiveXMLMalker(nodo.getFirstChild(),ident+1);
				}
		} while ((nodo=nodo.getNextSibling())!=null);
		return total;
	}
}
