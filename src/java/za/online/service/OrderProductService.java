package za.online.service;

import java.util.List;
import za.online.bean.OrderProduct;

public interface OrderProductService {

    public OrderProduct creatOrderProduct(OrderProduct orderProduct);

    public boolean updateProductId(int productId, int customerId, int newProductId);

    public boolean updateOrderId(int productId, int customerId, int newCustomerId);

    public boolean updateQuantity(int productId, int customerId, int newOrderProductId);

    public boolean deleteOrderProduct(int productId, int customerId);

    public List<OrderProduct> viewAllProduct();

    public OrderProduct viewOneProduct(int productId, int customerId);
}
