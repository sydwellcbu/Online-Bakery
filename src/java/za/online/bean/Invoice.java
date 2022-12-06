
package za.online.bean;


public class Invoice {
    
    private int invoiceId;
    private int orderId;
    private int paymentId;

    public Invoice() {
    }

    public Invoice(int invoiceId, int orderId, int paymentId) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

  
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceId=" + invoiceId + ", orderId=" + orderId + ", paymentId=" + paymentId + '}';
    }

   
    
    
    
}
