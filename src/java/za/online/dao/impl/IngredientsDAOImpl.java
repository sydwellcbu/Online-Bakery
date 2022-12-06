package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.Ingrediants;
import za.online.bean.Recipe;
import za.online.dao.IngredientsDAO;
import za.online.db.ConnectToBD;

public class IngredientsDAOImpl implements IngredientsDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
    private Ingrediants ingrediants;

    public IngredientsDAOImpl() {
        this.con = ConnectToBD.getConnection();
    }

    @Override
    public boolean addIngredients(Ingrediants ingredients) {
        boolean retVal = false;
        if (con != null) {
            int ingredientsId;
            String ingredientsName;
            try {
                ps = con.prepareStatement("Insert into ingredients(ingredientsId,ingredientsName) values(nulll,?)");
                ps.setString(1, ingredients.getIngredientsName());
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Faile To Add Ingrediants :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeIngrediants(int ingredientsId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("delete from ingredients where ingredientsId = ?");
                ps.setInt(1, ingredientsId);
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete ingredients :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean removeAllIngrediants() {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("Truncate table ingredients");
                ps.executeQuery();
            } catch (SQLException e) {
                System.out.println("Failed To Delete All ingredients :" + e.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public List<Ingrediants> getAllIngrediants() {
        List<Ingrediants> ingrediantsList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from ingrediants");
                rs = ps.executeQuery();
                while (rs.next()) {
                    ingrediants = new Ingrediants();
                    ingrediants.setIngredientsId(rs.getInt("ingridientsId"));
                    ingrediants.setIngredientsName(rs.getString("ingrediantsName"));
                    ingrediantsList.add(ingrediants);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get All ingrediants :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return ingrediantsList;
    }

    @Override
    public Ingrediants getOneIngrediants(int ingredientsId) {
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from ingredients where ingredientsId  = ?");
                ps.setInt(1, ingredientsId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ingrediants = new Ingrediants();
                    ingrediants.setIngredientsId(rs.getInt("ingrediantsId"));
                    ingrediants.setIngredientsName(rs.getString("ingrediantsName"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Get One Ingredients :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return ingrediants;
    }

    @Override
    public boolean updateIngrediantsName(int ingredientsId, String newIngredientsName) {
           boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE ingredients SET ingredientsName = ?  WHERE ingredientsId = ?");
                ps.setString(1, newIngredientsName);
                ps.setInt(2, ingredientsId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Ingredients Name :" + ex.getMessage());
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
