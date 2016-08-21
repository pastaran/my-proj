package net.company.my.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.User;
import net.company.my.logic.AdminLogic;
import net.company.my.resource.ConfigurationManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class ShowReadersCommand implements ActionCommand {

    static final Logger LOGGER = Logger.getLogger(ShowReadersCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<User> readers = new ArrayList<>();

        try {
            readers = AdminLogic.showReaders();
        } catch (SQLException e) {
            LOGGER.error("Cannot show readers", e);
            return ConfigurationManager.getProperty("path.page.error");
        }

        page = ConfigurationManager.getProperty("path.page.admin.readers");
        request.setAttribute("readers", readers);

        return page;
    }
}
