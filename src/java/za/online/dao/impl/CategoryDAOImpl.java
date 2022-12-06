/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.dao.impl;

import za.online.bean.Category;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.online.dao.CategoryDAO;
import za.online.db.ConnectToBD;

/**
 *
 * @author Train
 */
public class CategoryDAOImpl implements CategoryDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public CategoryDAOImpl() {
        con = ConnectToBD.getConnection();
    }
// ****************************************************************************************
    String productPicture = "picture/";

    @Override
    public boolean addCategory(Category category) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Insert into category(categoryName,categoryPiture, active) values(?,?, true)");
                ps.setString(1, category.getCategoryName());
                ps.setString(2, productPicture + category.getCategoryPic());
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
// ****************************************************************************************

    @Override
    public boolean updateCategoryName(int categoryId, String name) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE category SET categoryName = ?,  WHERE categoryId = ?");
                ps.setString(1, name);
                ps.setInt(2, categoryId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Category name:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    //....................................................................................
    public Category getCategory(int id) {

        Category category = null;

        try {
            String sql = "Select * from category where categoryId = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                int cid = rs.getInt("categoryId");
                String name = rs.getString("categoryName");
                String pic = rs.getString("categoryPicture");
                boolean active = rs.getBoolean("active");

                category = new Category(cid, name, pic, active);
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return category;

    }

// ****************************************************************************************
    @Override
    public boolean updateCategory(Category category) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE category SET categoryName = ?  ,active = ? WHERE categoryId = ?");
                ps.setString(1, category.getCategoryName());
                ps.setBoolean(2, category.isActive());
             
                ps.setInt(3, category.getCategoryId());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Category picture:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    // ****************************************************************************************
    @Override
    public boolean removeCategory(int categoryId) {

        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE category SET active = false WHERE categoryId = ?");
                ps.setInt(1, categoryId);
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
    //-----------------------------------------------------------------------------------------------
    //Set Active to false 
    public void setActiveStatus(int id) {
        Category category = new Category();

        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE category SET active = ? WHERE categoryId = ?");

                ps.setInt(2, id);
                ps.setBoolean(1, false);
                if (ps.executeUpdate() > 0) {
                    System.out.println("Your category is no longer active");
                } else {
                    System.out.println("Set active failed");
                }

            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Category picture:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }

    }

    // ****************************************************************************************
    @Override
    public List<Category> viewAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from category where active = true");
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
    //=-----------------------------------------------------------
    //This is for admin

//    @Override
//    public List<Category> AdminviewAllCategory() {
//        List<Category> categoryList = new ArrayList<>();
//        if (con != null) {
//            try {
//                ps = con.prepareStatement("select * from category");
//                rs = ps.executeQuery();
//                while (rs.next()) {
//                    Category category = new Category();
//                    category.setCategoryId(rs.getInt("categoryId"));
//                    category.setCategoryName(rs.getString("categoryName"));
//                    category.setCategoryPic(rs.getString("categoryPicture"));
//                    category.setActive(rs.getBoolean("active"));
//                    categoryList.add(category);
//                }
//            } catch (SQLException ex) {
//                System.out.println("Error Failed To Read Category Table :" + ex.getMessage());
//            } finally {
//                closeIfNotNull();
//            }
//        }
//        return categoryList;
//    }

    // ****************************************************************************************
    @Override
    public Category viewOneCategory(int categoryId) {
        Category category = new Category();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from category where categoryId = ?");
                ps.setInt(1, categoryId);
                rs = ps.executeQuery();
                rs.beforeFirst();
                while (rs.next()) {
                    category.setCategoryId(rs.getInt("categoryId"));
                    category.setCategoryName(rs.getString("categoryName"));
                    category.setCategoryPic(rs.getString("categoryPic"));
                    category.setActive(rs.getBoolean("active"));
                }

            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Category Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return category;
    }

    // ****************************************************************************************
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
