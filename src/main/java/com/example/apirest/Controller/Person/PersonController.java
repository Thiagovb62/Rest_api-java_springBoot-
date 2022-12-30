package com.example.apirest.Controller.Person;

import com.example.apirest.Services.PersonServices;
import com.example.apirest.data.vo.v1.PersonVO;

import com.example.apirest.data.vo.v2.PersonVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person/v1")
public class PersonController {
    @Autowired
     private PersonServices personServices;

        @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
            public PersonVO findById(@PathVariable(value = "id") Long id){
                return personServices.findById(id);
        }
        @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
            public List<PersonVO> findAll(){
                return  personServices.findAll();
        }
        @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
            public PersonVO create(@RequestBody PersonVO PersonVO){
                return personServices.create(PersonVO);
        }
        @PostMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
            public PersonVOV2 createV2(@RequestBody PersonVOV2 personVOV2){
            return personServices.createV2(personVOV2);
        }
        @PutMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
            public PersonVO update(@RequestBody PersonVO PersonVO){
                return personServices.update(PersonVO);
        }
        @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
            public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
                personServices.delete(id);
                return ResponseEntity.noContent().build();
        }

}
