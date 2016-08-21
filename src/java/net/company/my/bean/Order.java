package net.company.my.bean;

/**
 *
 * @author Kostya
 */
public class Order extends Entity {

    private Book book;
    private User user;
    private String date;
    private OrderType orderType;
    private StatusType statusType;

    public Order() {
    }

    public Order(int id, Book book, User user, String date, OrderType orderType,
            StatusType statusType) {
        super(id);
        this.book = book;
        this.user = user;
        this.date = date;
        this.orderType = orderType;
        this.statusType = statusType;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Order{" + "id=" + getId() + ", book=" + book + ", user=" + user
                + ", date=" + date + ", orderType=" + orderType + ", "
                + "statusType=" + statusType + '}';
    }
}
