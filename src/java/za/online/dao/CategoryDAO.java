/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.dao;

import java.util.List;
import za.online.bean.Category;

/**
 *
 * @author Train
 */
public interface CategoryDAO {

    public boolean addCategory(Category category);

    public boolean updateCategoryName(int categoryId, String name);

    public  boolean updateCategory(Category category) ;

    public boolean removeCategory(int categoryId);
    
    public Category getCategory(int id);

    public List<Category> viewAllCategory();
   // public List<Category> AdminviewAllCategory();

    public Category viewOneCategory(int categoryId);

}
