package net.company.my.dao.factory;

import java.sql.Connection;
import net.company.my.dao.AuthorDAO;
import net.company.my.dao.BookDAO;
import net.company.my.dao.MySQLAuthorDAO;
import net.company.my.dao.MySQLBookDAO;
import net.company.my.dao.MySQLOrderDAO;
import net.company.my.dao.MySQLSearchDAO;
import net.company.my.dao.MySQLUserDAO;
import net.company.my.dao.UserDAO;
import net.company.my.dao.OrderDAO;
import net.company.my.dao.SearchDAO;

/**
 *
 * @author Kostya
 */
public class MySQLDAOFactory implements AbstractDAOFactory {

    @Override
    public AuthorDAO createAuthorDAO(Connection connection) {
        return new MySQLAuthorDAO(connection);
    }

    @Override
    public BookDAO createBookDAO(Connection connection) {
        return new MySQLBookDAO(connection);
    }

    @Override
    public OrderDAO createOrderDAO(Connection connection) {
        return new MySQLOrderDAO(connection);
    }

    @Override
    public SearchDAO createSearchDAO(Connection connection) {
        return new MySQLSearchDAO(connection);
    }

    @Override
    public UserDAO createUserDAO(Connection connection) {
        return new MySQLUserDAO(connection);
    }
}
