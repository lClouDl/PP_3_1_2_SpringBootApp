package ru.kireev.spring.SpringBootApp.dao;

import ru.kireev.spring.SpringBootApp.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getListUser();
    User getUserById(int id);
    void addUser(User user);
    void update(User user);
    void delete(int id);
}
