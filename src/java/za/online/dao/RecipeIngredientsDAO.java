package za.online.dao;

import java.util.List;
import za.online.bean.RecipeIngrediants;

public interface RecipeIngredientsDAO {

    public boolean addRecipeIngrediants(RecipeIngrediants recipeIngredients);

    public boolean removeRecipeIngrediants(int recipeId, int IngredientId);

    public boolean removeRecipe(int recipeId);

    public boolean removeAllRecipeIngrediants();

    public List<RecipeIngrediants> getllRecipeIngrediants();

    public List<RecipeIngrediants> getOneRecipe(int recipeId);

    public RecipeIngrediants getOneRecipeIngrediants(int recipeId, int IngredientId);

    public boolean updateRecipeId(int recipeId, int newRecipeId);

    public boolean updateQuantity(int recipeId, int newQuantity);

    public boolean updateIngredientsId(int recipeId, int newIngredientsId);

    public boolean updateOneRecipeId(int recipeId, int IngredientId, int newRecipeId);

    public boolean updateOneQuantity(int recipeId, int IngredientId, int newQuantity);

    public boolean updateOneIngredientsId(int recipeId, int IngredientId, int newIngredientsId);
}
