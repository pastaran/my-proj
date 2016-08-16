package net.company.my.command;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Book;
import net.company.my.logic.MainLogic;
import net.company.my.resource.ConfigurationManager;

/**
 *
 * @author Kostya
 */
public class SearchBooksCommand implements ActionCommand {

    private static final String PARAM_NAME_TITLE = "title";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Book> books = null;

        String title = request.getParameter(PARAM_NAME_TITLE);

        try {
            books = MainLogic.searchBooks(title);
            request.setAttribute("books", books);
            page = ConfigurationManager.getProperty("path.page.main.search");
        } catch (SQLException e) {
            return ConfigurationManager.getProperty("path.page.error");
        }

        return page;
    }
}
