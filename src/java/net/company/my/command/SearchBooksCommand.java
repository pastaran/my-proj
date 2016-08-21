package net.company.my.command;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Book;
import net.company.my.logic.MainLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class SearchBooksCommand implements ActionCommand {

    private static final String PARAM_NAME_TITLE = "title";
    static final Logger LOGGER = Logger.getLogger(SearchBooksCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Book> books = null;

        String title = request.getParameter(PARAM_NAME_TITLE);

        try {
            books = MainLogic.searchBooks(title);
        } catch (SQLException e) {
            LOGGER.error("Cannot do search", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.main.search");
        request.setAttribute("books", books);

        return page;
    }
}
