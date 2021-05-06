package com.flightsearch.utilities;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML 
{
	public static String strClass (String objname) 
    { 
  
            return readObjectXML(objname, "strClass"); 
    } 
     
    public static String strProperty(String objname)
    { 
    	     
  	  return readObjectXML(objname, "strProperty"); 
    } 
      
    public static String strPropertyValue(String objname)
    { 
  	  
                  return readObjectXML(objname, "strPropertyValue"); 
    } 

    public static String readObjectXML(String objectname, String tagName)
    { 
  	         	  try{
		                   File fXmlFile = new File(Config.objectpath); 
		                   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
		                   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
		                   Document doc = dBuilder.parse(fXmlFile); 
		                   doc.getDocumentElement().normalize(); 
		                   NodeList nList = doc.getElementsByTagName(objectname); 
		                   Node nNode = nList.item(0); 
		                   Element eElement = (Element) nNode; 
		                   return eElement.getElementsByTagName(tagName).item(0).getTextContent(); 
  	         	  }catch(Exception e)
  	         	  {
  	         		  System.out.println(e.getMessage());
  	         		  return "";
  	         	  }
  	         	
    }
}
