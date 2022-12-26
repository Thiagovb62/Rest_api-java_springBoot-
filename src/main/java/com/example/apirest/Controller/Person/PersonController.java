package com.example.apirest.Controller.Person;

import com.example.apirest.Services.PersonServices;
import com.example.apirest.data.vo.v1.PersonVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Person")
public class PersonController {
    @Autowired
     private PersonServices PersonVOServices;

        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
            public PersonVO findById(@PathVariable(value = "id") Long id){
                return PersonServices.findById(id);
        }
        @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
            public List<PersonVO> findAll(){
                return  PersonServices.findAll();
        }
        @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
            public PersonVO create(@RequestBody PersonVO PersonVO){
                return PersonServices.create(PersonVO);
        }
        @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
            public PersonVO update(@RequestBody PersonVO PersonVO){
                return PersonServices.update(PersonVO);
        }
        @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
                PersonServices.delete(id);
                return ResponseEntity.noContent().build();
        }

}
