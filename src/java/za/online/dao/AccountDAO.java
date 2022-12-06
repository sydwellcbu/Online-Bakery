
package za.online.dao;

import za.online.bean.Customer;

/**
 *
 * @author Aubrey
 */
public interface AccountDAO {
    
    public boolean registerAccount(Customer customer);
    public Customer Login(String username ,String password);
    
    
}
