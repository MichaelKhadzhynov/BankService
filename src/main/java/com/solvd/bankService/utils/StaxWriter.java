package com.solvd.bankService.utils;

import com.solvd.bankService.dao.mySQL.EmployeesDao;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StaxWriter {
    public static void staxOutWriter(){
        String path = "/Users/michael/div/IntelejIDEA Project/BankService/src/main/java/com/solvd/bankService/utils/EmployeeOut.xml";

        XMLOutputFactory output = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(path));

            writer.writeStartDocument();
            writer.writeStartElement("employees");

            for(long i =1; i<6; i++){

                //Open employee tag
                writer.writeStartElement("employee");
                writer.writeAttribute("id", String.valueOf(EmployeesDao.getInstance().getEntityById(i).getId()));

                //Open bank tag
                writer.writeStartElement("bank");
                writer.writeAttribute("id", String.valueOf(EmployeesDao.getInstance().getEntityById(i).getBankId().getId()));

                //Bank
                writer.writeStartElement("bank_number");
                writer.writeCharacters(String.valueOf(EmployeesDao.getInstance().getEntityById(i).getBankId().getBankNumber()));
                writer.writeEndElement();
                    //Bank address
                    writer.writeStartElement("address");
                    writer.writeAttribute("id", String.valueOf(EmployeesDao.getInstance().getEntityById(i).getBankId().getAddressId().getId()));
                        //Address
                        writer.writeStartElement("country");
                        writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getBankId().getAddressId().getCountry());
                        writer.writeEndElement();

                        writer.writeStartElement("city");
                        writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getBankId().getAddressId().getCity());
                        writer.writeEndElement();

                        writer.writeStartElement("home_address");
                        writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getBankId().getAddressId().getHomeAddress());
                        writer.writeEndElement();

                        writer.writeStartElement("postal_code");
                        writer.writeCharacters(String.valueOf(EmployeesDao.getInstance().getEntityById(i).getBankId().getAddressId().getPostalCode()));
                        writer.writeEndElement();

                        writer.writeStartElement("phone_number");
                        writer.writeCharacters(String.valueOf(EmployeesDao.getInstance().getEntityById(i).getBankId().getAddressId().getPhoneNumber()));
                        writer.writeEndElement();
                    writer.writeEndElement();
                writer.writeEndElement();

                //Person
                writer.writeStartElement("person");
                writer.writeAttribute("id", String.valueOf(EmployeesDao.getInstance().getEntityById(i).getPersonId().getId()));

                writer.writeStartElement("first_name");
                writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getPersonId().getFirstName());
                writer.writeEndElement();
                writer.writeStartElement("last_name");
                writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getPersonId().getLastName());
                writer.writeEndElement();
                writer.writeStartElement("passport_number");
                writer.writeCharacters(String.valueOf(EmployeesDao.getInstance().getEntityById(i).getPersonId().getPassportNumber()));
                writer.writeEndElement();
                writer.writeStartElement("email");
                writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getPersonId().getEmail());
                writer.writeEndElement();
                    //Person address
                    writer.writeStartElement("address");
                        //Address
                        writer.writeStartElement("country");
                        writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getPersonId().getAddress().getCountry());
                        writer.writeEndElement();

                        writer.writeStartElement("city");
                        writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getPersonId().getAddress().getCity());
                        writer.writeEndElement();

                        writer.writeStartElement("home_address");
                        writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getPersonId().getAddress().getHomeAddress());
                        writer.writeEndElement();

                        writer.writeStartElement("postal_code");
                        writer.writeCharacters(String.valueOf(EmployeesDao.getInstance().getEntityById(i).getPersonId().getAddress().getPostalCode()));
                        writer.writeEndElement();

                        writer.writeStartElement("phone_number");
                        writer.writeCharacters(String.valueOf(EmployeesDao.getInstance().getEntityById(i).getPersonId().getAddress().getPhoneNumber()));
                        writer.writeEndElement();
                    writer.writeEndElement();
                writer.writeEndElement();

                writer.writeStartElement("position");
                writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getPosition());
                writer.writeEndElement();

                writer.writeStartElement("department");
                writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getDepartment());
                writer.writeEndElement();

                writer.writeStartElement("Job_experience");
                writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getJobExperience());
                writer.writeEndElement();

                writer.writeStartElement("education");
                writer.writeCharacters(EmployeesDao.getInstance().getEntityById(i).getEducation());
                writer.writeEndElement();

                writer.writeStartElement("salary");
                writer.writeCharacters(String.valueOf(EmployeesDao.getInstance().getEntityById(i).getSalary()));
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();

            writer.writeEndDocument();
            writer.flush();
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
