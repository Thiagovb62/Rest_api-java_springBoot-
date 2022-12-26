package com.example.apirest.unittests.mapper;

import com.example.apirest.Model.Person;
import com.example.apirest.data.vo.v1.PersonVO;
import com.example.apirest.mapper.DozerMapper;
import com.example.apirest.unitests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DozeConverterTest {

    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerMapper.parseObject(inputObject.mockEntity(), PersonVO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getName());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals(Integer.valueOf(0), output.getAge());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());
        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals(Integer.valueOf(0), outputZero.getAge());

        PersonVO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());
        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals(Integer.valueOf(7), outputSeven.getAge());

        PersonVO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals(Integer.valueOf(12), outputTwelve.getAge());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerMapper.parseObject(inputObject.mockVO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getName());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals(Integer.valueOf(0), output.getAge());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());

        assertEquals("Addres Test0", outputZero.getAddress());
        assertEquals(Integer.valueOf(0), outputZero.getAge());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());

        assertEquals("Addres Test7", outputSeven.getAddress());
        assertEquals(Integer.valueOf(7), outputSeven.getAge());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertEquals("Addres Test12", outputTwelve.getAddress());
        assertEquals(Integer.valueOf(12), outputTwelve.getAge());
    }
}