package com.ascending.training.model;

public class Account {
  private long id;
  private String account_type;
  private double balance;
  private String create_date;
  private long employee_id;

    public Account() {
    }

    public Account(String account_type, double balance, long emloyee_id) {
        this.account_type = account_type;
        this.balance = balance;
        this.employee_id = emloyee_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }
}
