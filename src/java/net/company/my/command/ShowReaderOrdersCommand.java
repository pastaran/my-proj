package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Order;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class ShowReaderOrdersCommand implements ActionCommand {

    private static final String PARAM_NAME_USER_ID = "userId";
    static final Logger LOGGER = Logger.getLogger(ShowReaderOrdersCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Order> readerOrders = new ArrayList<>();
        int userId = Integer.parseInt(request.getParameter(PARAM_NAME_USER_ID));

        try {
            readerOrders = AdminLogic.showReaderOrders(userId);
        } catch (SQLException e) {
            LOGGER.error("Cannot show reader orders", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.admin.orders");
        request.setAttribute("orders", readerOrders);

        return page;
    }
}
