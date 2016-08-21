package net.company.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.Author;
import net.company.my.bean.Book;

/**
 *
 * @author Kostya
 */
public class MySQLSearchDAO implements SearchDAO {

    private Connection connection;
    private static String GET_BOOKS_BY_TITLE = "SELECT * FROM book INNER JOIN author ON "
            + "book.author_id = author.id WHERE author.name LIKE ? or book.title LIKE ?";

    public MySQLSearchDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        List<Book> books = new ArrayList<>();
        AuthorDAO authorDAO = new MySQLAuthorDAO(connection);
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_BOOKS_BY_TITLE);
            statement.setString(1, "%" + title + "%");
            statement.setString(2, "%" + title + "%");

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
}
