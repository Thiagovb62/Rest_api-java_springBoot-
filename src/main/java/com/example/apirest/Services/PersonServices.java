package com.example.apirest.Services;

import com.example.apirest.Model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){

        logger.info("find one person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setName("Rafael");
        person.setAge(25);
        person.setAddress("Rua 1");
        return person;
    }
    public List<Person> findAll(){
        List<Person> result = new ArrayList();
        for (int i = 0; i < 8; i++) {
            logger.info("find all person");
            Person person = mockPerson(i);
            result.add(person);
        }
        return result;

    }
    public Person create(Person person){
        logger.info("create person");
        return person;
    }
    public Person update(Person person){
        logger.info("update person");
        return person;
    }
    public String delete(String id){
        logger.info("delete a person");
        return "Deletado com sucesso!";
    };

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setName("Person Name" + i);
        person.setAge(25 + i );
        person.setAddress("Rua in ceara" + i);
        return person;
    }

}
