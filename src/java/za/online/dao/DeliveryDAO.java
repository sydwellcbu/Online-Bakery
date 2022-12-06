
package za.online.dao;

import java.util.List;
import za.online.bean.Delivery;
import za.online.bean.Order;
import za.online.enums.DeliveryStatus;


public interface DeliveryDAO {
    
    
    public Delivery createDelivery(Delivery delivery);
    
    public boolean deleteDelivery(int deliveryId);
    
    public Delivery getOneDelivery(int deliveryId);
    
    public List<Delivery> getAllDelivery();
    
    public boolean updateDeliveryId(int deliveryId,int newDeliveryId);
    
    public boolean updateOrderId(int deliveryId,int newOrderId);
    
    public boolean updateDeliveryStatus(int deliveryId, DeliveryStatus newDeliveryStatus);
    
    
}

