package net.company.my.dao;

import java.util.List;
import net.company.my.bean.Order;
import net.company.my.bean.StatusType;

/**
 *
 * @author Kostya
 */
public interface OrderDAO {

    void addOrder(Order order);

    List<Order> findActiveOrders();

    List<Order> findOrdersByUserId(int id);

    void updateOrder(int id, StatusType statusType);
}
