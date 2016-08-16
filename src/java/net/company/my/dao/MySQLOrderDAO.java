package net.company.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.Book;
import net.company.my.bean.Order;
import net.company.my.bean.OrderType;
import net.company.my.bean.StatusType;
import net.company.my.bean.User;

/**
 *
 * @author Kostya
 */
public class MySQLOrderDAO implements OrderDAO {

    private Connection connection;
    private static final String ADD_ORDER = "INSERT INTO `order`(book_id, user_id, "
            + "date, order_type, status_type)" + "VALUES(?, ?, ?, ?, ?)";
    private static final String GET_ACTIVE_ORDERS = "SELECT id, book_id, user_id, date, "
            + "order_type, status_type FROM `order` WHERE status_type = ? OR status_type = ?";
    private static final String GET_ORDERS_BY_USER_ID = "SELECT order.id, book.id, "
            + "user.id, order.date, order.order_type, order.status_type FROM `order` JOIN book ON "
            + "order.book_id = book.id JOIN user ON order.user_id = user.id WHERE user.id = ?";
    private static final String UPDATE_ORDER = "UPDATE `order` SET status_type = ?"
            + "WHERE id = ?";

    public MySQLOrderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addOrder(Order order) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(ADD_ORDER);
            statement.setInt(1, order.getBookId());
            statement.setInt(2, order.getUserId());
            statement.setString(3, order.getDate());
            statement.setString(4, order.getOrderType().name());
            statement.setString(5, order.getStatusType().name());
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
    public List<Order> findActiveOrders() {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_ACTIVE_ORDERS);
            statement.setString(1, StatusType.PLACED.name());
            statement.setString(2, StatusType.GIVEN.name());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                OrderType orderType = OrderType.valueOf(resultSet.getString(5).toUpperCase());
                StatusType statusType = StatusType.valueOf(resultSet.getString(6).toUpperCase());
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setBookId(resultSet.getInt(2));
                order.setUserId(resultSet.getInt(3));
                order.setDate(resultSet.getString(4));
                order.setOrderType(orderType);
                order.setStatusType(statusType);
                orders.add(order);
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
        return orders;
    }

    @Override
    public List<Order> findOrdersByUserId(int id) {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(GET_ORDERS_BY_USER_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                OrderType orderType = OrderType.valueOf(resultSet.getString(4).toUpperCase());
                StatusType statusType = StatusType.valueOf(resultSet.getString(5).toUpperCase());
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setBookId(resultSet.getInt(2));
                order.setUserId(resultSet.getInt(3));
                order.setDate(resultSet.getString(4));
                order.setOrderType(orderType);
                order.setStatusType(statusType);
                orders.add(order);
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
        return orders;
    }

    @Override
    public void updateOrder(int id, StatusType statusType) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(UPDATE_ORDER);
            statement.setString(1, statusType.name());
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
}
