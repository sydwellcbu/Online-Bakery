package za.online.dao;

import java.util.List;
import za.online.bean.Admin;
import za.online.bean.Category;
import za.online.bean.Product;


public interface AdminDAO {
      public List<Category> AdminviewAllCategory() ;

    public boolean addAdmin(Admin admin);

    public List<Admin> viewAllAdmins(Admin admin);

    public Admin viewOneAdmin(int adminId, Admin admin);

    public boolean removeAdmin(int adminId);

    public boolean updateAdminFirstName(int adminId, String newFirstName);

    public boolean updateAdminLastName(int adminId, String newLastName);

    public boolean updateAddress(int adminId, String newAddress);

    public boolean updatEmail(int adminId, String newemail);

    public boolean updateTelephone(int adminId, String newTelephone);

    public boolean updateTittle(int adminId, String newTittle);

    public boolean updatePassword(int adminId, String newPasword);
  public List<Product> viewAllProduct();
}
