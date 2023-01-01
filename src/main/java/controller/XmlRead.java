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
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
    private static final String CARXML = "C:\\Users\\balaz\\Documents\\GitHub\\Autokatalogus\\src\\main\\java\\model\\kocsi.xml";
    private static final String USERXML = "C:\\Users\\balaz\\Documents\\GitHub\\Autokatalogus\\src\\main\\java\\model\\users.xml";
    //private static final String CARXML = "D:\\Netbeans Projects\\Autokatalogus\\src\\main\\java\\model\\kocsi.xml";
    //private static final String USERXML = "D:\\Kiko\\netbeans\\projektek\\Autokatalogus\\src\\main\\java\\model\\users.xml";
    
    public JSONObject carRead() {
        
        JSONObject mainObj = new JSONObject();
        JSONArray carList = new JSONArray();
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

                  JSONObject car = new JSONObject();
                  
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

                  car.put("id", id);
                  car.put("Marka", brand);
                  car.put("Modell", modell);
                  car.put("Ules", ules);
                  car.put("Kivitel", kivitel);
                  car.put("Evjarat", evjarat);
                  car.put("Alvaz", alvaz);
                  car.put("Motor", motor);
                  car.put("Uzemanyag", uzemanyag);
                  car.put("Szin", szin);
                  car.put("Meghajtas", meghajt);
                  car.put("Teljesitmeny", telj);
                  car.put("Henger", henger);
                  car.put("Fogyasztas", fogyaszt);
                  car.put("Ajtok szama", ajtok);
                  car.put("Ulesek szama", ules);
                
                  
                  carList.put(car);
                  
              }
          }
          mainObj.put("cars", carList);
          //read.put(read.getJSONObject(1).get("id").toString());
         

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
      
        return mainObj;
  }
    
    public JSONObject carValaszt(String alvazszam, String motorszam) {
        JSONObject car = new JSONObject();
      
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

                  String id = element.getAttribute("id");
                  String alvaz = element.getElementsByTagName("alvaz").item(0).getTextContent();
                  String motor = element.getElementsByTagName("motor").item(0).getTextContent();
                  if(motor.equals(motorszam)) {
                    if (alvaz.equals(alvazszam)) {
                        //szöveg
                        String brand = element.getElementsByTagName("brand").item(0).getTextContent();
                        String modell = element.getElementsByTagName("modell").item(0).getTextContent();
                        String kivitel = element.getElementsByTagName("kivitel").item(0).getTextContent();
                        String evjarat = element.getElementsByTagName("evjarat").item(0).getTextContent();
                        String uzemanyag = element.getElementsByTagName("uzemanyag").item(0).getTextContent();
                        String szin = element.getElementsByTagName("szin").item(0).getTextContent();
                        String meghajts = element.getElementsByTagName("meghajt").item(0).getTextContent();
                        carEnum meghajt = carEnum.valueOf(meghajts);
                        String telj = element.getElementsByTagName("telj").item(0).getTextContent();
                        String henger = element.getElementsByTagName("henger").item(0).getTextContent();
                        String fogyaszt = element.getElementsByTagName("fogyaszt").item(0).getTextContent();
                        String ajtok = element.getElementsByTagName("ajtok").item(0).getTextContent();
                        String ules = element.getElementsByTagName("ules").item(0).getTextContent();
                        
                        car.put("Id", id);
                        car.put("Marka",brand);
                        car.put("Modell",modell);
                        car.put("Ules", ules);
                        car.put("Kivitel", kivitel);
                        car.put("Evjarat", evjarat);
                        car.put("Alvaz", alvaz);
                        car.put("Motor", motor);
                        car.put("Uzemanyag", uzemanyag);
                        car.put("Szin", szin);
                        car.put("Meghajtas", meghajt);
                        car.put("Teljesitmeny", telj);
                        car.put("Henger", henger);
                        car.put("Fogyasztas", fogyaszt);
                        car.put("Ajtok szama", ajtok);
                        car.put("Ulesek szama", ules);
                    }
                }
              }
          }
      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
      
        return car;
  }
    
    public JSONArray CarReadData() {
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

                  String id = element.getAttribute("id");

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


                read.put(id);
                read.put(brand);
                read.put(modell);
                read.put(kivitel);
                read.put(evjarat);
                read.put(alvaz);
                read.put(motor);
                read.put(uzemanyag);
                read.put(szin);
                read.put(meghajt);
                read.put(telj);
                read.put(henger);
                read.put(fogyaszt);
                read.put(ajtok);
                read.put(ules);
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
                    
                    Long stamp = Long.parseLong(szul);
                    /*Date d = new Date(l);
                    DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    
                    Date myDate = new Date(l);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
                    String myDateString = sdf.format(myDate);*/
                    
                    users.add(new user(name,id,phone,email,cim,stamp));
                    }
                
                    
                }
            
        } catch (Exception e) {          
            e.printStackTrace();
        }
        return users;
     }

    
}