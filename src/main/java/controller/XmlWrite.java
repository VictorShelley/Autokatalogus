/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import model.user;



public class XmlWrite {
    //
    private static final String CARXML = "D:\\Netbeans Projects\\Autokatalogus\\src\\main\\java\\model\\kocsi.xml";
    private static final String USERXML = "D:\\Kiko\\netbeans\\projektek\\Autokatalogus\\src\\main\\java\\model\\users.xml";
    
    
    public static void UserWhite(ArrayList<user> users) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("users");
            document.appendChild(rootElement);

            for (int i=0; i<users.size();i++) {
                Element bookElement = document.createElement("user");
                rootElement.appendChild(bookElement);
                createChildElement(document, bookElement, "id", users.get(i).getId());
                createChildElement(document, bookElement, "name", users.get(i).getName());
                createChildElement(document, bookElement, "phone", users.get(i).getPhone());
                createChildElement(document, bookElement, "email", users.get(i).getEmail());
                createChildElement(document, bookElement, "cim", users.get(i).getCim());
                createChildElement(document, bookElement, "szul", users.get(i).getSzul().toString());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(USERXML));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("Sikeres mentés\n");
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
    }
    private static void createChildElement(Document document, Element parent,
                                           String tagName, String value) {
        Element element = document.createElement(tagName);
        element.setTextContent(value);
        parent.appendChild(element);
    }
}
    

