package com.example.apirest.Services;

import com.example.apirest.Exceptions.ResourceNotFoundException;
import com.example.apirest.Model.Person;
import com.example.apirest.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    public Person findById(Long id){

        logger.info("find one person");

        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }
    public List<Person> findAll(){

        logger.info("find all person");

        return  personRepository.findAll();

    }
    public Person create(Person person){
        logger.info("create person");

        return personRepository.save(person);
    }
    public Person update(Person person){
        logger.info("update person");

        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        entity.setName(person.getName());
        entity.setAge(person.getAge());
        entity.setAddress(person.getAddress());

        return personRepository.save(person);
    }
    public String delete(Long id){
        logger.info("delete a person");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        personRepository.delete(entity);

        return "Deletado com sucesso!";
    };

}
