<%-- 
    Document   : admin
    Created on : Nov 3, 2022, 11:19:28 AM
    Author     : TRAIN 20
--%>

<%@page import="za.online.service.impl.OrderServiceImpl"%>
<%@page import="za.online.service.OrderService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>

        <style>
            *{
                box-sizing: border-box;
                margin: 0;
                padding: 0;
                text-decoration: none;
                list-style: none;
            }
            body{

                background-color: rgba(255, 255, 255, 0.8);
                font-family: montserrat;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }

            nav{
                background: #00CED1;
                height: 80px;
                width: 100%;

            }

            label.logo{
                color: white;
                font-size: 35px;
                line-height: 80px;
                padding: 0 100px;
                font-weight: bold;
            }
            nav ul{
                float: right;
                margin-right: 20px;
            }

            nav ul li{
                display: inline-block;
                line-height: 80px;
                margin: 0 5px;

            }

            nav ul li a{
                color: whitesmoke;
                font-size: 17px;
                text-transform: uppercase;

            }
            nav ul img{
                height: 30px;


            }
            .reg-Container{

             
                
                box-shadow: 0px 1px 20px -3px rgba(0,0,0,0.75);
                padding: 1rem;

                align-items: center;
                max-width: 950px;

                margin: 0 auto;
                font: 500 100%/1.5 system-ui;
                margin-top: 70px;

            }
            .lterName h1{
                margin-top: 20px;
                font-size: 25px;
                text-align: center;
                display: flex;
                align-items: center;
                justify-content: center;


            }

            .image-gallery {
                display: flex;
                padding: auto;
                justify-content: center;
                gap: 30px;
                object-fit: cover;
                width: 100%;
                height: 100%;

                border-radius: 10px;
            }

            .image-gallery  li {
                flex-basis: 250px;
            }

            .image-gallery li img {
                object-fit: cover;
                width: 100%;
                height: 100%;


            }


        </style>

    </head>

    <body>
        

        <nav>
            <label class="logo">To Pie For</label>
            <ul class="nav_links">
                <li><a href="admin.jsp">Home</a></li>
              
                    <%
                        if (session.getAttribute("adminSession") != null) {

                    %>
                <li><a href="recipe.jsp">Recipe</a></li>
                    <li><a href="AdminProfile.jsp">My Profile</a></li>
           
               <li> <a href="LogOut">Log Out</a> 
                       <li> <a href="adminAddAdmin.jsp"><img src="picture/addAdminIcon.png" /></a></li>
               </li>
                    <%}%>
            </ul>
        </nav>
        <div class="lterName">
            <h1>Admin Portal</h1>
        </div>
        <div class="reg-Container">
            <%                
             if (session.getAttribute("adminSession") != null) {

            %>

            <center>

                <ul class="image-gallery">
                    <form>
                        <li>
                            <a href="displayUsers.jsp">
                                <div class="overlay"><span>Users</span></div> 
                                <img src="picture/usersIcon.jpg" alt="" />
                            </a>
                        </li>
                    </form>

                    <form>
                        <li>
                            <div class="overlay"><span>Categories</span></div> 
                            <a href="displayCategory.jsp"><img src="picture/category.png" alt="" /></a>

                        </li>
                    </form>
                    <form>
                        <li>
                            <div class="overlay"><span>Products</span></div> 
                            <a href="displayProducts.jsp""> <img src="picture/product.png" alt="" />

                        </li>
                    </form>
                    <form>
                        <li>
                            <a href="AddCategory.jsp"">
                                <div class="overlay"><span>Add Category</span></div> 
                                <img src="picture/addCategoryIcon.png" alt="" />
                            </a>
                        </li>
                        </a>
                    </form>
                    <form>
                        <li>
                            <a href="addProduct.jsp">
                                <div class="overlay"><span>Add Product</span></div> 
                                <img src="picture/addProduct.png" alt="" />
                            </a>
                        </li>
                    </form>
                    
                       <form>
                        <li>
                            <a href="OrdersAdmin?action=all">
                                <div class="overlay"><span>Orders</span></div> 
                                <img src="picture/orders.png" alt="" />
                            </a>
                        </li>
                         </form>
                     <form>
                        <li>
                            <a href="recipe.jsp">
                                <div class="overlay"><span>Recipes</span></div> 
                                <img src="picture/orders.png" alt="" />
                            </a>
                        </li>
                     </form>
            </center>
            
            <%          
                } else{

            %>
            <h3>Please Log In to proceed</h3>
            <a href ="login.jsp" ><p>Click here</p></a>
            <%}%>
            
        </div>




    </body>


</html>
