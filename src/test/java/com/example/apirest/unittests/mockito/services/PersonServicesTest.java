package com.example.apirest.unittests.mockito.services;

import com.example.apirest.Exceptions.RequiredObjectIsNullException;
import com.example.apirest.Model.Person;
import com.example.apirest.Repositories.PersonRepository;
import com.example.apirest.Services.PersonServices;

import com.example.apirest.data.vo.v1.PersonVO;
import com.example.apirest.unitests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS) // essa anotação faz com que o JUnit crie uma instância da classe de teste para cada método de teste
@ExtendWith(MockitoExtension.class) // essa anotação  serve para inicializar os mocks
class PersonServicesTest {

    MockPerson input;

    @InjectMocks // essa anotação faz com que o mockito injete os mocks  quando for necessário
    private PersonServices personServices;

    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUp() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this); // essa anotação  serve para inicializar os mocks
    }
    @Test
    void testFindAll(){
        List<Person> persons = input.mockEntityList();

        when(personRepository.findAll()).thenReturn(persons); // quando o método findAll() for chamado, o mockito vai retornar a lista de pessoas

        var result = personServices.findAll();
        assertNotNull(result); // verifica se o resultado não é nulo
        assertEquals(13, result.size()); // verifica se o tamanho da lista é 14

        var personOne = result.get(1); // pega o primeiro elemento da lista

        assertNotNull(personOne);
        assertNotNull(personOne.getKey()); // verifica se a chave não é nula
        assertNotNull(personOne.getLinks()); // verifica se os links não são nulos
        System.out.println(personOne.toString());
        assertTrue(personOne.toString().contains("links: [</person/v1/1>;rel=\"self\"]")); // verifica se o toString() contém o link hateoas
        assertEquals("Addres Test1", personOne.getAddress()); // verifica se o endereço é igual ao esperado
        assertEquals("First Name Test1", personOne.getName()); // verifica se o nome é igual ao esperado
        assertEquals(1,personOne.getAge()); // verifica se a idade é igual ao esperado
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
    void create() {
        Person person = input.mockEntity(1);
        Person persisted = person;
        persisted.setId(1l);

        PersonVO personVO = input.mockVO(1);
        personVO.setKey(1l);

        when(personRepository.save(person)).thenReturn(persisted);

        var result  = personServices.create(personVO);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getName());
        assertEquals(1,result.getAge());


    }
    //para validar qualquer regra de negocio que seja necessario!
    @Test
    void createNullTest() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            personServices.create(null);
        });
        String expected = "It is not allowed to persist a null object";
        String actual = exception.getMessage();

        assertTrue( actual.contains(expected));
    }
    @Test
    void updateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            personServices.update(null);
        });
        String expected = "It is not allowed to persist a null object";
        String actual = exception.getMessage();

        assertTrue( actual.contains(expected));

    }
    @Test
    void update() {
        Person person = input.mockEntity(1);
        person.setId(1l);

        Person persisted = person;
        persisted.setId(1l);

        PersonVO personVO = input.mockVO(1);
        personVO.setKey(1l);

        when(personRepository.findById(1l)).thenReturn(Optional.of(person));
        when(personRepository.save(person)).thenReturn(persisted);

        var result  = personServices.update(personVO);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("First Name Test1", result.getName());
        assertEquals(1,result.getAge());

    }

    @Test
    void delete() {
        Person person = input.mockEntity(1);
        person.setId(1l);

        PersonVO personVO = input.mockVO(1);

        when(personRepository.findById(1l)).thenReturn(Optional.of(person));

       personServices.delete(1L);
    }
}