/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.online.bean.Customer;
import za.online.dao.AccountDAO;
import za.online.dao.impl.AccountDAOImpl;
import za.online.service.CustomerService;
import za.online.service.impl.CustomerServiceImpl;

/**
 *
 * @author Aubrey
 */
@WebServlet(name = "AddAdmin", urlPatterns = {"/AddAdmin"})
public class AddAdmin extends HttpServlet {

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
            AccountDAOImpl register = new AccountDAOImpl();
            Customer customer = new Customer();
            CustomerService customerServ = new CustomerServiceImpl();
        try ( PrintWriter out = response.getWriter()) {
       String fistName = request.getParameter("First_name");
            String lastName = request.getParameter("Last_name");
            String tell = request.getParameter("Contact");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String title = request.getParameter("tittle");
            String password = request.getParameter("psw");
            String cPas = request.getParameter("psw-repeat");
            
            customer.setFirstName(fistName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setTittle(title);
            customer.setTelephone(tell);
            customer.setPassword(password); 
            customer.setAddress(address);
            
            
           if(password.equals(cPas) && email.contains("@")){
           
           
           register.addAdmin(customer);
           
           if(customer != null){
           response.sendRedirect("login.jsp");
           }
           else{
           out.println(fistName  + " Sorry our system couldn't create your account please try again");
           
           }
           
            } 
            else{
            
            request.setAttribute("error", "Make sure your password Match"  );
            RequestDispatcher re = request.getRequestDispatcher("register.jsp");
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
