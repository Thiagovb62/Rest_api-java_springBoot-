package com.example.apirest.data.vo.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id","title","price","author"})
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String title;
    private Float price;
    private String author;

    public BookVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookVO bookVO)) return false;
        return getKey().equals(bookVO.getKey()) && getTitle().equals(bookVO.getTitle()) && getPrice().equals(bookVO.getPrice()) && getAuthor().equals(bookVO.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getTitle(), getPrice(), getAuthor());
    }

}
