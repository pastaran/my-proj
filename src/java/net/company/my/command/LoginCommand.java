package net.company.my.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import net.company.my.bean.User;
import static net.company.my.command.GiveBookCommand.LOGGER;
import net.company.my.logic.LoginLogic;
import net.company.my.resource.ConfigurationManager;
import net.company.my.resource.MessageManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class LoginCommand implements ActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    static final Logger LOGGER = Logger.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        User user = null;

        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        try {
            user = LoginLogic.checkLogin(login, pass);
        } catch (SQLException e) {
            LOGGER.error("Cannot authorize user", e);
            return ConfigurationManager.getProperty("path.page.error");
        } catch (Exception e) {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            return ConfigurationManager.getProperty("path.page.login");
        }

        request.getSession().setAttribute("userName", user.getName());
        request.getSession().setAttribute("userId", user.getId());
        request.getSession().setAttribute("userType", user.getUserType());

        switch (user.getUserType()) {
            case READER:
                page = ConfigurationManager.getProperty("path.page.main");
                break;
            case LIBRARIAN:
                page = ConfigurationManager.getProperty("path.page.admin");
                break;
        }

        return page;
    }
}
