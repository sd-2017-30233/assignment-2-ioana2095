/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.BookModel;
import Model.SellingModel;
import Model.UserModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ioana
 */
public class Administrator {
    public boolean createUser(UserModel u)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document document = null;
         try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("user.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//user[username='"+u.getUserName()+"']/username/text()");
            //evaluate expression result on XML document
            Node nodes = (Node) expr.evaluate(document, XPathConstants.NODE);
            System.out.println(nodes);         
            if(nodes==null)
           {
                     Node node = document.getDocumentElement();
                     Element user = document.createElement("user");
                     node.appendChild(user);
                     Element newelement = document.createElement("username");
                     newelement.appendChild(document.createTextNode(u.getUserName()));
                     user.appendChild(newelement);
                     Element newelement1 = document.createElement("password");
                     newelement1.appendChild(document.createTextNode(u.getPassword()));
                     user.appendChild(newelement1);
                     Element newelement2 = document.createElement("type");
                     newelement2.appendChild(document.createTextNode(u.getAccesType()));
                     user.appendChild(newelement2);
                     //System.out.println();
                    TransformerFactory tff  = TransformerFactory.newInstance();
                    Transformer transformer = tff.newTransformer();

                    DOMSource xmlSource = new DOMSource(document);
                    StreamResult outputTarget = new StreamResult("user.xml");
                    transformer.transform(xmlSource, outputTarget);
                    return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean updateUser(UserModel u)
    {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("user.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//user[username='"+u.getUserName()+"']/password/text()");
            //evaluate expression result on XML document
            Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);
            nodes.setNodeValue(u.getPassword());
		// write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("user.xml"));
            transformer.transform(source, result);

            System.out.println("Done");
            return true;

    } catch (Exception e) {
         System.out.println(e);
    }
        return false;
        
    }
     public boolean deleteUser(String username)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("user.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//user/*/text()");
            Element root = doc.getDocumentElement(); // should be <project>
            NodeList targets = doc.getElementsByTagName("user");
            for(int i=0;i<targets.getLength();i++){
                Element person = (Element)targets.item(i);
                Element name = (Element)person.getElementsByTagName("username").item(0);
                String pName = name.getTextContent();
                if(pName.equals(username))
                        person.getParentNode().removeChild( targets.item( i ) );
            }
         // write the content on console
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("user.xml"));
        transformer.transform(source, result);
         return true;
        }
        catch (Exception e) {
         System.out.println(e);
    }
        return false;
    }
     public List<UserModel> readUsers()
    {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        List<UserModel> list = new ArrayList<>();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("user.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//user/*/text()");
            Element root = doc.getDocumentElement(); // should be <project>
            NodeList targets = doc.getElementsByTagName("user");
            for (int i = 0; i < targets.getLength(); i++){
                Element person = (Element)targets.item(i);
                Element name = (Element)person.getElementsByTagName("username").item(0);
                String pName = name.getTextContent();
                Element person1 = (Element)targets.item(i);
                Element name1 = (Element)person1.getElementsByTagName("password").item(0);
                String pName1 = name1.getTextContent();
                Element person2 = (Element)targets.item(i);
                Element name2 = (Element)person2.getElementsByTagName("type").item(0);
                String pName2 = name2.getTextContent();
                if(pName2.equals("employee")){
                UserModel u=new UserModel(pName,pName1,pName2);
                list.add(u);
                }
            }
         return list; 

    } catch (Exception e) {
         System.out.println(e);
    }
        return null;
        
    }
      public String readUser(String username,String password)
    {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        String s=new String();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("user.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//user[username='"+username+"']/password/text()");
            Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);
            if(nodes!=null){
                if(nodes.getNodeValue().equals(password))
                {
                    XPathExpression expr1 =xpath.compile("//user[username='"+username+"']/type/text()");
                    Node nodes1 = (Node) expr1.evaluate(doc, XPathConstants.NODE);
                    return nodes1.getNodeValue();
                }
            }
    } catch (Exception e) {
         System.out.println(e);
    }
        return null;
        
    }
     
     
     
     public boolean createBook(BookModel u)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document document = null;
         try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("book.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//book[Title='"+u.getTitle()+"']/Title/text()");
            //evaluate expression result on XML document
            Node nodes = (Node) expr.evaluate(document, XPathConstants.NODE);
            System.out.println(nodes);         
            if(nodes==null)
           {
                     Node node = document.getDocumentElement();
                     Element user = document.createElement("book");
                     node.appendChild(user);
                     Element newelement = document.createElement("Title");
                     newelement.appendChild(document.createTextNode(u.getTitle()));
                     user.appendChild(newelement);
                     Element newelement1 = document.createElement("Author");
                     newelement1.appendChild(document.createTextNode(u.getAuthor()));
                     user.appendChild(newelement1);
                     Element newelement2 = document.createElement("Genre");
                     newelement2.appendChild(document.createTextNode(u.getGenre()));
                     user.appendChild(newelement2);
                     Element newelement3 = document.createElement("Quantity");
                     newelement3.appendChild(document.createTextNode(String.valueOf(u.getQuantity())));
                     user.appendChild(newelement3);
                     Element newelement4 = document.createElement("Price");
                     newelement4.appendChild(document.createTextNode(String.valueOf(u.getPrice())));
                     user.appendChild(newelement4);
                     //System.out.println();
                    TransformerFactory tff  = TransformerFactory.newInstance();
                    Transformer transformer = tff.newTransformer();

                    DOMSource xmlSource = new DOMSource(document);
                    StreamResult outputTarget = new StreamResult("book.xml");
                    transformer.transform(xmlSource, outputTarget);
                    return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean updateBook(BookModel u)
    {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("book.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//book[Title='"+u.getTitle()+"']/Quantity/text()");
            //evaluate expression result on XML document
            Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);
            nodes.setNodeValue(String.valueOf(u.getQuantity()));
            XPathExpression expr1 =xpath.compile("//book[Title='"+u.getTitle()+"']/Price/text()");
            //evaluate expression result on XML document
            Node nodes1 = (Node) expr1.evaluate(doc, XPathConstants.NODE);
            nodes1.setNodeValue(String.valueOf(u.getPrice()));
            //nodes.setNodeValue(String.valueOf(u.getPrice()));
		// write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("book.xml"));
            transformer.transform(source, result);

            System.out.println("Done");
            return true;

    } catch (Exception e) {
         System.out.println(e);
    }
        return false;
        
    }
     public boolean deleteBook(String title)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("book.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//book/*/text()");
            Element root = doc.getDocumentElement(); // should be <project>
            NodeList targets = doc.getElementsByTagName("book");
            for(int i=0;i<targets.getLength();i++){
                Element person = (Element)targets.item(i);
                Element name = (Element)person.getElementsByTagName("Title").item(0);
                String pName = name.getTextContent();
                if(pName.equals(title))
                        person.getParentNode().removeChild( targets.item( i ) );
            }
         // write the content on console
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("book.xml"));
        transformer.transform(source, result);
         return true;
        }
        catch (Exception e) {
         System.out.println(e);
    }
        return false;
    }
     public List<BookModel> readBooks()
    {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        List<BookModel> list = new ArrayList<>();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("book.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr =xpath.compile("//book/*/text()");
            Element root = doc.getDocumentElement(); // should be <project>
            NodeList targets = doc.getElementsByTagName("book");
            for (int i = 0; i < targets.getLength(); i++){
                Element person = (Element)targets.item(i);
                Element name = (Element)person.getElementsByTagName("Title").item(0);
                String pName = name.getTextContent();
                Element person1 = (Element)targets.item(i);
                Element name1 = (Element)person1.getElementsByTagName("Author").item(0);
                String pName1 = name1.getTextContent();
                Element person2 = (Element)targets.item(i);
                Element name2 = (Element)person2.getElementsByTagName("Genre").item(0);
                String pName2 = name2.getTextContent();
                Element person3 = (Element)targets.item(i);
                Element name3 = (Element)person3.getElementsByTagName("Quantity").item(0);
                String pName3 = name3.getTextContent();
                Element person4 = (Element)targets.item(i);
                Element name4 = (Element)person4.getElementsByTagName("Price").item(0);
                String pName4 = name4.getTextContent();
                BookModel u=new BookModel(pName,pName1,pName2,Integer.parseInt(pName3),Float.parseFloat(pName4));
                list.add(u);
            }
         return list; 

    } catch (Exception e) {
         System.out.println(e);
    }
        return null;
        
    }
     public BookModel readBook(String title)
    {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        BookModel list = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("book.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            Element root = doc.getDocumentElement(); // should be <project>
            NodeList targets = doc.getElementsByTagName("book");
            for (int i = 0; i < targets.getLength(); i++){
                Element person = (Element)targets.item(i);
                Element name = (Element)person.getElementsByTagName("Title").item(0);
                String pName = name.getTextContent();
                if(pName.equals(title)){
                Element person1 = (Element)targets.item(i);
                Element name1 = (Element)person1.getElementsByTagName("Author").item(0);
                String pName1 = name1.getTextContent();
                Element person2 = (Element)targets.item(i);
                Element name2 = (Element)person2.getElementsByTagName("Genre").item(0);
                String pName2 = name2.getTextContent();
                Element person3 = (Element)targets.item(i);
                Element name3 = (Element)person3.getElementsByTagName("Quantity").item(0);
                String pName3 = name3.getTextContent();
                Element person4 = (Element)targets.item(i);
                Element name4 = (Element)person4.getElementsByTagName("Price").item(0);
                String pName4 = name4.getTextContent();
                list=new BookModel(pName,pName1,pName2,Integer.parseInt(pName3),Float.parseFloat(pName4));
                }
            }
         return list; 

    } catch (Exception e) {
         System.out.println(e);
    }
        return null;
        
    }
   public List<SellingModel> getDate()
   {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        List<SellingModel> list = new ArrayList<>();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("sell.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            Element root = doc.getDocumentElement(); // should be <project>
            NodeList targets = doc.getElementsByTagName("sell");
            for (int i = 0; i < targets.getLength(); i++){
                Element person = (Element)targets.item(i);
                Element name = (Element)person.getElementsByTagName("username").item(0);
                String pName = name.getTextContent();
                Element person1 = (Element)targets.item(i);
                Element name1 = (Element)person1.getElementsByTagName("title").item(0);
                String pName1 = name1.getTextContent();
                Element person2 = (Element)targets.item(i);
                Element name2 = (Element)person2.getElementsByTagName("author").item(0);
                String pName2 = name2.getTextContent();
                Element person3 = (Element)targets.item(i);
                Element name3 = (Element)person3.getElementsByTagName("genre").item(0);
                String pName3 = name3.getTextContent();
                Element person4 = (Element)targets.item(i);
                Element name4 = (Element)person4.getElementsByTagName("quantity").item(0);
                String pName4 = name4.getTextContent();
                Element person5 = (Element)targets.item(i);
                Element name5 = (Element)person5.getElementsByTagName("price").item(0);
                String pName5 = name5.getTextContent();
                Element person6 = (Element)targets.item(i);
                Element name6= (Element)person6.getElementsByTagName("Date").item(0);
                String pName6 = name6.getTextContent();
                BookModel bm=new BookModel(pName1,pName2,pName3,Integer.parseInt(pName4),Float.parseFloat(pName5));
                SellingModel sm=new SellingModel(pName6,pName,bm);
                list.add(sm);
            }
         return list; 

    } catch (Exception e) {
         System.out.println(e);
    }
        return null;
        
   }
}
