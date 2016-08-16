package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Author;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;

/**
 *
 * @author Kostya
 */
public class ShowAuthorsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Author> authors = new ArrayList<>();

        try {
            authors = AdminLogic.showAuthors();
        } catch (SQLException ex) {
            Logger.getLogger(ShowAuthorsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        page = ConfigurationManager.getProperty("path.page.admin.authors");
        request.setAttribute("authors", authors);

        return page;
    }
}
