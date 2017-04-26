/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.pox.foodmenu.ototade.netbeans.controller;

/**
 *
 * @author Omkar Totade
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Omkar Totade
 */

import com.cse564.pox.foodmenu.ototade.netbeans.model.FoodItems;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author Omkar Totade
 */
public class Controller {
    
    
    public static ArrayList<FoodItems> food_items_arraylist = new ArrayList<FoodItems>();
    
    
    public static void readXMLData()
    {
    try 
    {
        int i=0; 
        String currentElement;
        //
        //ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        //InputStream inputFile = classloader.getResourceAsStream("FoodItemData.xml");
        //
	File inputFile = new File("src/main/resources/FoodItemData.xml");
        //File inputFile = new File ("C://FoodItemData.xml");
        //File inputFile = new File("C:\\Users\\Omkar Totade\\Desktop\\src\\resources\\FoodItemData.xml");
        //System.out.println("ReadXMLData File:"+inputFile);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
	//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        
        NodeList nList = doc.getElementsByTagName("FoodItem");
        
        //System.out.println("----------------------------");
           
	for (int temp = 0; temp < nList.getLength(); temp++) 
        {

		Node nNode = nList.item(temp);
				
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
                currentElement=nNode.getNodeName();
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {                    
                    Element eElement = (Element) nNode;
                    FoodItems fi = new FoodItems();
                    fi.setCurrentElement(currentElement);
                    fi.setCountry(eElement.getAttribute("country"));             
                    fi.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                    fi.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    fi.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
                    fi.setCategory(eElement.getElementsByTagName("category").item(0).getTextContent());
                    fi.setPrice(Float.parseFloat(eElement.getElementsByTagName("price").item(0).getTextContent()));
                    food_items_arraylist.add(fi);
                    
                }
                
        }
        
        //for (int count=0 ; count<food_items_arraylist.size() ; count++)
        //{               
            //System.out.println("CurrentElement:"+food_items_array[count].getCurrentElement());
            //System.out.println("Country:"+food_items_arraylist.get(count).getCountry());
            //System.out.println("ID:"+food_items_arraylist.get(count).getId());
            //System.out.println("Name:"+food_items_arraylist.get(count).getName());
            //System.out.println("Description:"+food_items_arraylist.get(count).getDescription());
            //System.out.println("Category:"+food_items_arraylist.get(count).getCategory());
            //System.out.println("Price:"+food_items_arraylist.get(count).getPrice());
            //System.out.println();
        //}
        
     
    }
    
    
    catch (Exception e)
    {
        e.printStackTrace();
    }
 }
    
    public static void writeToXMLFile (FoodItems fi)
    {
        try
        {
            String inputFile = "src/main/resources/FoodItemData.xml";
            //String inputFile = "C://FoodItemData.xml";
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //
            //ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            //InputStream inputFile = classloader.getResourceAsStream("FoodItemData.xml");        
            //
            //Document document = documentBuilder.parse("C:\\Users\\Omkar Totade\\Desktop\\src\\resources\\FoodItemData.xml");
            Document document = documentBuilder.parse(inputFile);
            Element root = document.getDocumentElement();
            //System.out.println("Root Element:"+root);
            
            Element newFoodItem = document.createElement("FoodItem");                
            
            newFoodItem.setAttribute("country",fi.getCountry());
                
            Element id = document.createElement("id");
            id.appendChild(document.createTextNode(Integer.toString(fi.getId())));
            newFoodItem.appendChild(id);
               
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(fi.getName()));
            newFoodItem.appendChild(name);
               
            Element description = document.createElement("description");
            description.appendChild(document.createTextNode(fi.getDescription()));
            newFoodItem.appendChild(description);
               
            Element category = document.createElement("category");
            category.appendChild(document.createTextNode(fi.getCategory()));
            newFoodItem.appendChild(category);
                
            Element price = document.createElement("price");
            price.appendChild(document.createTextNode(Float.toString(fi.getPrice())));
            newFoodItem.appendChild(price);
                
            root.appendChild(newFoodItem);
            
            DOMSource source = new DOMSource(document);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            //
            //ClassLoader cl = Thread.currentThread().getContextClassLoader();
            //File outputFile = stream2file(inputFile);       //
            //
            //StreamResult result = new StreamResult("C://FoodItemData.xml");
            StreamResult result = new StreamResult("src/main/resources/FoodItemData.xml");
            //StreamResult result = new StreamResult("C:\\Users\\Omkar Totade\\Desktop\\src\\resources\\FoodItemData.xml");
            //StreamResult result = new StreamResult(new FileOutputStream("C:\\Users\\Omkar Totade\\Desktop\\src\\resources\\FoodItemData.xml",false));
            transformer.transform(source, result);//
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}