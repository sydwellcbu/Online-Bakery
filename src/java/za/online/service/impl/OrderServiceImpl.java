package za.online.service.impl;

import java.util.List;
import za.online.bean.CardPayment;
import za.online.bean.Customer;
import za.online.bean.Invoice;
import za.online.bean.Order;
import za.online.bean.OrderLineItem;
import za.online.bean.Payment;
import za.online.bean.Product;
import za.online.dao.InvoiseDAO;
import za.online.dao.OrderDAO;
import za.online.dao.PaymentDAO;
import za.online.dao.impl.InvoiceDAOImpl;
import za.online.dao.impl.OrderDAOImpl;
import za.online.dao.impl.PaymentDAOImpl;
import za.online.enums.OrderStatus;
import za.online.enums.PaymentStatus;
import za.online.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private InvoiseDAO invoiceDAOI;
    private OrderDAO orderDAO;
    private PaymentDAO paymentDAO = new PaymentDAOImpl();
    private Order order = null;

    public OrderServiceImpl() {
        this.orderDAO = new OrderDAOImpl();
        this.paymentDAO = new PaymentDAOImpl();
        this.invoiceDAOI = new InvoiceDAOImpl();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public Order createAnOrder(List<OrderLineItem> orderedProducts, CardPayment cardPayment, Payment payment, int customerId) {
        boolean retTyp = false;
        order = new Order();
        Invoice invoice = new Invoice();
        if ((orderedProducts == null) || (customerId < 1)) {
            return null;
        } else if ("Cash".equalsIgnoreCase(payment.getPaymentMethod())) {
            order = orderDAO.generateNewOrder(customerId);
            orderDAO.updateOrderLineItems(order.getOrderId(), orderedProducts);
            invoice = invoiceDAOI.createInvoice(order.getOrderId());
            payment.setInvoiceId(invoice.getInvoiceId());
            paymentDAO.createPayment(payment);
            orderDAO.updatProducts(orderedProducts);
            orderDAO.updateIngrediantsInventory(orderedProducts);
        } else {
            if ("Card".equalsIgnoreCase(payment.getPaymentMethod())) {
                order = orderDAO.generateNewOrder(customerId);
                orderDAO.updateOrderLineItems(order.getOrderId(), orderedProducts);
                invoice = invoiceDAOI.createInvoice(order.getOrderId());
                payment.setInvoiceId(invoice.getInvoiceId());
                paymentDAO.createPayment(payment);
                orderDAO.updatProducts(orderedProducts);
                orderDAO.updateIngrediantsInventory(orderedProducts);

            }
        }
        return order;
    }

    @Override
    public boolean deleteAnOrders(int orderId
    ) {
        if (orderId < 0) {
            return false;
        }
        return orderDAO.deleteAnOrders(orderId);
    }

    @Override
    public double calTotAmnt(List<OrderLineItem> purchasedProducts
    ) {
        if (purchasedProducts == null) {
            return 0;
        }
        return orderDAO.calTotAmnt(purchasedProducts);
//return (purchasedProducts!=null)?orderDAO.calTotAmnt(purchasedProducts):0;
    }

    @Override
    public Order getOneOrder(int orderId
    ) {
        if (orderId < 0) {
            return null;
        }
        return orderDAO.getOneOrder(orderId);
    }

    public Order getOrder() {
        return this.order;
    }

    @Override
    public List<Order> ordersByDate() {
        return orderDAO.ordersByDate();
    }

    @Override
    public List<Order> pendingOrders() {
        return orderDAO.pendingOrders();
    }

    @Override
    public List<Order> completedOrders() {
        return orderDAO.completedOrders();
    }

    @Override
    public List<Order> dispachedOrders() {
        return orderDAO.dispachedOrders();
    }
}
