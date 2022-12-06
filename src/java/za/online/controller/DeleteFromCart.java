/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.online.bean.Category;
import za.online.bean.OrderLineItem;
import za.online.bean.Product;
import za.online.dao.impl.CategoryDAOImpl;
import za.online.service.impl.OrderLineItemServiceImpl;
import za.online.service.impl.ProductServiceImpl;

/**
 *
 * @author TRAIN 96
 */
@WebServlet(name = "DeleteFromCart", urlPatterns = {"/DeleteFromCart"})
public class DeleteFromCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        OrderLineItemServiceImpl olit = new OrderLineItemServiceImpl();
        List<OrderLineItem> myCart = (ArrayList<OrderLineItem>) session.getAttribute("OrderLineItem");
        List<OrderLineItem> myCart1 = new ArrayList<>();
        int id = 0;
        String ids = request.getParameter("id");
        if (ids != null) {
            id = Integer.parseInt(ids);
        } else {
            id = 0;
        }

        Product product = new Product();
        ProductServiceImpl psi = new ProductServiceImpl();
        product = psi.viewOneProduct(id);
        String action1 = request.getParameter("action");
        try (PrintWriter out = response.getWriter()) {
            String errorMsg = null;
            myCart1 = myCart;

            if ("add".equals(action1)) {
                if (olit.increaseQuantity(id, myCart1) == true) {
                    session.setAttribute("OrderLineItem", myCart1);
                    response.sendRedirect("cart.jsp");
                } else {
//                     request.setAttribute("error", "INVALID CREDENTIALS");
//                RequestDispatcher re = request.getRequestDispatcher("login.jsp");
//                re.include(request, response);
                    errorMsg = "sorry out of stock";
                    session.setAttribute("OrderLineItem", myCart1);
                    session.setAttribute("errors", errorMsg);
                    response.sendRedirect("cart.jsp");
                }
            }
            if ("sub".equals(action1)) {
                id = Integer.parseInt(request.getParameter("id"));
                olit.decreaseQuantity(id, myCart1);
                session.setAttribute("OrderLineItem", myCart1);
                response.sendRedirect("cart.jsp");
            }

            if (action1.equals("delete")) {
                id = Integer.parseInt(request.getParameter("id"));
                myCart1 = olit.removeProductFromCart(id, myCart);
                session.setAttribute("OrderLineItem", myCart1);
                response.sendRedirect("cart.jsp");
            }
            if (action1.equals("deleteAll")) {
                myCart1 = olit.removeAllProduct(myCart1);
                if (myCart1.isEmpty()) {
                    session.setAttribute("OrderLineItem", myCart1);
                    response.sendRedirect("cart.jsp");
                }
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
        // processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
