package com.example.EjbJpaLab.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    String title;
    String author;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }
}
