package com.ascending.training.jdbc;

import com.ascending.training.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    static final String DBURL = "jdbc:postgresql://localhost:5431/mydata";
    static final String USER = "admin";
    static final String PASS = "password";
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            logger.debug("Connecting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            logger.debug("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM account";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String account_type = rs.getString("account_type");
                double  balance = rs.getDouble("balance");
                String create_date = rs.getString("create_date");
                long employee_id = rs.getLong("employee_id");
                //Fill the object
                Account account = new Account();
                account.setId(id);
                account.setAccount_type(account_type);
                account.setBalance(balance);
                account.setCreate_date(create_date);
                account.setEmployee_id(employee_id);
                accounts.add(account);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return accounts;
    }

    public Account saveAccounts(Account input) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            logger.debug("Connecting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            logger.debug("Creating statement...");
            String sql = "INSERT INTO account (account_type, balance, employee_id)" + "VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql, stmt.RETURN_GENERATED_KEYS);
            stmt.setString(1, input.getAccount_type());
            stmt.setDouble(2, input.getBalance());
            stmt.setLong(3, input.getEmployee_id());
            stmt.execute();
            rs = stmt.getGeneratedKeys();
            //STEP 4: Extract data from result set
            if(rs.next()){
                logger.debug("ID before generatedKey: " + input.getId());
                logger.debug("Getting generatedKey: " + rs.getLong("id"));
                long generatedKey = rs.getLong("id");
                input.setId(generatedKey);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null)stmt.close();
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();
                logger.debug("Database connection closed");
            }
            catch (SQLException se){
                se.printStackTrace();
            }
        }
        return input;
    }
    public boolean deleteAccount(long accId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean result = true;
        try {
            //STEP 2: Open a connection
            logger.debug("Connecting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            logger.debug("Creating statement...");
            String sql = "DELETE FROM account WHERE id=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, accId);
            //STEP 4: Delete data from account
            result = stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();
                logger.debug("Database connection closed");
            }
            catch (SQLException se){
                se.printStackTrace();
            }
        }
        return result;
    }
}
