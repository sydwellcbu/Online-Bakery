/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.service;

import java.util.List;
import za.online.bean.Category;
import za.online.bean.Customer;

/**
 *
 * @author Train
 */
public interface CustomerService {

      public List<Customer> viewAllCustomers();

    public Customer viewOneCustomer(int customerId);

    public boolean removeCustomer(int customerId);

    public boolean addCustomer(Customer customer);
   public boolean updateCustomer(String email);
   

    public boolean updateCustomerLastName(int customerId, String newLastName);
    public boolean updateAddress(int customerId, String newAddress);
    public boolean updatEmail(int customerId, String newemail);
    public boolean updateTelephone(int customerId, String newTelephone);
    public boolean updateTittle(int customerId, String newTittle);
    public boolean updatePassword(int customerId, String newPasword);
    public Customer viewMyProfile( String email);
}
