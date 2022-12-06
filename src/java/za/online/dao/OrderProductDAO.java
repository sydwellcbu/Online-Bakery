
package za.online.dao;

import java.util.List;
import za.online.bean.OrderProduct;


public interface OrderProductDAO {
    
    public OrderProduct creatOrderProduct(OrderProduct orderProduct);
    
    public boolean updateProductId(int productId,int orderId,int newProductId);
    
    public boolean updateOrderId(int productId,int orderId,int newOrderId);
    
    public boolean updateQuantity(int productId,int orderId,int newQuantity);
    
    public boolean deleteOrderProduct(int productId,int orderId);
    
      public List<OrderProduct> viewAllProduct();

    public OrderProduct viewOneProduct(int productId,int customerId);
    
      
}
