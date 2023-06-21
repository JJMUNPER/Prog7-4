package Org.LosRemedios.Programacion.T7.Actividades.Act4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ImportarXML {

    public static void main(String[] args) {
        try {
            File file = new File("C:/contactosImp.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            // Normaliza el XML
            doc.getDocumentElement().normalize();

            // Obtiene la lista de nodos de contacto
            NodeList nodeList = doc.getElementsByTagName("Contacto");

            // Recorre la lista de contactos
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoContacto = (Element) node;

                    // Obtener los valores de los campos de cada contacto
                    String nombre = elementoContacto.getElementsByTagName("Nombre").item(0).getTextContent();
                    String direccion = elementoContacto.getElementsByTagName("Direccion").item(0).getTextContent();
                    String telefono = elementoContacto.getElementsByTagName("Telefono").item(0).getTextContent();

                    // Imprimir valores
                    System.out.println("Contacto " + (i + 1));
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Dirección: " + direccion);
                    System.out.println("Teléfono: " + telefono);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
