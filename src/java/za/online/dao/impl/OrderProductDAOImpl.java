package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.Customer;
import za.online.bean.OrderProduct;
import za.online.bean.Product;
import za.online.dao.OrderProductDAO;
import za.online.db.ConnectToBD;

public class OrderProductDAOImpl implements OrderProductDAO {

    Customer customer;
    Product product;
    OrderProduct orderProduct = new OrderProduct();
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public OrderProductDAOImpl() {
        con = ConnectToBD.getConnection();

    }

    @Override
    public OrderProduct creatOrderProduct(OrderProduct orderProduct) {
        if (con != null) {
            try {
                ps = con.prepareStatement("Insert into orderproducts(orderId,productId,quantity) values(?,?,?)");
                ps.setInt(1, orderProduct.getOrderId());
                ps.setInt(2, orderProduct.getProductId());
                ps.setInt(3, orderProduct.getQuantity());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed to Create Order Product :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return orderProduct;
    }

    @Override
    public boolean updateProductId(int productId, int orderId, int newProductId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE orderproducts SET productId = ? WHERE productId = ? AND orderId = ?");
                ps.setInt(1, newProductId);
                ps.setInt(2, productId);
                ps.setInt(3, orderId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update ProductId :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateOrderId(int productId, int orderId, int newOrderId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE orderproducts SET orderId = ? WHERE productId = ? AND orderId = ?");
                ps.setInt(1, newOrderId);
                ps.setInt(2, productId);
                ps.setInt(3, orderId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update ProductId :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean deleteOrderProduct(int productId, int orderId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Delete from orderproducts WHERE productId = ? AND orderId = ?");
                ps.setInt(1, productId);
                ps.setInt(2, orderId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To delete Row:" + ex.getMessage());
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

    @Override
    public List<OrderProduct> viewAllProduct() {
        List<OrderProduct> orderProductList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from orderproducts");
                rs = ps.executeQuery();
                while (rs.next()) {
                    orderProduct.setProductId(rs.getInt("productId"));
                    orderProduct.setOrderId(rs.getInt("orderId"));
                    orderProduct.setQuantity(rs.getInt("quantity"));
                    orderProductList.add(orderProduct);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read OrderProduct Table :" + ex.getMessage());
            } finally {
                for (OrderProduct od : orderProductList) {
                    System.out.println(od);
                }
                closeIfNotNull();
            }
        }
        return orderProductList;
    }

    @Override
    public OrderProduct viewOneProduct(int productId, int customerId) {
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from orderproducts");
                rs = ps.executeQuery();
                while (rs.next()) {
                    orderProduct.setProductId(rs.getInt("productId"));
                    orderProduct.setOrderId(rs.getInt("orderId"));
                    orderProduct.setQuantity(rs.getInt("quantity"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read OrderProduct Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return orderProduct;
    }

    @Override
    public boolean updateQuantity(int productId, int orderId, int newQuantity) {
             boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE orderproducts SET orderId = ? WHERE productId = ? AND orderId = ?");
                ps.setInt(1, newQuantity);
                ps.setInt(2, productId);
                ps.setInt(3, orderId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Quantity :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

}
