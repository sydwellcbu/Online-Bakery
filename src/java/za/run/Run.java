package za.run;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.online.bean.Category;
import za.online.bean.Customer;
import za.online.bean.OrderLineItem;
import za.online.bean.Product;
import za.online.dao.AccountDAO;
import za.online.dao.CategoryDAO;
import za.online.dao.impl.AccountDAOImpl;
import za.online.dao.impl.AdminDAOImpl;
import za.online.dao.impl.CategoryDAOImpl;
import za.online.dao.impl.ProductDAOImpl;
import za.online.service.CategoryService;
import za.online.service.CustomerService;
import za.online.service.ProductService;
import za.online.service.impl.CategoryServiceImpl;
import za.online.service.impl.CustomerServiceImpl;
import za.online.service.impl.OrderLineItemServiceImpl;
import za.online.service.impl.ProductServiceImpl;

public class Run {
//   <%=prod1.getProductName() %>
//     <%=prod1.getProductId() %>
//     <%=prod1.getProductPic() %>
//     <%=prod1.getProductDesc() %>
//     <%=prod1.getPrice() %>
    CategoryService categoryService = new CategoryServiceImpl();
    CategoryDAO catDao = new CategoryDAOImpl();
    CategoryDAOImpl catD = new CategoryDAOImpl();
    Category category = new Category();
    ProductService productServ = new ProductServiceImpl();
    Product product = new Product();
    ProductDAOImpl p = new ProductDAOImpl();
    AccountDAO account = new AccountDAOImpl();
    CustomerService customers = new CustomerServiceImpl();
    Customer customer = new Customer();

    public static void main(String[] args) {

 OrderLineItemServiceImpl olit = new OrderLineItemServiceImpl();
            List<OrderLineItem> cart = new ArrayList<>();
  cart.add(olit.addProductToCart(21));
        


 // olit.increaseQuantity(21, cart);
 
 for(OrderLineItem prod : cart){
     
     System.out.println(prod.getProductId());  
     System.out.println(prod.getProductName());  
     System.out.println(prod.getProductPic());  
     System.out.println(prod.getProductPrice());  
 
 }
 
      
  
    }

    public void testAddCategory() {
        Category cat = new Category();
        cat.setCategoryName("Kota");
        cat.setCategoryPic("picture/bread.jpg");
        if (categoryService.addCategory(cat)) {
            System.out.println("Category added");
        } else {
            System.out.println("Category NOT added");
        }

    }

    public void testViewCaetgory() {
        List<Category> myList = categoryService.viewAllCategory();

        System.out.println(myList);

    }

    public void testUpdateCat() {

        category.setCategoryId(1);
        category.setCategoryName("CakeRice");

        boolean success = categoryService.updateCategory(category);

        System.out.println(success);
    }

    public void testViewOneCat() {

        categoryService.getCategory(2);

    }

    public void testRemoveCat() {

        catD.setActiveStatus(1);

    }

    public void testViewAllPro() {

        List list = productServ.viewAllProduct();
        System.out.println(list);

    }

    public void adddViewAllPro() {

        product.setProductName("IceKota");
        product.setProductPic("picture/bread5.jpg");
        product.setProductDesc("The only kota that matters");
        product.setQuantity(6);
        product.setCategoryId(2);
        product.setPrice(23.00);
        product.setDiscount(8.00);

        productServ.addProduct(product);

    }

    public void testUpdateProduct() {

        String id = "1";

        int catId = Integer.parseInt(id);

        System.out.println(catId);

        product.setProductName("Kota");
        product.setProductPic("picture/bread5.jpg");
        product.setProductDesc("The only kota that matters");
        product.setQuantity(6);

        product.setPrice(23.00);
        product.setDiscount(8.00);
        product.setProductId(1);
        product.setActive(true);

        boolean rs = productServ.updateProduct(product);
        System.out.println(rs);

    }

    public void testViewOneProd() {

        System.out.println(productServ.viewOneProduct(10));

    }

    public void testAddProd() {

        product.setProductDesc("We have a cream in a pie");
        product.setProductPic("picture/bread.jpg");
        product.setProductName("Cream Pie");
        product.setPrice(25.00);
        product.setQuantity(20);
        product.setCategoryId(1);
        product.setDiscount(0.00);

        boolean s = productServ.addProduct(product);
        System.out.println(s);

    }

    public void testRemoveProd() {

        boolean s = productServ.removeProduct(12);
        System.out.println(s);
    }

    public void testGetCateId() {

        ProductDAOImpl pi = new ProductDAOImpl();

        System.out.println(pi.getCategoryId("pies"));

    }

    public void testRegister() {
        Customer customer = new Customer();
        customer.setFirstName("Ditiro");

        customer.setLastName("Mokoena");

        customer.setEmail("mokoenaD@gmail.com");

        customer.setTittle("Other");
        customer.setAddress("Winnie Zone 10 Mambisa");

        customer.setTelephone("0114525698");

        customer.setPassword("@mokoena");

        account.registerAccount(customer);
    }

    public void testLogin() {

//        List l = account.Login("mash@gmail.com", "@123kb");
//        System.out.println(l);
    }

    public void viewAllUsers() {

        List list = customers.viewAllCustomers();
        System.out.println(list);
    }

    public void testCategoryPro() {
        List l = p.categoryProduct(1);
        System.out.println(l);
    }

    public void viewProfile() {

        AdminDAOImpl admin = new AdminDAOImpl();

   Customer c = admin.viewMyProfile("masala@gmail.com");
        System.out.println(c);
    }

    public void viewProfile2() {

     CustomerService customer = new CustomerServiceImpl();

   Customer c = customer.viewMyProfile("mash@gmail.com");
        System.out.println(c);
    }

}
