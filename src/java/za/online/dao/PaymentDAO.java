package za.online.dao;

import java.util.List;
import za.online.bean.CardPayment;
import za.online.bean.Invoice;
import za.online.bean.Payment;

public interface PaymentDAO {

    public Payment createPayment(Payment payment);

    public boolean deletePayment(int paymentId);
    
    public boolean deleteAllPayment();

    public Payment viewOnePayment(int paymentId);

    public List<Payment> viewAllPayment();

    public boolean validateCard(CardPayment cardPayment);
    
    
   
}
