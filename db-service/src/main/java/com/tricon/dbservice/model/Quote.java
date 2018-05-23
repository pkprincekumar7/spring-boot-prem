package com.tricon.dbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by premsingh on 2/19/18.
 */
@Entity
@Table(name="Quotes", catalog="test")
public class Quote {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column (name="id")
    private Integer id;

   @Column(name="quote")
    private String quote;

   @Column(name="user_name")
    private String userName;

    public Quote() {
    }

    public Quote(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }

    /**
     * Gets id.
     * @return Value of id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets userName.
     * @return Value of userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets new userName.
     * @param userName New value of userName.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets quote.
     * @return Value of quote.
     */
    public String getQuote() {
        return quote;
    }

    /**
     * Sets new id.
     * @param id New value of id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets new quote.
     * @param quote New value of quote.
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }
}
