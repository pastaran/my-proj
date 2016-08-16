package net.company.my.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Book;
import net.company.my.bean.OrderType;
import net.company.my.bean.StatusType;
import net.company.my.bean.User;
import net.company.my.logic.MainLogic;
import net.company.my.resource.ConfigurationManager;

/**
 *
 * @author Kostya
 */
public class OrderBookCommand implements ActionCommand {

    private static final String PARAM_NAME_BOOK_ID = "bookId";
    private static final String PARAM_NAME_USER_ID = "userId";
    private static final String PARAM_NAME_ORDER_TYPE = "orderType";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int bookId = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_ID));
        int userId = (int) request.getSession().getAttribute(PARAM_NAME_USER_ID);
        Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = simpleDateFormat.format(date);
        OrderType orderType = OrderType.valueOf(request.getParameter(PARAM_NAME_ORDER_TYPE).toUpperCase());

        try {
            MainLogic.orderBook(bookId, userId, currentTime, orderType);
        } catch (SQLException e) {

        }

        page = ConfigurationManager.getProperty("path.page.order.success");

        return page;
    }
}
