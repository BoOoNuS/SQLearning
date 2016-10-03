package ua.nure.questions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Стас on 21.09.2016.
 */
public abstract class AbstractTask {

    protected String userAnswer = "";
    protected ResultSet result;

    public abstract boolean check(String query, Connection connection) throws SQLException;

}
