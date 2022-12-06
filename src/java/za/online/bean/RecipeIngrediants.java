/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.bean;


public class RecipeIngrediants {
    
    private int recipeId;
    private int ingredientsId;
    private int quantity;
    private int productId;
    

    public RecipeIngrediants() {
    }

    public RecipeIngrediants(int recipeId, int ingredientsId, int quantity, int productId) {
        this.recipeId = recipeId;
        this.ingredientsId = ingredientsId;
        this.quantity = quantity;
        this.productId = productId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }

    public void setIngredientsId(int ingredientsId) {
        this.ingredientsId = ingredientsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "RecipeIngrediants{" + "recipeId=" + recipeId + ", ingredientsId=" + ingredientsId + ", quantity=" + quantity + ", productId=" + productId + '}';
    }

   
    
    
}
