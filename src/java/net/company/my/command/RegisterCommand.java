package net.company.my.command;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import net.company.my.logic.RegisterLogic;
import net.company.my.resource.ConfigurationManager;
import net.company.my.resource.MessageManager;

/**
 *
 * @author Kostya
 */
public class RegisterCommand implements ActionCommand {

    private static final String PARAM_NAME_NAME = "name";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String userName = null;

        String name = request.getParameter(PARAM_NAME_NAME);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String password = request.getParameter(PARAM_NAME_PASSWORD);

        try {
            userName = RegisterLogic.register(name, email, password);
            request.setAttribute("userName", userName);
            page = ConfigurationManager.getProperty("path.page.reg.success");
        } catch (SQLException e) {
            return ConfigurationManager.getProperty("path.page.error");
        } catch (Exception e) {
            request.setAttribute("errorRegisterMessage",
                    MessageManager.getProperty("message.regerror"));
            return ConfigurationManager.getProperty("path.page.register");
        }

        return page;
    }
}
