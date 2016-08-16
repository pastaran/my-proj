package net.company.my.command;

import javax.servlet.http.HttpServletRequest;
import net.company.my.resource.ConfigurationManager;

/**
 *
 * @author Kostya
 */
public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
