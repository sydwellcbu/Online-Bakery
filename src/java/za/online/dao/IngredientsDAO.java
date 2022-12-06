package za.online.dao;

import java.util.List;
import za.online.bean.Ingrediants;

public interface IngredientsDAO {

    public boolean addIngredients(Ingrediants ingredients);

    public boolean removeIngrediants(int ingredientsId);

    public boolean removeAllIngrediants();

    public List<Ingrediants> getAllIngrediants();

    public Ingrediants getOneIngrediants(int ingredientsId);

    public boolean updateIngrediantsName(int ingredientsId, String newIngredientsName);

}
