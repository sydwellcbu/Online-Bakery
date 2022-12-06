package za.online.bean;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import za.online.enums.OrderStatus;

public class Order {

    private int orderId;
    private int customerId;
    private int productId;
    private int quantity;
    private double orderAmnt;
    private String orderStatus;
    private LocalDate orderDate;
    boolean active;

    public Order() {
    }

    public Order(int orderId, int customerId, int productId, int quantity, double orderAmnt, String orderStatus, LocalDate orderDate, boolean active) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderAmnt = orderAmnt;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.active = active;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus.toString();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrderAmnt() {
        return orderAmnt;
    }

    public void setOrderAmnt(double orderAmnt) {
        this.orderAmnt = orderAmnt;
    }


    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double calculateTotalCost( List<OrderLineItem> purchasedProducts) {
        double cost = 0.0D;

        for (OrderLineItem product : purchasedProducts) {
            cost += product.getProductPrice();
        }

        return cost;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity + ", orderAmnt=" + orderAmnt + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", active=" + active + '}';
    }


}
