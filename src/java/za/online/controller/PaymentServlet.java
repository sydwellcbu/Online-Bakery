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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.online.bean.CardPayment;
import za.online.bean.Customer;
import za.online.bean.Order;
import za.online.bean.OrderLineItem;
import za.online.bean.Payment;
import za.online.email.Email;
import za.online.enums.PaymentStatus;
import za.online.service.CardPaymentService;
import za.online.service.OrderService;
import za.online.service.PaymentService;
import za.online.service.impl.CardPaymentServiceImpl;
import za.online.service.impl.OrderServiceImpl;
import za.online.service.impl.PaymentServiceImpl;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Payment", urlPatterns = {"/payments"})
public class PaymentServlet extends HttpServlet {

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
        Email sendEmail = new Email();
        Customer customer = new Customer();
        List<OrderLineItem> cart = new ArrayList<>();
        HttpSession session = request.getSession();
        customer = (Customer) session.getAttribute("UserSession");
        cart = (List<OrderLineItem>) session.getAttribute("OrderLineItem");
        String paymentStatus = PaymentStatus.DECLINE.toString();
        String  deliver= null;
        String deliveryAddress = request.getParameter("address");
        String cvv = request.getParameter("cvv");
        PaymentService paymentServ = new PaymentServiceImpl();
        OrderService os = new OrderServiceImpl();
        Payment pay = new Payment();
        Order order = new Order();
        if(deliveryAddress != null){
        deliver = deliveryAddress.trim();
        customer.setAddress(deliver);
        }else{
        deliveryAddress = deliver;
        }
        String payMethod = request.getParameter("pay");
        if (payMethod.equalsIgnoreCase("Pay With Card")) {
            payMethod = "Card";
        } else if (payMethod.equalsIgnoreCase("Pay With Cash")) {
            payMethod = "Cash";
        } else {
            payMethod = null;
        }
        pay.setPaymentMethod(payMethod.trim());
        try (PrintWriter out = response.getWriter()) {
            CardPayment cardPayment = new CardPayment();
            if (pay.getPaymentMethod().equals("Card")) {
                cardPayment.setBankName((request.getParameter("cardname")));
                cardPayment.setCardExpeiryDate(Integer.parseInt(request.getParameter("expyear")));
                cardPayment.setCustomerId(customer.getCustomerId());
                cardPayment.setCardNumber(Integer.parseInt(request.getParameter("cardnumber")));
                cvv = request.getParameter("cvv");
                if (cvv != null) {
                    cvv = cvv.trim();
                    if (!cvv.isEmpty()) {
                        int cvvInt = 0;
                        try {
                            cvvInt = Integer.parseInt(cvv);
                        } catch (NumberFormatException nfe) {
                            System.out.println("" + nfe.getMessage());
                        }
                        cardPayment.setCardSecurityCode(cvvInt);
                    } else {
                        out.print("cvv is empty\n");
                    }
                } else {
                    out.print("invalid!\n");
                }

                if (((order = os.createAnOrder(cart, cardPayment, pay, customer.getCustomerId())) != null) && paymentServ.validateCard(cardPayment)) {
                    session.setAttribute("order", order);
                    paymentStatus = PaymentStatus.APPROVED.toString();
                    sendEmail.sendEmeail(customer.getEmail(), "hi",cart,customer,order);
                    session.setAttribute("payStatus", paymentStatus);
                    session.setAttribute("OrderLineItem", cart);
                    response.sendRedirect("placedOrder.jsp");
                } else {
                    paymentStatus = PaymentStatus.DECLINE.toString();
                    session.setAttribute("payStatus", paymentStatus);
                    session.setAttribute("OrderLineItem", cart);
                    response.sendRedirect("placedOrder.jsp");
                }

            } else if (pay.getPaymentMethod().equals("Cash")) {
                if ((order = os.createAnOrder(cart, cardPayment, pay, customer.getCustomerId())) != null) {
                    session.setAttribute("order", order);
                    sendEmail.sendEmeail(customer.getEmail(), "hi",cart,customer,order);
                    paymentStatus = PaymentStatus.APPROVED.toString();
                    session.setAttribute("payStatus", paymentStatus);
                    session.setAttribute("OrderLineItem", cart);
                    response.sendRedirect("placedOrder.jsp");
                } else {
                    paymentStatus = PaymentStatus.DECLINE.toString();
                    session.setAttribute("payStatus", paymentStatus);
                    session.setAttribute("OrderLineItem", cart);
                    response.sendRedirect("placedOrder.jsp");
                }
            } else {
                out.print("Invalid Payment Method");

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
