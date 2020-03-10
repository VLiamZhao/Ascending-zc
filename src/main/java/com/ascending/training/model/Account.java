package com.ascending.training.model;

public class Account {
  private long id;
  private String account_type;
  private double balance;
  private String create_date;
  private long emloyee_id;

    public Account() {
    }

    public Account(String account_type, double balance, String create_date, long emloyee_id) {
        this.account_type = account_type;
        this.balance = balance;
        this.create_date = create_date;
        this.emloyee_id = emloyee_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public long getEmloyee_id() {
        return emloyee_id;
    }

    public void setEmloyee_id(long emloyee_id) {
        this.emloyee_id = emloyee_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
