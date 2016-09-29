package ua.nure.questions;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task1 implements ITask {

    /**
     * Вывести все типы продуктов где maker - "С"
     */

    private static Logger logger = Logger.getLogger(Task1.class);
    private String trueAnswers = "Laptop";

    @Override
    public boolean check(String query, Connection connection) {
        ResultSet result;
        String userAnswer = "";
        try {
            result = connection.createStatement().executeQuery(query);
            while (result.next()){
                userAnswer += result.getString("type");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return userAnswer.length() == trueAnswers.length() && trueAnswers.equals(userAnswer);
    }
}
