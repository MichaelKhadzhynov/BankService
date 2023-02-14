package com.solvd.bankService.utils.parsersFactory.Parsers;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;

public class JaxbParser extends BaseParser implements  IWrite {

    private static final Logger LOGGER = Logger.getLogger(JaxbParser.class);

    private Object className;


    public JaxbParser(String filePath, Object className) {
        super(filePath);
        this.className = className;

    }

    public JaxbParser(String filePath) {
        super(filePath);
    }

    public Object readFile() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(className.getClass());
            className =  jaxbContext.createUnmarshaller().unmarshal(new FileReader(filePath));
            return className;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void writeFile() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(className.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(className, new File(filePath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
