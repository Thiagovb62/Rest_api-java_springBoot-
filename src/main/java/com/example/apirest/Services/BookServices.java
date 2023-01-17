package com.example.apirest.Services;


import com.example.apirest.Controller.Book.BookController;
import com.example.apirest.Controller.Person.PersonController;
import com.example.apirest.Exceptions.ResourceNotFoundException;
import com.example.apirest.Repositories.BookRepository;
import com.example.apirest.data.vo.v1.BookVO;
import com.example.apirest.data.vo.v1.PersonVO;
import com.example.apirest.mapper.DozerMapper;
import com.example.apirest.mapper.custom.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(BookServices.class.getName());

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper bookMapper;

    public BookVO findById(Long id){

        logger.info("find one person");

        var entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        var vo = DozerMapper.parseObject(entity, BookVO.class);

        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());

        return vo;
    }
}
