/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.IAccount;
import model.Account;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DUC MINH
 */
public class AccountDAO extends DBContext implements IAccount{

    @Override
    public boolean registerAccount(Account account) {
        String sql = "INSERT INTO Accounts (Full_Name, Email, Phone_Number, Password, Gender, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getFull_Name());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getPhone_Number());
            ps.setString(4, account.getPassword());
            ps.setBoolean(5, account.isGender());
            ps.setString(6, account.getStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
