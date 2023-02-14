package com.solvd.bankService.utils.parsersFactory.Parsers;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Objects;

public class DomParser extends BaseParser implements IRead {
    private static final Logger LOGGER = Logger.getLogger(DomParser.class);

    private String elementByTag;

    public DomParser(String filepath, String elementByTag) {
        super(filepath);
        this.elementByTag = elementByTag;
    }


    @Override
    public void readFile() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filePath);
            NodeList nodeList = document.getElementsByTagName(elementByTag);

            for(int i=0; i< nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                LOGGER.info(node.getTextContent());
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getElementByTag() {
        return elementByTag;
    }

    public void setElementByTag(String elementByTag) {
        this.elementByTag = elementByTag;
    }


    @Override
    public String toString() {
        return "DomParser{" +
               "elementByTag='" + elementByTag + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomParser)) return false;
        if (!super.equals(o)) return false;
        DomParser domParser = (DomParser) o;
        return Objects.equals(elementByTag, domParser.elementByTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), elementByTag);
    }
}
