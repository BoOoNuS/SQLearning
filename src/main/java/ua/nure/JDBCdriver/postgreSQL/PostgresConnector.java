package ua.nure.JDBCdriver.postgreSQL;

import org.apache.log4j.Logger;
import ua.nure.questions.AbstractTask;
import ua.nure.springMVC.models.UserQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PostgresConnector {

    public static final String ORG_POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private static Logger logger = Logger.getLogger(PostgresConnector.class);
    private static Map<String, Connection> postgreConnections = new HashMap<>();
    private String dbName;

    private PostgresConnector(String dbName) {
        this.dbName = dbName;
    }

    public static PostgresConnector connect(String hostName, int port, String dbName, String userName, String password) {
        if(postgreConnections.get(dbName) == null) {
            synchronized (PostgresConnector.class) {
                if(postgreConnections.get(dbName) == null) {
                    Connection connection = null;
                    try {
                        Class.forName(ORG_POSTGRESQL_DRIVER);
                        connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s",
                                hostName, port,
                                dbName), userName, password);
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                    } catch (ClassNotFoundException e) {
                        logger.error(e.getMessage());
                    }
                    postgreConnections.put(dbName, connection);
                    return new PostgresConnector(dbName);
                }
            }
        }
        return new PostgresConnector(dbName);
    }

    public boolean checkQuery(UserQuery query, AbstractTask task){
        boolean answer = false;
        try {
            answer = task.check(query.getQuery(), postgreConnections.get(dbName));
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return answer;
    }
}
