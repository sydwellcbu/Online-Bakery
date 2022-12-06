
package za.online.bean;

public class Customer {
   
    private String firstName;
    private String lastName;
    private String address;
    private int customerId;
    private String email;
    private String telephone;
    private String tittle;
    private String password;
    private boolean active;
    private boolean isAdmin;
    


    public Customer() {
    }

    public Customer(String firstName, String lastName, String address, String email, String telephone, String tittle, String password , boolean active ,boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.tittle = tittle;
        this.password = password;
        this.isAdmin = isAdmin;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

  

    public void setActive(boolean active) {
            this.active = active;
    }

    public boolean isActive(){
    return active;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    
    
    
    @Override
    public String toString() {
        return "CostumerImpl{" + "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", customerId=" + customerId + ", email=" + email + ", telephone=" + telephone + ", tittle=" + tittle + ", password=" + password + '}';
    }  
}
