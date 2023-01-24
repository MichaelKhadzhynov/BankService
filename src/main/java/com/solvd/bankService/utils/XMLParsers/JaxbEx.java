package com.solvd.bankService.utils.XMLParsers;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;

public class JaxbEx {
    private static final Logger LOGGER = Logger.getLogger(JaxbEx.class);

    private static String unmarshallFilePath = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/XMLParsers/Employees.xml";
    private static String marshallNewFilePath = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/XMLParsers/JaxbNewFile.xml";


    public static void jaxbStartRead(){

        EmployeesList employees = new EmployeesList();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            employees = (EmployeesList)  unmarshaller.unmarshal( new FileReader(unmarshallFilePath));
            employees.getEmployees().forEach(LOGGER::info);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void jaxbStartWrite(){


        EmployeesList employeesList = new EmployeesList();

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(employeesList, new File(marshallNewFilePath));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
