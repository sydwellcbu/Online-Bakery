/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.online.bean.Customer;
import za.online.dao.AccountDAO;
import za.online.dao.impl.AccountDAOImpl;

/**
 *
 * @author Aubrey
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    AccountDAO register = new AccountDAOImpl();
    Customer customer = new Customer();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            session.getId();

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Customer result = register.Login(email, password);
            if (!result.getEmail().equals(email) && !result.getPassword().equals(password)) {
                request.setAttribute("error", "INVALID CREDENTIALS");
                RequestDispatcher re = request.getRequestDispatcher("login.jsp");
                re.include(request, response);
            } else if (result.getEmail().equals(email) && result.getPassword().equals(password)) {
                if (result.isIsAdmin() == false) {
                    //  session.setMaxInactiveInterval(100);
                    session.setAttribute("UserSession", result);
                    RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                    view.forward(request, response);
                }
                if (result.isIsAdmin() == true) {
                    //session.setMaxInactiveInterval(100);
                    session.setAttribute("adminSession", result);
                    RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
                    view.forward(request, response);

                }
            } else {
                request.setAttribute("error", "INVALID CREDENTIALS");
                RequestDispatcher re = request.getRequestDispatcher("login.jsp");
                re.include(request, response);

            }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
                                           