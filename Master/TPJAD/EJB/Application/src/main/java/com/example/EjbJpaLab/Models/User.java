package com.example.EjbJpaLab.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="user")
    private List<Book> books;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
