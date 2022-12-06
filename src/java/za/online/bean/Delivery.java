package za.online.bean;

public class Delivery {

    private Order order;
    private int deliveryId;
    private String deliveryStatus;

    public Delivery(Order order, int deliveryId, String deliveryStatus) {
        this.order = order;
        this.deliveryId = deliveryId;
        this.deliveryStatus = deliveryStatus;
    }

    public Delivery() {
        this.order = new Order();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public String toString() {
        return "Delivery{" + "order=" + order + ", deliveryId=" + deliveryId + ", deliveryStatus=" + deliveryStatus + '}';
    }

}
