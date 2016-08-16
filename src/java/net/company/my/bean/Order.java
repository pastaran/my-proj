package net.company.my.bean;

/**
 *
 * @author Kostya
 */
public class Order extends Entity {

    private int bookId;
    private int userId;
    private String date;
    private OrderType orderType;
    private StatusType statusType;

    public Order() {
    }

    public Order(int id, int bookId, int userId, String date, OrderType orderType, StatusType statusType) {
        super(id);
        this.bookId = bookId;
        this.userId = userId;
        this.date = date;
        this.orderType = orderType;
        this.statusType = statusType;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "Order{" + "bookId=" + bookId + ", userId=" + userId + ", date="
                + date + ", orderType=" + orderType + ", statusType="
                + statusType + '}';
    }
}
