package com.example.apirest.unittests.mockito.services;

import com.example.apirest.Model.Person;
import com.example.apirest.Repositories.PersonRepository;
import com.example.apirest.Services.PersonServices;

import com.example.apirest.unitests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices personServices;

    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUp() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void findById() {
        Person person = input.mockEntity(1);
        person.setId(1l);

        when(personRepository.findById(1l)).thenReturn(Optional.of(person));

        var result = personServices.findById(1l);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getName());
        assertEquals(1,result.getAge());

    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void createV2() {
    }
}