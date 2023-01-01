/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.File;
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
import org.json.JSONArray;
import org.w3c.dom.Attr;



public class XmlWrite {
    // Állítsd át magadnak
    private static final String CARXML = "C:\\Users\\balaz\\Documents\\GitHub\\Autokatalogus\\src\\main\\java\\model\\kocsi.xml";
    private static final String USERXML = "C:\\Users\\balaz\\Documents\\GitHub\\Autokatalogus\\src\\main\\java\\model\\users.xml";
    //private static final String CARXML = "D:\\Netbeans Projects\\Autokatalogus\\src\\main\\java\\model\\kocsi.xml";
    //private static final String USERXML = "D:\\Kiko\\netbeans\\projektek\\Autokatalogus\\src\\main\\java\\model\\users.xml";
    
    
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
                createChildElement(document, bookElement, "szul", String.valueOf(users.get(i).getSzul())); //.getTime() 
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
    
    public static boolean CarAdd(JSONArray uj) /*throws ParserConfigurationException, TransformerException*/ {
       
    JSONArray done = new JSONArray();
    XmlRead fa = new XmlRead();
    done = fa.CarReadData();
    int eddigi = 0;
    try {
        DocumentBuilderFactory dbFactory =
        DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        // root element
        Element rootElement = doc.createElement("cars");
        doc.appendChild(rootElement);
        for(int i = 0;i<done.length();i=i+15){
        Element car = doc.createElement("car");
        rootElement.appendChild(car);

        Attr attr = doc.createAttribute("id");
        attr.setValue(String.valueOf(eddigi));
        car.setAttributeNode(attr);
        
        
        Element brand = doc.createElement("brand");
        brand.appendChild(doc.createTextNode(done.get(i+1).toString()));
        car.appendChild(brand);

        Element modell = doc.createElement("modell");
        modell.appendChild(doc.createTextNode(done.get(i+2).toString()));
        car.appendChild(modell);

        Element kivitel = doc.createElement("kivitel");
        kivitel.appendChild(doc.createTextNode(done.get(i+3).toString()));
        car.appendChild(kivitel);
        
        Element evjarat = doc.createElement("evjarat");
        evjarat.appendChild(doc.createTextNode(done.get(i+4).toString()));
        car.appendChild(evjarat);
        
        Element alvaz = doc.createElement("alvaz");
        alvaz.appendChild(doc.createTextNode(done.get(i+5).toString()));
        car.appendChild(alvaz);
        
        Element motor = doc.createElement("motor");
        motor.appendChild(doc.createTextNode(done.get(i+6).toString()));
        car.appendChild(motor);
        
        Element uzemanyag = doc.createElement("uzemanyag");
        uzemanyag.appendChild(doc.createTextNode(done.get(i+7).toString()));
        car.appendChild(uzemanyag);
        
        Element szin = doc.createElement("szin");
        szin.appendChild(doc.createTextNode(done.get(i+8).toString()));
        car.appendChild(szin);
        
        Element meghajt = doc.createElement("meghajt");
        meghajt.appendChild(doc.createTextNode(done.get(i+9).toString()));
        car.appendChild(meghajt);
        
        Element telj = doc.createElement("telj");
        kivitel.appendChild(doc.createTextNode(done.get(i+10).toString()));
        car.appendChild(telj);
        
        Element henger = doc.createElement("henger");
        henger.appendChild(doc.createTextNode(done.get(i+11).toString()));
        car.appendChild(henger);
        
        Element fogyaszt = doc.createElement("fogyaszt");
        fogyaszt.appendChild(doc.createTextNode(done.get(i+12).toString()));
        car.appendChild(fogyaszt);
        
        Element ajtok = doc.createElement("ajtok");
        ajtok.appendChild(doc.createTextNode(done.get(i+13).toString()));
        car.appendChild(ajtok);
        
        Element ules = doc.createElement("ules");
        ules.appendChild(doc.createTextNode(done.get(i+14).toString()));
        car.appendChild(ules);
        
        eddigi++;
        }
        
        
        Element car = doc.createElement("car");
        rootElement.appendChild(car);

        Attr attr = doc.createAttribute("id");
        attr.setValue(String.valueOf(eddigi));
        car.setAttributeNode(attr);
        
        
        Element brand = doc.createElement("brand");
        brand.appendChild(doc.createTextNode(uj.get(0).toString()));
        car.appendChild(brand);

        Element modell = doc.createElement("modell");
        modell.appendChild(doc.createTextNode(uj.get(1).toString()));
        car.appendChild(modell);

        Element kivitel = doc.createElement("kivitel");
        kivitel.appendChild(doc.createTextNode(uj.get(2).toString()));
        car.appendChild(kivitel);
        
        Element evjarat = doc.createElement("evjarat");
        evjarat.appendChild(doc.createTextNode(uj.get(3).toString()));
        car.appendChild(evjarat);
        
        Element alvaz = doc.createElement("alvaz");
        alvaz.appendChild(doc.createTextNode(uj.get(4).toString()));
        car.appendChild(alvaz);
        
        Element motor = doc.createElement("motor");
        motor.appendChild(doc.createTextNode(uj.get(5).toString()));
        car.appendChild(motor);
        
        Element uzemanyag = doc.createElement("uzemanyag");
        uzemanyag.appendChild(doc.createTextNode(uj.get(6).toString()));
        car.appendChild(uzemanyag);
        
        Element szin = doc.createElement("szin");
        szin.appendChild(doc.createTextNode(uj.get(7).toString()));
        car.appendChild(szin);
        
        Element meghajt = doc.createElement("meghajt");
        meghajt.appendChild(doc.createTextNode(uj.get(8).toString()));
        car.appendChild(meghajt);
        
        Element telj = doc.createElement("telj");
        kivitel.appendChild(doc.createTextNode(uj.get(9).toString()));
        car.appendChild(telj);
        
        Element henger = doc.createElement("henger");
        henger.appendChild(doc.createTextNode(uj.get(10).toString()));
        car.appendChild(henger);
        
        Element fogyaszt = doc.createElement("fogyaszt");
        fogyaszt.appendChild(doc.createTextNode(uj.get(11).toString()));
        car.appendChild(fogyaszt);
        
        Element ajtok = doc.createElement("ajtok");
        ajtok.appendChild(doc.createTextNode(uj.get(12).toString()));
        car.appendChild(ajtok);
        
        Element ules = doc.createElement("ules");
        ules.appendChild(doc.createTextNode(uj.get(13).toString()));
        car.appendChild(ules);
        
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(CARXML));
        transformer.transform(source, result);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return true;
  }
}
    

