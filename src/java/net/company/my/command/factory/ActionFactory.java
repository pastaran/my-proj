package net.company.my.command.factory;

import javax.servlet.http.HttpServletRequest;
import net.company.my.client.CommandEnum;
import net.company.my.command.ActionCommand;
import net.company.my.command.EmptyCommand;
import net.company.my.resource.MessageManager;

/**
 *
 * @author Kostya
 */
public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
