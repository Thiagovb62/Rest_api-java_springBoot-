package com.example.apirest.unitests.mapper.mocks;

import com.example.apirest.Model.Person;
import com.example.apirest.data.vo.v1.PersonVO;

import java.util.ArrayList;
import java.util.List;



public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVO mockVO() {
        return mockVO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Addres Test" + number);
        person.setName("First Name Test" + number);
        person.setAge(number);
        person.setId(number.longValue());
        return person;
    }

    public PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setAddress("Addres Test" + number);
        person.setName("First Name Test" + number);
        person.setAge(number);
        person.setKey(number.longValue());
        return person;
    }

}