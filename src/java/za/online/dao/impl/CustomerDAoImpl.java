/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.online.dao.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.Customer;
import za.online.bean.Product;
import za.online.dao.CustomerDAO;
import za.online.db.ConnectToBD;

/**
 *
 * @author Administrator
 */
public class CustomerDAoImpl implements CustomerDAO {

    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
   Customer customer;

    public CustomerDAoImpl() {
        con = ConnectToBD.getConnection();
    }

    @Override
    public List<Customer> viewAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        if (con != null) {
            try {
                ps = con.prepareStatement("select * from user");
                rs = ps.executeQuery();
                while (rs.next()) {
                     customer = new Customer();
                    customer.setCustomerId(rs.getInt("userId"));
                    customer.setFirstName(rs.getString("firstName"));
                    customer.setLastName(rs.getString("lastName"));
                    customer.setAddress(rs.getString("address"));
                    customer.setEmail(rs.getString("email"));
                    customer.setTelephone(rs.getString("telephone"));
                    customer.setTittle(rs.getString("tittle"));
                    customer.setPassword(rs.getString("password"));
                    customer.setActive(rs.getBoolean("active"));
                    customer.setIsAdmin(rs.getBoolean("isAdmin"));
                    customerList.add(customer);
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Customer Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return customerList;
    }

    @Override
    public Customer viewOneCustomer(int customerId) {
        if (con != null) {
            try {
                //   customer_Id,firstName,lastName,address,email,telephone,tittle,active 
                ps = con.prepareStatement("select * from customer where customer_Id = ?");
                ps.setInt(1, customerId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    customer.setCustomerId(rs.getInt("customer_Id"));
                    customer.setFirstName(rs.getString("firstName"));
                    customer.setLastName(rs.getString("lastName"));
                    customer.setAddress(rs.getString("address"));
                    customer.setEmail(rs.getString("email"));
                    customer.setTelephone(rs.getString("telephone"));
                    customer.setTittle(rs.getString("tittle"));
                    customer.setActive(rs.getBoolean("active"));
                    customer.setPassword(rs.getString("password"));
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Customer Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return customer;
    }

    @Override
    public boolean removeCustomer(int customerId) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE customer SET active = false WHERE customerId = ?");
                ps.setInt(1, customerId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To delete Customer:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }
    @Override
    public boolean addCustomer(Customer customer) {
        boolean retVal = false;
        if (con != null) {
            try {
                //   String firstName, String lastName, String address, String email, String telephone, String tittle, String password)
                ps = con.prepareStatement("Insert into user(firstName,lastName,email,telephone,tittle,password,address,active,isAdmin) values(?,?,?,?,?,?,?, true,false)");
               
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                ps.setString(3, customer.getEmail());
                ps.setString(4, customer.getTelephone());
                ps.setString(5, customer.getTittle());
               
                ps.setString(6, customer.getPassword());
                ps.setString(7, customer.getAddress());
                
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Add Customer :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }
    
    @Override
      public Customer viewMyProfile( String email) {
        
     List profile = new ArrayList(); 
        Customer customer = null;
            if (con != null) {
         
            try {
                ps = con.prepareStatement("select * from user where isAdmin = false AND email = ?");
                ps.setString(1, email);
                rs = ps.executeQuery();
              
                while (rs.next()) {
                 
                    String name = rs.getString("firstName");
                   String last = rs.getString("lastName");
                   String address = rs.getString("address");
                   String pass = rs.getString("password");
                   
                    email = rs.getString("email");
                   
                    String tel = (rs.getString("telephone"));
                    String title  =(rs.getString("tittle"));
                    boolean active = (rs.getBoolean("active"));
                    boolean isAdmin = (rs.getBoolean("isAdmin"));
              
             customer = new Customer(name ,last ,address,email,tel,title ,pass ,active,isAdmin);
                    
                    
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Read Admin Table :" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(String email) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE user SET firstName = ? , lastName =? , title = ? email = ? , address = ? password = ?   WHERE email = ?");
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                ps.setString(3, customer.getTittle());
                ps.setString(4, customer.getEmail());
                ps.setString(5, customer.getAddress());
                ps.setString(6, customer.getPassword());
                ps.setString(7, email);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Customer Name:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateCustomerLastName(int customerId, String newLastName) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE customer SET lastName = ?,  WHERE customerId = ?");
                ps.setString(1, newLastName);
                ps.setInt(2, customerId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Customer lastName:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateAddress(int customerId, String newAddress) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE customer SET address = ?,  WHERE customerId = ?");
                ps.setString(1, newAddress);
                ps.setInt(2, customerId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Customer address:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updatEmail(int customerId, String newEmail) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE customer SET email = ?,  WHERE customerId = ?");
                ps.setString(1, newEmail);
                ps.setInt(2, customerId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Customer Email:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateTelephone(int customerId, String newTelephone) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE customer SET telephone = ?,  WHERE customerId = ?");
                ps.setString(1, newTelephone);
                ps.setInt(2, customerId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Customer Telephone:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updateTittle(int customerId, String newTittle) {
        boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE customer SET tittle = ?,  WHERE customerId = ?");
                ps.setString(1, newTittle);
                ps.setInt(2, customerId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Customer Tittle:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    @Override
    public boolean updatePassword(int customerId, String newPasword) {
           boolean retVal = false;
        if (con != null) {
            try {
                ps = con.prepareStatement("UPDATE customer SET password = ?,  WHERE customerId = ?");
                ps.setString(1, newPasword);
                ps.setInt(2, customerId);
                if (ps.executeUpdate() > 0) {
                    retVal = true;
                }
            } catch (SQLException ex) {
                System.out.println("Error Failed To Update Customer Password:" + ex.getMessage());
            } finally {
                closeIfNotNull();
            }
        }
        return retVal;
    }

    private void closeIfNotNull() {

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Fail To Close Prepared Statement :" + ex.getMessage());
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Fail To Close Results Set :" + ex.getMessage());
            }
        }

    }

}
