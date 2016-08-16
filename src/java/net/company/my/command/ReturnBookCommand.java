package net.company.my.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.StatusType;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;

/**
 *
 * @author Kostya
 */
public class ReturnBookCommand implements ActionCommand {

    private static final String PARAM_NAME_ORDER_ID = "orderId";
    private static final String PARAM_NAME_BOOK_ID = "bookId";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int orderId = Integer.parseInt(request.getParameter(PARAM_NAME_ORDER_ID));
        int bookId = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_ID));

        try {
            AdminLogic.returnBook(orderId, StatusType.RETURNED, bookId);
        } catch (SQLException e) {

        }

        page = ConfigurationManager.getProperty("path.page.return.success");

        return page;
    }
}
