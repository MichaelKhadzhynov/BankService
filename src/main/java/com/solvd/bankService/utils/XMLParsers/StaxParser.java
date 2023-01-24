package com.solvd.bankService.utils.XMLParsers;

import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class StaxParser {
    private static final Logger LOGGER = Logger.getLogger(StaxParser.class);

    public static void staxParsing(){
        final String file = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/Employees.xml";

        try {
            XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
                    .createXMLStreamReader(file, new FileInputStream(file));

            while (xmlStreamReader.hasNext()){
                xmlStreamReader.next();


                if(xmlStreamReader.isStartElement()){
                    if(xmlStreamReader.getLocalName().equals("employee")) LOGGER.info("\n");

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
}
