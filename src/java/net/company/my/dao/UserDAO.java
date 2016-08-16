package net.company.my.dao;

import java.util.List;
import net.company.my.bean.User;

/**
 *
 * @author Kostya
 */
public interface UserDAO {

    int addUser(User user);

    List<User> findAllUsers();

    User findUserByEmail(String email);

    User findUserById(int id);

    User findUserByLoginAndPass(String login, String pass);
}
