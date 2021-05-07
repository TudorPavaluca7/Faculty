package com.example.EjbJpaLab.Interfaces;



import com.example.EjbJpaLab.Models.Book;
import com.example.EjbJpaLab.Models.User;

import java.util.List;

public interface BookService {


    public void addBook(String title,String author);
    public List<Book> findAll();
    public void deleteBook(Long id);
    public Book findBookById(Long id);
    public Long validate(String title, String author);
    public User findUser(Long id);
    public void borrowBook(Long bookId, Long userId);
    public void returnBook(Long bookId, Long userId);

}
