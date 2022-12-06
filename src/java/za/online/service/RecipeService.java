/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service;

import java.util.List;
import za.online.bean.Recipe;

/**
 *
 * @author Train
 */
public interface RecipeService {
   
      
    public boolean addRecipe(Recipe recipe);
    
    public boolean removeRecipe(int recipeId);
    
    public boolean removeAllRecipe();
    
    public List<Recipe> getllRecipe();
    
    public Recipe getOneRecipe(int recipeId);
    
    public boolean updateRecipeDesc(int recipeId,String newDesc);
    
    public boolean updateRecipeInstr(int recipeId,String newInstr);
    
    public boolean updateProductId(int recipeId,int newProductId);
}
