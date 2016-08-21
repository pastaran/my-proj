package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Author;
import net.company.my.bean.Book;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class GoUpdateBookCommand implements ActionCommand {

    private static final String PARAM_NAME_BOOK_ID = "bookId";
    static final Logger LOGGER = Logger.getLogger(GoUpdateBookCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int bookId = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_ID));
        Book book = null;
        List<Author> authors = new ArrayList<>();

        try {
            book = AdminLogic.goUpdateBook(bookId);
        } catch (SQLException e) {
            LOGGER.error("Cannot go update book", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        try {
            authors = AdminLogic.showAuthors();
        } catch (SQLException e) {
            LOGGER.error("Cannot show authors", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        Author authorSelected = book.getAuthor();
        authors.remove(authorSelected);

        page = ConfigurationManager.getProperty("path.page.admin.update.book");
        request.setAttribute("book", book);
        request.setAttribute("authors", authors);

        return page;
    }
}
