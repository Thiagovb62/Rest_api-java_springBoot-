package com.example.apirest.Controller.Person;

import com.example.apirest.Services.PersonServices;
import com.example.apirest.data.vo.v1.PersonVO;

import com.example.apirest.data.vo.v2.PersonVOV2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person/v1")
@Tag(name = "Person Endpoint",description = "Endpoint for person")
public class PersonController {
    @Autowired
     private PersonServices personServices;

        @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        @Operation(summary = "Find person by id", description = "Find person by id",
                tags = {"Person Endpoint"}
                , responses = {
                @ApiResponse(responseCode = "200", description = "Success",
                content = {
                        @Content(mediaType = "application/json", schema = @Schema(implementation = PersonVO.class))
                }),
                @ApiResponse(responseCode = "404", description = "Not found",content = @Content),
                @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
                @ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
                @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content)
        })
            public PersonVO findById(@PathVariable(value = "id") Long id){
                return personServices.findById(id);
        }

        @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        @Operation(summary = "Find all persons ", description = "Find all person ",
                tags = {"Person Endpoint"}
                , responses = {
                @ApiResponse(responseCode = "200", description = "Success",
                        content = @Content(schema = @Schema(implementation = PersonVO.class))
                ),
                @ApiResponse(responseCode = "204', description = 'No content",content = @Content),
                @ApiResponse(responseCode = "404", description = "Not found",content = @Content),
                @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
                @ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
                @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content)
        })
            public List<PersonVO> findAll(){
                return  personServices.findAll();
        }
        @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        @Operation(summary = "create a person ", description = "Add a new person by passing a json object",
                tags = {"Person Endpoint"}
                , responses = {
                @ApiResponse(responseCode = "200", description = "Success",
                        content = @Content(schema = @Schema(implementation = PersonVO.class))
                ),
                @ApiResponse(responseCode = "400', description = 'No Bad Request",content = @Content),
                @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
                @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content)
        })
            public PersonVO create(@RequestBody PersonVO personVO){
                return personServices.create(personVO);
        }
        @PutMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        @Operation(summary = "Update a person", description = "update a person by passing a json object",
                tags = {"Person Endpoint"}
                , responses = {
                @ApiResponse(responseCode = "200", description = "Success",
                        content = @Content(schema = @Schema(implementation = PersonVO.class))
                ),
                @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
                @ApiResponse(responseCode = "400", description = "Bad Request",content = @Content),
                @ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
                @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content)
        })
            public PersonVO update(@RequestBody PersonVO personVO){
                return personServices.update(personVO);
        }

        @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        @Operation(summary = "Update a person", description = "update a person by passing a json object",
                tags = {"Person Endpoint"}
                , responses = {
                @ApiResponse(responseCode = "204", description = "No Content",
                        content = @Content(schema = @Schema(implementation = PersonVO.class))
                ),
                @ApiResponse(responseCode = "401", description = "Unauthorized",content = @Content),
                @ApiResponse(responseCode = "400", description = "Bad Request",content = @Content),
                @ApiResponse(responseCode = "404", description = "Not Found",content = @Content),
                @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content)
        })
            public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
                personServices.delete(id);
                return ResponseEntity.noContent().build();
        }

}
