package net.company.my.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.Author;
import net.company.my.bean.Book;
import net.company.my.bean.Order;
import net.company.my.bean.StatusType;
import net.company.my.bean.User;
import net.company.my.bean.UserType;
import net.company.my.dao.AuthorDAO;
import net.company.my.dao.BookDAO;
import net.company.my.dao.OrderDAO;
import net.company.my.dao.UserDAO;
import net.company.my.dao.factory.DAOFactoryCreator;
import net.company.my.pool.ConnectionPool;

/**
 *
 * @author Kostya
 */
public class AdminLogic {

    public static List<Author> showAuthors() throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory().createAuthorDAO(connection);
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
        OrderDAO orderDAO = DAOFactoryCreator.getFactory().createOrderDAO(connection);
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
        OrderDAO orderDAO = DAOFactoryCreator.getFactory().createOrderDAO(connection);
        BookDAO bookDAO = DAOFactoryCreator.getFactory().createBookDAO(connection);

        try {
            bookDAO.decrementBookById(bookId);
            orderDAO.updateOrder(orderId, statusType);
        } finally {
            connection.close();
        }
    }

    public static void returnBook(int orderId, StatusType statusType, int bookId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        OrderDAO orderDAO = DAOFactoryCreator.getFactory().createOrderDAO(connection);
        BookDAO bookDAO = DAOFactoryCreator.getFactory().createBookDAO(connection);

        try {
            bookDAO.incrementBookById(bookId);
            orderDAO.updateOrder(orderId, statusType);
        } finally {
            connection.close();
        }
    }

    public static void addAuthor(String name) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory().createAuthorDAO(connection);

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
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory().createAuthorDAO(connection);

        try {
            authorDAO.updateAuthor(id, name);
        } finally {
            connection.close();
        }
    }

    public static Author goUpdateAuthor(int id) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory().createAuthorDAO(connection);
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
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory().createAuthorDAO(connection);

        try {
            authorDAO.removeAuthorById(id);
        } finally {
            connection.close();
        }
    }

    public static void addBook(String title, Author author, int year,
            int qtyTotal, int qtyAvailable) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        BookDAO bookDAO = DAOFactoryCreator.getFactory().createBookDAO(connection);

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        book.setQtyTotal(qtyTotal);
        book.setQtyAvailable(qtyAvailable);

        try {
            bookDAO.addBook(book);
        } finally {
            connection.close();
        }
    }

    public static Author findAuthorById(int id) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        AuthorDAO authorDAO = DAOFactoryCreator.getFactory().createAuthorDAO(connection);

        Author author = null;

        try {
            author = authorDAO.findAuthorById(id);
        } finally {
            connection.close();
        }

        return author;
    }

    public static void deleteBook(int id) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        BookDAO bookDAO = DAOFactoryCreator.getFactory().createBookDAO(connection);

        try {
            bookDAO.removeBookById(id);
        } finally {
            connection.close();
        }
    }

    public static Book goUpdateBook(int id) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        BookDAO bookDAO = DAOFactoryCreator.getFactory().createBookDAO(connection);
        Book book = null;

        try {
            book = bookDAO.findBookById(id);
        } finally {
            connection.close();
        }

        return book;
    }

    public static void updateBook(int id, String title, int authorId, int year,
            int qtyTotal, int qtyAvailable) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        BookDAO bookDAO = DAOFactoryCreator.getFactory().createBookDAO(connection);

        try {
            bookDAO.updateBook(id, title, authorId, year, qtyTotal, qtyAvailable);
        } finally {
            connection.close();
        }
    }

    public static List<User> showReaders() throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        UserDAO userDAO = DAOFactoryCreator.getFactory().createUserDAO(connection);
        List<User> readers = new ArrayList<>();

        try {
            readers = userDAO.findAllUsers(UserType.READER);
        } finally {
            connection.close();
        }

        return readers;
    }

    public static List<Order> showReaderOrders(int userId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        OrderDAO orderDAO = DAOFactoryCreator.getFactory().createOrderDAO(connection);
        List<Order> readerOrders = new ArrayList<>();

        try {
            readerOrders = orderDAO.findOrdersByUserId(userId);
        } finally {
            connection.close();
        }

        return readerOrders;
    }

    public static boolean checkBookIfAvailable(int bookId) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        BookDAO bookDAO = DAOFactoryCreator.getFactory().createBookDAO(connection);
        boolean check = false;

        try {
            check = bookDAO.checkBookIfAvailable(bookId);
        } finally {
            connection.close();
        }

        return check;
    }
}
