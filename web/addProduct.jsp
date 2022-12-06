<%-- 
    Document   : addProducts
    Created on : Nov 3, 2022, 1:41:19 PM
    Author     : TRAIN 20
--%>

<%@page import="za.online.service.impl.ProductServiceImpl"%>
<%@page import="za.online.bean.Product"%>
<%@page import="za.online.service.ProductService"%>
<%@page import="za.online.service.ProductService"%>
<%@page import="za.online.service.impl.CategoryServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="za.online.bean.Category"%>
<%@page import="za.online.service.CategoryService"%>
<%@page import="za.online.service.CategoryService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

    ProductService productData = new ProductServiceImpl();
    CategoryService categoryData = new CategoryServiceImpl();
    List<Category> category = categoryData.viewAllCategory();
    request.setAttribute("cat", category);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Products</title>
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

    <div class="lterName">
        <h1>Admin Portal</h1>
    </div>

    <div class="reg-Container">

        <h1>Add Product</h1>
        <br>
        <form method="post" action="AddProduct">
        
             
                 <label for="productName"><b>Product Name</b></label>
                
                 <input type="text"  name="productName" placeholder ="Product Name" required>

                <label for="productDesc"><b>Product Description</b></label>

                <input type="text"  name="productDesc" placeholder ="Product Description"required>

                <label for="quantity"><b>Quantity</b></label>

                <input type="text" name="quantity"placeholder ="Quantity"required>

                <label for="price"><b>Price</b></label>
                <input type="text" name="price"placeholder ="Price" required >

                <label for="discount"><b>Discount</b></label>
                <input type="text" name="discount"placeholder ="Discount" required>

                
                <label for="category"><b>Category</b></label>
                <select name = "categoryName"id ="category" required>
                    <c:forEach var = "catD" items ="${cat}">
                        <option>${catD.categoryName}</option>
                    </c:forEach>
                </select>

                <label for="productPic"><b>Picture</b></label>
                <input type="file" name="productPic"placeholder ="Product Picture">

                <hr>
                <button type="submit" class="addBtn">Add</button>
                <button type ='button' class ="cancelBtn"><a href="admin.jsp">Cancel</a></button>


        </form>




    </div>

</body>
</html>
