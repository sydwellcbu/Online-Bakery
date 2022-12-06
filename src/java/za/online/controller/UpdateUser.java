/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.online.bean.Customer;
import za.online.service.CustomerService;
import za.online.service.impl.CustomerServiceImpl;

/**
 *
 * @author TRAIN 96
 */
@WebServlet(name = "UpdateUser", urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");
           
        Customer customer = new Customer();
        CustomerService service = new CustomerServiceImpl();
     
        
        try (PrintWriter out = response.getWriter()) {
           
            int userId =Integer.parseInt(request.getParameter("CustomerId"));  
            String fistName = request.getParameter("First_name");
             out.println("Upadte his account");
            String lastName = request.getParameter("Last_name");
            String tell = request.getParameter("Contact");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String title = request.getParameter("tittle");
            String password = request.getParameter("psw");
               
            customer.setFirstName(fistName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setTelephone(tell);
            customer.setPassword(password);
            customer.setTittle(title);
            
            
            
          boolean s = true; //service.updateCustomer(userId);
         
          
          if(s){
          out.println(fistName + "Upadtes his account");
          
          }
          else
              out.println("Something went wrrong");
                          
         
         //   response.sendRedirect("Userprofile.jsp");
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }


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
