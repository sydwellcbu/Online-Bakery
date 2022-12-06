
package za.online.bean;


public class CardPayment {
    private int customerId;
    private int payId;
    private int cardNumber;
    private int cardSecurityCode;
    private int cardExpeiryDate;
    private String bankName;

    public CardPayment() {
    }

    public CardPayment(int customerId, int payId, int cardNumber, int cardSecurityCode, int cardExpeiryDate, String bankName) {
        this.customerId = customerId;
        this.payId = payId;
        this.cardNumber = cardNumber;
        this.cardSecurityCode = cardSecurityCode;
        this.cardExpeiryDate = cardExpeiryDate;
        this.bankName = bankName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(int cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public int getCardExpeiryDate() {
        return cardExpeiryDate;
    }

    public void setCardExpeiryDate(int cardExpeiryDate) {
        this.cardExpeiryDate = cardExpeiryDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    @Override
    public String toString() {
        return "CardPayment{" + "customerId=" + customerId + ", payId=" + payId + ", cardNumber=" + cardNumber + ", cardSecurityCode=" + cardSecurityCode + ", cardExpeiryDate=" + cardExpeiryDate + ", bankName=" + bankName + '}';
    }
    
    

}
