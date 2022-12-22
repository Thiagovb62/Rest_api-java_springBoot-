package com.example.apirest.Controller.Person;

import com.example.apirest.Model.Person;
import com.example.apirest.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
     private PersonServices personServices;

    @RequestMapping(value = "/",method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
        public Person findById(@RequestParam(value = "id", defaultValue = "1") String id){
            return personServices.findById(id);
        }

}
