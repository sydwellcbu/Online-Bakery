
package za.online.service.impl;

import java.util.List;
import za.online.bean.CardPayment;
import za.online.dao.CardPaymentDAO;
import za.online.dao.impl.CardPaymentDAOImpl;
import za.online.service.CardPaymentService;


public class CardPaymentServiceImpl implements CardPaymentService{
    CardPaymentDAO cardPaymentDAO;

    public CardPaymentServiceImpl() {
        this.cardPaymentDAO = new CardPaymentDAOImpl();
    }
    
    @Override
    public boolean removeCard(CardPayment cardPayment) {
        if(cardPayment == null){
        return false;
        }
        return cardPaymentDAO.removeCard(cardPayment);
    }

    @Override
    public boolean removeAllCards() {
        return cardPaymentDAO.removeAllCards();
    }

    @Override
    public CardPayment addCard(CardPayment cardPayment) {
          if(cardPayment == null){
        return cardPayment;
        }
        return cardPaymentDAO.addCard(cardPayment);
    }

    @Override
    public List<CardPayment> getAllCustomerCards(int customerId) {
        if(customerId <= 0){
            return null;
        }
        return cardPaymentDAO.getAllCustomerCards(customerId);
    }

    @Override
    public List<CardPayment> getAllCards() {
        return cardPaymentDAO.getAllCards();
    }

    @Override
    public CardPayment getOneCards(int payId) {
        if( (payId <= 0)){
        return null;
        }
        return cardPaymentDAO.getOneCards(payId);
    }

    @Override
    public CardPayment getLastInsertedCard(int customerId) {
        if(customerId <1){
        return null;
        }
        return cardPaymentDAO.getLastInsertedCard(customerId);
    }
    
}
