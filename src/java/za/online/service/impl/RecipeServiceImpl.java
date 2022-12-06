package za.online.service.impl;

import java.util.List;
import za.online.bean.Recipe;
import za.online.dao.RecipeDAO;
import za.online.dao.impl.RecipeDAOImpl;
import za.online.service.RecipeService;

public class RecipeServiceImpl implements RecipeService {

    RecipeDAO recipeDAO;

    public RecipeServiceImpl() {
        this.recipeDAO = new RecipeDAOImpl();
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        if (recipe == null) {
            return false;
        }
        return recipeDAO.addRecipe(recipe);
    }

    @Override
    public boolean removeRecipe(int recipeId) {
        if (recipeId <= 0) {
            return false;
        }
        return recipeDAO.removeRecipe(recipeId);
    }

    @Override
    public boolean removeAllRecipe() {
        return recipeDAO.removeAllRecipe();
    }

    @Override
    public List<Recipe> getllRecipe() {
        return recipeDAO.getllRecipe();
    }

    @Override
    public Recipe getOneRecipe(int recipeId) {
        if (recipeId <= 0) {
            return null;
        }
        return recipeDAO.getOneRecipe(recipeId);
    }

    @Override
    public boolean updateRecipeDesc(int recipeId, String newDesc) {
        if ((recipeId <= 0) || (newDesc == null)) {
            return false;
        }
        return recipeDAO.updateRecipeDesc(recipeId, newDesc);
    }

    @Override
    public boolean updateRecipeInstr(int recipeId, String newInstr) {
        if ((recipeId <= 0) || (newInstr == null)) {
            return false;
        }
        return recipeDAO.updateRecipeInstr(recipeId, newInstr);
    }

    @Override
    public boolean updateProductId(int recipeId, int newProductId) {
        if ((recipeId <= 0) || (newProductId <= 0)) {
            return false;
        }
        return recipeDAO.updateProductId(recipeId, newProductId);
    }

}
