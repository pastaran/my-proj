package net.company.my.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.company.my.bean.Book;
import net.company.my.bean.Order;
import net.company.my.bean.OrderType;
import net.company.my.bean.StatusType;
import net.company.my.dao.OrderDAO;
import net.company.my.dao.SearchDAO;
import net.company.my.dao.factory.DAOFactoryCreator;
import net.company.my.pool.ConnectionPool;

/**
 *
 * @author Kostya
 */
public class MainLogic {

    public static List<Book> searchBooks(String title) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        SearchDAO searchDAO = DAOFactoryCreator.getFactory("MYSQL").createSearchDAO(connection);
        List<Book> books = new ArrayList<>();

        try {
            books = searchDAO.findBooksByTitle(title);
        } finally {
            connection.close();
        }

        return books;
    }

    public static void orderBook(int bookId, int userId, String date,
            OrderType orderType) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        OrderDAO orderDAO = DAOFactoryCreator.getFactory("MYSQL").createOrderDAO(connection);

        Order order = new Order();
        order.setBookId(bookId);
        order.setUserId(userId);
        order.setDate(date);
        order.setOrderType(orderType);
        order.setStatusType(StatusType.PLACED);

        try {
            orderDAO.addOrder(order);
        } finally {
            connection.close();
        }
    }
}
