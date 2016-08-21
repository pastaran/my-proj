package net.company.my.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Author;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class GoUpdateAuthorCommand implements ActionCommand {

    private static final String PARAM_NAME_AUTHOR_ID = "authorId";
    static final Logger LOGGER = Logger.getLogger(GoUpdateAuthorCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int authorId = Integer.parseInt(request.getParameter(PARAM_NAME_AUTHOR_ID));
        Author author = null;

        try {
            author = AdminLogic.goUpdateAuthor(authorId);
        } catch (SQLException e) {
            LOGGER.error("Cannot go update author", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.admin.update.author");
        request.setAttribute("author", author);

        return page;
    }
}
