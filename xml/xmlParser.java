package xml;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
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
				System.out.println("Ejercicio 1:\n\tHay "+listaplantas.getLength()+" plantas");
				NodeList listaespecies=elementoraiz.getElementsByTagName("BOTANICAL");
				System.out.println("Primera especie "+listaespecies.item(0).getTextContent());
				Set<String> especies=new HashSet<String>();
				for (int i = 0; i < listaespecies.getLength(); i++) {
					especies.add(listaespecies.item(i).getFirstChild().getTextContent());
				}
				System.out.println("Ejercicio 2:\n\tEspecies distintas: "+especies.size());
				
				NodeList listaprecios=elementoraiz.getElementsByTagName("PRICE");
				double minPrecio=1000000,maxPrecio=0,suma = 0,tmpPrecio=0.0;
				for (int i = 0; i < listaprecios.getLength(); i++) {
					tmpPrecio=Double.parseDouble(listaprecios.item(i).getFirstChild().getTextContent().replace("$", "").trim());
					suma+=tmpPrecio;
					minPrecio=tmpPrecio < minPrecio ? tmpPrecio : minPrecio;
					maxPrecio=tmpPrecio > maxPrecio ? tmpPrecio : maxPrecio; 
				}
				System.out.println("Ejercicio 3:\n\tPrecio total "+suma);
				System.out.println("Ejercicio 4:\n\tPrecio minimo: "+minPrecio+"\tPrecio maximo: "+maxPrecio);
				DecimalFormat df = new DecimalFormat("0.00");
				System.out.println("Precio medio: "+df.format(suma/listaprecios.getLength()));
				System.out.printf("Precio maximo %1$.2f\n Precio minimo %2$.2f\n Precio medio: %3$.2f\n"
						,minPrecio,maxPrecio,suma/listaprecios.getLength());
				
				//Solucion usando un HashMap
				
				HashMap<Double, String> mapa=new HashMap<Double, String>(listaplantas.getLength());
				for (int i = 0; i < listaplantas.getLength(); i++) {
					mapa.put(Double.parseDouble(((Element) listaplantas.item(i)).getElementsByTagName("PRICE").item(0).getFirstChild().getTextContent().substring(1).trim()),
							((Element)listaplantas.item(i)).getElementsByTagName("COMMON").item(0).getFirstChild().getTextContent()
							);
				}
				System.out.printf("Ejercicio 5: Precio maximo=%1$.2f  ,common=%2$s\n",maxPrecio,mapa.get(maxPrecio));
				System.out.printf("Ejercicio 5: Precio minimo=%1$.2f  ,common=%2$s\n",minPrecio,mapa.get(minPrecio));
				
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
