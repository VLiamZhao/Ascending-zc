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
  private long employee_id;

  public Account() {}

  public Account(String account_type, BigDecimal balance, long emloyee_id) {
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

  public long getEmployee_id() {
    return employee_id;
  }

  public void setEmployee_id(long employee_id) {
    this.employee_id = employee_id;
  }
}
