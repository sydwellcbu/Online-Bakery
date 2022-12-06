/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.bean;


public class Ingrediants {
   private int ingredientsId;
    private String ingredientsName; 

    public Ingrediants() {
    }

    public Ingrediants(int ingredientsId, String ingredientsName) {
        this.ingredientsId = ingredientsId;
        this.ingredientsName = ingredientsName;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }

    public void setIngredientsId(int ingredientsId) {
        this.ingredientsId = ingredientsId;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

    @Override
    public String toString() {
        return "Ingrediants{" + "ingredientsId=" + ingredientsId + ", ingredientsName=" + ingredientsName + '}';
    }
    
    
}
