package net.company.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.Author;

/**
 *
 * @author Kostya
 */
public class MySQLAuthorDAO implements AuthorDAO {

    private Connection connection;
    private static final String ADD_AUTHOR = "INSERT INTO author(name) VALUES(?)";
    private static final String GET_ALL_AUTHORS = "SELECT * FROM author";
    private static final String GET_AUTHOR_BY_ID = "SELECT * FROM author WHERE id = ?";
    private static final String GET_AUTHOR_BY_NAME = "SELECT * FROM author WHERE name = ?";
    private static final String UPDATE_AUTHOR = "UPDATE author SET name = ? WHERE id = ?";
    private static final String DELETE_AUTHOR_BY_ID = "DELETE FROM author WHERE id = ?";

    public MySQLAuthorDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addAuthor(Author author) {
        int authorId = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Author existingAuthor = findAuthorByName(author.getName());

            if (existingAuthor != null) {
                return existingAuthor.getId();
            }

            statement = connection.prepareStatement(ADD_AUTHOR, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, author.getName());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                authorId = resultSet.getInt(1);
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
        return authorId;
    }

    @Override
    public List<Author> findAllAuthors() {
        List<Author> authors = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_ALL_AUTHORS);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
                authors.add(author);
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
        return authors;
    }

    @Override
    public Author findAuthorById(int id) {
        Author author = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_AUTHOR_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                author = new Author();
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
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
        return author;
    }

    @Override
    public Author findAuthorByName(String name) {
        Author author = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_AUTHOR_BY_NAME);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                author = new Author();
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
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
        return author;
    }

    @Override
    public void updateAuthor(int id, String name) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(UPDATE_AUTHOR);
            statement.setString(1, name);
            statement.setInt(2, id);
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
    public void deleteAuthorById(int id) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(DELETE_AUTHOR_BY_ID);
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
