package za.online.bean;

import java.sql.Timestamp;

public class Payment {

    private int paymentId;
    private int invoiceId;
    private String paymentStatus;
    private Timestamp payementDate;
    private String paymentMethod;

    public Payment() {
    
    }

    public Payment(int paymentId, int invoiceId, String paymentStatus, Timestamp payementDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.invoiceId = invoiceId;
        this.paymentStatus = paymentStatus;
        this.payementDate = payementDate;
        this.paymentMethod = paymentMethod;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Timestamp getPayementDate() {
        return payementDate;
    }

    public void setPayementDate(Timestamp payementDate) {
        this.payementDate = payementDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", invoiceId=" + invoiceId + ", paymentStatus=" + paymentStatus + ", payementDate=" + payementDate + ", paymentMethod=" + paymentMethod + '}';
    }

    
}
