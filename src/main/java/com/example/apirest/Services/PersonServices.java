package com.example.apirest.Services;

import com.example.apirest.Exceptions.ResourceNotFoundException;
import com.example.apirest.Model.Person;
import com.example.apirest.Repositories.PersonRepository;
import com.example.apirest.data.vo.v1.PersonVO;
import com.example.apirest.data.vo.v2.PersonVOV2;
import com.example.apirest.mapper.DozerMapper;
import com.example.apirest.mapper.custom.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    public PersonVO findById(Long id){

        logger.info("find one person");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }
    public List<PersonVO> findAll(){

        logger.info("find all person");

        return  DozerMapper.parseListObjects(personRepository.findAll(),PersonVO.class);

    }
    public PersonVO create(PersonVO person){
        logger.info("create person");

        var entity = DozerMapper.parseObject(person, Person.class);

        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }
    public PersonVO update(PersonVO person){
        logger.info("update person");

        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        entity.setName(person.getName());
        entity.setAge(person.getAge());
        entity.setAddress(person.getAddress());

        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }
    public void delete(Long id){
        logger.info("delete a person");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        personRepository.delete(entity);
    };

    public PersonVOV2 createV2(PersonVOV2 personVOV2) {
        logger.info("create person");

        var entity = personMapper.convertVoToEntity(personVOV2);

        var vo = personMapper.convertEntityToVO(personRepository.save(entity));
        return vo;
    }

}
