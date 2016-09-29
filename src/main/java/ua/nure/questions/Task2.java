package ua.nure.questions;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task2 implements ITask{

    /**
     * Найдите все записи таблицы Printer для цветных принтеров
     */

    private static Logger logger = Logger.getLogger(Task2.class);
    private String trueAnswers = "21433yJet270 000,00 ?31434yJet290 000,00 ?";

    @Override
    public boolean check(String query, Connection connection) {
        ResultSet result;
        String userAnswer = "";
        try {
            result = connection.createStatement().executeQuery(query);
            while (result.next()){
                userAnswer += result.getString("code");
                userAnswer += result.getString("model");
                userAnswer += result.getString("color");
                userAnswer += result.getString("type");
                userAnswer += result.getString("price");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return userAnswer.length() == trueAnswers.length() && trueAnswers.equals(userAnswer);
    }

}
