package com.ascending.training.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "account")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "account_type")
  private String account_type;

  @Column(name = "balance")
  private BigDecimal balance;

  @Column(name = "create_date")
  private LocalDate create_date;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  public Account() {}

  public Account(String account_type, BigDecimal balance) {
    this.account_type = account_type;
    this.balance = balance;
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

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public LocalDate getCreate_date() {
    return create_date;
  }

  public void setCreate_date(LocalDate create_date) {
    this.create_date = create_date;
  }

  public Employee getEmployee() {
    return employee;
  }
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
