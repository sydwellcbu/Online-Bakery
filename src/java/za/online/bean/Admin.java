
package za.online.bean;


public class Admin {
    
    private String firstName;
    private String lastName;
    private String address;
    private int adminId;
    private String email;
    private String telephone;
    private String tittle;
    private String password;
    boolean active;

    public Admin() {
    }
//     <%olit.increaseQuantity(cart.getProductId(), myCart);%>
//      <%olit.decreaseQuantity(cart.getProductId(), myCart);%>
    public Admin(String firstName, String lastName, String address, String email, String telephone, String tittle, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.tittle = tittle;
        this.password = password;
    }

    public boolean getIsActive() {
        return active;
    }
    
    public void setIsActive(boolean active){
    this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", adminId=" + adminId + ", email=" + email + ", telephone=" + telephone + ", tittle=" + tittle + ", active=" + active + '}';
    }


    public void setActive(boolean active) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
