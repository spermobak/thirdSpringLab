package com.bismus.thirdLab.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class ConnectionAgent {



    static {
        setDriver();
    }

    public static Connection getNewConnection(){
        try {
            return DriverManager.getConnection(
                    ConnectionProperties.getByKeyProperties("spring.datasource.url"),
                    ConnectionProperties.getByKeyProperties("spring.datasource.username"),
                    ConnectionProperties.getByKeyProperties("spring.datasource.password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    static void setDriver (){
        try {
            Class.forName(ConnectionProperties.getByKeyProperties("spring.datasource.driver-class-name"));
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
