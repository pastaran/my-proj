package net.company.my.dao.factory;

import java.sql.Connection;
import net.company.my.dao.AuthorDAO;
import net.company.my.dao.BookDAO;
import net.company.my.dao.UserDAO;
import net.company.my.dao.OrderDAO;
import net.company.my.dao.SearchDAO;

/**
 *
 * @author Kostya
 */
public interface AbstractDAOFactory {

    AuthorDAO createAuthorDAO(Connection connection);

    BookDAO createBookDAO(Connection connection);

    OrderDAO createOrderDAO(Connection connection);

    SearchDAO createSearchDAO(Connection connection);

    UserDAO createUserDAO(Connection connection);
}
