package ua.nure.questions;

import java.sql.Connection;
import java.sql.SQLException;

public class Task1 extends AbstractTask {

    /**
     * Вывести все типы продуктов где maker - "С"
     */

    private String trueAnswers = "Laptop";

    @Override
    public boolean check(String query, Connection connection) throws SQLException {
        super.result = connection.createStatement().executeQuery(query);
        while (result.next()) {
            super.userAnswer += super.result.getString("type");
        }
        return super.userAnswer.length() == trueAnswers.length() && trueAnswers.equals(super.userAnswer);
    }
}
