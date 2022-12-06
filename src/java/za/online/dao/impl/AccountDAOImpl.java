package za.online.dao.impl;

import com.sun.javafx.geom.CubicApproximator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.online.bean.Customer;
import za.online.dao.AccountDAO;
import za.online.db.ConnectToBD;
import za.online.service.CustomerService;
import za.online.service.impl.CustomerServiceImpl;

/**
 *
 * @author Aubrey
 */
public class AccountDAOImpl implements AccountDAO {

    CustomerService customerServ = new CustomerServiceImpl();
    private Connection con = null;

    public AccountDAOImpl() {

        con = ConnectToBD.getConnection();

    }

    @Override
    public boolean registerAccount(Customer customer) {
        if (customer == null) {
            return false;
        }
        return customerServ.addCustomer(customer);

    }
    public boolean addAdmin(Customer customer) {
        boolean retVal = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con != null) {
            try {
                //   String firstName, String lastName, String address, String email, String telephone, String tittle, String password)
                ps = con.prepareStatement("Insert into user(firstName,lastName,email,telephone,tittle,password,address,active,isAdmin) values(?,?,?,?,?,?,?, true,true)");

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

            }
        }
        return retVal;
    }

    @Override
    public Customer Login(String email, String password) {

        String sql = "Select * from user where email = ? AND password = ?";
        Customer customer = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        boolean isAdmin;
        try {

            if (con != null) {
                pr = con.prepareStatement(sql);
                pr.setString(1, email);
                pr.setString(2, password);

                rs = pr.executeQuery();
                rs.beforeFirst();
                while (rs.next()) {
                    customer = new Customer();
                    customer.setIsAdmin(rs.getBoolean("isAdmin"));
                    customer.setActive(rs.getBoolean("active"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPassword(rs.getString("password"));
                    customer.setTittle(rs.getString("tittle"));
                    customer.setTelephone(rs.getString("telephone"));
                    customer.setAddress(rs.getString("address"));
                    customer.setFirstName(rs.getString("firstName"));
                    customer.setLastName(rs.getString("lastName"));
                    customer.setCustomerId(rs.getInt("userId"));
                }

            }

        } catch (SQLException e) {
            System.out.println("Error in connecting your drive " + e.getMessage());
        } finally {
            if (pr != null) {
                try {
                    pr.close();
                } catch (SQLException ex) {
                    System.out.println("Failed to close Prepared Statement :" + ex.getMessage());
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Failed to close Results Statement :" + ex.getMessage());
                }
            }
        }
        // myDet.toArray();
        if (customer == null) {
            return null;
        } else {
            return customer;
        }
    }

}
