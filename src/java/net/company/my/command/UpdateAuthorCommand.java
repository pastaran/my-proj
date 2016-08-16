package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.Author;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;

/**
 *
 * @author Kostya
 */
public class UpdateAuthorCommand implements ActionCommand {

    private static final String PARAM_NAME_AUTHOR_ID = "authorId";
    private static final String PARAM_NAME_AUTHOR_NAME = "authorName";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int authorId = Integer.parseInt(request.getParameter(PARAM_NAME_AUTHOR_ID));
        String authorName = request.getParameter(PARAM_NAME_AUTHOR_NAME);
        List<Author> authors = new ArrayList<Author>();

        try {
            AdminLogic.updateAuthor(authorId, authorName);
            authors = AdminLogic.showAuthors();
        } catch (SQLException e) {

        }

        page = ConfigurationManager.getProperty("path.page.admin.authors");
        request.setAttribute("authors", authors);

        return page;
    }
}
