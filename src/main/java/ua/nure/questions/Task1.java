package ua.nure.questions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        List<String> userAnswer = new ArrayList<>();
        try {
            result = connection.createStatement().executeQuery(query);
            while (result.next()){
                userAnswer.add(result.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(userAnswer.size() == 1 && trueAnswers.equals(userAnswer.get(0))){
            return true;
        }
        return false;
    }
}
