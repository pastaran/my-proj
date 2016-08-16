package net.company.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.User;
import net.company.my.bean.UserType;

/**
 *
 * @author Kostya
 */
public class MySQLUserDAO implements UserDAO {

    private Connection connection;
    private static final String ADD_USER = "INSERT INTO user(name, email, password, user_type) "
            + "VALUES(?, ?, ?, ?)";
    private static final String GET_ALL_USERS = "SELECT * FROM user";
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String GET_USER_BY_LOGIN_AND_PASS = "SELECT * FROM user WHERE "
            + "email = ? AND password = ?";

    public MySQLUserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addUser(User user) {
        int userId = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            User existingUser = findUserByEmail(user.getEmail());

            if (existingUser != null) {
                return existingUser.getId();
            }

            statement = connection.prepareStatement(ADD_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getUserType().name());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                userId = resultSet.getInt(1);
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
        return userId;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_ALL_USERS);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UserType userType = UserType.valueOf(resultSet.getString(5).toUpperCase());
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setUserType(userType);
                users.add(user);
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
        return users;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_USER_BY_EMAIL);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                UserType userType = UserType.valueOf(resultSet.getString(5).toUpperCase());
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setUserType(userType);
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
        return user;
    }

    @Override
    public User findUserById(int id) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_USER_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                UserType userType = UserType.valueOf(resultSet.getString(5).toUpperCase());
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setUserType(userType);
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
        return user;
    }

    @Override
    public User findUserByLoginAndPass(String login, String pass) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_USER_BY_LOGIN_AND_PASS);
            statement.setString(1, login);
            statement.setString(2, pass);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                UserType userType = UserType.valueOf(resultSet.getString(5).toUpperCase());
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setUserType(userType);
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
        return user;
    }
}
