
package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.online.bean.Delivery;
import za.online.bean.Order;
import za.online.bean.Product;
import za.online.dao.DeliveryDAO;
import za.online.db.ConnectToBD;
import za.online.enums.DeliveryStatus;


public class DeliveryDAOImpl implements DeliveryDAO{
     private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public DeliveryDAOImpl() {
        con = ConnectToBD.getConnection();
    }
    @Override
    public Delivery createDelivery(Delivery delivery) {
        if(con != null){
            try {
                ps = con.prepareStatement("Inserct into delivery(deliveryId, deliveryStatus, orderId)  values(null,?,?)");
                ps.setString(1, delivery.getDeliveryStatus());
                ps.setInt(2, delivery.getOrder().getOrderId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed To Add A Delivery :"+ex.getMessage());
            }finally{
            closeIfNotNull();
            }
        }
       return delivery; 
    }

    @Override
    public boolean deleteDelivery(int deliveryId) {
           boolean retVal = false;
        try {
            ps = con.prepareStatement("delete from delivery where deliveryId = ?");
            ps.setInt(1, deliveryId);
            ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed To Delete From Delivery Table :" + e.getMessage());
        } finally {
            closeIfNotNull();
        }
        return retVal;
    }

    @Override
    public Delivery getOneDelivery(int deliveryId) {
           Delivery delivery = new Delivery();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from delivery");
                rs = ps.executeQuery();
                while (rs.next()) {
                    delivery.setDeliveryId(rs.getInt("deliveryId"));
                    delivery.setDeliveryStatus(rs.getString("deliveryStatus"));
                    delivery.getOrder().setOrderId(rs.getInt("orderId"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Delivery Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return delivery;
        
    }

    @Override
    public List<Delivery> getAllDelivery() {
         List<Delivery> deliveryList = new ArrayList<>();
         Delivery delivery = new Delivery();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from delivery");
                rs = ps.executeQuery();
                while (rs.next()) {
                    delivery.setDeliveryId(rs.getInt("deliveryId"));
                    delivery.setDeliveryStatus(rs.getString("deliveryStatus"));
                    delivery.getOrder().setOrderId(rs.getInt("orderId"));
                    deliveryList.add(delivery);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Delivery Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return deliveryList;
    }

    @Override
    public boolean updateDeliveryId(int deliveryId, int newDeliveryId) {
            boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE delivery SET deliveryId = ?,  WHERE deliveryId = ?");
                ps.setInt(1, newDeliveryId);
                ps.setInt(2, deliveryId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update DeliveryId :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateOrderId(int deliveryId, int newOrderId) {
            boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE delivery SET orderId = ?,  WHERE deliveryId = ?");
                ps.setInt(1, newOrderId);
                ps.setInt(2, deliveryId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update DeliveryId :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateDeliveryStatus(int deliveryId, DeliveryStatus newDeliveryStatus) {
                 boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE delivery SET deliveryStatus = ?,  WHERE deliveryId = ?");
                ps.setString(1, newDeliveryStatus.toString());
                ps.setInt(2, deliveryId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Delivery Status :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }
    
    private void closeIfNotNull() {

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Fail To Close Prepared Statement :" + ex.getMessage());
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Fail To Close Results Set :" + ex.getMessage());
            }
        }

    }
}
