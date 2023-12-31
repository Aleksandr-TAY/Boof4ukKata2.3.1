package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    public void addUser(User user);
    public void deleteUser(int id);
    public void updateUser(User user);
    User findUser(int id);
    public List<User> getUserTable();
}
