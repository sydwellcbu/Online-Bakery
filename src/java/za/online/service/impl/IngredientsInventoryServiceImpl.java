package za.online.service.impl;

import java.util.List;
import za.online.bean.IngredientsInventory;
import za.online.dao.IngredientsInventoryDAO;
import za.online.dao.impl.IngredientsInventoryDAOImpl;
import za.online.service.IngredientsInventoryService;

public class IngredientsInventoryServiceImpl implements IngredientsInventoryService {

    IngredientsInventoryDAO ingredientsInventoryDAO;

    public IngredientsInventoryServiceImpl() {
        this.ingredientsInventoryDAO = new IngredientsInventoryDAOImpl();
    }

    @Override
    public boolean addIngrediantsInv(IngredientsInventory ingredientsInventory) {
        if (ingredientsInventory == null) {
            return false;
        }
        return ingredientsInventoryDAO.addIngrediantsInv(ingredientsInventory);
    }

    @Override
    public boolean removeIngrediantsInv(int ingredientsId) {
        if (ingredientsId <= 0) {
            return false;
        }
        return ingredientsInventoryDAO.removeIngrediantsInv(ingredientsId);
    }

    @Override
    public boolean removeAllIngrediantsInv() {
        return ingredientsInventoryDAO.removeAllIngrediantsInv();
    }

    @Override
    public List<IngredientsInventory> getAllIngrediantsInv() {
        return ingredientsInventoryDAO.getAllIngrediantsInv();
    }

    @Override
    public IngredientsInventory getOneIngredientsInv(int ingredientsId) {
        if (ingredientsId <= 0) {
            return null;
        }
        return ingredientsInventoryDAO.getOneIngredientsInv(ingredientsId);
    }

    @Override
    public boolean updateAvailableStock(int ingredientsId, int newAvailableStock) {
        if (ingredientsId <= 0) {
            return false;
        }
        return ingredientsInventoryDAO.updateAvailableStock(ingredientsId, newAvailableStock);
    }

    @Override
    public boolean updateMaxStock(int ingredientsId, int newMaxStock) {
        if (ingredientsId <= 0) {
            return false;
        }
        return ingredientsInventoryDAO.updateMaxStock(ingredientsId, newMaxStock);
    }

}
