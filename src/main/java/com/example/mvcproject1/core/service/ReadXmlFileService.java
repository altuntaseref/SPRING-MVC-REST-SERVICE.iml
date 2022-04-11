package com.example.mvcproject1.core.service;

import com.example.mvcproject1.model.Product;
import com.example.mvcproject1.model.XmlRoots;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
@Slf4j
public class ReadXmlFileService {

    public XmlRoots xmlReader() {


        String entryName = "C:\\XML\\products.xml";

        File userListFile = new File(entryName);

        XmlRoots xmlRoots = new XmlRoots();


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XmlRoots.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            xmlRoots = (XmlRoots) jaxbUnmarshaller.unmarshal(userListFile);
            log.info("User List reading completed.");
        } catch (Exception e) {
            log.error("Internal Error!", e);
        }
      // List<Product> products = xmlRoots.getProduct();
       //System.out.println(products);
        return xmlRoots;

    }

}
