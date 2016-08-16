package net.company.my.logic;

import java.sql.Connection;
import java.sql.SQLException;
import net.company.my.bean.User;
import net.company.my.dao.MySQLUserDAO;
import net.company.my.dao.UserDAO;
import net.company.my.dao.factory.DAOFactoryCreator;
import net.company.my.pool.ConnectionPool;

/**
 *
 * @author Kostya
 */
public class LoginLogic {

    public static User checkLogin(String enterLogin, String enterPass) throws SQLException, Exception {
        Connection connection = ConnectionPool.getConnection();
        UserDAO userDAO = DAOFactoryCreator.getFactory("MYSQL").createUserDAO(connection);
        User user = null;

        try {
            user = userDAO.findUserByLoginAndPass(enterLogin, enterPass);
        } finally {
            connection.close();
        }

        if (user == null) {
            throw new Exception("User not found");
        }

        return user;
    }
}
