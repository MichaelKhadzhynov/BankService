package com.solvd.bankService.utils.XMLParsers;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {
    private static final Logger LOGGER = Logger.getLogger(DOMParser.class);
    public static void domParser() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        final String file = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/Employees.xml";

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList = document.getElementsByTagName("employee");

            for(int i=0; i< nodeList.getLength(); i++){
                Node node = nodeList.item(i);

                LOGGER.info(node.getTextContent());
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
