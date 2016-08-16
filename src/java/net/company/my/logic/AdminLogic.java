package net.company.my.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.Author;
import net.company.my.bean.Order;
import net.company.my.bean.StatusType;
import net.company.my.dao.AuthorDAO;
import net.company.my.dao.BookDAO;
import net.company.my.dao.OrderDAO;
import net.company.my.dao.factory.DAOFactoryCreator;
import net.company.my.pool.ConnectionPool;

/**
 *
 * @author Kostya
 */
public class AdminLogic {

    public static List<Author> showAuthors() throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory("MYSQL").createAuthorDAO(connection);
        List<Author> authors = new ArrayList<>();

        try {
            authors = authorDAO.findAllAuthors();
        } finally {
            connection.close();
        }

        return authors;
    }

    public static List<Order> showOrders() throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        OrderDAO orderDAO = DAOFactoryCreator.getFactory("MYSQL").createOrderDAO(connection);
        List<Order> orders = new ArrayList<>();

        try {
            orders = orderDAO.findActiveOrders();
        } finally {
            connection.close();
        }

        return orders;
    }

    public static void giveBook(int orderId, StatusType statusType, int bookId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        OrderDAO orderDAO = DAOFactoryCreator.getFactory("MYSQL").createOrderDAO(connection);
        BookDAO bookDAO = DAOFactoryCreator.getFactory("MYSQL").createBookDAO(connection);

        try {
            bookDAO.decrementBookById(bookId);
            orderDAO.updateOrder(orderId, statusType);
        } finally {
            connection.close();
        }
    }

    public static void returnBook(int orderId, StatusType statusType, int bookId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        OrderDAO orderDAO = DAOFactoryCreator.getFactory("MYSQL").createOrderDAO(connection);
        BookDAO bookDAO = DAOFactoryCreator.getFactory("MYSQL").createBookDAO(connection);

        try {
            bookDAO.incrementBookById(bookId);
            orderDAO.updateOrder(orderId, statusType);
        } finally {
            connection.close();
        }
    }

    public static void addAuthor(String name) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory("MYSQL").createAuthorDAO(connection);

        Author author = new Author();
        author.setName(name);

        try {
            authorDAO.addAuthor(author);
        } finally {
            connection.close();
        }
    }

    public static void updateAuthor(int id, String name) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory("MYSQL").createAuthorDAO(connection);

        try {
            authorDAO.updateAuthor(id, name);
        } finally {
            connection.close();
        }
    }

    public static Author goUpdateAuthor(int id) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory("MYSQL").createAuthorDAO(connection);
        Author author = null;

        try {
            author = authorDAO.findAuthorById(id);
        } finally {
            connection.close();
        }

        return author;
    }

    public static void deleteAuthor(int id) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory("MYSQL").createAuthorDAO(connection);

        try {
            authorDAO.deleteAuthorById(id);
        } finally {
            connection.close();
        }
    }
}
