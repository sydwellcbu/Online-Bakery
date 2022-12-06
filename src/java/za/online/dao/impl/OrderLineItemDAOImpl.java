package za.online.dao.impl;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.OrderLineItem;
import za.online.bean.Product;
import za.online.db.ConnectToBD;
import za.online.dao.OrderLineItemDAO;

public class OrderLineItemDAOImpl implements OrderLineItemDAO {

    List<Product> cart = new ArrayList<>();
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
    private double totAmnt;

    public OrderLineItemDAOImpl() {
        con = ConnectToBD.getConnection();
    }

    @Override
    public OrderLineItem addProductToCart(int productId) {
        OrderLineItem product = new OrderLineItem();

        try {
            if (con != null) {
                ps = con.prepareStatement("select productId,productName,productPic,price,discount from product where productId = ?");
                ps.setInt(1, productId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    double dis = 0;
                    double pric = 0;
                    product.setProductId(rs.getInt("productId"));
                    product.setProductName(rs.getString("productName"));
                    product.setProductPic(rs.getString("productPic"));
                    product.setQuantity(1);
                    product.setProductDiscount(rs.getDouble("discount"));
                    dis = rs.getDouble("discount") / 100;
                    pric = (rs.getDouble("price") - (rs.getDouble("price") * dis));
                    product.setProductPrice(pric);
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to Add Product To Cart :" + e.getMessage());
        } finally {
            closeIfNotNull();
        }
        return product;
    }

    @Override
    public List<OrderLineItem> removeProductFromCart(int productId, List<OrderLineItem> cart) {

        for (OrderLineItem p : cart) {
            if (p.getProductId() == productId) {
                cart.remove(cart.indexOf(p));
                return cart;
            }
        }
        return cart;
    }

    @Override
    public boolean increaseQuantity(int ItemId, List<OrderLineItem> cart) {
        boolean retType = false;
        try {
            ps = con.prepareStatement("Select quantity from product where productId =?");
            ps.setInt(1, ItemId);
            rs = ps.executeQuery();
            while (rs.next()) {
                for (OrderLineItem c : cart) {
                    if (c.getProductId() == ItemId) {
                        if ((rs.getInt("quantity")-c.getQuantity())>0) {
                            c.setQuantity(c.getQuantity() + 1);
                            retType = true;
                        } else {
                            retType = false;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return retType;
    }

    @Override
    public boolean decreaseQuantity(int ItemId, List<OrderLineItem> cart) {
        boolean retType = false;
        for (OrderLineItem c : cart) {
            if (c.getProductId() == ItemId) {
                c.setQuantity(c.getQuantity() - 1);
                retType = true;
            }
        }
        return retType;
    }

    @Override
    public int numberOfOrderlineItems(List<OrderLineItem> cartItems) {
        int numberOfItem = 0;
        for (OrderLineItem oli : cartItems) {
            if (oli.getQuantity() > 1) {
                for (int i = 0; i < oli.getQuantity(); i++) {
                    numberOfItem++;
                }
            } else {
                numberOfItem++;
            }
        }
        return numberOfItem;
    }

    @Override
    public List<OrderLineItem> removeAllProduct(List<OrderLineItem> cartItems) {
        while (!cartItems.isEmpty()) {
            cartItems.removeAll(cartItems);
        }

        return cartItems;
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
