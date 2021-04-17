package pl.lisowski.newsstack.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProvider {
    private static DataSource dataSource;

    private DataSourceProvider() { }

    public static DataSource getDataSource() throws NamingException {  // pobieranie obiektu DataSource z pulą połączeń z kontekstu aplikacji
        if (dataSource == null) {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env/"); //zasoby skonfigurowane w context.xml umieszane są w dedykowanej przestrzeni java:comp/env/
            dataSource = (DataSource) envContext.lookup("jdbc/newsstack");
        }
        return dataSource;
    }
}
