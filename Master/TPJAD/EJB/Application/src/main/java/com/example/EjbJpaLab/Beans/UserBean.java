package com.example.EjbJpaLab.Beans;


import com.example.EjbJpaLab.Interfaces.UserService;
import com.example.EjbJpaLab.Models.Book;
import com.example.EjbJpaLab.Models.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
@Remote(UserService.class)

public class UserBean implements UserService {

    @PersistenceContext(unitName = "ejb")
    private EntityManager manager;

    @Override
    public void addUser(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        manager.persist(user);


    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User find(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public Long validate(String username, String password)
    {
        Long result= 0L;
        TypedQuery<User> query = manager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username",username);
        query.setParameter("password", password);
        try{
            User u = query.getSingleResult();
            return u.getId_user();
        }catch(javax.persistence.NoResultException e)
        {
            return result;
        }


    }

    @Override
    public Long containsBook(Long userId, String title, String author)
    {
        Long result= 0L;
        User user = find(userId);
        List<Book> books= user.getBooks();

        for (Book b:books) {
            if (b.getTitle().equals(title) && b.getAuthor().equals(author))
                return b.getBook_id();
        }
            return result;



    }
}
