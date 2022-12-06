package za.online.bean;

import java.util.List;

public class OrderLineItem {

//    Product product;
    private int productId;
    private int quantity;
    private double productPrice;
    private double productDiscount;
    private String productPic;
    private String productName;

    public OrderLineItem(int quantity) {
//        this.product = product;
//        this.quantity = quantity;
    }

    public OrderLineItem() {
      //  this(null, 0);
       // this.product = new Product();
    }

  //  public Product getProduct() {
    //    return product;
    //}

// public void setProduct(Product product) {
//        this.product = product;
//    }
//
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


    public double getProductPrice() {
        return productPrice*this.quantity;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }

    @Override
    public String toString() {
        return "OrderLineItem{" + "productId=" + productId + ", quantity=" + quantity + ", productPrice=" + productPrice + ", productDiscount=" + productDiscount + ", productPic=" + productPic + ", productName=" + productName + '}';
    }
    


}
