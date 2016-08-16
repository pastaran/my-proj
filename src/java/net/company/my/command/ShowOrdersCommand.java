package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Order;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;

/**
 *
 * @author Kostya
 */
public class ShowOrdersCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Order> orders = new ArrayList<>();

        try {
            orders = AdminLogic.showOrders();
        } catch (SQLException ex) {
            Logger.getLogger(ShowBooksCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("orders", orders);
        page = ConfigurationManager.getProperty("path.page.admin.orders");

        return page;
    }
}
