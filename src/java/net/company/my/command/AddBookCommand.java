package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Author;
import net.company.my.bean.Book;
import net.company.my.logic.AdminLogic;
import net.company.my.logic.CommonLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class AddBookCommand implements ActionCommand {

    private static final String PARAM_NAME_BOOK_TITLE = "bookTitle";
    private static final String PARAM_NAME_BOOK_AUTHOR_ID = "authorId";
    private static final String PARAM_NAME_BOOK_YEAR = "bookYear";
    private static final String PARAM_NAME_BOOK_QTY_TOTAL = "bookQtyTotal";
    private static final String PARAM_NAME_BOOK_QTY_AVAILABLE = "bookQtyAvailable";
    static final Logger LOGGER = Logger.getLogger(AddBookCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String bookTitle = request.getParameter(PARAM_NAME_BOOK_TITLE);
        int bookYear = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_YEAR));
        int qtyTotal = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_QTY_TOTAL));
        int qtyAvailable = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_QTY_AVAILABLE));
        int authorId = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_AUTHOR_ID));
        Author author = null;
        List<Book> books = new ArrayList<>();

        try {
            author = AdminLogic.findAuthorById(authorId);
        } catch (SQLException e) {
            LOGGER.error("Cannot find author", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        try {
            AdminLogic.addBook(bookTitle, author, bookYear, qtyTotal, qtyAvailable);
        } catch (SQLException e) {
            LOGGER.error("Cannot add book", e);
            return ConfigurationManager.getProperty("path.page.error");

        }

        try {
            books = CommonLogic.showBooks();
        } catch (SQLException e) {
            LOGGER.error("Cannot get books", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.admin.books");
        request.setAttribute("books", books);

        return page;
    }
}
