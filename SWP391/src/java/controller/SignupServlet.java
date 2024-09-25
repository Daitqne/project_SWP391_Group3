/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import model.Customer;

/**
 *
 * @author DUC MINH
 */
public class SignupServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String firstName = request.getParameter("Firstname");
        String lastName = request.getParameter("Lastname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("phone");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        // Kiểm tra tính hợp lệ của mật khẩu
        if (!password.matches(passwordPattern)) {
            request.setAttribute("notification", "Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Kiểm tra mật khẩu và nhập lại mật khẩu
        if (!password.equals(repassword)) {
            request.setAttribute("notification", "Mật khẩu không khớp!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Tạo đối tượng Customer với ngày tạo và ngày cập nhật
        Date now = new Date();
        Customer cus = new Customer(0, 0, firstName, lastName, mobile, email, "", now, now, null);

        // Đăng ký tài khoản qua DAO
        CustomerDAO dao = new CustomerDAO();
        boolean result = dao.registerAccount(cus);

        if (result) {
            // Đăng ký thành công, chuyển hướng tới trang đăng nhập
            response.sendRedirect("login");
        } else {
            // Đăng ký thất bại, gửi thông báo lỗi
            request.setAttribute("notification", "Đăng ký không thành công!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
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
