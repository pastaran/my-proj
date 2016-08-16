package net.company.my.logic;

import java.sql.Connection;
import java.sql.SQLException;
import net.company.my.bean.User;
import net.company.my.bean.UserType;
import net.company.my.dao.UserDAO;
import net.company.my.dao.factory.DAOFactoryCreator;
import net.company.my.pool.ConnectionPool;

/**
 *
 * @author Kostya
 */
public class RegisterLogic {

    public static String register(String name, String email, String password)
            throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        UserDAO userDAO = DAOFactoryCreator.getFactory("MYSQL").createUserDAO(connection);

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserType(UserType.READER);

        try {
            userDAO.addUser(user);
        } finally {
            connection.close();
        }

        return name;
    }
}
