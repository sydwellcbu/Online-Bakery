/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service;

import java.util.List;
import za.online.bean.Product;

/**
 *
 * @author Train
 */
public interface ProductService {

     public boolean addProduct(Product product );

    public boolean removeProduct(int productId);

    public boolean updateProduct(Product product);

    public boolean updateProductDesc(int productID, String productDesc);

    public boolean updateProductQuantity(int productID, int productQuantity);

    public boolean updateProductDiscount(int productID, double newDiscount);

    public boolean updateProductPic(int productID, String newPic);
    
    public boolean updateProductPrice(int productID, double newPrice);

    public List<Product> viewAllProduct();

    public Product viewOneProduct(int productId);
    
    public int getCategoryId(String categoryName);
    
}
