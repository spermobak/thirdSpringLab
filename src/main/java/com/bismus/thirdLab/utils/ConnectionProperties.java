package com.bismus.thirdLab.utils;


import java.io.IOException;
import java.util.Properties;


public class ConnectionProperties {

    private ConnectionProperties(){}

    static final Properties properties = new Properties();

    static {
        setProperties();
    }


    private static void setProperties(){
        try(var inputStream= ConnectionProperties.class.getClassLoader().getResourceAsStream("application.properties")){
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String getByKeyProperties(String key){
        return properties.getProperty(key);
    }
}
