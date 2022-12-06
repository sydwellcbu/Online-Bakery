
import java.util.ArrayList;
import java.util.List;
import za.online.bean.CardPayment;
import za.online.bean.Ingrediants;
import za.online.bean.OrderLineItem;
import za.online.bean.Payment;
import za.online.dao.impl.CardPaymentDAOImpl;
import za.online.dao.impl.IngredientsDAOImpl;
import za.online.dao.impl.OrderDAOImpl;
import za.online.dao.impl.PaymentDAOImpl;
import za.online.service.CardPaymentService;
import za.online.service.OrderLineItemService;
import za.online.service.OrderService;
import za.online.service.impl.CardPaymentServiceImpl;
import za.online.service.impl.OrderLineItemServiceImpl;
import za.online.service.impl.OrderServiceImpl;

public class test {

    CardPaymentDAOImpl cardDAO = new CardPaymentDAOImpl();
    CardPayment card = new CardPayment();
    OrderService orderServiceImpl = new OrderServiceImpl();
    OrderLineItemService olisi = new OrderLineItemServiceImpl();
    OrderDAOImpl odi = new OrderDAOImpl();

    List<OrderLineItem> orderedProducts = new ArrayList<>();
    Payment payment = new Payment();

    public static void main(String[] args) {
        IngredientsDAOImpl in = new IngredientsDAOImpl();
        for(Ingrediants c :in.getAllIngrediants()){
            System.out.println(c);
        
        }
//        new test().testCard();
        //System.out.println(new test().placeOrder());  
//        CardPayment cardpay = new CardPayment();
//        cardpay.setBankName("Nedbank");
//        cardpay.setCardExpeiryDate(2025);
//        cardpay.setCardNumber(6655454);
//        cardpay.setCardSecurityCode(333);
//        cardpay.setCustomerId(2);
//        PaymentDAOImpl payyy = new PaymentDAOImpl();
//        System.out.println(payyy.validateCard(cardpay));

       // new test().testCard();
    }

    public void testCard() {
        card = cardDAO.getOneCards(1);
        //  List<CardPayment> card = cardDAO.getAllCustomerCards(2);
        System.out.println(card.toString());
//        for (CardPayment c : card) {
//            System.out.println(c);
//        }
    }

    public void getOneCard() {
        List<CardPayment> all = new ArrayList<>();
        CardPaymentService cps = new CardPaymentServiceImpl();
        CardPayment cardPayment1 = new CardPayment();
        cardPayment1 = cps.getOneCards(1);
        all = cps.getAllCustomerCards(2);
        for (CardPayment ccc : all) {
            System.out.println(ccc);

        }
    }

    public boolean placeOrder() {
        boolean retTyp = false;
        orderedProducts.add(olisi.addProductToCart(19));
        for (OrderLineItem oli : orderedProducts) {
            if (oli.getProductId() == 19) {
                oli.setQuantity(6);
                if (olisi.increaseQuantity(19, orderedProducts)) {
                    retTyp = true;
                } else {
                    retTyp = false;
                }
            }
        }
        payment.setPaymentMethod("Cash");
        orderedProducts.add(olisi.addProductToCart(29));
        orderedProducts.add(olisi.addProductToCart(21));
//        orderedProducts.add(olisi.addProductToCart(23));
//        orderedProducts.add(olisi.addProductToCart(24));
        // System.out.println(odi.updatProducts(orderedProducts));
        //  payment.setPaymentMethod("Cash");
        OrderDAOImpl d = new OrderDAOImpl();

        if (orderServiceImpl.createAnOrder(orderedProducts, card, payment, 2) != null) {
            d.updateIngrediantsInventory(orderedProducts);
        }
        return retTyp;
    }

    public void addCard() {
        CardPaymentService cardPaymentService = new CardPaymentServiceImpl();
        CardPayment cardPay = new CardPayment();

        int cardNumber = 12233;
        int cvv = 223;
        int month = 9;
        int year =2025;
        int userId = 2;
        String cardName = "time back";
        cardPay.setBankName(cardName);
        cardPay.setCardExpeiryDate(year);
        cardPay.setCardNumber(cardNumber);
        cardPay.setCardSecurityCode(cvv);
        cardPay.setCustomerId(userId);
        cardPaymentService.addCard(cardPay);

    }
}
