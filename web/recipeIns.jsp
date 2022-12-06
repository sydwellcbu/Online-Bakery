<%-- 
    Document   : recipeIns
    Created on : 30 Nov 2022, 9:45:11 PM
    Author     : User
--%>

<%@page import="za.online.service.impl.ProductServiceImpl"%>
<%@page import="za.online.service.ProductService"%>
<%@page import="za.online.bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.online.service.impl.RecipeServiceImpl"%>
<%@page import="za.online.bean.Recipe"%>
<%@page import="java.util.List"%>


<%@page import="za.online.service.RecipeService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

RecipeService recipeServ = new RecipeServiceImpl();
ProductService pService = new ProductServiceImpl();
List<Recipe> recipes = recipeServ.getllRecipe();
Product product = new Product();

%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                box-sizing: border-box;
                margin: 0;
                padding: 0;
                text-decoration: none;
                list-style: none;


            }
            body{
                background-image: url("pexels-suzy-hazelwood-1126359.jpg");
                background-color:white;
                font-family: montserrat;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;

            }

            nav{
                top: 0;
                background: #00CED1;
                height: 80px;
                width: 100%;
                position: fixed;

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
                background-color:#DCDCDC;


                align-items: center;

                height: 650px;

                padding: 20px;


                top: 80px;
                position: fixed;





            }
            .dash1 {
                display: flex;
                margin-top: 30px;
                position: relative;
                display: flex;
            }
            .dash2 {

                margin-top: 30px;

            }
            .reg-Container img{
                height: 40px;


            }


            table {
                top: 10px;
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 60%;
                align-items: center;
                justify-content: center;
                margin-top: 200px;
                margin-left: 15%;
                position:static;
            }

            td, th {
                width: 50%;
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }


        </style>
    </head>
    <body>

        <nav>
            <label class="logo">To Pie For</label>
            <ul class="nav_links">
                <li><a href="admin.jsp">Home</a></li>
                <li><a href="LogOut">Logout</a></li>

            </ul>
        </nav>
        <div class="reg-Container">
            <div class="dash">
                <div class="dash1">
                    <div class="dash2">
                        <a href="ingredient.jsp">

                            <h  style='font-family: Verdana, sans-serif;'> Ingredient Inventory</h></a>
                        <div class="dash2">
                            <a href="recipe.jsp">

                                <h style='font-family: Verdana, sans-serif;'>Recipe</h></a>
                            <div class="dash2">
                                <a href="recipeIns.jsp">

                                    <h style='font-family: Verdana, sans-serif;'>Recipe Instruction</h></a>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <p style =" margin-top:140px; margin-left: 50%";><b>Recipe Instruction</b></p>




    <center>

        <table  style =" margin-top:10px;">
            <tr>
              
              
               
                <th>Description</th>
                <th>Instructions</th>
                <th>Recipe#</th>
                <th>Product Name </th>


            </tr>

            <tr>



                <%for (Recipe rc : recipes) {%>
                <% product = pService.viewOneProduct(rc.getProductId());%>
                
              
                <td><%= rc.getRecipeDesc()%></td>
                <td><%=rc.getRecipeInstr()%></td>
                <td><%=rc.getRecipeId()%></td>
                <td><%= product.getProductName() %></td>
            </tr>

            <%}%>

            </tr>






        </table>
    </center>

</body>
</html>
