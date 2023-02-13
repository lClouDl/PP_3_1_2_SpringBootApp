package ru.kireev.spring.SpringBootApp.servises;

import ru.kireev.spring.SpringBootApp.models.User;

import java.util.List;

public interface UserService {

    List<User> getListUser();
    User getUserById(int id);
    void addUser(User user);
    void update(User user);
    void delete(int id);
}
