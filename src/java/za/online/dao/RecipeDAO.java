
package za.online.dao;

import java.util.List;
import za.online.bean.Recipe;


public interface RecipeDAO {
    
    public boolean addRecipe(Recipe recipe);
    
    public boolean removeRecipe(int recipeId);
    
    public boolean removeAllRecipe();
    
    public List<Recipe> getllRecipe();
    
    public Recipe getOneRecipe(int recipeId);
    
    public boolean updateRecipeDesc(int recipeId,String newDesc);
    
    public boolean updateRecipeInstr(int recipeId,String newInstr);
    
    public boolean updateProductId(int recipeId,int newProductId);
    
    
}
