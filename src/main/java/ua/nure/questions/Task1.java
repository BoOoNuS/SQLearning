package ua.nure.questions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Стас on 21.09.2016.
 */
public class Task1 implements ITask {

    /**
     * Вывести все типы продуктов где maker - "С"
     */

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
            e.printStackTrace();
        }
        return userAnswer.length() == trueAnswers.length() && trueAnswers.equals(userAnswer);
    }
}
