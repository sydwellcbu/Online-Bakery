/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service.impl;

import java.util.List;
import za.online.bean.Customer;
import za.online.dao.CustomerDAO;
import za.online.dao.impl.CustomerDAoImpl;
import za.online.service.CustomerService;

/**
 *
 * @author Train
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;
Customer customer = new Customer();
    public CustomerServiceImpl() {
        this.customerDAO = new CustomerDAoImpl();
    }

    @Override
    public List<Customer> viewAllCustomers() {
        return customerDAO.viewAllCustomers();
    }

    @Override
    public Customer viewOneCustomer(int customerId) {
        if (customerId < 0) {
            return null;
        }
        return customerDAO.viewOneCustomer(customerId);
    }
    
   @Override
   public Customer viewMyProfile( String email){
        if (email.length() < 0) {
            return null;
        }
        return customerDAO.viewMyProfile(email);
    }
    @Override
    public boolean removeCustomer(int customerId) {
        if (customerId < 1) {
            return false;
        }
        return customerDAO.removeCustomer(customerId);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        return customerDAO.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(String email) {
        if (email.length()< 1  || customer.getFirstName().trim().isEmpty()) {
            return false;
        }
        return customerDAO.updateCustomer(email);
    }

    @Override
    public boolean updateCustomerLastName(int customerId, String newLastName) {
        if (customerId < 1 || newLastName == null || newLastName.trim().isEmpty()) {
            return false;
        }
        return customerDAO.updateCustomerLastName(customerId, newLastName);
    }

    @Override
    public boolean updateAddress(int customerId, String newAddress) {
        if (customerId < 1 || newAddress == null || newAddress.trim().isEmpty()) {
            return false;
        }
        return customerDAO.updateAddress(customerId, newAddress);
    }

    @Override
    public boolean updatEmail(int customerId, String newEmail) {
        if (customerId < 1 || newEmail == null || newEmail.trim().isEmpty()) {
            return false;
        }
        return customerDAO.updatEmail(customerId, newEmail);
    }

    @Override
    public boolean updateTelephone(int customerId, String newTelephone) {
        if (customerId < 1 || newTelephone == null || newTelephone.trim().isEmpty()) {
            return false;
        }
        return customerDAO.updateTelephone(customerId, newTelephone);
    }

    @Override
    public boolean updateTittle(int customerId, String newTittle) {
           if (customerId < 1 || newTittle == null || newTittle.trim().isEmpty()) {
            return false;
        }
        return customerDAO.updateTittle(customerId, newTittle);
    }

    @Override
    public boolean updatePassword(int customerId, String newPasword) {
              if (customerId < 1 || newPasword == null || newPasword.trim().isEmpty()) {
            return false;
        }
        return customerDAO.updatePassword(customerId, newPasword);
    }

}
