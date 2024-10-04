/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.IEmployee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author DUC MINH
 */
public class EmployeeDAO extends DBContext implements IEmployee{

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setPhone(rs.getString("phone"));
                emp.setEmail(rs.getString("email"));
                emp.setDepartmentId(rs.getInt("department_id"));
                employees.add(emp);
            }
        } catch (SQLException ex) {
            System.out.println("ex");
        }
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employee (user_id, first_name, last_name, phone, email, department_id) VALUES (?, ?, ?, ?, ?, ?)";
        try  {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, employee.getUserId());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getLastName());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getEmail());
            stmt.setInt(6, employee.getDepartmentId());
            stmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("e");
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        String query = "UPDATE Employee SET first_name = ?, last_name = ?, phone = ?, email = ?, department_id = ? WHERE employee_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getPhone());
            stmt.setString(4, employee.getEmail());
            stmt.setInt(5, employee.getDepartmentId());
            stmt.setInt(6, employee.getEmployeeId());
            stmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("e");
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String query = "DELETE FROM Employee WHERE employee_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("e");
        }
    }
    public static void main(String[] args) {
        // Tạo đối tượng EmployeeDAO
        EmployeeDAO employeeDAO = new EmployeeDAO();
        
        // Gọi phương thức getAllEmployees() để lấy danh sách nhân viên
        List<Employee> employees = employeeDAO.getAllEmployees();
        
        // In danh sách nhân viên ra màn hình
        if (employees != null && !employees.isEmpty()) {
            for (Employee emp : employees) {
                System.out.println("ID: " + emp.getEmployeeId());
                System.out.println("First Name: " + emp.getFirstName());
                System.out.println("Last Name: " + emp.getLastName());
                System.out.println("Phone: " + emp.getPhone());
                System.out.println("Email: " + emp.getEmail());
                System.out.println("Department ID: " + emp.getDepartmentId());
                System.out.println("-------------------------------");
            }
        } else {
            System.out.println("No employees found.");
        }
    }
}
