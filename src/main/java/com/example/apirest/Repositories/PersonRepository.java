package com.example.apirest.Repositories;

import com.example.apirest.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface PersonRepository extends JpaRepository<Person, Long> {}

