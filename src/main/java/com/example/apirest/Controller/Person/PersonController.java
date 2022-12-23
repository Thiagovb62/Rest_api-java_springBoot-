package com.example.apirest.Controller.Person;

import com.example.apirest.Model.Person;
import com.example.apirest.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
     private PersonServices personServices;

        @RequestMapping(value = "/{id}",method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
            public Person findById(@RequestParam(value = "id", defaultValue = "1") Long id){
                return personServices.findById(id);
        }
        @RequestMapping(value = "/all",method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
            public List<Person> findAll(){
                return  personServices.findAll();
        }
        @RequestMapping(value = "/",method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
            public Person create(@RequestBody Person person){
                return personServices.create(person);
        }
        @RequestMapping(value = "/update",method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
            public Person update(@RequestBody Person person){
                return personServices.update(person);
        }
        @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE , produces = MediaType.APPLICATION_JSON_VALUE)
            public String delete(@RequestParam(value = "id", defaultValue = "1") Long id){
                return personServices.delete(id);
        }

}
