package com.naveen.test;
import uk.co.britishgas.bertha.Classes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ObjectMapper
{
    public Classes getObjectMapper(String filePath) throws JAXBException, FileNotFoundException {
        InputStream xmlInputStream = null;
        if(filePath.startsWith("classpath:"))
        {
            xmlInputStream = getClass().getClassLoader().getResourceAsStream(filePath.substring(filePath.indexOf(":")+1));
        }
        else
        {
            xmlInputStream = new FileInputStream(filePath);
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(Classes.class.getPackage().getName());
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<Classes> classes = (JAXBElement<Classes>) unmarshaller.unmarshal(xmlInputStream);
        return classes.getValue();
    }
}
