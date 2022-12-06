/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service;

import java.util.List;
import za.online.bean.RecipeIngrediants;

/**
 *
 * @author Train
 */
public interface RecipeIngredientsService {
    
    
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
