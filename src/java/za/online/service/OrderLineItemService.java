
package za.online.service;

import java.util.List;
import za.online.bean.OrderLineItem;
import za.online.bean.Product;

public interface OrderLineItemService {
    
    public OrderLineItem addProductToCart(int productId);
    
    public List<OrderLineItem> removeProductFromCart(int productId,List<OrderLineItem> addProduct);
    
    public boolean increaseQuantity(int ItemId,List<OrderLineItem> cart);
    
    public boolean decreaseQuantity(int ItemId,List<OrderLineItem> cart);
    
    public int numberOfOrderlineItems(List<OrderLineItem> cartItems);
    
    public List<OrderLineItem> removeAllProduct(List<OrderLineItem> cartItems); 
}
