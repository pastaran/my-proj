package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Author;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class ShowAuthorsCommand implements ActionCommand {

    static final Logger LOGGER = Logger.getLogger(ShowAuthorsCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<Author> authors = new ArrayList<>();

        try {
            authors = AdminLogic.showAuthors();
        } catch (SQLException e) {
            LOGGER.error("Cannot show authors", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.admin.authors");
        request.setAttribute("authors", authors);

        return page;
    }
}
