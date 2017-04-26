/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse564.pox.foodmenu.ototade.netbeans.main;

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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * Jersey REST client generated for REST resource:GenericResource [FoodItem]<br>
 * USAGE:
 * <pre>
 *        Client client = new Client();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Omkar Totade
 */
public class FoodClient {

    private static final Logger LOG = LoggerFactory.getLogger(FoodClient.class);

    private WebResource webResource;
    private static final String BASE_URI = "http://localhost:8080/POX-FoodMenu-ototade-Netbeans";
        
        public static void main (String args[]) throws UniformInterfaceException, IOException, Exception
        {            
            ClientConfig config = new DefaultClientConfig();
            Client client = Client.create(config);
            WebResource webResource = client.resource(BASE_URI);
            Scanner in = new Scanner (System.in);
            
            
            System.out.println ("Enter choice number what do you want to do?"+"\n"+"1. Add Food Item"+"\n"+"2. Select Food Item");
            int choice=in.nextInt();
            File inputFile;
            if (choice==1)
            {
                System.out.println ("Reading request message from src/main/resources/add_food_item.xml file");                
                inputFile = new File ("src/main/resources/add_food_item.xml");
            }
            else if (choice==2)
            {
                System.out.println ("Reading request message from src/main/resources/get_food_item.xml file");                
                inputFile = new File ("src/main/resources/get_food_item.xml");
            }
            else 
            {
                System.out.println ("Invalid choice. Please enter either 1 or 2");                
                inputFile = new File ("");
            }
            
            //File inputFile = new File("src/resources/add_food_item.xml");//just change the file name
            
            ClientResponse response = webResource.path("restservices").path("restservices").path("FoodItem").type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).entity(inputFile).post(ClientResponse.class);
            
            String output=response.getEntity(String.class);
            String final_output=format(output);
            System.out.println("Response is:\n"+final_output);
            
            
        }
        
        
        
        public static String format(String xml) 
        {
            String final_string="";
            try 
            {
                final InputSource src = new InputSource(new StringReader(xml));
                final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
                final Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));
                final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
                final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
                final LSSerializer writer = impl.createLSSerializer();

                writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output needs to be beautified.
                writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Set this to true if the declaration is needed to be outputted.
                final_string=final_string+writer.writeToString(document);
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            return final_string;
        }
    
}

