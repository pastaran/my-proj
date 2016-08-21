package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Book;
import net.company.my.logic.AdminLogic;
import net.company.my.logic.CommonLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class DeleteBookCommand implements ActionCommand {

    private static final String PARAM_NAME_BOOK_ID = "bookId";
    static final Logger LOGGER = Logger.getLogger(DeleteBookCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int bookId = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_ID));
        List<Book> books = new ArrayList<>();

        try {
            AdminLogic.deleteBook(bookId);
        } catch (SQLException e) {
            LOGGER.error("Cannot delete book", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        try {
            books = CommonLogic.showBooks();
        } catch (SQLException e) {
            LOGGER.error("Cannot retrieve books", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.admin.books");
        request.setAttribute("books", books);

        return page;
    }
}
