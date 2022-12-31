/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import model.carEnum;
import model.user;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author PC
 */
public class XmlRead {
    //Állítsd át magadnak
<<<<<<< Updated upstream
    //Külön fájlba tároljuk a különböző osztályokat mert az xml írás fellülír mindent
    private static final String CARXML = "D:\\Netbeans Projects\\Autokatalogus\\src\\main\\java\\model\\kocsi.xml";
=======
    private static final String CARXML = "C:\\Users\\balaz\\Documents\\GitHub\\Autokatalogus\\src\\main\\java\\model\\kocsi.xml";
>>>>>>> Stashed changes
    private static final String USERXML = "D:\\Kiko\\netbeans\\projektek\\Autokatalogus\\src\\main\\java\\model\\users.xml";
    
    public JSONArray carRead() {
        JSONArray read = new JSONArray();
        //String FILENAME = "car.xml";
        
        //String FILENAME = "C:\\Users\\PC\\Desktop\\car.xml";
        //String FILENAME = "D:\\Netbeans Projects\\progmod2beadando\\src\\main\\java\\controller\\submitted.xml";
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {
          
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(CARXML));
          doc.getDocumentElement().normalize();

          
          
          NodeList list = doc.getElementsByTagName("car");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  String id = element.getAttribute("id");//lineup id

                  //szöveg
                  /*String mapstring = element.getElementsByTagName("map").item(0).getTextContent();
                  MapEnum map= MapEnum.valueOf(mapstring);
                  String landingLocation = element.getElementsByTagName("landingLocation").item(0).getTextContent();
                  String aimLocation = element.getElementsByTagName("aimLocation").item(0).getTextContent();
                  String UI = element.getElementsByTagName("UI").item(0).getTextContent();*/
                  
                  String brand = element.getElementsByTagName("brand").item(0).getTextContent();
                  String modell = element.getElementsByTagName("modell").item(0).getTextContent();
                  String kivitel = element.getElementsByTagName("kivitel").item(0).getTextContent();
                  String evjarat = element.getElementsByTagName("evjarat").item(0).getTextContent();
                  String alvaz = element.getElementsByTagName("alvaz").item(0).getTextContent();
                  String motor = element.getElementsByTagName("motor").item(0).getTextContent();
                  String uzemanyag = element.getElementsByTagName("uzemanyag").item(0).getTextContent();
                  String szin = element.getElementsByTagName("szin").item(0).getTextContent();
                  String meghajts = element.getElementsByTagName("meghajt").item(0).getTextContent();
                  carEnum meghajt = carEnum.valueOf(meghajts);
                  String telj = element.getElementsByTagName("telj").item(0).getTextContent();
                  String henger = element.getElementsByTagName("henger").item(0).getTextContent();
                  String fogyaszt = element.getElementsByTagName("fogyaszt").item(0).getTextContent();
                  String ajtok = element.getElementsByTagName("ajtok").item(0).getTextContent();
                  String ules = element.getElementsByTagName("ules").item(0).getTextContent();

                  
                  
                  read.put("id: " + id);
                  read.put("Marka: " + brand);
                  read.put("Modell: " + modell);
                  read.put("Ules: " + ules);
                  read.put("Kivitel: " + kivitel);
                  read.put("Evjarat: " + evjarat);
                  read.put("Alvaz: " + alvaz);
                  read.put("Motor: " + motor);
                  read.put("Uzemanyag: " + uzemanyag);
                  read.put("Szin: " + szin);
                  read.put("Meghajtas: " + meghajt);
                  read.put("Teljesitmeny: " + telj);
                  read.put("Henger: " + henger);
                  read.put("Fogyasztas: " + fogyaszt);
                  read.put("Ajtok szama: " + ajtok);
                  read.put("Ulesek szama: " + ules);
              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
      
        return read;
  }
    
