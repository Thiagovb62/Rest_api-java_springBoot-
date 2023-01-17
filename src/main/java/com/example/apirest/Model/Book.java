package com.example.apirest.Model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "tittle", length = 80)
    private String title;
    @Column(name="price",nullable = false, length = 80)
    private Float price;
    @Column(name="author")
    private String author;

    public Book() {
    }

    public Book(String title, Float price, String author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof Book book)) return false;
        return getId().equals(book.getId()) && getTitle().equals(book.getTitle()) && getPrice().equals(book.getPrice()) && getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPrice(), getAuthor());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
