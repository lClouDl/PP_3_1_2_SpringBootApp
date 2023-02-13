package ru.kireev.spring.SpringBootApp.servises;

import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;
import ru.kireev.spring.SpringBootApp.dao.UserDAO;
import ru.kireev.spring.SpringBootApp.models.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;

    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getListUser() {
        return userDAO.getListUser();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void addUser(User user) { userDAO.addUser(user); }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
