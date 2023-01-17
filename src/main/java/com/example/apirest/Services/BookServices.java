package com.example.apirest.Services;


import com.example.apirest.Controller.Book.BookController;
import com.example.apirest.Controller.Person.PersonController;
import com.example.apirest.Exceptions.ResourceNotFoundException;
import com.example.apirest.Model.Book;
import com.example.apirest.Repositories.BookRepository;
import com.example.apirest.data.vo.v1.BookVO;
import com.example.apirest.data.vo.v1.PersonVO;
import com.example.apirest.mapper.DozerMapper;
import com.example.apirest.mapper.custom.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<BookVO> findaAllBooks() {
        logger.info("find all books");
        var books = DozerMapper.parseListObjects(bookRepository.findAll(), BookVO.class);
        books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return books;
    }
    public BookVO findByBookId(Long id){
        logger.info("find one book");

        var entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        var vo = DozerMapper.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return vo;
    }

    public BookVO create(BookVO book){

        logger.info("create Book");

        var entity = DozerMapper.parseObject(book, Book.class);

        var vo = DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);

        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());

        return vo;
    }
}