    public JSONArray carValaszt(String alvazszam, String motorszam) {
        JSONArray read = new JSONArray();
      
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {
          
          DocumentBuilder db = dbf.newDocumentBuilder();

          Document doc = db.parse(new File(CARXML));
          doc.getDocumentElement().normalize();

          
          
          NodeList list = doc.getElementsByTagName("car");

          for (int temp = 0; temp < list.getLength(); temp++) {

              Node node = list.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {

                  Element element = (Element) node;

                  String id = element.getAttribute("id");//lineup id

                  //szöveg
                  String brand = element.getElementsByTagName("brand").item(0).getTextContent();
                  String modell = element.getElementsByTagName("modell").item(0).getTextContent();
                  String kivitel = element.getElementsByTagName("kivitel").item(0).getTextContent();
                  String evjarat = element.getElementsByTagName("evjarat").item(0).getTextContent();
                  String alvaz = element.getElementsByTagName("alvaz").item(0).getTextContent();
                  String motor = element.getElementsByTagName("motor").item(0).getTextContent();
                  String uzemanyag = element.getElementsByTagName("uzemanyag").item(0).getTextContent();
                  String szin = element.getElementsByTagName("szin").item(0).getTextContent();
                  String meghajts = element.getElementsByTagName("meghajt").item(0).getTextContent();
                  carEnum meghajt = carEnum.valueOf(meghajts);
                  String telj = element.getElementsByTagName("telj").item(0).getTextContent();
                  String henger = element.getElementsByTagName("henger").item(0).getTextContent();
                  String fogyaszt = element.getElementsByTagName("fogyaszt").item(0).getTextContent();
                  String ajtok = element.getElementsByTagName("ajtok").item(0).getTextContent();
                  String ules = element.getElementsByTagName("ules").item(0).getTextContent();

                  Integer alvazi = Integer.valueOf(alvaz);
                  Integer motori = Integer.valueOf(motor);
                if(motor.equals(motorszam)) {
                      if (alvaz.equals(alvazszam)) {
                          read.put("id: " + id);
                          read.put("Marka: " + brand);
                          read.put("Modell: " + modell);
                          read.put("Ules: " + ules);
                          read.put("Kivitel: " + kivitel);
                          read.put("Evjarat: " + evjarat);
                          read.put("Alvaz: " + alvaz);
                          read.put("Motor: " + motor);
                          read.put("Uzemanyag: " + uzemanyag);
                          read.put("Szin: " + szin);
                          read.put("Meghajtas: " + meghajt);
                          read.put("Teljesitmeny: " + telj);
                          read.put("Henger: " + henger);
                          read.put("Fogyasztas: " + fogyaszt);
                          read.put("Ajtok szama: " + ajtok);
                          read.put("Ulesek szama: " + ules);
                      }
                }
              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
      
        return read;
  }
    
     public ArrayList UserRead() {
                 ArrayList<user> users = new ArrayList<>();
        try {
            DocumentBuilderFactory documentBuilderFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =
                    documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(USERXML);

            Element rootElement = document.getDocumentElement();

            NodeList childNodesList = rootElement.getChildNodes();

            int numberOfElementNodes = 0;
            Node node;
            for (int i = 0; i < childNodesList.getLength(); i++) {
                node = childNodesList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    numberOfElementNodes++;
                    NodeList childNodesOfBooksTag = node.getChildNodes();
                    String id = "", name = "", phone = "", email = "", cim = "", szul = "";
                    //int temp =childNodesOfBooksTag.getLength();
                    for (int j = 0; j < childNodesOfBooksTag.getLength(); j++) {

                         if (childNodesOfBooksTag.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            if (null!=childNodesOfBooksTag.item(j).getNodeName())switch (childNodesOfBooksTag.item(j).getNodeName()) {
                                 case "id":
                                     id = childNodesOfBooksTag.item(j).getTextContent();
                                     break;
                                 case "name":
                                     name = childNodesOfBooksTag.item(j).getTextContent();
                                     break;                               
                                 case "phone":
                                     phone = childNodesOfBooksTag.item(j).getTextContent();
                                     break;
                                 case "email":
                                     email = childNodesOfBooksTag.item(j).getTextContent();
                                     break;
                                 case "cim":
                                     cim = childNodesOfBooksTag.item(j).getTextContent();
                                     break;
                                 case "szul":
                                     szul = childNodesOfBooksTag.item(j).getTextContent();
                                     break;
                                 default:
                                     break;
                             }
                           }
                    }
                    
                    Long l = Long.parseLong(szul);
                    Date d = new Date(l);
                    
                    users.add(new user(name,id,phone,email,cim,d));
                    }
                
                    
                }
            
        } catch (Exception e) {          
            e.printStackTrace();
        }
        return users;
     }

    
}