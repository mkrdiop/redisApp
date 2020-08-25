package com.example.redisApp.api;

import com.example.redisApp.model.Person;
import com.example.redisApp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RequestMapping("api/v1/person/")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
    @GetMapping(path ="{id}")
    public Stream<Person> getPersonByID(@PathVariable("id") UUID id){
        return  personService.getPersonByID(id);
    }
}
