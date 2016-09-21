package ua.nure.questions;

import java.sql.Connection;

/**
 * Created by Стас on 21.09.2016.
 */
public interface ITask {

    boolean check(String query, Connection connection);

}
