package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Order;
import net.company.my.bean.StatusType;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class ReturnBookCommand implements ActionCommand {

    private static final String PARAM_NAME_ORDER_ID = "orderId";
    private static final String PARAM_NAME_BOOK_ID = "bookId";
    static final Logger LOGGER = Logger.getLogger(ReturnBookCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int orderId = Integer.parseInt(request.getParameter(PARAM_NAME_ORDER_ID));
        int bookId = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_ID));
        List<Order> orders = new ArrayList<>();

        try {
            AdminLogic.returnBook(orderId, StatusType.RETURNED, bookId);
        } catch (SQLException e) {
            LOGGER.error("Cannot return book", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        try {
            orders = AdminLogic.showOrders();
        } catch (SQLException e) {
            LOGGER.error("Cannot show orders", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.admin.orders");
        request.setAttribute("orders", orders);

        return page;
    }
}
