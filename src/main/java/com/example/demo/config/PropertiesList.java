package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "test.demo")
public class PropertiesList {

    private List<String> propertiesList;

    public PropertiesList(List<String> propertiesList) {
        this.propertiesList = propertiesList;
    }

    public PropertiesList() {
    }

    public List<String> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<String> propertiesList) {
        this.propertiesList = propertiesList;
    }

    @PostConstruct
    public void demo(){
        for (String s:
             propertiesList) {
            System.out.println(s);
        }
    }

}
