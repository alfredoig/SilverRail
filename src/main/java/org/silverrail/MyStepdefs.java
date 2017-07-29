package org.silverrail;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyStepdefs {

    @Given("^question one$")
    public void questionOne() throws Throwable {

    }

    @When("^I read the xml$")
    public void iReadTheXml() throws Throwable {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("src/test/AB356.xml");
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        javax.xml.xpath.XPathExpression expr = xpath.compile("(//Crs)[4]");
        /* This is not a technique I am using in my response but it will be more efficient to use:
        If the web service is a WSDL, WSImport could be used to generate all the classes representing
        The WSDL request and response objects. On this way all the response values can be easily accessible
        in Java data structures, and the search for specific values can  be simpler.

        Also the xpath expression could be better to identify the station with the third smallest number
        and not picking the one i know is the third closest location.
         */

        String result = expr.evaluate(doc, XPathConstants.STRING).toString();

        System.out.println(result);
    }

    @Then("^I give back CRS code of third closest station$")
    public void iGiveBackCRSCodeOfThirdClosestStation() throws Throwable {

    }

    //todo: delete the functions below. Not used.

    static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static NodeList getNodes(Document document, String expression) {

        NodeList nodes = null;

        try {

            XPathFactory factory = XPathFactory.newInstance();
            XPath xPath = factory.newXPath();
            Object result = xPath.evaluate(expression, document, XPathConstants.NODESET);
            nodes = (NodeList) result;

        }catch (Exception e){

            System.out.println(e);
        }

        return nodes;
    }

    public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    public static String getChildNodeTextContent(Node node, String childNodeName) {

        String textContext = "";

        Element element = (Element) node;

        NodeList nodeList = element.getElementsByTagName(childNodeName);

        if (nodeList.getLength() > 0) {
            textContext = nodeList.item(0).getTextContent();
        }

        return textContext;
    }


}
