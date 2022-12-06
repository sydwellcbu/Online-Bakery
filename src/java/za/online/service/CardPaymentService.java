package za.online.service;

import java.util.List;
import za.online.bean.CardPayment;

public interface CardPaymentService {

    public boolean removeCard(CardPayment cardPayment);

    public boolean removeAllCards();

    public CardPayment addCard(CardPayment cardPayment);

    public List<CardPayment> getAllCustomerCards(int customerId);

    public List<CardPayment> getAllCards();

    public CardPayment getOneCards(int payId);

    public CardPayment getLastInsertedCard(int customerId);


}
