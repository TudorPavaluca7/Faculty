package com.example.EjbJpaLab.Beans;


import com.example.EjbJpaLab.Interfaces.BookService;
import com.example.EjbJpaLab.Models.Book;
import com.example.EjbJpaLab.Models.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Remote(BookService.class)
public class BookBean implements BookService {

    @PersistenceContext(unitName = "ejb")
    private EntityManager manager;


    @Override
    public void addBook(String title, String author) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        manager.persist(book);
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = manager.createQuery("select b from Book b where b.user is NULL", Book.class);
        return query.getResultList();
    }

    @Override
    public void deleteBook(Long id) {
        Book b = findBookById(id);
        manager.remove(b);

    }

    @Override
    public Book findBookById(Long id) {
        return manager.find(Book.class, id);
    }

    @Override
    public Long validate(String title, String author)
    {
        Long result= 0L;
        TypedQuery<Book> query = manager.createQuery("SELECT b FROM Book b WHERE b.title = :title AND b.author = :author", Book.class);
        query.setParameter("title",title);
        query.setParameter("author", author);
        try{
            Book b = query.getSingleResult();
            return b.getBook_id();
        }catch(javax.persistence.NoResultException e)
        {
            return result;
        }


    }

    @Override
    public User findUser(Long id) {
        return manager.find(User.class, id);
    }


    @Override
    public void borrowBook(Long bookId, Long userId){

        Book book = findBookById(bookId);
        User user = findUser(userId);

        book.setUser(user);
        List<Book> books = user.getBooks();
        books.add(book);
        user.setBooks(books);

        manager.merge(user);

    }

    @Override
    public void returnBook(Long bookId, Long userId){

        Book book = findBookById(bookId);
        User user = findUser(userId);

        book.setUser(null);
        List<Book> books = user.getBooks();
        books.remove(book);
        user.setBooks(books);

        manager.merge(user);

    }



}
