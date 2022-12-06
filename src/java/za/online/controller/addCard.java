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
import javax.servlet.http.HttpSession;
import za.online.bean.CardPayment;
import za.online.service.CardPaymentService;
import za.online.service.impl.CardPaymentServiceImpl;

/**
 *
 * @author Train
 */
@WebServlet(name = "addCard", urlPatterns = {"/addCard"})
public class addCard extends HttpServlet {

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
        CardPaymentService cardPaymentService = new CardPaymentServiceImpl();
        CardPayment cardPay = new CardPayment();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int dd = 0;
        String d = request.getParameter("Id");
        if (d != null) {
            dd = Integer.parseInt(d.trim());
        }
        String d1 = request.getParameter("value");

        int ids = 0;
        String cardCheck = request.getParameter("ids");
        if (cardCheck != null) {
            ids = Integer.parseInt(cardCheck.trim());
        }

        String bool = request.getParameter("valueId");

        try (PrintWriter out = response.getWriter()) {

            if (dd == 1 && bool == null) {
                if (d1.trim().equalsIgnoreCase("false")) {
                    d1 = "true";
                    session.setAttribute("ischecked", d1.trim());
                    response.sendRedirect("paymentMethod.jsp");
                } else {
                    d1 = "false";
                    session.setAttribute("ischecked", d1.trim());
                    response.sendRedirect("paymentMethod.jsp");
                }

            }
            if (bool != null && dd != 1) {
                if (bool.trim().equalsIgnoreCase("false")) {
                    bool = "true";
                    session.setAttribute("ischecked", bool.trim());
                    response.sendRedirect("payment.jsp");
                } else {
                    bool = "false";
                    session.setAttribute("ischecked", bool.trim());
                    response.sendRedirect("payment.jsp");
                }
            }
            if (ids == 3) {
                String cardNum = request.getParameter("cardnumber");
                int cardNumber = Integer.parseInt(cardNum.trim());
                int cvv = Integer.parseInt(request.getParameter("cvv"));
                int month = Integer.parseInt(request.getParameter("expmonth"));
                int year = Integer.parseInt(request.getParameter("expyear"));
                int userId = Integer.parseInt(request.getParameter("userId"));
                String cardName = request.getParameter("cardname");
                cardPay.setBankName(cardName);
                cardPay.setCardExpeiryDate(year);
                cardPay.setCardNumber(cardNumber);
                cardPay.setCardSecurityCode(cvv);
                cardPay.setCustomerId(userId);

                if (cardPaymentService.addCard(cardPay) != null) {
                    session.setAttribute("selectedCard", cardPay);
                    response.sendRedirect("payment.jsp");
                } else {
                    response.sendRedirect("addCard.jsp");
                }
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
