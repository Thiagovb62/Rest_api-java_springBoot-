package com.example.apirest.data.vo.v1;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;



public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String name;

    private Integer age;

    private String address;

    public PersonVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO person)) return false;
        return id.equals(person.id) && getName().equals(person.getName()) && getAge().equals(person.getAge()) && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getAge(), getAddress());
    }
}
