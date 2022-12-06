/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.dao;

import java.util.List;
import za.online.bean.IngredientsInventory;

/**
 *
 * @author Train
 */
public interface IngredientsInventoryDAO {

    public boolean addIngrediantsInv(IngredientsInventory ingredientsInventory);

    public boolean removeIngrediantsInv(int ingredientsId);

    public boolean removeAllIngrediantsInv();

    public List<IngredientsInventory> getAllIngrediantsInv();

    public IngredientsInventory getOneIngredientsInv(int ingredientsId);

    public boolean updateAvailableStock(int ingredientsId, int newAvailableStock);

    public boolean updateMaxStock(int ingredientsId, int newMaxStock);

    // public boolean updateMinStock(int ingredientsId, newMinStock);
}
