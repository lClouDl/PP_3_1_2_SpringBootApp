package ru.kireev.spring.SpringBootApp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.kireev.spring.SpringBootApp.models.User;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getListUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.find(User.class, user.getId()).setFirstName(user.getFirstName());
        entityManager.find(User.class, user.getId()).setLastName(user.getLastName());
        entityManager.find(User.class, user.getId()).setGender(user.getGender());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
