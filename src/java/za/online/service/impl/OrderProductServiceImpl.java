package za.online.service.impl;

import java.util.List;
import za.online.bean.OrderProduct;
import za.online.dao.OrderProductDAO;
import za.online.dao.impl.OrderProductDAOImpl;
import za.online.service.OrderProductService;

public class OrderProductServiceImpl implements OrderProductService {

    OrderProductDAO orderProductDAO;

    public OrderProductServiceImpl() {
        this.orderProductDAO = new OrderProductDAOImpl();

    }

    @Override
    public OrderProduct creatOrderProduct(OrderProduct orderProduct) {
        if (orderProduct.equals(null)) {
            return null;
        }
        return orderProductDAO.creatOrderProduct(orderProduct);
    }

    @Override
    public boolean updateProductId(int productId, int customerId, int newProductId) {
        if (((productId | customerId | newProductId) < 0)) {
            return false;
        }
        return orderProductDAO.updateQuantity(productId, customerId, newProductId);
    }

    @Override
    public boolean updateOrderId(int productId, int customerId, int newCustomerId) {
        if (((productId | customerId | newCustomerId) < 0)) {
            return false;
        }
        return orderProductDAO.updateOrderId(productId, customerId, newCustomerId);
    }

    @Override
    public boolean updateQuantity(int productId, int customerId, int newOrderProductId) {
        if (((productId | customerId | newOrderProductId) < 0)) {
            return false;
        }
        return orderProductDAO.updateOrderId(productId, customerId, newOrderProductId);
    }

    @Override
    public boolean deleteOrderProduct(int productId, int customerId) {
        if (((productId | customerId) < 0)) {
            return false;
        }
        return orderProductDAO.deleteOrderProduct(productId, customerId);
    }

    @Override
    public List<OrderProduct> viewAllProduct() {
        return orderProductDAO.viewAllProduct();
    }

    @Override
    public OrderProduct viewOneProduct(int productId, int customerId) {
        if (((productId | customerId) < 0)) {
            return null;
        }
        return orderProductDAO.viewOneProduct(productId, customerId);
    }

}
