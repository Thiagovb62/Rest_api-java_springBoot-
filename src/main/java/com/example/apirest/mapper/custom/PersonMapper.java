package com.example.apirest.mapper.custom;


import com.example.apirest.Model.Person;
import com.example.apirest.data.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonVOV2 convertEntityToVO(Person entity){
        PersonVOV2 vo = new PersonVOV2();
        vo.setAddress(entity.getAddress());
        vo.setAge(entity.getAge());
        vo.setBirthDate(new Date());
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        return vo;
    }
    public Person convertVoToEntity(PersonVOV2 person){
        Person entity = new Person();
        entity.setAddress(person.getAddress());
        entity.setAge(person.getAge());
        //vo.setBirthDate(new Date());
        entity.setId(person.getId());
        entity.setName(person.getName());
        return entity;
    }

}
