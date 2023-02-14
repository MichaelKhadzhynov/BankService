package com.solvd.bankService.utils;

import com.solvd.bankService.models.Address;
import com.solvd.bankService.models.Bank;
import com.solvd.bankService.models.Employees;
import com.solvd.bankService.models.Persons;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler<T> extends DefaultHandler {
    private static final Logger LOGGER = Logger.getLogger(MyHandler.class);

    private static final String EMPLOYEES_TAG = "employees";
    private static final String EMPLOYEE_TAG = "employee";

    private static final String BANK_TAG = "bank";
    private static final String BANK_NUMBER_TAG = "bank_number";

    private static final String ADDRESS_TAG = "address";
    private static final String COUNTRY_TAG = "country";
    private static final String CITY_TAG = "city";
    private static final String HOME_ADDRESS_TAG = "home_address";
    private static final String POSTAL_CODE_TAG = "postal_code";
    private static final String PHONE_NUMBER_TAG = "phone_number";

    private static final String PERSONS_TAG = "person";
    private static final String FIRST_NAME_TAG = "first_name";
    private static final String LAST_NAME_TAG = "last_name";
    private static final String PASSPORT_NUMBER_TAG = "passport_number";
    private static final String EMAIL_TAG = "email";

    private static final String POSITION_TAG = "position";
    private static final String DEPARTMENT_TAG = "department";
    private static final String JOB_EXPERIENCE_TAG = "job_experience";
    private static final String EDUCATION_TAG = "education";
    private static final String SALARY_TAG = "salary";

    private Employees employees;
    private Bank bank;
    private Address address;
    private Persons persons;
    private String currentElement;

    private final List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
    }

    @Override
    public void startDocument() throws SAXException {
        LOGGER.info("Start parse Employees.xml document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        switch (currentElement) {

            case EMPLOYEE_TAG:
                employees = new Employees();
                employees.setId(Long.valueOf(attributes.getValue("id")));

                bank = new Bank();
                employees.setBankId(bank);

                persons = new Persons();
                employees.setPersonId(persons);
                break;

            case BANK_TAG:
                address = new Address();
                bank.setId(Long.valueOf(attributes.getValue("id")));
                bank.setAddressId(address);
                break;

            case PERSONS_TAG:
                address = new Address();
                persons.setId(Long.valueOf(attributes.getValue("id")));
                persons.setAddress(address);
                break;

            case ADDRESS_TAG:
                address.setId(Long.valueOf(attributes.getValue("id")));
                break;

            default:
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);

        if (text.contains("<") || currentElement == null) {
            return;
        }

        switch (currentElement) {

            //ADDRESS
            case COUNTRY_TAG:
                address.setCountry(text);
                break;
            case CITY_TAG:
                address.setCity(text);
                break;
            case HOME_ADDRESS_TAG:
                address.setHomeAddress(text);
                break;
            case POSTAL_CODE_TAG:
                address.setPostalCode(Integer.valueOf(text));
                break;
            case PHONE_NUMBER_TAG:
                address.setPhoneNumber(Long.valueOf(text));
                break;

            //BANK
            case BANK_NUMBER_TAG:
                bank.setBankNumber(Integer.valueOf(text));
                break;

            //PERSONS
            case FIRST_NAME_TAG:
                persons.setFirstName(text);
                break;
            case LAST_NAME_TAG:
                persons.setLastName(text);
                break;
            case PASSPORT_NUMBER_TAG:
                persons.setPassportNumber(Integer.valueOf(text));
                break;
            case EMAIL_TAG:
                persons.setEmail(text);
                break;

            //EMPLOYEES
            case POSITION_TAG:
                employees.setPosition(text);
                break;
            case DEPARTMENT_TAG:
                employees.setDepartment(text);
                break;
            case JOB_EXPERIENCE_TAG:
                employees.setJobExperience(text);
                break;
            case EDUCATION_TAG:
                employees.setEducation(text);
                break;
            case SALARY_TAG:
                employees.setSalary(Integer.valueOf(text));
                break;
            default:
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch (qName) {
            case EMPLOYEE_TAG:
                list.add((T) employees);
                employees = null;
                break;
            default:
        }
        currentElement = null;
    }

    @Override
    public void endDocument() throws SAXException {
        LOGGER.info("End parse Employees.xml Document");
    }
}
