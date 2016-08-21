package net.company.my.dao;

import java.util.List;
import net.company.my.bean.User;
import net.company.my.bean.UserType;

/**
 *
 * @author Kostya
 */
public interface UserDAO {

    int addUser(User user);

    List<User> findAllUsers(UserType userType);

    User findUserByEmail(String email);

    User findUserById(int id);

    User findUserByLoginAndPass(String login, String pass);
}
