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
import java.util.ArrayList;
import java.util.List;
import za.online.bean.Admin;
import za.online.bean.Category;
import za.online.bean.Customer;
import za.online.bean.Product;
import za.online.dao.AdminDAO;
import za.online.db.ConnectToBD;

/**
 *
 * @author Administrator
 */
public class AdminDAOImpl implements AdminDAO {
    
        private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public AdminDAOImpl() {
        con = ConnectToBD.getConnection();
    }
      
    @Override
    public List<Product> viewAllProduct() {
        List<Product> productList = new ArrayList<>();

        if (con != null) {
            try {
                ps = con.prepareStatement("select * from product");
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
    public List<Category> AdminviewAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from category");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Category category = new Category();
                    category.setCategoryId(rs.getInt("categoryId"));
                    category.setCategoryName(rs.getString("categoryName"));
                    category.setCategoryPic(rs.getString("categoryPicture"));
                    category.setActive(rs.getBoolean("active"));
                    categoryList.add(category);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Category Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return categoryList;
    }
    
    @Override
    public boolean addAdmin(Admin admin) {
           boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Insert into user values(?,?,?,?,?,?,true, true)");
                ps.setString(1, admin.getFirstName());
                ps.setString(2, admin.getLastName());
                ps.setString(3, admin.getEmail());
                ps.setString(4, admin.getTelephone());
                ps.setString(5, admin.getTittle());
                ps.setString(6, admin.getAddress());
                ps.setString(7, admin.getPassword());
                ps.setString(8, admin.getPassword());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Faile To Add Admin :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public List<Admin> viewAllAdmins(Admin admin) {
           List<Admin> adminList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select adminId,firstName,lastName,email,telephone,tittle,address,active from admin");
                rs = ps.executeQuery();
                while (rs.next()) {
                    admin.setAdminId(rs.getInt("adminId"));
                    admin.setFirstName(rs.getString("firstName"));
                    admin.setLastName(rs.getString("lastName"));
                    admin.setAddress(rs.getString("address"));
                    admin.setEmail(rs.getString("email"));
                    admin.setTelephone(rs.getString("telephone"));
                    admin.setTittle(rs.getString("tittle"));
                    admin.setIsActive(rs.getBoolean("active"));
                    adminList.add(admin);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Admin Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return adminList;
    }

    public Customer viewMyProfile( String email) {
        
     List profile = new ArrayList(); 
        Customer customer = null;
            if (con != null) {
         
            try {
                ps = con.prepareStatement("select * from user where isAdmin = true AND email = ?");
                ps.setString(1, email);
                rs = ps.executeQuery();
              
                while (rs.next()) {
                 
                    String name = rs.getString("firstName");
                   String last = rs.getString("lastName");
                   String address = rs.getString("address");
                   String pass = rs.getString("password");
                   
                    email = rs.getString("email");
                   
                    String tel = (rs.getString("telephone"));
                    String title  =(rs.getString("tittle"));
                    boolean active = (rs.getBoolean("active"));
                    boolean isAdmin = (rs.getBoolean("isAdmin"));
              
             customer = new Customer(name ,last ,address,email,tel,title ,pass ,active,isAdmin);
                    
                    
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Admin Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return customer;
    }
    @Override
    public Admin viewOneAdmin(int adminId, Admin admin) {
            if (con != null) {
            try {
                ps = con.prepareStatement("select * from user where isAdmin = true AND email = ?");
                rs = ps.executeQuery();
                while (rs.next()) {
                    admin.setAdminId(rs.getInt("adminId"));
                    admin.setFirstName(rs.getString("firstName"));
                    admin.setLastName(rs.getString("lastName"));
                    admin.setAddress(rs.getString("address"));
                    admin.setEmail(rs.getString("email"));
                    admin.setTelephone(rs.getString("telephone"));
                    admin.setTittle(rs.getString("tittle"));
                    admin.setActive(rs.getBoolean("active"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Admin Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return admin;
    }

    @Override
    public boolean removeAdmin(int adminId) {
         boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE admin SET active = false WHERE adminId = ?");
                ps.setInt(1, adminId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To delete Customer:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateAdminFirstName(int adminId, String newFirstName) {
              boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE admin SET firstName = ?  WHERE adminId = ?");
                ps.setString(1, newFirstName);
                ps.setInt(2, adminId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Admin Name:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateAdminLastName(int adminId, String newLastName) {
          boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE admin SET lastName = ?,  WHERE adminId = ?");
                ps.setString(1, newLastName);
                ps.setInt(2, adminId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Admin lastName:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateAddress(int adminId, String newAddress) {
       boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE admin SET address = ?,  WHERE adminId = ?");
                ps.setString(1, newAddress);
                ps.setInt(2, adminId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Admin address:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updatEmail(int adminId, String newEmail) {
    boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE admin SET email = ?,  WHERE adminId = ?");
                ps.setString(1, newEmail);
                ps.setInt(2, adminId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Admin Email:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateTelephone(int adminId, String newTelephone) {
           boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE admin SET telephone = ?,  WHERE adminId = ?");
                ps.setString(1, newTelephone);
                ps.setInt(2, adminId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Admin Telephone:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateTittle(int adminId, String newTittle) {
           boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE admin SET tittle = ?,  WHERE adminId = ?");
                ps.setString(1, newTittle);
                ps.setInt(2, adminId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Admin Tittle:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updatePassword(int adminId, String newPasword) {
               boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE admin SET password = ?,  WHERE adminId = ?");
                ps.setString(1, newPasword);
                ps.setInt(2, adminId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Admin Password:" + ex.getMessage());
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