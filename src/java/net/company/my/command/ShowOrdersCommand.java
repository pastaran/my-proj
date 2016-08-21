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
public class ShowOrdersCommand implements ActionCommand {

    static final Logger LOGGER = Logger.getLogger(ShowOrdersCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Order> orders = new ArrayList<>();

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
