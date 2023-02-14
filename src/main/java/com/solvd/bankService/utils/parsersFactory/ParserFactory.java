package com.solvd.bankService.utils.parsersFactory;


import com.solvd.bankService.utils.MyHandler;
import com.solvd.bankService.utils.parsersFactory.Parsers.*;

public class ParserFactory  {

    private static ParserFactory INSTANCE;


    public DomParser getDomParser(String filepath, String elementByTag) {
        return new DomParser(filepath, elementByTag);
    }


    public SAXParser getSAXParser(String filepath, MyHandler myHandler) {
        return new SAXParser(filepath, myHandler);
    }


    public STAXParser getSTAXParserRead(String filePath, String localName) {
        return new STAXParser(filePath, localName);
    }

    public STAXParser getSTAXParserWrite(String filePath) {
        return new STAXParser(filePath);
    }


    public JaxbParser getJaxbParser(String filePath, Object className) {
        return new JaxbParser(filePath, className);
    }

    public JacksonParser getJacksonParser(String filePath, Object className) {
        return new JacksonParser(filePath, className);
    }

    public static ParserFactory getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new ParserFactory();
        }
        return INSTANCE;
    }
}
