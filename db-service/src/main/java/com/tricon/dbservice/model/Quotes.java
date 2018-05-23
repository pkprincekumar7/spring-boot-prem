package com.tricon.dbservice.model;

import java.util.List;

/**
 * Created by premsingh on 2/19/18.
 */
public class Quotes {
    private String userName;
    private List<String> quotes;

    public Quotes() {
    }

    public Quotes(String userName, List<String> quotes) {
        this.userName = userName;
        this.quotes = quotes;
    }

    /**
     * Gets userName.
     * @return Value of userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets new quotes.
     * @param quotes New value of quotes.
     */
    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    /**
     * Sets new userName.
     * @param userName New value of userName.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets quotes.
     * @return Value of quotes.
     */
    public List<String> getQuotes() {
        return quotes;
    }
}
