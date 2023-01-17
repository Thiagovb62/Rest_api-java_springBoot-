package com.example.apirest.mapper.custom;

import com.example.apirest.Model.Book;
import com.example.apirest.data.vo.v1.BookVO;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public Book convertVoToEntity(BookVO book){
        Book entity = new Book();
        entity.setAuthor(book.getAuthor());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());
        return entity;
    }
}
