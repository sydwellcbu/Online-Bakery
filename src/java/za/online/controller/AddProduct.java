
package za.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.online.bean.Product;
import za.online.dao.impl.ProductDAOImpl;
import za.online.service.CategoryService;
import za.online.service.ProductService;
import za.online.service.impl.CategoryServiceImpl;
import za.online.service.impl.ProductServiceImpl;

/**
 *
 * @author TRAIN 96
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {
    
    ProductDAOImpl pi = new ProductDAOImpl();
    Product product = new Product();
    ProductService productServ = new ProductServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();  
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();  
         
        try {
        
           
         
            String productName = request.getParameter("productName");
            String productDesc = request.getParameter("productDesc");
            boolean active = Boolean.parseBoolean(request.getParameter("active"));

            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String pic = request.getParameter("productPic");
            double price = Double.parseDouble(request.getParameter("price"));
            double discount = Double.parseDouble(request.getParameter("discount"));
            String catParam = request.getParameter("categoryName");
           
            
            int catid  =   pi.getCategoryId(catParam);

            product.setProductName(productName);
            product.setProductDesc(productDesc);
            product.setProductPic(pic);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setDiscount(discount);
            product.setCategoryId(catid);
            product.setActive(active);
               
            boolean success = productServ.addProduct(product);
          
            if(success){
            
           // out.println("Product successfully added");
            response.sendRedirect("displayProducts.jsp");
            }
            else{
            
            out.println("Something went wrong");
           
            }
        }finally{
        
        out.close();
        
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
