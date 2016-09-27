package ua.nure.questions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Стас on 27.09.2016.
 */
public class Task2 implements ITask{

    /**
     * Найдите все записи таблицы Printer для цветных принтеров
     */

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
            e.printStackTrace();
        }
        return userAnswer.length() == trueAnswers.length() && trueAnswers.equals(userAnswer);
    }

}
