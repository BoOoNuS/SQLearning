package ua.nure.springMVC.models;

import org.springframework.stereotype.Component;

@Component
public class UserQuery {

    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
