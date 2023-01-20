package com.solvd.bankService.utils;

import com.solvd.bankService.dao.mySQL.EmployeesDao;
import com.solvd.bankService.models.Employees;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JaxbEx {
    private static final Logger LOGGER = Logger.getLogger(JaxbEx.class);

    private static String unmarshallFilePath = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/Employees.xml";
    private static String marshallNewFilePath = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/JaxbNewFile.xml";


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
