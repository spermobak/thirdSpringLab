package com.bismus.thirdLab.service;


import com.bismus.thirdLab.dao.PersonDao;
import com.bismus.thirdLab.exception.PersonByIdNotFoundException;
import com.bismus.thirdLab.exception.PersonByNameNotFoundException;
import com.bismus.thirdLab.exception.PersonTableIsEmptyException;
import com.bismus.thirdLab.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonDao personDao;

    public List<Person> findAll(){
        if (personDao.findAll().isEmpty()){
            throw new PersonTableIsEmptyException();
        }
        return personDao.findAll();
    }

    public Person findById(int id){
        if (personDao.findById(id) == null){
            throw  new PersonByIdNotFoundException(id);
        }
        return personDao.findById(id);
    }

    public List<Person> findByName(String name){
        if (personDao.findByName(name).isEmpty()){
            throw new PersonByNameNotFoundException(name);
        }
        return personDao.findByName(name);
    }
}
