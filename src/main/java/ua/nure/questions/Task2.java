package ua.nure.questions;

import java.sql.Connection;
import java.sql.SQLException;

public class Task2 extends AbstractTask {

    /**
     * Найдите все записи таблицы Printer для цветных принтеров
     */

    private String trueAnswers = "31434yJet29000021433yJet270000";

    @Override
    public boolean check(String query, Connection connection) throws SQLException {
        super.result = connection.createStatement().executeQuery(query);
        while (result.next()) {
            super.userAnswer += super.result.getString("code");
            super.userAnswer += super.result.getString("model");
            super.userAnswer += super.result.getString("color");
            super.userAnswer += super.result.getString("type");
            super.userAnswer += super.result.getString("price");
        }
        return super.userAnswer.length() == trueAnswers.length() && trueAnswers.equals(super.userAnswer);
    }

}
