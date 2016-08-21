package net.company.my.dao.factory;

/**
 *
 * @author Kostya
 */
public class DAOFactoryCreator {

    private static AbstractDAOFactory factory = null;

    private DAOFactoryCreator() {

    }

    public static AbstractDAOFactory getFactory() {
        return factory;
    }

    public static void initFactory(String database) {
        DatabaseType dbType = DatabaseType.valueOf(database.toUpperCase());

        switch (dbType) {
            case MYSQL:
                factory = new MySQLDAOFactory();
                break;
            default:
                throw new RuntimeException("Unknown database");
        }
    }
}
