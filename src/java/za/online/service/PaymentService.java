/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service;

import java.util.List;
import za.online.bean.CardPayment;
import za.online.bean.Payment;

/**
 *
 * @author Train
 */
public interface PaymentService {
    
        public Payment createPayment(Payment payment);

    public boolean deletePayment(int paymentId);
    
    public boolean deleteAllPayment();

    public Payment viewOnePayment(int paymentId);

    public List<Payment> viewAllPayment();

    public boolean validateCard(CardPayment cardPayment);
}
