/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service.impl;

import java.util.List;
import za.online.bean.Ingrediants;
import za.online.dao.IngredientsDAO;
import za.online.dao.impl.IngredientsDAOImpl;
import za.online.service.IngredientsService;

/**
 *
 * @author Train
 */
public class IngredientsServiceImpl implements IngredientsService{
    
    IngredientsDAO ingredientsDAO;

    public IngredientsServiceImpl() {
        this.ingredientsDAO = new IngredientsDAOImpl();
    }
    
    @Override
    public boolean addIngredients(Ingrediants ingredients) {
        if(ingredients == null){
        return false;
        }
        return ingredientsDAO.addIngredients(ingredients);
    }

    @Override
    public boolean removeIngrediants(int ingredientsId) {
        if(ingredientsId <= 0){
        return false;
        }
        return ingredientsDAO.removeIngrediants(ingredientsId);
    }

    @Override
    public boolean removeAllIngrediants() {
        return ingredientsDAO.removeAllIngrediants();
    }

    @Override
    public List<Ingrediants> getAllIngrediants() {
        return ingredientsDAO.getAllIngrediants();
    }

    @Override
    public Ingrediants getOneIngrediants(int ingredientsId) {
        if(ingredientsId <=0 ){
        return null;
        }
        return ingredientsDAO.getOneIngrediants(ingredientsId);
    }

    @Override
    public boolean updateIngrediantsName(int ingredientsId, String newIngredientsName) {
        if((ingredientsId <= 0) || (newIngredientsName == null)){
        return false;
        }
        return ingredientsDAO.updateIngrediantsName(ingredientsId, newIngredientsName);
    }
    
}
