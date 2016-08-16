package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Book;
import net.company.my.bean.UserType;
import net.company.my.logic.CommonLogic;
import net.company.my.resource.ConfigurationManager;

/**
 *
 * @author Kostya
 */
public class ShowBooksCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Book> books = new ArrayList<>();

        try {
            books = CommonLogic.showBooks();
        } catch (SQLException ex) {
            Logger.getLogger(ShowBooksCommand.class.getName()).log(Level.SEVERE, null, ex);
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
