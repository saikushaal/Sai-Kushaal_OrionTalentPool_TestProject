package WorkItems;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class WorkItem_XMLReader {
	
	public static void main(String[] args)
	
	{
		
		    try {
// 1. Destination of the XML File is assigned to fXMLFile object reference. 
		    File fXmlFile = new File("\\Users\\Training\\Desktop\\WorkItem_XMLReader\\WorkItem_XMLReader.xml");
		    
// 2. DocumentBuilderFactory.newInstance() is a static method creates a new instance of a DocumentBuilder Factory.	
// 2a. The new instance of the document builder factory is assigned to dbFactory object reference.
// 2b. Document Builder defines the API to obtain DOM Document instances from an XML document
		  
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    
 		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    
		    Document doc = dBuilder.parse(fXmlFile);
		    
		    doc.getDocumentElement().normalize();
		    
/*
 Purpose of using getDocumentElement()
 ----------------------------------------
 A DOM object contains different nodes connected in a tree-like structure. 
 At the top is the Document object. 
 The Document object has a single root element, which is returned by calling getDocumentElement()
 */
		    
/*
 getNodeName()
 --------------
 Gets the text of the XML node.
 
 */
		    
		    
		    
		    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

// Store all the nodes in a list (with object reference nList).
		    NodeList nList = doc.getElementsByTagName("staff");
		    
		    System.out.println("----------------------------");

		    for (int temp = 0; temp < nList.getLength(); temp++) {
		        Node nNode = nList.item(temp);
		        System.out.println("\nCurrent Element :" + nNode.getNodeName());
		        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) nNode;
		            System.out.println("Staff id : "
		                               + eElement.getAttribute("id"));
		            System.out.println("First Name : "
		                               + eElement.getElementsByTagName("firstname")
		                                 .item(0).getTextContent());
		            System.out.println("Last Name : "
		                               + eElement.getElementsByTagName("lastname")
		                                 .item(0).getTextContent());
		            System.out.println("Nick Name : "
		                               + eElement.getElementsByTagName("nickname")
		                                 .item(0).getTextContent());
		            System.out.println("Salary : "
		                               + eElement.getElementsByTagName("salary")
		                                 .item(0).getTextContent());
		        }
		    }
		    } catch (Exception e) {
		    e.printStackTrace();
		    }
		  }
		
		
	}


