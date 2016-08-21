package net.company.my.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import net.company.my.logic.RegisterLogic;
import net.company.my.resource.ConfigurationManager;
import net.company.my.resource.MessageManager;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class RegisterCommand implements ActionCommand {

    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_PASSWORD = "password";
    static final Logger LOGGER = Logger.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String userName = null;

        String name = request.getParameter(PARAM_NAME_NAME);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String password = request.getParameter(PARAM_NAME_PASSWORD);

        try {
            userName = RegisterLogic.register(name, email, password);
        } catch (SQLException e) {
            LOGGER.error("Cannot register user", e);
            return ConfigurationManager.getProperty("path.page.error");
        } catch (Exception e) {
            request.setAttribute("errorRegisterMessage",
                    MessageManager.getProperty("message.regerror"));
            return ConfigurationManager.getProperty("path.page.register");
        }

        page = ConfigurationManager.getProperty("path.page.reg.success");
        request.setAttribute("userName", userName);

        return page;
    }
}
