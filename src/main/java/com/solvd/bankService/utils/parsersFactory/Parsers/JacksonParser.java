package com.solvd.bankService.utils.parsersFactory.Parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class JacksonParser extends BaseParser implements IWrite {

    private Object className;

    public JacksonParser(String filePath, Object className) {
        super(filePath);
        this.className = className;
    }


    public Object readFile(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            className = objectMapper.readValue(new File(filePath), className.getClass());
            return className;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeFile() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filePath), className);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public Object getClassName() {
        return className;
    }

    public void setClassName(Object className) {
        this.className = className;
    }

    @Override
    public String
    toString() {
        return "JacksonParser{" +
               "aClass=" + className +
               '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof JacksonParser)) return false;
        if (!super.equals(o)) return false;
        JacksonParser that = (JacksonParser) o;
        return Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), className);
    }
}
