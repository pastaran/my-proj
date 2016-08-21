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
public class UpdateBookCommand implements ActionCommand {

    private static final String PARAM_NAME_BOOK_ID = "bookId";
    private static final String PARAM_NAME_BOOK_TITLE = "bookTitle";
    private static final String PARAM_NAME_BOOK_AUTHOR_ID = "authorId";
    private static final String PARAM_NAME_BOOK_YEAR = "bookYear";
    private static final String PARAM_NAME_BOOK_QTY_TOTAL = "bookQtyTotal";
    private static final String PARAM_NAME_BOOK_QTY_AVAILABLE = "bookQtyAvailable";
    static final Logger LOGGER = Logger.getLogger(UpdateBookCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int bookId = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_ID));
        String bookTitle = request.getParameter(PARAM_NAME_BOOK_TITLE);
        int authorId = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_AUTHOR_ID));
        int bookYear = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_YEAR));
        int qtyTotal = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_QTY_TOTAL));
        int qtyAvailable = Integer.parseInt(request.getParameter(PARAM_NAME_BOOK_QTY_AVAILABLE));
        List<Book> books = new ArrayList<>();

        try {
            AdminLogic.updateBook(bookId, bookTitle, authorId, bookYear, qtyTotal, qtyAvailable);
        } catch (SQLException e) {
            LOGGER.error("Cannot update book", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        try {
            books = CommonLogic.showBooks();
        } catch (SQLException e) {
            LOGGER.error("Cannot show books", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.admin.books");
        request.setAttribute("books", books);

        return page;
    }
}
