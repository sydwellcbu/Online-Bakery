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
import za.online.bean.Recipe;
import za.online.dao.RecipeDAO;
import za.online.db.ConnectToBD;

/**
 *
 * @author Train
 */
public class RecipeDAOImpl implements RecipeDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
    Recipe recipe;

    public RecipeDAOImpl() {
        this.con  = ConnectToBD.getConnection();
    }

    
    
    @Override
    public boolean addRecipe(Recipe recipe) {
        boolean retVal = false;
        if (con != null) {
            
       
            try {
                ps = con.prepareStatement("Insert into recipe(productId,recipeDesc,recipeInstr) values(?,?,?)");
                ps.setInt(1, recipe.getProductId());
                ps.setString(2, recipe.getRecipeDesc());
                ps.setString(3, recipe.getRecipeInstr());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Faile To Add Recipe :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeRecipe(int recipeId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from recipe where recipeId = ?");
                ps.setInt(1, recipeId);
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete From Recipe Table :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeAllRecipe() {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Truncate table recipe");
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete All Recipe Table :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public List<Recipe> getllRecipe() {
        List<Recipe> recipeList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from recipe");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Recipe recipe = new Recipe();
                    recipe.setProductId(rs.getInt("productId"));
                    recipe.setRecipeId(rs.getInt("recipeId"));
                    recipe.setRecipeDesc(rs.getString("recipeDesc"));
                    recipe.setRecipeInstr(rs.getString("recipeInstr"));
                    recipeList.add(recipe);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get All Recipe :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return recipeList;
    }

    @Override
    public Recipe getOneRecipe(int recipeId) {
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from recipe where recipeId  = ?");
                ps.setInt(1, recipeId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Recipe recipe = new Recipe();
                    recipe.setProductId(rs.getInt("productId"));
                    recipe.setRecipeId(rs.getInt("recipeId"));
                    recipe.setRecipeDesc(rs.getString("recipeDesc"));
                    recipe.setRecipeInstr(rs.getString("recipeInstr"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get One Recipe :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return recipe;

    }

    @Override
    public boolean updateRecipeDesc(int recipeId, String newDesc) {
          boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipe SET recipeDesc = ?  WHERE recipeId = ?");
                ps.setString(1, newDesc);
                ps.setInt(2, recipeId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Recipe Description :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateRecipeInstr(int recipeId, String newInstr) {
   boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipe SET recipeInstr = ?  WHERE recipeId = ?");
                ps.setString(1, newInstr);
                ps.setInt(2, recipeId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Recipe Instruction :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateProductId(int recipeId, int newProductId) {
          boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipe SET productId = ?  WHERE recipeId = ?");
                ps.setInt(1, newProductId);
                ps.setInt(2, recipeId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Recipe ProductId :" + ex.getMessage());
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
