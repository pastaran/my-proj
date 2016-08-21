package net.company.my.pool;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 *
 * @author Kostya
 */
public class ConnectionPool {

    private static final String DATASOURCE_NAME = "jdbc/library";
    private static DataSource dataSource;
    static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private ConnectionPool() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("Cannot get a connection", e);
        }
        return connection;
    }
}
