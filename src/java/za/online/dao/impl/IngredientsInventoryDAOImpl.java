package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.IngredientsInventory;
import za.online.dao.IngredientsInventoryDAO;
import za.online.db.ConnectToBD;

public class IngredientsInventoryDAOImpl implements IngredientsInventoryDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
    private IngredientsInventory ingredientsInventory;

    public IngredientsInventoryDAOImpl() {
        this.con = ConnectToBD.getConnection();
    }

    @Override
    public boolean addIngrediantsInv(IngredientsInventory ingredientsInventory) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Insert into ingredientsinventory(ingredientsId,availableStock,maxStock) values(?,?,?)");
                ps.setInt(1, ingredientsInventory.getIngredientsId());
                ps.setInt(2, ingredientsInventory.getAvailableStock());
                ps.setInt(3, ingredientsInventory.getMaxStock());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Faile To Add Ingredients Invetory :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeIngrediantsInv(int ingredientsId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from ingredientsinventory where ingredientsId = ?");
                ps.setInt(1, ingredientsId);
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete ingredients Inventory :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeAllIngrediantsInv() {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Truncate table ingredientsinventory");
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete All Ingredients In Inventory:" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public List<IngredientsInventory> getAllIngrediantsInv() {
        List<IngredientsInventory> IngredientsInventoryList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from ingredientsinventory");
                rs = ps.executeQuery();
                while (rs.next()) {
                    ingredientsInventory = new IngredientsInventory();
                    ingredientsInventory.setIngredientsId(rs.getInt("ingredientsId"));
                    ingredientsInventory.setAvailableStock(rs.getInt("availableStock"));
                    ingredientsInventory.setMaxStock(rs.getInt("maxStock"));
                    ingredientsInventory.setMinStock(rs.getInt("minStock"));
                    IngredientsInventoryList.add(ingredientsInventory);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get All Ingredients In Inventory :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return IngredientsInventoryList;
    }

    @Override
    public IngredientsInventory getOneIngredientsInv(int ingredientsId) {
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from ingredientsinventory where ingredientsId = ? ");
                ps.setInt(1, ingredientsId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ingredientsInventory = new IngredientsInventory();
                    ingredientsInventory.setIngredientsId(rs.getInt("ingredientsId"));
                    ingredientsInventory.setAvailableStock(rs.getInt("availableStock"));
                    ingredientsInventory.setMaxStock(rs.getInt("maxStock"));
                      ingredientsInventory.setMinStock(rs.getInt("minStock"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get One Ingredients In Inventory :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return ingredientsInventory;
    }

    @Override
    public boolean updateAvailableStock(int ingredientsId, int newAvailableStock) {
            boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE ingredientsinventory SET availableStock = ?  WHERE ingredientsId = ?");
                ps.setInt(1, newAvailableStock);
                ps.setInt(2, ingredientsId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Available Stock From Ingredients Invetory :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateMaxStock(int ingredientsId, int newMaxStock) {
               boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE ingredientsinventory SET availableStock = ?  WHERE ingredientsId = ?");
                ps.setInt(1, newMaxStock);
                ps.setInt(2, ingredientsId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Maximun Order From Ingredients Invetory :" + ex.getMessage());
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
