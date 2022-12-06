package za.online.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.online.bean.Product;
import za.online.dao.impl.ProductDAOImpl;
import za.online.service.ProductService;
import za.online.service.impl.ProductServiceImpl;

@WebServlet(name = "EditProduct", urlPatterns = {"/EditProduct"})
public class EditProduct extends HttpServlet {

    ProductDAOImpl pi = new ProductDAOImpl();
    Product product = new Product();
    ProductService productServ = new ProductServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("productId"));

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
            product.setProductId(id);
            product.setProductDesc(productDesc);
            product.setProductPic(pic);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setDiscount(discount);
            product.setCategoryId(catid);
            product.setActive(active);

            boolean success = productServ.updateProduct(product);
            out.println(success);
            if (success) {
               
                response.sendRedirect("displayProducts.jsp");
               
            } else {
                out.print("Something went wrong ");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
