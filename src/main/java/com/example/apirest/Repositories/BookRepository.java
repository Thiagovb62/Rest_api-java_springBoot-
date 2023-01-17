package com.example.apirest.Repositories;

import com.example.apirest.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {

}
