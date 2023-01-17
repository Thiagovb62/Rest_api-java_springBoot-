package com.example.apirest.unittests.mockito.services;

import com.example.apirest.Model.Book;
import com.example.apirest.Model.Person;
import com.example.apirest.Repositories.BookRepository;
import com.example.apirest.Services.BookServices;
import com.example.apirest.data.vo.v1.BookVO;
import com.example.apirest.data.vo.v1.PersonVO;
import com.example.apirest.unitests.mapper.mocks.MockBook;
import jakarta.persistence.Id;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookServicesTest {

    MockBook input;

    @InjectMocks
    private BookServices bookServices;

    @Mock
    BookRepository bookRepository;

    @BeforeEach
    void setUp() throws Exception {
        input = new MockBook();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findaAllBooks() {
        List<Book> book = input.mockEntityList();

        when(bookRepository.findAll()).thenReturn(book);

        var result = bookServices.findaAllBooks();
        assertNotNull(result);
        assertEquals(14, result.size());

        var bookOne = result.get(1);

        assertNotNull(bookOne);
        assertNotNull(bookOne.getKey());
        assertNotNull(bookOne.getLinks());
        System.out.println(bookOne.toString());
        assertTrue(bookOne.toString().contains("links: [</book/v1/1>;rel=\"self\"]"));
        assertEquals("Title Test1", bookOne.getTitle());
        assertEquals("Author Test1", bookOne.getAuthor());
        assertEquals(20.0F, bookOne.getPrice());
    }

    @Test
    void findByBookId() {
        Book book = input.mockEntity(1);
        book.setId(1l);

        when(bookRepository.findById(1l)).thenReturn(Optional.of(book));

        var result = bookServices.findByBookId(1l);
        assertNotNull(result);
        assertNotNull(result.getLinks());
        assertNotNull(result.getKey());
        System.out.println(result.toString());
        assertTrue(result.toString().contains("links: [</book/v1/1>;rel=\"self\"]"));
        assertEquals(1l, result.getKey());
        assertEquals("Title Test1", result.getTitle());
        assertEquals("Author Test1", result.getAuthor());
        assertEquals(20.0F, result.getPrice());

    }
    @Test
    void create() {
        Book book = input.mockEntity(1);
        Book persistedBook = book;
        persistedBook.setId(1l);

        BookVO bookVO = input.mockVO(1);
        bookVO.setKey(1l);

        when(bookRepository.save(book)).thenReturn(persistedBook);

        var result = bookServices.create(bookVO);
        assertNotNull(result);
        assertNotNull(result.getLinks());
        assertNotNull(result.getKey());

        assertTrue(result.toString().contains("links: [</book/v1/1>;rel=\"self\"]"));

        assertEquals(1l, result.getKey());
        assertEquals("Title Test1", result.getTitle());
        assertEquals("Author Test1", result.getAuthor());
        assertEquals(20.0F, result.getPrice());

    }
}