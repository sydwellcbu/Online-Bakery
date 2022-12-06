/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.dao;

import java.util.List;
import za.online.bean.OrderLineItem;
import za.online.bean.Product;

/**
 *
 * @author Train
 */
public interface OrderLineItemDAO {
    
    public OrderLineItem addProductToCart(int productId);
    
    public List<OrderLineItem> removeProductFromCart(int productId,List<OrderLineItem> addProduct);
    
    public boolean increaseQuantity(int ItemId,List<OrderLineItem> cart);
    
    public boolean decreaseQuantity(int ItemId,List<OrderLineItem> cart);
    
    public int numberOfOrderlineItems(List<OrderLineItem> cartItems);
    
    public List<OrderLineItem> removeAllProduct(List<OrderLineItem> cartItems); 
    
}

