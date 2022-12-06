package za.online.service;

import java.util.List;
import za.online.bean.Category;

/**
 *
 * @author Train
 */
public interface CategoryService {

    public boolean addCategory(Category category);

    public boolean updateCategoryName(int categoryId, String name);

    public boolean updateCategory(Category category);

    public boolean removeCategory(int categoryId);

    public List<Category> viewAllCategory();

  //  public List<Category> AdminviewAllCategory();

    public Category viewOneCategory(int categoryId);
    
  
    public Category getCategory(int categoryId);
    

}
