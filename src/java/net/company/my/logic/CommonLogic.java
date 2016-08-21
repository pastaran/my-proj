package net.company.my.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.Book;
import net.company.my.dao.BookDAO;
import net.company.my.dao.factory.DAOFactoryCreator;
import net.company.my.pool.ConnectionPool;

/**
 *
 * @author Kostya
 */
public class CommonLogic {

    public static List<Book> showBooks() throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        BookDAO bookDAO = DAOFactoryCreator.getFactory().createBookDAO(connection);
        List<Book> books = new ArrayList<>();

        try {
            books = bookDAO.findAllBooks();
        } finally {
            connection.close();
        }

        return books;
    }
}
