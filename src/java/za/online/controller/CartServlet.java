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
import za.online.bean.OrderLineItem;
import za.online.bean.Product;
import za.online.service.impl.OrderLineItemServiceImpl;
import za.online.service.impl.ProductServiceImpl;

/**
 *
 * @author TRAIN 96
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //New cart
            OrderLineItemServiceImpl olit = new OrderLineItemServiceImpl();
            List<OrderLineItem> cart = new ArrayList<>();
            int productId = 0;
            productId = Integer.parseInt(request.getParameter("productId"));
            Product product = new Product();
            ProductServiceImpl psi = new ProductServiceImpl();
            boolean productExist = false;
            String errorMsg = "";
            HttpSession session = request.getSession();
            //Cart from JSP
            List<OrderLineItem> cartList = new ArrayList<>();
            cartList = (ArrayList<OrderLineItem>) session.getAttribute("OrderLineItem");
            product = psi.viewOneProduct(productId);

            int sixe = 0;

            if (cartList == null) {
                cart.add(olit.addProductToCart(productId));
                session.setAttribute("OrderLineItem", cart);
                RequestDispatcher re = request.getRequestDispatcher("cart.jsp");
                re.include(request, response);
                response.sendRedirect("cart.jsp");

            } else {
                cart = cartList;
                int qty = 0;
                boolean exixt = false;
                OrderLineItem oli1 = new OrderLineItem();
                for (OrderLineItem oli : cart) {

                    if (oli.getProductId() == productId) {
                        oli1 = oli;
                        exixt = true;
                    }
                    sixe++;
                }

                if (cart.size() == sixe) {
                    //   oli1.setQuantity(5);
                    if (exixt == true) {
                        if (product.getQuantity() > oli1.getQuantity()) {
                            for (OrderLineItem oli : cart) {
                                if (oli.getProductId() == oli1.getProductId()) {
                                    oli.setQuantity(oli1.getQuantity() + 1);
                                    session.setAttribute("OrderLineItem", cart);
                                    RequestDispatcher re = request.getRequestDispatcher("cart.jsp");
                                    re.include(request, response);
//                                response.sendRedirect("cart.jsp");
                                    //out.print("does exist add quantity " + oli1.getQuantity());
                                } else {
                                    out.print("can't find product Id match and it's does exist");
                                }
                            }
                        } else {
                            session.setAttribute("product", oli1);

                            errorMsg = "sorry out of stock";
                            session.setAttribute("OrderLineItem", cart);
                            request.setAttribute("errors", errorMsg);
                            RequestDispatcher re = request.getRequestDispatcher("cart.jsp");
                            re.include(request, response);
                            // response.sendRedirect("cart.jsp");
                            // out.print("does exist product of stock " + productId);
                        }

                    } else {

                        if (product.getQuantity() > qty) {
                            cart.add(olit.addProductToCart(productId));
                            session.setAttribute("OrderLineItem", cart);
                            RequestDispatcher re = request.getRequestDispatcher("cart.jsp");
                            re.include(request, response);
                            //  response.sendRedirect("cart.jsp");
                            // out.print("does not exist ,add quantity " + productId);
                        } else {
                            session.setAttribute("product", oli1);
                            errorMsg = "sorry out of stock";
                            session.setAttribute("OrderLineItem", cart);
                            request.setAttribute("errors", errorMsg);
                            RequestDispatcher re = request.getRequestDispatcher("cart.jsp");
                            re.include(request, response);
                            // response.sendRedirect("cart.jsp");
                            //  out.print("does not exist product out of stock " + productId);

                        }
                    }
                } else {
                    out.print("Array sise does = to sixe");
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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
