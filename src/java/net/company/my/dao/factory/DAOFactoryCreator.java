package net.company.my.dao.factory;

/**
 *
 * @author Kostya
 */
public class DAOFactoryCreator {

    private DAOFactoryCreator() {

    }

    public static AbstractDAOFactory getFactory(String database) {
        DatabaseType dbType = DatabaseType.valueOf(database.toUpperCase());
        switch (dbType) {
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}
