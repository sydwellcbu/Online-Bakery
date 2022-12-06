/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service.impl;

import java.util.List;
import za.online.bean.Category;
import za.online.dao.CategoryDAO;
import za.online.dao.impl.CategoryDAOImpl;
import za.online.service.CategoryService;

/**
 *
 * @author Train
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    public CategoryServiceImpl() {
        categoryDAO = new CategoryDAOImpl();
    }

    @Override
    public boolean addCategory(Category category) {
//       if(category== null){
//           return false;
//       }
//       return categoryDAO.addCategory(category);
        return category == null ? false : categoryDAO.addCategory(category);
    }

    @Override
    public boolean updateCategoryName(int categoryId, String name) {
        if (categoryId < 1 || name == null || name.trim().isEmpty()) {
            return false;
        }
        return categoryDAO.updateCategoryName(categoryId, name);
    }

    @Override
    public boolean updateCategory(Category category) {
        if (category.getCategoryId() < 1) {
            return false;
        }
        return categoryDAO.updateCategory(category);
    }
    @Override
    public boolean removeCategory(int categoryId) {
        if (categoryId < 1) {
            return false;
        }
        return categoryDAO.removeCategory(categoryId);
    }

    @Override
    public List<Category> viewAllCategory() {
        return categoryDAO.viewAllCategory();
    }
//    @Override
//    public List<Category> AdminviewAllCategory() {
//        return categoryDAO.AdminviewAllCategory();
//    }

    @Override
    public Category viewOneCategory(int categoryId) {
        if (categoryId < 1) {
            return null;
        }
        return categoryDAO.viewOneCategory(categoryId);
    }


        @Override
    public Category getCategory(int categoryId) {
        if (categoryId < 1) {
            return null;
        }
        return categoryDAO.getCategory(categoryId);
    }
    
    
    
    
    
    
    
    
}
