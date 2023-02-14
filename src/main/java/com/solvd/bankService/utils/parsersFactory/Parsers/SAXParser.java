package com.solvd.bankService.utils.parsersFactory.Parsers;

import com.solvd.bankService.utils.MyHandler;
import org.apache.log4j.Logger;

import javax.xml.parsers.SAXParserFactory;
import java.util.List;
import java.util.Objects;

public class SAXParser extends BaseParser implements IRead {
    private static final Logger LOGGER = Logger.getLogger(SAXParser.class);

    private final MyHandler<?> myHandler;

    public SAXParser(String filepath, MyHandler<?> myHandler) {
        super(filepath);
        this.myHandler = myHandler;
    }

    @Override
    public void readFile() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        List<?> list =null;
        try {

            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(filePath, myHandler);
            list = myHandler.getList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (list != null) {
            list.forEach(LOGGER::info);
        }

    }



    @Override
    public String toString() {
        return "SAXParser{" +
               "myHandler=" + myHandler +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SAXParser)) return false;
        if (!super.equals(o)) return false;
        SAXParser saxParser = (SAXParser) o;
        return Objects.equals(myHandler, saxParser.myHandler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), myHandler);
    }
}
