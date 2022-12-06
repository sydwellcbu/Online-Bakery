package za.online.service.impl;

import java.util.ArrayList;
import java.util.List;
import za.online.bean.OrderLineItem;
import za.online.bean.Product;
import za.online.dao.impl.OrderLineItemDAOImpl;
import za.online.service.ProductService;
import za.online.dao.OrderLineItemDAO;
import za.online.service.OrderLineItemService;

public class OrderLineItemServiceImpl implements OrderLineItemService {

    OrderLineItemDAO cartDAO;

    public OrderLineItemServiceImpl() {
        this.cartDAO = new OrderLineItemDAOImpl();
    }

    @Override
    public boolean increaseQuantity(int quantity, List<OrderLineItem> cart) {
        if (quantity < 0) {
            return false;
        }
        return cartDAO.increaseQuantity(quantity, cart);
    }

    @Override
    public boolean decreaseQuantity(int quantity, List<OrderLineItem> cart) {
        if (quantity <= 0) {
            return false;
        }
        return cartDAO.decreaseQuantity(quantity, cart);
    }

    @Override
    public OrderLineItem addProductToCart(int productId) {
                if (productId < 1) {
            return null;
        }
        return cartDAO.addProductToCart(productId);
    }

    @Override
    public List<OrderLineItem> removeProductFromCart(int productId, List<OrderLineItem> cart) {
            if ((productId < 1) && (cart == null)){
            return cart;
        }

        return cartDAO.removeProductFromCart(productId, cart);
    }

    @Override
    public int numberOfOrderlineItems(List<OrderLineItem> cartItems) {
        if(cartItems == null){
        return 0;
        }
        return cartDAO.numberOfOrderlineItems(cartItems);
    }

    @Override
    public List<OrderLineItem> removeAllProduct(List<OrderLineItem> cartItems) {
        if(cartItems == null){
        return cartItems;
        }
        return cartDAO.removeAllProduct(cartItems);
    }
}


