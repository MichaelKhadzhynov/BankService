package com.solvd.bankService.utils.parsersFactory.Parsers;

import org.apache.log4j.Logger;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class STAXParser extends BaseParser implements IRead, IWrite {
    private static final Logger LOGGER = Logger.getLogger(STAXParser.class);


    private String localName;

    public STAXParser(String filePath, String localName) {
        super(filePath);
        this.localName = localName;
    }

    public STAXParser(String filePath) {
        super(filePath);
    }

    @Override
    public void readFile() {
        try {
            XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
                    .createXMLStreamReader(filePath, new FileInputStream(filePath));

            while (xmlStreamReader.hasNext()){
                xmlStreamReader.next();


                if(xmlStreamReader.isStartElement()){
                    if(xmlStreamReader.getLocalName().equals(localName)) LOGGER.info("\n");

                    LOGGER.info(xmlStreamReader.getLocalName());

                } else if (xmlStreamReader.isEndElement()){
//                    LOGGER.info("/" + xmlStreamReader.getLocalName());

                } else if (xmlStreamReader.hasNext() && xmlStreamReader.getText().trim().length() > 0 ) {
                    LOGGER.info("\"" + xmlStreamReader.getText() + "\"");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile() {
        XMLOutputFactory output = XMLOutputFactory.newInstance();

        try {

            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(filePath));
            STAXWriter.writer(writer);

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @Override
    public String
    toString() {
        return "STAXParser{" +
               "localName='" + localName + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof STAXParser)) return false;
        if (!super.equals(o)) return false;
        STAXParser that = (STAXParser) o;
        return Objects.equals(localName, that.localName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), localName);
    }
}
