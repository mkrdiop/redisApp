package com.example.redisApp.dao;

import com.example.redisApp.model.Person;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public interface PersonDAO {

    int insertPerson(UUID id, Person person);
    default int addPerson( Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    List<Person> selectAllPerson();

    Stream<Person> selectPersonByID(UUID id);

    int deletePersonByID(UUID id);

    int updatePersonByID(UUID id, Person person);
}
