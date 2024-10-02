/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author DUC MINH
 */
public class SignupServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/hondaotog3.com/signup.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        // Kiểm tra tính hợp lệ của mật khẩu
        if (!password.matches(passwordPattern)) {
            request.setAttribute("notification", "Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt.");
            request.getRequestDispatcher("/hondaotog3.com/signup.jsp").forward(request, response);
            return;
        }

        // Kiểm tra mật khẩu và nhập lại mật khẩu
        if (!password.equals(repassword)) {
            request.setAttribute("notification", "Mật khẩu không khớp!");
            request.getRequestDispatcher("/hondaotog3.com/signup.jsp").forward(request, response);
            return;
        }
        User user = new User(0, userName, password, phone, 0, email, phone);

        // Đăng ký tài khoản qua DAO
        UserDAO dao = new UserDAO();
        boolean result = dao.registerAccount(user);

        if (result) {
            // Đăng ký thành công, chuyển hướng tới trang đăng nhập
            //response.sendRedirect("login");
            request.getRequestDispatcher("/hondaotog3.com/index.jsp").forward(request, response);
        } else {
            // Đăng ký thất bại, gửi thông báo lỗi
            request.setAttribute("notification", "Đăng ký không thành công!");
            request.getRequestDispatcher("/hondaotog3.com/signup.jsp").forward(request, response);
        }
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
