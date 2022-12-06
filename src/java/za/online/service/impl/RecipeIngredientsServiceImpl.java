package za.online.service.impl;

import java.util.List;
import za.online.bean.RecipeIngrediants;
import za.online.dao.RecipeIngredientsDAO;
import za.online.dao.impl.RecipeIngredientsDAOImpl;
import za.online.service.RecipeIngredientsService;

/**
 *
 * @author Train
 */
public class RecipeIngredientsServiceImpl implements RecipeIngredientsService {

    RecipeIngredientsDAO recipeIngredientsDAO;

    public RecipeIngredientsServiceImpl() {
        this.recipeIngredientsDAO = new RecipeIngredientsDAOImpl();
    }

    @Override
    public boolean addRecipeIngrediants(RecipeIngrediants recipeIngredients) {
        if (recipeIngredients == null) {
            return false;
        }
        return recipeIngredientsDAO.addRecipeIngrediants(recipeIngredients);
    }

    @Override
    public boolean removeRecipeIngrediants(int recipeId, int ingredientId) {
        if ((recipeId <= 0) || (ingredientId <= 0)) {
            return false;
        }
        return recipeIngredientsDAO.removeRecipeIngrediants(recipeId, ingredientId);
    }

    @Override
    public boolean removeRecipe(int recipeId) {
        if (recipeId <= 0) {
            return false;
        }
        return recipeIngredientsDAO.removeRecipe(recipeId);
    }

    @Override
    public boolean removeAllRecipeIngrediants() {
        return recipeIngredientsDAO.removeAllRecipeIngrediants();
    }

    @Override
    public List<RecipeIngrediants> getllRecipeIngrediants() {
        return recipeIngredientsDAO.getllRecipeIngrediants();
    }

    @Override
    public List<RecipeIngrediants> getOneRecipe(int recipeId) {
        if (recipeId < 0) {
            return null;
        }
        return recipeIngredientsDAO.getOneRecipe(recipeId);
    }

    @Override
    public RecipeIngrediants getOneRecipeIngrediants(int recipeId, int ingredientId) {
        if ((recipeId < 0) || (ingredientId <= 0)) {
            return null;
        }
        return recipeIngredientsDAO.getOneRecipeIngrediants(recipeId, ingredientId);
    }

    @Override
    public boolean updateRecipeId(int recipeId, int newRecipeId) {
        if ((recipeId < 0) || (newRecipeId <= 0)) {
            return false;
        }
        return recipeIngredientsDAO.updateRecipeId(recipeId, newRecipeId);
    }

    @Override
    public boolean updateQuantity(int recipeId, int newQuantity) {
        if (recipeId <=  0) {
            return false;
        }
        return recipeIngredientsDAO.updateQuantity(recipeId, newQuantity);
    }

    @Override
    public boolean updateIngredientsId(int recipeId, int newIngredientsId) {
        if ((recipeId < 0) || (newIngredientsId <= 0)) {
            return false;
        }
        return recipeIngredientsDAO.updateIngredientsId(recipeId, newIngredientsId);
    }

    @Override
    public boolean updateOneRecipeId(int recipeId, int IngredientId, int newRecipeId) {
        if((recipeId <=  0) || (IngredientId <= 0) || (newRecipeId <= 0)){
        return false;
        }
        return recipeIngredientsDAO.updateOneRecipeId(recipeId, IngredientId, newRecipeId);
    }

    @Override
    public boolean updateOneQuantity(int recipeId, int IngredientId, int newQuantity) {
           if((recipeId <=  0) || (IngredientId <= 0)){
        return false;
        }
           return recipeIngredientsDAO.updateOneQuantity(recipeId, IngredientId, newQuantity);
    }

    @Override
    public boolean updateOneIngredientsId(int recipeId, int IngredientId, int newIngredientsId) {
             if((recipeId <=  0) || (IngredientId <= 0) || (newIngredientsId <= 0)){
        return false;
        }
             return recipeIngredientsDAO.updateOneIngredientsId(recipeId, IngredientId, newIngredientsId);
    }

}
