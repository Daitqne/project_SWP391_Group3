/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Customer;
import dal.ICustomer;

/**
 *
 * @author DUC MINH
 */
public class CustomerDAO extends DBContext implements ICustomer{

    @Override
    public boolean registerAccount(Customer cus) {
        String sql = "INSERT INTO Customer (first_name, lastname, email, phone) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cus.getFirst_name());
            ps.setString(2, cus.getLast_name());
            ps.setString(3, cus.getEmail());
            ps.setString(4, cus.getPhone());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
