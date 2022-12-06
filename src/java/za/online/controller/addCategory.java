package za.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "addCategory", urlPatterns = {"/addCategory"})
public class addCategory extends HttpServlet {

    Category category = new Category();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {


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
        PrintWriter out = response.getWriter();

        try{
        
            String catName = request.getParameter("Category_name");
            String catPic = request.getParameter("Category_pic");
            CategoryService catService = new CategoryServiceImpl();

            category.setCategoryName(catName);
            category.setCategoryPic(catPic);
            catService.addCategory(category);
            RequestDispatcher view = request.getRequestDispatcher("displayCategory.jsp");
            view.forward(request, response);
        }finally{
        
        out.close();
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
