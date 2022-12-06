
package za.online.service.impl;

import java.util.List;
import za.online.bean.CardPayment;
import za.online.bean.Payment;
import za.online.dao.PaymentDAO;
import za.online.dao.impl.PaymentDAOImpl;
import za.online.service.PaymentService;




public class PaymentServiceImpl implements PaymentService{
    private PaymentDAO paymentDAO;

    public PaymentServiceImpl() {
        this.paymentDAO = new PaymentDAOImpl();
    }

    
    
    @Override
    public Payment createPayment(Payment payment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePayment(int paymentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAllPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return paymentDAO.validateCard(cardPayment);
    }

    
}
