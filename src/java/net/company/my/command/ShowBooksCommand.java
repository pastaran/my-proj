package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Book;
import net.company.my.bean.UserType;
import net.company.my.logic.CommonLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class ShowBooksCommand implements ActionCommand {

    static final Logger LOGGER = Logger.getLogger(ShowBooksCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Book> books = new ArrayList<>();

        try {
            books = CommonLogic.showBooks();
        } catch (SQLException e) {
            LOGGER.error("Cannot retrieve books", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        UserType userType = (UserType) request.getSession().getAttribute("userType");
        switch (userType) {
            case READER:
                page = ConfigurationManager.getProperty("path.page.main.books");
                break;
            case LIBRARIAN:
                page = ConfigurationManager.getProperty("path.page.admin.books");
                break;
        }
        request.setAttribute("books", books);

        return page;
    }
}
