package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.RecipeIngrediants;
import za.online.db.ConnectToBD;
import za.online.dao.RecipeIngredientsDAO;

public class RecipeIngredientsDAOImpl implements RecipeIngredientsDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
    private RecipeIngrediants recipeIngredients;

    public RecipeIngredientsDAOImpl() {
        this.con = ConnectToBD.getConnection();
    }

    @Override
    public boolean addRecipeIngrediants(RecipeIngrediants recipeIngredients) {
        boolean retVal = false;
        if (con != null) {

            try {
                ps = con.prepareStatement("Insert into recipeingridients(recipeId,ingridientsId,quantity) values(?,?,?)");
                ps.setInt(1, recipeIngredients.getRecipeId());
                ps.setInt(2, recipeIngredients.getIngredientsId());
                ps.setInt(3, recipeIngredients.getQuantity());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Faile To Add Recipe Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeRecipeIngrediants(int recipeId, int IngredientId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from recipe where recipeId = ? And ingredientId");
                ps.setInt(1, recipeId);
                ps.setInt(2, IngredientId);
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete Recipe and Ingredients :" + e.getMessage());
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
                ps = con.prepareStatement("delete from recipeingredients where recipeId = ?");
                ps.setInt(1, recipeId);
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete Recipe :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeAllRecipeIngrediants() {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Truncate table recipeingrediants");
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete All Recipe and Ingredients :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public List<RecipeIngrediants> getllRecipeIngrediants() {
        List<RecipeIngrediants> recipeIngredientsList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from recipeingredients");
                rs = ps.executeQuery();
                while (rs.next()) {
                    recipeIngredients = new RecipeIngrediants();
                    recipeIngredients.setIngredientsId(rs.getInt("ingredientsId"));
                    recipeIngredients.setQuantity(rs.getInt("quantity"));
                    recipeIngredients.setRecipeId(rs.getInt("recipeId"));
                    recipeIngredientsList.add(recipeIngredients);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get All Recipe And Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return recipeIngredientsList;
    }

    @Override
    public List<RecipeIngrediants> getOneRecipe(int recipeId) {
        List<RecipeIngrediants> recipeIngredientsList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from recipeingredients where recipeId = ?");
                ps.setInt(1, recipeId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    RecipeIngrediants recipeIngredients = new RecipeIngrediants();
                    recipeIngredients.setIngredientsId(rs.getInt("ingredientsId"));
                    recipeIngredients.setQuantity(rs.getInt("quantity"));
                    recipeIngredients.setRecipeId(rs.getInt("recipeId"));
                    recipeIngredientsList.add(recipeIngredients);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get Recipe And Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return recipeIngredientsList;
    }

    @Override
    public RecipeIngrediants getOneRecipeIngrediants(int recipeId, int IngredientId) {
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from recipeingredients where recipeId = ?  and ingredientsId = ?");
                ps.setInt(1, recipeId);
                ps.setInt(2, IngredientId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    RecipeIngrediants recipeIngredients = new RecipeIngrediants();
                    recipeIngredients.setIngredientsId(rs.getInt("ingredientsId"));
                    recipeIngredients.setQuantity(rs.getInt("quantity"));
                    recipeIngredients.setRecipeId(rs.getInt("recipeId"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get One Recipe And Ingredient :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return recipeIngredients;
    }

    @Override
    public boolean updateRecipeId(int recipeId, int newRecipeId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipeingredients SET recipeId = ?  WHERE recipeId = ?");
                ps.setInt(1, newRecipeId);
                ps.setInt(2, recipeId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update RecipeId From Recipe Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateQuantity(int recipeId, int newQuantity) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipeingredients SET quantity = ?  WHERE recipeId = ?");
                ps.setInt(1, newQuantity);
                ps.setInt(2, recipeId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update quantity From Recipe Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateIngredientsId(int recipeId, int newIngredientsId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipeingredients SET ingredientsId = ?  WHERE recipeId = ?");
                ps.setInt(1, newIngredientsId);
                ps.setInt(2, recipeId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update IngredientsId From Recipe Ingredients :" + ex.getMessage());
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
    public boolean updateOneRecipeId(int recipeId, int IngredientId, int newRecipeId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipeingredients SET recipeId = ?  WHERE recipeId = ? and ingredientsId = ?");
                ps.setInt(1, newRecipeId);
                ps.setInt(2, recipeId);
                ps.setInt(2, IngredientId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update RecipeId From Recipe Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateOneQuantity(int recipeId, int IngredientId, int newQuantity) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipeingredients SET quantity = ?  WHERE recipeId = ? and ingredientsId = ?");
                ps.setInt(1, newQuantity);
                ps.setInt(2, recipeId);
                ps.setInt(3, IngredientId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update quantity From Recipe Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateOneIngredientsId(int recipeId, int IngredientId, int newIngredientsId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE recipeingredients SET ingredientsId = ?  WHERE recipeId = ? and ingredientsId = ?");
                ps.setInt(1, newIngredientsId);
                ps.setInt(2, recipeId);
                ps.setInt(3, IngredientId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update IngredientsId From Recipe Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }
}
