package net.company.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.Author;
import net.company.my.bean.Book;

/**
 *
 * @author Kostya
 */
public class MySQLBookDAO implements BookDAO {

    private Connection connection;
    private static final String ADD_BOOK = "INSERT INTO book(title, author_id,"
            + "year, qty_total, qty_available) " + "VALUES(?, ?, ?, ?, ?)";
    private static final String GET_ALL_BOOKS = "SELECT * FROM book";
    private static final String GET_BOOK_BY_ID = "SELECT * FROM book WHERE id = ?";
    private static final String REMOVE_BOOK_BY_ID = "DELETE FROM book WHERE id = ?";
    private static final String DECREMENT_BOOK_BY_ID = "UPDATE book SET "
            + "qty_available = qty_available - 1 WHERE id = ? AND qty_available > 0";
    private static final String INCREMENT_BOOK_BY_ID = "UPDATE book SET "
            + "qty_available = qty_available + 1 WHERE id = ?";

    public MySQLBookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addBook(Book book) {
        int bookId = 0;
        AuthorDAO authorDAO = new MySQLAuthorDAO(connection);
        int authorId = authorDAO.addAuthor(book.getAuthor());
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(ADD_BOOK, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book.getTitle());
            statement.setInt(2, authorId);
            statement.setInt(3, book.getYear());
            statement.setInt(4, book.getQtyTotal());
            statement.setInt(5, book.getQtyAvailable());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                bookId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookId;
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        AuthorDAO authorDAO = new MySQLAuthorDAO(connection);
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_ALL_BOOKS);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int authorId = resultSet.getInt(3);
                Author author = authorDAO.findAuthorById(authorId);
                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(author);
                book.setYear(resultSet.getInt(4));
                book.setQtyTotal(resultSet.getInt(5));
                book.setQtyAvailable(resultSet.getInt(6));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Book findBookById(int id) {
        Book book = null;
        AuthorDAO authorDAO = new MySQLAuthorDAO(connection);
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_BOOK_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int authorId = resultSet.getInt(3);
                Author author = authorDAO.findAuthorById(authorId);
                book = new Book();
                book.setId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(author);
                book.setYear(resultSet.getInt(4));
                book.setQtyTotal(resultSet.getInt(5));
                book.setQtyAvailable(resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

    @Override
    public void removeBookById(int id) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(REMOVE_BOOK_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void decrementBookById(int id) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(DECREMENT_BOOK_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void incrementBookById(int id) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(INCREMENT_BOOK_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
