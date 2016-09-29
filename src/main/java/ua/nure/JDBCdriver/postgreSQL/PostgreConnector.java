package ua.nure.JDBCdriver.postgreSQL;

import org.apache.log4j.Logger;
import ua.nure.questions.ITask;
import ua.nure.springMVC.model.UserQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PostgreConnector {

    private static Logger logger = Logger.getLogger(PostgreConnector.class);
    private static Map<String, Connection> postgreConnections = new HashMap<>();
    private String dbName;

    public PostgreConnector(String dbName) {
        this.dbName = dbName;
    }

    public static PostgreConnector connect(String hostName, int port, String dbName, String userName, String password) {
        if(postgreConnections.get(dbName) == null) {
            synchronized (PostgreConnector.class) {
                if(postgreConnections.get(dbName) == null) {
                    Connection connection = null;
                    try {
                        Class.forName("org.postgresql.Driver");
                        connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s",
                                hostName, port,
                                dbName), userName, password);
                    } catch (SQLException e) {
                        logger.error(e.getMessage());
                    } catch (ClassNotFoundException e) {
                        logger.error(e.getMessage());
                    }
                    postgreConnections.put(dbName, connection);
                    return new PostgreConnector(dbName);
                }
            }
        }
        return new PostgreConnector(dbName);
    }

    public boolean checkQuery(UserQuery query, ITask task){
        return task.check(query.getQuery(), postgreConnections.get(dbName));
    }
}
