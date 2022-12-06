package za.online.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Product {

    private int productId;
    private int categoryId;
    private int quantity;
    private String productName;
    private String productDesc;
    private double price;
    private double discount;
    private String productPic;
    private Date postedDate;
    private boolean active;
    

    public Product() {
    }

    public Product(int productId, int categoryId, int quantity, String productName, String productDesc, double price, double discount, String productPic, Date postedDate) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.discount = discount;
        this.productPic = productPic;
        this.postedDate = postedDate;
    }

       public Product(int categoryId, int quantity, String productName, String productDesc, double price, double discount, String productPic , boolean active) {
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.discount = discount;
        this.productPic = productPic;
        this.active = true;
    }
    
    
    
    
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        double discnt = this.discount/100;
        this.price = (price-(price*discnt));
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
    
    
    
    
    
    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", categoryId=" + categoryId + ", quantity=" + quantity + ", productName=" + productName + ", productDesc=" + productDesc + ", price=" + price + ", discount=" + discount + ", productPic=" + productPic + ", postedDate=" + postedDate + '}';
    }
    
    
   
  
}
