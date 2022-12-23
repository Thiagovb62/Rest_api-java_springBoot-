package com.example.apirest.Controller.Person;

import com.example.apirest.Model.Person;
import com.example.apirest.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
     private PersonServices personServices;

        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
            public Person findById(@PathVariable(value = "id") Long id){
                return personServices.findById(id);
        }
        @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
            public List<Person> findAll(){
                return  personServices.findAll();
        }
        @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
            public Person create(@RequestBody Person person){
                return personServices.create(person);
        }
        @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
            public Person update(@RequestBody Person person){
                return personServices.update(person);
        }
        @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
                personServices.delete(id);
                return ResponseEntity.noContent().build();
        }

}
