<%-- 
    Document   : AddRecipes
    Created on : Dec 1, 2022, 1:20:25 PM
    Author     : TRAIN 96
--%>

<%@page import="za.online.bean.Ingrediants"%>
<%@page import="za.online.service.impl.IngredientsServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.online.service.IngredientsService"%>
<%@page import="java.util.List"%>
<%@page import="za.online.bean.Product"%>
<%@page import="za.online.service.impl.ProductServiceImpl"%>
<%@page import="za.online.service.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    ProductService productData = new ProductServiceImpl();
    Product product = new Product();
    List<Product> prod = productData.viewAllProduct();
    request.setAttribute("productList", prod);

    
    IngredientsService ingrBean = new IngredientsServiceImpl();
    List<Ingrediants> allIn = new ArrayList();
    allIn = ingrBean.getAllIngrediants();
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        *{
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            text-decoration: none;
            list-style: none;
        }
        body{

            background-color:white;
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

            background-color: rgba(255, 255, 255, 0.8);
            -webkit-box-shadow: -1px 3px 32px -8px rgba(0,0,0,0.75);
            -moz-box-shadow: -1px 3px 32px -8px rgba(0,0,0,0.75);
            box-shadow: -1px 3px 32px -8px rgba(0,0,0,0.75);

            padding: 1rem;
            grid-template-columns: 300px 1fr;
            gap: 1rem;
            align-items: center;
            max-width: 700px;

            margin: 0 auto;
            font: 500 100%/1.5 system-ui;
            margin-top: 50px;

        }







        footer{
            margin-top: 20px;
            background: #505761;
            height: 100px;
            width: 100%;

        }


        footer p{
            color: white;
            font-size: 15px;
            line-height: 40px;
            margin-left: 20px;
            font-weight: bold;
        }



        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            border: none;
            background: #f1f1f1;
        }



        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        hr {
            margin-top: 10px;
            border: 2px solid #f1f2f2;
            margin-bottom: 25px;
        }


        .addBtn {
            background-color: #04AA6D;
            color: white;
            padding: 10px 3px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 20%;

        }

        .addBtn {
            opacity: 1;
        }

        .cancelBtn {
            background-color: red;
            color: white;
            padding: 10px 3px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 20%;

        }

        .cancelBtn {
            opacity: 1;
        }


        a {
            color: white;
        }


        .signin {

            text-align: center;
        }

        .lterName h1{
            margin-top: 20px;
            font-size: 25px;
            text-align: center;
            display: flex;
            align-items: center;
            justify-content: center;


        }
    </style>
</head>
<body>
    <nav>
        <label class="logo">To Pie For</label>
        <ul class="nav_links">
            <li><a href="admin.jsp">Home</a></li>

        </ul>
    </nav>

    <div class="reg-Container">

        <h1>Add Recipes and Ingridients</h1>
        <br>
        <form method="post" action="AddRecipes">
   

            <label for="productName"><b>Product Name</b></label>
             <br>
          
            <select name = "prodId">
                  <%  for (Product prod1 : prod) {%>
              

                <option><%= prod1.getProductId()+ "." +  prod1.getProductName()%></option>

              <%}%> 
            </select>
    
 <br>
 <br>
          

            <label for="productDesc"><b>Available Ingridients</b></label>
 <br>
                 <select name = "ingId" >
                <%  for (Ingrediants al : allIn) {%>
                <option><%=al.getIngredientsId() + "." +  al.getIngredientsName()  %></option>
                
                <%
                }%>
            </select>

 <br>
            <label for="quantity"><b>Quantity</b></label>
            <input type="text" name="quantity"placeholder ="Quantity" >
            
            
            <label for="quantity"><b>Description</b></label>
            <input type="text" name="desc"placeholder ="Description" >
            
            <label for="quantity"><b>Add Ingridient</b></label>
            <input type="text" name="ingrd"placeholder ="Ingridient" >
            
            <label for="quantity"><b>Instructions</b></label>
            <input type="text" name="instr"placeholder ="Instructions">
 
            <hr>
            <button type="submit" class="addBtn">Add</button>
            <button type ='button' class ="cancelBtn"><a href="admin.jsp">Cancel</a></button>
         
            
            
        </form>




    </div>

</body>
</html>
