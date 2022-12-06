/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.Category;
import za.online.bean.Payment;
import za.online.bean.Product;
import za.online.dao.ProductDAO;
import za.online.db.ConnectToBD;

/**
 *
 * @author Administrator
 */
public class ProductDAOImpl implements ProductDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
    Product product = new Product();

    public ProductDAOImpl() {
        con = ConnectToBD.getConnection();
    }
    LocalDate postedDate = LocalDate.now();

    String productPicture = "picture/";

    @Override
    public boolean addProduct(Product product) {
        boolean retVal = false;
        if (con != null) {
            try {
                String sql = "INSERT INTO product(productName,productPic,categoryId,productDesc,quantity,price,discount,active,postedDate ) values(?,?,?,?,?,?,?,true,?)";

                ps = con.prepareStatement(sql);

                ps.setString(1, product.getProductName());
                ps.setString(2, productPicture + product.getProductPic());
                ps.setInt(3, product.getCategoryId());
                ps.setString(4, product.getProductDesc());
                ps.setInt(5, product.getQuantity());
                ps.setDouble(6, product.getPrice());
                ps.setDouble(7, product.getDiscount());
                ps.setString(8, postedDate.toString());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Faile To Add Category :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeProduct(int productId) {

        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("DELETE from product WHERE productId = ?");
                ps.setInt(1, productId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To delete Category:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE product SET productName  = ? ,categoryId = ? ,productDesc = ?,"
                        + "quantity = ? ,price = ? ,discount = ? ,active = ?  WHERE productId = ?");

                ps.setString(1, product.getProductName());
              
                ps.setInt(2, product.getCategoryId());
                ps.setString(3, product.getProductDesc());
                ps.setInt(4, product. getQuantity());
                ps.setDouble(5, product.getPrice());
                ps.setDouble(6, product.getDiscount());
                ps.setBoolean(7, product.isActive());
                //  ps.setDate(9, product.getPostedDate());
                ps.setInt(8, product.getProductId());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update product name:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }
//Get product using category id 
    public List categoryProduct(int id) {

        List<Product> products = new ArrayList();
        if (con != null) {

            try {
                ps = con.prepareStatement("select * from product where categoryId = ? AND active = true");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("productId"));
                    product.setProductName(rs.getString("productName"));
                    product.setProductPic(rs.getString("productPic"));
                    product.setCategoryId(rs.getInt("categoryId"));
                    product.setProductDesc(rs.getString("productDesc"));
                    product.setQuantity(rs.getInt("quantity"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDiscount(rs.getDouble("discount"));

                    products.add(product);

                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Product Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }

        }
        return products;
    }

    @Override
    public boolean updateProductDesc(int productID, String newDesc) {

        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE product SET productDesc = ?  WHERE productId = ?");
                ps.setString(1, newDesc);
                ps.setInt(2, productID);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update product description:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateProductQuantity(int productID, int newQuantity) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE product SET quantity = ?,  WHERE productId = ?");
                ps.setInt(1, newQuantity);
                ps.setInt(2, productID);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update product quantity:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateProductDiscount(int productID, double newDiscount) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE product SET discount = ?,  WHERE productId = ?");
                ps.setDouble(1, newDiscount);
                ps.setInt(2, productID);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update product discount:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }

        }
        return retVal;
    }

    @Override
    public boolean updateProductPic(int productID, String newPic) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE product SET productPic = ?,  WHERE productId = ?");
                ps.setString(1, newPic);
                ps.setInt(2, productID);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update product picture:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateProductPrice(int productID, double newPrice) {

        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE product SET price = ?,  WHERE productId = ?");
                ps.setDouble(1, newPrice);
                ps.setInt(2, productID);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update product price:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }

        }
        return retVal;
    }

    @Override
    
    
    public List<Product> viewAllProduct() {
        List<Product> productList = new ArrayList<>();

        if (con != null) {
            try {
                ps = con.prepareStatement("select * from product where active = true");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    
                    product.setProductId(rs.getInt("productId"));
                    product.setProductName(rs.getString("productName"));
                    product.setProductPic(rs.getString("productPic"));
                    product.setCategoryId(rs.getInt("categoryId"));
                    product.setProductDesc(rs.getString("productDesc"));
                    product.setQuantity(rs.getInt("quantity"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDiscount(rs.getDouble("discount"));
                    product.setActive(rs.getBoolean("active"));
                    product.setPostedDate(rs.getDate("postedDate"));
                    productList.add(product);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Product Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return productList;
    }

    @Override
    public Product viewOneProduct(int productId) {
        Product product = new Product();
        if (con != null) {
            if (con != null) {
                try {
                    ps = con.prepareStatement("select productId,categoryId,productName,productPic,productDesc,quantity,price,discount,postedDate from product where productId = ?");
                    ps.setInt(1, productId);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        product.setProductId(rs.getInt("productId"));
                        product.setCategoryId(rs.getInt("categoryId"));
                        product.setProductName(rs.getString("productName"));
                        product.setProductPic(rs.getString("productPic"));
                        product.setProductDesc(rs.getString("productDesc"));
                        product.setQuantity(rs.getInt("quantity"));
                        product.setPrice(rs.getDouble("price"));
                        product.setDiscount(rs.getDouble("discount"));

                        product.setActive(rs.getBoolean("active"));

                        product.setPostedDate(rs.getDate("postedDate"));
                    }
                } catch (SQLException ex) {
                    System.out.println("Error Failed To Read Product Table :" + ex.getMessage());
                } finally {
                    closeIfNotNull();
                }
            }
        }
        return product;
    }
    
    
    //get category id using category name
   public int getCategoryId(String categoryName){
   
   
    String sql = "Select * from category where categoryName = ?";
    int id  = 0;
    if (con != null) {
              
                try {
                    ps = con.prepareStatement(sql);
                    ps.setString(1,categoryName );
                    rs = ps.executeQuery();
                    while (rs.next()) {
                     
                         id = rs.getInt("categoryId");
                        
                    }
                    
                }catch (SQLException ex){
                    
                    System.out.println(ex.getMessage()); 
                    
                }}
    
    
    
    return id;
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
