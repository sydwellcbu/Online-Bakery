<%-- 
    Document   : ingridients
    Created on : 30 Nov 2022, 3:08:17 PM
    Author     : TRAIN 14
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="za.online.bean.IngredientsInventory"%>
<%@page import="za.online.service.impl.IngredientsInventoryServiceImpl"%>
<%@page import="za.online.service.IngredientsInventoryService"%>
<%@page import="za.online.bean.Ingrediants"%>
<%@page import="java.util.List"%>
<%@page import="za.online.service.impl.IngredientsServiceImpl"%>
<%@page import="za.online.service.IngredientsService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

    IngredientsInventoryService ingrServ = new IngredientsInventoryServiceImpl();
    IngredientsService ingrBean = new IngredientsServiceImpl();
    List<Ingrediants> allIn = new ArrayList();
    allIn = ingrBean.getAllIngrediants();
    IngredientsInventory allIn1 = new IngredientsInventory();

//-------------------------------------------------------------------------------------


%>


<!DOCTYPE html>
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
                <li><a href="AddRecipes.jsp">Add Recipe</a></li>
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
        <p style =" margin-top:140px; margin-left: 50%";><b>Ingredient Inventory</b></p>




    <center>

        <table  style =" margin-top:10px;">
            <tr>
                <th>Ingredient Name</th>
                <th>Available Stock </th>
                <th>Minimum Stock</th>
                <th>Maximum Stock</th>
                <th style =" color: red";> Stock to Order</th>

                <th>Action</th>

            </tr>


            <tr>
                <%for (Ingrediants in : allIn) {%>
                <%  allIn1 = ingrServ.getOneIngredientsInv(in.getIngredientsId());%>
                <td><%=in.getIngredientsName()%></td> 
                <td><%=allIn1.getAvailableStock()%></td>
                <td><%=allIn1.getMinStock()%></td>
                <td><%=allIn1.getMaxStock()%></td>
                <td><%=allIn1.getMaxStock() - allIn1.getMinStock()%></td>

                <td> <a href ="IngredientEdit.jsp">Edit</a><br><a href ="#">Delete</a></td>

            </tr>
            <%}%>




        </table>
    </center>

</body>
</html>
