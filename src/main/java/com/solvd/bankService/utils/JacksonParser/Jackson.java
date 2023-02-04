package com.solvd.bankService.utils.JacksonParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.solvd.bankService.dao.mySQL.*;
import com.solvd.bankService.models.*;
import com.solvd.bankService.utils.XMLParsers.EmployeesList;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Jackson {
    private static final Logger LOGGER = Logger.getLogger(Jackson.class);

    public static void jacksonRead() {
        String filePath = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/JacksonParser/ClientList.json";

        ClientList clientList = new ClientList();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            clientList = objectMapper.readValue(new File(filePath), ClientList.class);

            clientList.getClientList().forEach(LOGGER::info);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void jacksonWrite() {
        String filePath = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/JacksonParser/DepositDepartment.json";

//        ClientList clientList = new ClientList();


        List<DepositDepartment> list = new ArrayList<>();
        for(int i =1; i<6; i++) {
        list.add(DepositDepartmentDAO.getInstance().getEntityById(i));
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void jacksonWriteCreditCards(){
        String filePath = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/JacksonParser/CreditCardsListWrite.json";

        CreditCardsList creditCardsList = new CreditCardsList();

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File(filePath), creditCardsList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
