package com.example.redisApp.service;

import com.example.redisApp.dao.PersonDAO;
import com.example.redisApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class PersonService {


    private final PersonDAO personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDAO") PersonDAO personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.addPerson(person);
    }

    public List<Person> getAllPerson(){
        return personDao.selectAllPerson();
    }
    public Stream<Person> getPersonByID(UUID id){
        return personDao.selectPersonByID(id);
    }
}
