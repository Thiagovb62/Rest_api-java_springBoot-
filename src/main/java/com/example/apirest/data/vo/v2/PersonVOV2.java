package com.example.apirest.data.vo.v2;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVOV2 implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String name;

    private Integer age;

    private String address;

    private Date birthDate;

    public PersonVOV2() {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVOV2 that)) return false;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getAge().equals(that.getAge()) && getAddress().equals(that.getAddress()) && getBirthDate().equals(that.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getAddress(), getBirthDate());
    }
}
