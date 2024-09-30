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
public class CustomerDAO extends DBContext implements ICustomer {

    @Override
    public boolean registerAccount(Customer cus) {
        String sql = "BEGIN TRANSACTION;\n"
                + "\n"
                + "-- Insert vào bảng User\n"
                + "INSERT INTO [dbo].[User] (user_name, password)\n"
                + "VALUES ('?', '?');\n"
                + "\n"
                + "-- Lấy User ID vừa được tạo\n"
                + "DECLARE @UserID INT;\n"
                + "SET @UserID = SCOPE_IDENTITY();\n"
                + "\n"
                + "-- Insert vào bảng Customer với chỉ phone và email\n"
                + "INSERT INTO [dbo].[Customer] (user_id, phone, email, created_at)\n"
                + "VALUES (@UserID, '?', '?', GETDATE());\n"
                + "\n"
                + "COMMIT;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cus.getUser_name());
            ps.setString(2, cus.getPassword());
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
