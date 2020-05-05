package designpatterns.dao;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    List<User> getUsers();
}

class User {
    private String name;
}

class UserDaoImpl implements UserDao {

    @Override
    public List<User> getUsers() {
        return new ArrayList<>();
    }
}

class Test {
    public void test() {
        UserDao userDao = new UserDaoImpl();
        userDao.getUsers();
    }
}