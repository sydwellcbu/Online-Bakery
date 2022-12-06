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
import za.online.bean.Category;
import za.online.service.CategoryService;
import za.online.service.impl.CategoryServiceImpl;

/**
 *
 * @author TRAIN 96
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
              
        try {
            int id = Integer.parseInt(request.getParameter("categoryId"));
            String catName = request.getParameter("Category_name");
             String catPic = request.getParameter("Category_pic");
            boolean active = Boolean.parseBoolean(request.getParameter("active"));
            CategoryService catService = new CategoryServiceImpl();
            Category category = new Category();
            category.setCategoryName(catName);
            category.setActive(active);
            category.setCategoryId(id);
            category.setCategoryPic(catPic);
            boolean success = catService.updateCategory(category);
            if (success) {
               out.println("Successfully Edited" + catName);
              response.sendRedirect("displayCategory.jsp");
            
            } else {
                out.print("Something went wrong");
              //response.sendRedirect("editCategory.jsp");
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
