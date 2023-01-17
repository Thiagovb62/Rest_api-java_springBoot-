package com.example.apirest.Controller.Book;

import com.example.apirest.Services.BookServices;
import com.example.apirest.data.vo.v1.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/v1")
public class BookController {
    @Autowired
    BookServices bookServices;

    @GetMapping(value = "/{id}")
    public BookVO findById(@PathVariable(value = "id") Long id){
        return bookServices.findById(id);
    }
}
