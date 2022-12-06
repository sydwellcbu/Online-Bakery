/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service.impl;

import java.util.List;
import za.online.bean.Product;
import za.online.dao.ProductDAO;
import za.online.dao.impl.ProductDAOImpl;
import za.online.service.ProductService;

/**
 *
 * @author Train
 */
public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO;

    public ProductServiceImpl() {
        this.productDAO = new ProductDAOImpl();
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null) {
            return false;
        }
        return productDAO.addProduct(product);
    }

    @Override
    public boolean removeProduct(int productId) {
        if (productId < 1) {
            return false;
        }
        return productDAO.removeProduct(productId);
    }

    @Override
    public boolean updateProduct(Product product) {
        if ( product.getProductId() < 1 || product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            return false;
        }
        return productDAO.updateProduct(product);
    }


    @Override
    public boolean updateProductDesc(int productID, String productDesc) {
        if (productID < 1 || productDesc == null || productDesc.trim().isEmpty()) {
            return false;
        }
        return productDAO.updateProductDesc(productID, productDesc);
    }

    @Override
    public boolean updateProductQuantity(int productID, int productQuantity) {
        if (productID < 1 || productQuantity < 1) {
            return false;
        }
        return productDAO.updateProductQuantity(productID, productQuantity);
    }

    @Override
    public boolean updateProductDiscount(int productID, double newDiscount) {
        if (productID < 1 || newDiscount < 1) {
            return false;
        }
        return productDAO.updateProductDiscount(productID, newDiscount);
    }

    @Override
    public boolean updateProductPic(int productID, String newPic) {
        if (productID < 1 || newPic == null || newPic.trim().isEmpty()) {
            return false;
        }
        return productDAO.updateProductPic(productID, newPic);
    }

    @Override
    public boolean updateProductPrice(int productID, double newPrice) {
        if (productID < 1 || newPrice < 1) {
            return false;
        }
        return productDAO.updateProductPrice(productID, newPrice);
    }

    @Override
    public List<Product> viewAllProduct() {
        return productDAO.viewAllProduct();
    }

    @Override
    public Product viewOneProduct(int productId) {
        if (productId < 1) {
            return null;
        }
        return productDAO.viewOneProduct(productId);
    }

    @Override
    public int getCategoryId(String categoryName) {
    Product product = new Product();
        if (product.getCategoryId() > 0) {
            return 0 ;
        }
  
return productDAO.getCategoryId(categoryName);
    

    }
    
   

}
