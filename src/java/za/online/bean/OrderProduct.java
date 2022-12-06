
package za.online.bean;


public class OrderProduct {
    
    private int productId;
    private int orderId;
    private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(int productId, int orderId, int quantity) {
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
    }
 
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderProduct{" + "productId=" + productId + ", orderId=" + orderId + ", quantity=" + quantity + '}';
    }


   }
