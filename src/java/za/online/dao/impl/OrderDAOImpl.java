package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.Customer;
import za.online.bean.IngredientsInventory;
import za.online.bean.Invoice;
import za.online.bean.OrderLineItem;
import za.online.bean.Order;
import za.online.bean.Product;
import za.online.dao.OrderDAO;
import za.online.db.ConnectToBD;
import za.online.enums.OrderStatus;
import za.online.enums.PaymentStatus;

public class OrderDAOImpl implements OrderDAO {

    Order order = new Order();
    List<Order> orderList = new ArrayList<>();
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public OrderDAOImpl() {
        con = ConnectToBD.getConnection();
    }

    @Override
    public Order getOneOrder(int orderId) {

        if (con != null) {
            try {
                ps = con.prepareStatement("select * from orders where orderId = ?");
                ps.setInt(1, orderId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    order.setOrderId(rs.getInt("orderId"));
                    order.setCustomerId(rs.getInt("customerId"));
                    order.setOrderStatus(rs.getString("orderStatus"));
                    order.setOrderDate(LocalDate.parse(rs.getString("orderDate")));
                    order.setActive(rs.getBoolean("isActive"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Order Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        orderList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from orders");
                rs = ps.executeQuery();
                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt("orderId"));
                    order.setCustomerId(rs.getInt("userId"));
                    order.setOrderStatus(rs.getString("orderStatus"));
                    order.setOrderDate(LocalDate.parse(rs.getString("orderDate")));
                    order.setActive(rs.getBoolean("isActive"));
                    orderList.add(order);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Order Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return orderList;
    }

    @Override
    public boolean deleteAnOrders(int orderId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from orders where orderId = ?");
                ps.setInt(1, orderId);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Failed To Delete Order From Orders Table");
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
    public double calTotAmnt(List<OrderLineItem> purchasedProducts) {
        double cost = 0;
        for (OrderLineItem product : purchasedProducts) {
            cost += product.getProductPrice();
        }
        return cost;
    }

    // *************************************************************************************************************
    @Override
    public Order generateNewOrder(int customerId) {
        Order order = null;
        if (con != null) {
            try {
                LocalDate dateNow = LocalDate.now();
                ps = con.prepareStatement("INSERT INTO orders (orderId, userId, orderStatus, orderDate, isActive) VALUES (NULL,?,?,?,TRUE)");
                ps.setInt(1, customerId);
                ps.setString(2, OrderStatus.PROCESSED.toString());
                ps.setString(3, dateNow.toString());
                if (ps.executeUpdate() > 0) {
                    ps.close();
                    ps = con.prepareStatement("SELECT isActive,orderId,orderStatus,userId from orders ORDER BY orderId DESC Limit 1");
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        order = new Order();
                        order.setActive(rs.getBoolean("isActive"));
                        order.setOrderId(rs.getInt("orderId"));
                        order.setOrderDate(dateNow);
                        order.setOrderStatus(rs.getString("orderStatus"));
                        order.setCustomerId(rs.getInt("userId"));
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Create Order :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return order;
    }

    @Override
    public boolean updateOrderLineItems(int orderId, List<OrderLineItem> orderLineItems) {
        int inserted = 0;
        if (con != null) {
            try {
                ps = con.prepareStatement("INSERT INTO orderproducts (productId, orderId, quantity) VALUES (?,?,?)");
                for (OrderLineItem oli : orderLineItems) {
                    ps.setInt(1, oli.getProductId());
                    ps.setInt(2, orderId);
                    ps.setInt(3, oli.getQuantity());
                    if (ps.executeUpdate() > 0) {
                        inserted += 1;
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Add To Order Product :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return inserted == orderLineItems.size();
    }

    public double generateOrderBill(List<OrderLineItem> cart) {
        double totAmnt = 0;
        for (OrderLineItem oli : cart) {
            totAmnt = totAmnt + oli.getProductPrice();
        }
        return totAmnt;
    }

    //must be removed
    public boolean efromFilling(String adress, Customer customer) {
        boolean retVal = false;
        try {
            ps = con.prepareStatement("update customer Set address =? where customerId = ?");
            ps.setString(1, adress);
            ps.setInt(2, customer.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed To Update Customer Address :" + e.getMessage());
        } finally {
            closeIfNotNull();
        }
        return retVal;
    }

    @Override
    public boolean updateIngrediantsInventory(List<OrderLineItem> cartItems) {
        boolean retType = false;
        int listSize = 0;
        if (con != null) {
            for (OrderLineItem oli : cartItems) {

                try {
                    ps = con.prepareStatement("select recipeId from recipe where productId = ?");
                    ps.setInt(1, oli.getProductId());
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        int recipeId = rs.getInt("recipeId");
                        ps = con.prepareStatement("select ingridientsId,quantity from recipeingridients where recipeId = ?");
                        ps.setInt(1, recipeId);
                        ResultSet rss = ps.executeQuery();

                        while (rss.next()) {
                            int quantity = rss.getInt("quantity");
                            int ingredientsId = rss.getInt("ingridientsId");
                            ps = con.prepareStatement("select availableStock from ingridientinventory Where ingredientsId = ?");
                            ps.setInt(1, ingredientsId);
                            rs = ps.executeQuery();

                            if (rs.next()) {
                                int newStock = rs.getInt("availableStock") - quantity;
                                ps = con.prepareStatement("Update ingridientinventory Set availableStock = ? where ingredientsId = ? ");
                                ps.setInt(1, newStock);
                                ps.setInt(2, ingredientsId);
                                ps.executeUpdate();
                            }
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Failed to Update Ingredients Inventory :" + e.getMessage());
                }
                listSize++;
            }
            closeIfNotNull();
            if (listSize == cartItems.size()) {
                retType = true;
            }
        }

        return retType;
    }

    @Override
    public boolean updatProducts(List<OrderLineItem> cartItems) {
        boolean retTyp = false;
        int count = 0;
        for (OrderLineItem oli : cartItems) {

            try {
                ps = con.prepareStatement("Select quantity from product where productId= ?");
                ps.setInt(1, oli.getProductId());
                rs = ps.executeQuery();
                while (rs.next()) {
                    ps = con.prepareStatement("Update product Set quantity =? where productId= ?");
                    ps.setInt(1, (rs.getInt("quantity") - oli.getQuantity()));
                    ps.setInt(2, oli.getProductId());
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                System.out.println("Failed To Update Product Quantity :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
            count++;
        }
        if (count == cartItems.size()) {
            retTyp = true;
        }
        return retTyp;
    }

    @Override
    public List<Order> ordersByDate() {
        orderList = new ArrayList<>();
        if (con != null) {
            try {

                ps = con.prepareStatement("select * from orders ORDER BY orderDate");
                rs = ps.executeQuery();

                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt("orderId"));
                    order.setCustomerId(rs.getInt("userId"));
                    order.setQuantity(rs.getInt("quantity"));
                    order.setOrderStatus(rs.getString("orderStatus"));
                    order.setOrderAmnt(rs.getDouble("orderAmount"));
                    order.setOrderDate(LocalDate.parse(rs.getString("orderDate")));
                    order.setActive(rs.getBoolean("isActive"));
                    orderList.add(order);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Order Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return orderList;
    }

    @Override
    public List<Order> pendingOrders() {
        orderList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from orders where orderStatus = 'PENDING' ");
                rs = ps.executeQuery();

                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt("orderId"));
                    order.setCustomerId(rs.getInt("userId"));
                    order.setQuantity(rs.getInt("quantity"));
                    order.setOrderStatus(rs.getString("orderStatus"));
                    order.setOrderAmnt(rs.getDouble("orderAmount"));
                    order.setOrderDate(LocalDate.parse(rs.getString("orderDate")));
                    order.setActive(rs.getBoolean("isActive"));
                    orderList.add(order);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Order Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return orderList;
    }

    @Override
    public List<Order> completedOrders() {
        orderList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from orders where orderStatus = 'PROCESSED' ");
                rs = ps.executeQuery();

                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt("orderId"));
                    order.setCustomerId(rs.getInt("userId"));
                    order.setQuantity(rs.getInt("quantity"));
                    order.setOrderStatus(rs.getString("orderStatus"));
                    order.setOrderAmnt(rs.getDouble("orderAmount"));
                    order.setOrderDate(LocalDate.parse(rs.getString("orderDate")));
                    order.setActive(rs.getBoolean("isActive"));
                    orderList.add(order);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Order Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return orderList;
    }

    @Override
    public List<Order> dispachedOrders() {
        orderList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from deliveries where deliveryStatus = 'PROCESSED' ");
                rs = ps.executeQuery();

                while (rs.next()) {
                    order = new Order();
                    order.setOrderId(rs.getInt("orderId"));
                    order.setCustomerId(rs.getInt("userId"));
                    order.setQuantity(rs.getInt("quantity"));
                    order.setOrderStatus(rs.getString("orderStatus"));
                    order.setOrderAmnt(rs.getDouble("orderAmount"));
                    order.setOrderDate(LocalDate.parse(rs.getString("orderDate")));
                    order.setActive(rs.getBoolean("isActive"));
                    orderList.add(order);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Order Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return orderList;
    }

}
