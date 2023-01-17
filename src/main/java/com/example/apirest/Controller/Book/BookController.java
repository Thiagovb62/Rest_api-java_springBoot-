package com.example.apirest.Controller.Book;

import com.example.apirest.Services.BookServices;
import com.example.apirest.data.vo.v1.BookVO;
import com.example.apirest.data.vo.v1.PersonVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
@Tag(name = "Book Endpoint",description = "Endpoint for book")
public class BookController {
    @Autowired
    BookServices bookServices;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Find book by id", description = "Find book by id",
            tags = {"Book Endpoint"}
            , responses = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BookVO.class))
                    }),
            @ApiResponse(responseCode = "204", description = "No content",content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content)
    })
    public BookVO findById(@PathVariable(value = "id") Long id){
        return bookServices.findById(id);
    }

    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Create book", description = "Create book",
            tags = {"Book Endpoint"}
            , responses = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BookVO.class))
                    }),
            @ApiResponse(responseCode = "400', description = 'Bad Request",content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content)
    })
    public BookVO create(@RequestBody BookVO book){
        return bookServices.create(book);
    }
}
