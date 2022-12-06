package za.online.service;

import java.util.List;
import za.online.bean.CardPayment;
import za.online.bean.Customer;
import za.online.bean.Order;
import za.online.bean.OrderLineItem;
import za.online.bean.Payment;
import za.online.bean.Product;

public interface OrderService {

    public Order getOneOrder(int orderId);

    public List<Order> getAllOrders();

    public Order createAnOrder(List<OrderLineItem> orderedProducts, CardPayment cardPayment, Payment payment, int customerId);

    public boolean deleteAnOrders(int orderId);

    public double calTotAmnt(List<OrderLineItem> purchasedProducts);

    public List<Order> ordersByDate();

    public List<Order> pendingOrders();

    public List<Order> completedOrders();

    public List<Order> dispachedOrders();

}
