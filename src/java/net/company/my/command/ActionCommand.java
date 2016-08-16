package net.company.my.command;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kostya
 */
public interface ActionCommand {

    String execute(HttpServletRequest request);
}
