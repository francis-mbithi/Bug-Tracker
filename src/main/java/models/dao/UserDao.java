package models.dao;

import models.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAll();

    void clearAll();
}
