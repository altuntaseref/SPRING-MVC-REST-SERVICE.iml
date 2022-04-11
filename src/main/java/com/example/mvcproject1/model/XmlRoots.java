package com.example.mvcproject1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlRoots {

    @XmlElement(name="id")
    private int id;

    private List<Product> product;
}
