
package za.online.service;

import java.util.List;
import za.online.bean.IngredientsInventory;

public interface IngredientsInventoryService {
    
    
    
    public boolean addIngrediantsInv(IngredientsInventory ingredientsInventory);

    public boolean removeIngrediantsInv(int ingredientsId);

    public boolean removeAllIngrediantsInv();

    public List<IngredientsInventory> getAllIngrediantsInv();

    public IngredientsInventory getOneIngredientsInv(int ingredientsId);

    public boolean updateAvailableStock(int ingredientsId, int newAvailableStock);

    public boolean updateMaxStock(int ingredientsId, int newMaxStock);
}
