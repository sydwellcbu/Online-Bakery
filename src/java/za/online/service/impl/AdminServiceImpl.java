/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service.impl;

import java.util.List;
import za.online.bean.Admin;
import za.online.bean.Category;
import za.online.bean.Product;
import za.online.dao.AdminDAO;
import za.online.dao.impl.AdminDAOImpl;
import za.online.service.AdminService;

/**
 *
 * @author Train
 */
public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO;

    public AdminServiceImpl() {
        this.adminDAO = new AdminDAOImpl();
    }

    @Override
    public List<Category> AdminviewAllCategory() {
        return adminDAO.AdminviewAllCategory();
    }
       @Override
    public List<Product> viewAllProduct() {
        return adminDAO.viewAllProduct();
    }

    
    @Override
    public boolean addAdmin(Admin admin) {
        if (admin == null) {
            return false;
        }
        return adminDAO.addAdmin(admin);
    }

    @Override
    public List<Admin> viewAllAdmins(Admin admin) {
        return adminDAO.viewAllAdmins(admin);
    }

    @Override
    public Admin viewOneAdmin(int adminId, Admin admin) {
        if (adminId < 1) {
            return null;
        }
        return adminDAO.viewOneAdmin(adminId, admin);
    }

    @Override
    public boolean removeAdmin(int adminId) {
        if (adminId < 1) {
            return false;
        }
        return adminDAO.removeAdmin(adminId);
    }

    @Override
    public boolean updateAdminFirstName(int adminId, String newFirstName) {
        if (adminId < 1 || newFirstName == null || newFirstName.trim().isEmpty()) {
            return false;
        }
        return adminDAO.updateAdminFirstName(adminId, newFirstName);
    }

    @Override
    public boolean updateAdminLastName(int adminId, String newLastName) {
        if (adminId < 1 || newLastName == null || newLastName.trim().isEmpty()) {
            return false;
        }
        return adminDAO.updateAdminLastName(adminId, newLastName);
    }

    @Override
    public boolean updateAddress(int adminId, String newAddress) {
        if (adminId < 1 || newAddress == null || newAddress.trim().isEmpty()) {
            return false;
        }
        return adminDAO.updateAddress(adminId, newAddress);
    }

    @Override
    public boolean updatEmail(int adminId, String newemail) {
        if (adminId < 1 || newemail == null || newemail.trim().isEmpty()) {
            return false;
        }
        return adminDAO.updatEmail(adminId, newemail);
    }

    @Override
    public boolean updateTelephone(int adminId, String newTelephone) {
            if (adminId < 1 || newTelephone == null || newTelephone.trim().isEmpty()) {
            return false;
        }
        return adminDAO.updateTelephone(adminId, newTelephone);
    }

    @Override
    public boolean updateTittle(int adminId, String newTittle) {
              if (adminId < 1 || newTittle == null || newTittle.trim().isEmpty()) {
            return false;
        }
        return adminDAO.updateTittle(adminId, newTittle);
    }

    @Override
    public boolean updatePassword(int adminId, String newPasword) {
                  if (adminId < 1 || newPasword == null || newPasword.trim().isEmpty()) {
            return false;
        }
        return adminDAO.updatePassword(adminId, newPasword);
    }

}
