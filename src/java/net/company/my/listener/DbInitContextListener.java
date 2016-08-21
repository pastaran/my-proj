package net.company.my.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import net.company.my.dao.factory.DAOFactoryCreator;

/**
 *
 * @author Kostya
 */
@WebListener
public class DbInitContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String database = sce.getServletContext().getInitParameter("database");
        DAOFactoryCreator.initFactory(database);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener destroyed");
    }
}
