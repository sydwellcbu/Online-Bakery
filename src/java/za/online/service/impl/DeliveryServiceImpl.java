
package za.online.service.impl;

import java.util.List;
import za.online.bean.Delivery;
import za.online.dao.DeliveryDAO;
import za.online.enums.DeliveryStatus;
import za.online.service.DeliveryService;

 

public class DeliveryServiceImpl implements DeliveryService{
    
    DeliveryDAO deliveryDAO;

    public DeliveryServiceImpl(DeliveryDAO diliveryDAO) {
        this.deliveryDAO = diliveryDAO;
    }
    
    @Override
    public Delivery createDelivery(Delivery delivery) {
        if(delivery == null){
        return null;
        }
        return deliveryDAO.createDelivery(delivery);
    }

    @Override
    public boolean deleteDelivery(int deliveryId) {
        boolean retTyp = false;
        if(deliveryId <0){
        return retTyp;
        }
        return deliveryDAO.deleteDelivery(deliveryId);
    }

    @Override
    public Delivery getOneDelivery(int deliveryId) {
          if(deliveryId <0){
        return null;
        }
        return deliveryDAO.getOneDelivery(deliveryId);
    }

    @Override
    public List<Delivery> getAllDelivery() {
        return deliveryDAO.getAllDelivery();
    }

    @Override
    public boolean updateDeliveryId(int deliveryId, int newDeliveryId) {
               boolean retTyp = false;
        if(deliveryId<0 || newDeliveryId<0){
        return retTyp;
        }
        return deliveryDAO.updateDeliveryId(deliveryId, newDeliveryId);
    }

    @Override
    public boolean updateOrderId(int deliveryId, int newOrderId) {
          boolean retTyp = false;
          if((deliveryId | newOrderId)<0){
          return retTyp;
          }
          return deliveryDAO.updateOrderId(deliveryId, newOrderId);
    }

    @Override
    public boolean updateDeliveryStatus(int deliveryId, DeliveryStatus newDeliveryStatus) {
            boolean retTyp = false;
          if((deliveryId <0)){
          return retTyp;
          }
          return deliveryDAO.updateDeliveryStatus(deliveryId, newDeliveryStatus);
    }
    
    
}
