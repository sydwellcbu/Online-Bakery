package za.online.dao;

import java.util.List;
import za.online.bean.Customer;
import za.online.bean.Order;
import za.online.bean.OrderLineItem;

public interface OrderDAO {

    public Order getOneOrder(int orderId);

    public List<Order> getAllOrders();

    public boolean deleteAnOrders(int orderId);

    public double calTotAmnt(List<OrderLineItem> cart);

    public Order generateNewOrder(int customerId);

    public boolean updateOrderLineItems(int orderId, List<OrderLineItem> orderLineItems);

    public boolean updateIngrediantsInventory(List<OrderLineItem> cartItems);

    public List<Order> ordersByDate();

    public List<Order> pendingOrders();

    public List<Order> completedOrders();

    public List<Order> dispachedOrders();
    
    public boolean updatProducts(List<OrderLineItem> cartItems);
}
