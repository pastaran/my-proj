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
public class AddAuthorCommand implements ActionCommand {

    private static final String PARAM_NAME_AUTHOR_NAME = "authorName";
    static final Logger LOGGER = Logger.getLogger(AddAuthorCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String authorName = request.getParameter(PARAM_NAME_AUTHOR_NAME);
        List<Author> authors = new ArrayList<Author>();

        try {
            AdminLogic.addAuthor(authorName);
        } catch (SQLException e) {
            LOGGER.error("Cannot add author", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

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
