package com.solvd.bankService.utils;

import com.solvd.bankService.models.Employees;
import org.apache.log4j.Logger;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public class SaxParser {

    private static final Logger LOGGER = Logger.getLogger(SaxParser.class);

    public static void saxParser() {

        final String file = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/Employees.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            saxParser.parse(file, myHandler);

            List<Employees> employeesList = myHandler.getEmployeesList();
            employeesList.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
