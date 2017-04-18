/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Model.BookModel;
import Model.SellingModel;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ioana
 */
public class Users {
    public List<String> ReadGenre(String genre) 
    {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("book.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            List<String> bookGenre = getBookGenre(doc, xpath,genre);
            return bookGenre;
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public List<String> ReadTitle(String title) 
    {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("book.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            return getBookTitle(doc, xpath,title);
        }catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.print(e);
        }
        return null;

    }
     public List<String> ReadAuthor(String author) 
    {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc =builder.parse("book.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();
            return getBookAuthor(doc, xpath,author);
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    private static List<String> getBookGenre(Document doc, XPath xpath,String genre) {
        List<String> list = new ArrayList<>();
        try {
            //create XPathExpression object
            XPathExpression expr =xpath.compile("/Books/book[Genre='"+genre+"']/Title/text()");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getNodeValue());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
    private static List<String> getBookTitle(Document doc, XPath xpath,String title) {
        List<String> list = new ArrayList<>();
        try {
            //create XPathExpression object
            XPathExpression expr =xpath.compile("/Books/book[Title='"+title+"']/Author/text()");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getNodeValue());
            return list;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static List<String> getBookAuthor(Document doc, XPath xpath,String author) {
        List<String> list = new ArrayList<>();
        try {
            //create XPathExpression object
            XPathExpression expr =xpath.compile("/Books/book[Author='"+author+"']/Title/text()");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getNodeValue());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean sellBooks(String title,int quantity,String username)
    {
        Administrator a=new Administrator();
        SellingModel sm=new SellingModel();
        BookModel book=a.readBook(title);
        sm.setB(book);
        sm.setUsername(username);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();        
        String reportDate = df.format(today);
        sm.setDate(reportDate);
        if(book.getQuantity()-quantity<0)
            return false;
        book.setQuantity(book.getQuantity()-quantity);
        a.updateBook(book);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document document = null;
         try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("sell.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            Node node = document.getDocumentElement();
            Element user = document.createElement("sell");
            node.appendChild(user);
            Element newelement = document.createElement("username");
            newelement.appendChild(document.createTextNode(sm.getUsername()));
            user.appendChild(newelement);
            Element newelement1 = document.createElement("title");
            newelement1.appendChild(document.createTextNode(book.getTitle()));
            user.appendChild(newelement1);
            Element newelement2 = document.createElement("author");
            newelement2.appendChild(document.createTextNode(book.getAuthor()));
            user.appendChild(newelement2);
            Element newelement3 = document.createElement("genre");
            newelement3.appendChild(document.createTextNode(book.getGenre()));
            user.appendChild(newelement3);
            Element newelement4 = document.createElement("quantity");
            newelement4.appendChild(document.createTextNode(String.valueOf(quantity)));
            user.appendChild(newelement4);
            Element newelement5 = document.createElement("price");
            newelement5.appendChild(document.createTextNode(String.valueOf(quantity*book.getPrice())));
            user.appendChild(newelement5);
            Element newelement6 = document.createElement("Date");
            newelement6.appendChild(document.createTextNode(sm.getDate()));
            user.appendChild(newelement6);
            
            TransformerFactory tff  = TransformerFactory.newInstance();
            Transformer transformer = tff.newTransformer();

            DOMSource xmlSource = new DOMSource(document);
            StreamResult outputTarget = new StreamResult("sell.xml");
            transformer.transform(xmlSource, outputTarget);
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }
}
