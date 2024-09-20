/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.ICatefory_Car;
import java.util.ArrayList;
import java.util.List;
import model.Category_Car;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hieun
 */
public class Category_CarDAO extends DBContext implements ICatefory_Car {

    @Override
    public List<Category_Car> getAllCatefory_Car() {
        ArrayList<Category_Car> list = new ArrayList<>();
        try {
            String sql = "{call Category_Car_getAll}";
            CallableStatement ps=connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category_Car(rs.getInt("category_id"), rs.getString("category_name")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public void AddCategory_Car(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void DeleteCategory_Car(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void UpdateCategory_Car(int id, String newName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args) {
        Category_CarDAO c=new Category_CarDAO();
        List<Category_Car> list=c.getAllCatefory_Car();
        for(Category_Car car:list){
            System.out.println(car.getCategory_name());
        }
    }
}
