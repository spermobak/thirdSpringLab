package com.bismus.thirdLab.dao;


import com.bismus.thirdLab.model.Person;
import com.bismus.thirdLab.utils.ConnectionAgent;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private static final String SQL_GET_ALL_PERSONS = "Select * from person";
    private static final String SQL_GET_PERSON_BY_ID = "Select * from person where id = ?";
    private static final String SQL_GET_PERSON_BY_NAME = "Select * from person where username = ?";

    Connection connection = ConnectionAgent.getNewConnection();


    public List<Person> findAll()  {
        List<Person> personList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_PERSONS);

            while (resultSet.next()) {

                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("username"));
                person.setAge(resultSet.getInt("age"));

                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personList;
    }


    public Person findById(int id) {
        Person person;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PERSON_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("username"));
            person.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }


    public List<Person> findByName(String name) {
        List<Person> personList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_PERSON_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("username"));
                person.setAge(resultSet.getInt("age"));

                personList.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

}
