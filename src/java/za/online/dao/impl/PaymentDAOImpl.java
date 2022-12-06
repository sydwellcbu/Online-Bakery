/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import za.online.bean.CardPayment;
import za.online.bean.Invoice;
import za.online.bean.Payment;
import za.online.dao.PaymentDAO;
import za.online.db.ConnectToBD;
import za.online.enums.PaymentStatus;

public class PaymentDAOImpl implements PaymentDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public PaymentDAOImpl() {
        con = ConnectToBD.getConnection();
    }

    @Override
    public Payment createPayment(Payment payment) {
        System.out.println("invoice Id is :" + payment.getInvoiceId());
        if (con != null) {
            try {

                ps = con.prepareStatement("Insert into payment(payId,invoiceId,payMethod,payStatus,payDate)  values(null,?,?,?,CURRENT_TIMESTAMP)");
                ps.setInt(1, payment.getInvoiceId());
                ps.setString(2, payment.getPaymentMethod());
                ps.setString(3, payment.getPaymentStatus());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed to Create Payment :" + ex.getMessage());
            }
        }
        return payment;
    }

    @Override
    public boolean deletePayment(int paymentId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from invoice where invoiceId = ?");
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed To Delete invoice From Invoice Table");
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public Payment viewOnePayment(int paymentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Payment> viewAllPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateCard(CardPayment cardPayment) {
        boolean retType = false;
        try {
            if (con != null) {
                ps = con.prepareStatement("select cardNumber,cvv from card where customerId = ?");
                ps.setInt(1, cardPayment.getCustomerId());
                rs = ps.executeQuery();
                while (rs.next()) {
                    if ((cardPayment.getCardNumber() == rs.getInt("cardNumber")) && cardPayment.getCardSecurityCode() == rs.getInt("cvv")) {

                        retType = true;
                    } else {
                        retType = false;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Card Selected Not Found :" + e.getMessage());
        } finally {
            closeIfNotNull();
        }
        return retType;

    }

    private void closeIfNotNull() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Fail To Close Prepared Statement :" + ex.getMessage());
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Fail To Close Results Set :" + ex.getMessage());
            }
        }
    }

    public boolean addCard(CardPayment cardPayment) {
        boolean retType = false;
        try {
            if (con != null) {
                ps = con.prepareStatement("insert into card(customerId,cardNumber,cardSecurityCode,cardExpeiryDate,bankName) values(?,?,?,?,?) ");
                ps.setInt(1, cardPayment.getCustomerId());
                ps.setInt(2, cardPayment.getCardNumber());
                ps.setInt(3, cardPayment.getCardSecurityCode());
                ps.setInt(4, cardPayment.getCardExpeiryDate());
                ps.setString(5, cardPayment.getBankName());
                if (ps.executeUpdate() > 0) {
                    retType = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Failed To Add Card :" + ex.getMessage());
        } finally {
            closeIfNotNull();
        }
        return retType;
    }

    @Override
    public boolean deleteAllPayment() {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Truncate table payment");
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Failed To Delete All Payments");
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

}
