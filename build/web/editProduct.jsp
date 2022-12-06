<%-- 
    Document   : category
    Created on : Nov 2, 2022, 2:54:47 PM
    Author     : TRAIN 20
--%>

<%@page import="za.online.bean.Category"%>
<%@page import="za.online.service.impl.CategoryServiceImpl"%>
<%@page import="za.online.service.CategoryService"%>
<%@page import="za.online.dao.impl.ProductDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="za.online.bean.Product"%>
<%@page import="za.online.service.impl.ProductServiceImpl"%>
<%@page import="za.online.service.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    ProductService productData = new ProductServiceImpl();

    Product product = productData.viewOneProduct(id);
    request.setAttribute("prod", product);

    CategoryService categoryData = new CategoryServiceImpl();
    List<Category> category = categoryData.viewAllCategory();
    request.setAttribute("cat", category);
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
                grid-template-columns: 300px 1fr;
                gap: 1rem;
                align-items: center;
                max-width: 700px;

                margin: 0 auto;
                font: 500 100%/1.5 system-ui;
                margin-top: 50px;

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
                border: 2px solid #f1f2f2;
                margin-bottom: 25px;
            }


            .updateBtn {
                background-color: #04AA6D;
                color: white;
                padding: 10px 3px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 20%;

            }

            .updateBtn:hover {
                opacity: 1;
            }

            .cancelBtn {
                background-color: #04AA6D;
                color: red;
                padding: 10px 3px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 20%;

            }

            .cancelBtn:hover {
                opacity: 1;
            }
            cancelBtn

            a {
                color: dodgerblue;
            }


            .signin {

                text-align: center;
            }
        </style>
    </head>
    <body>
        <nav>
            <label class="logo">To Pie For</label>
            <ul class="nav_links">
            </ul>
        </nav>

        <div class="reg-Container">
            <form method="POST" action="EditProduct">
                <br>
                <h1>Edit Product</h1>

                <hr>

                <h for="productId"><b>Product Id</b></h>
                <hr>
                <input type="text"  name="productId" value ="${prod.productId}" readonly>

                <h for="productName"><b>Product Name</b></h>
                <hr>
                <input type="text"  name="productName" value ="${prod.productName}">

                <label for="productDesc"><b>Product Description</b></label>

                <input type="text"  name="productDesc" value ="${prod.productDesc}">

                <label for="quantity"><b>Quantity</b></label>

                <input type="text" name="quantity"value ="${prod.quantity}">

                <label for="price"><b>Price</b></label>
                <input type="text" name="price"value ="${prod.price}">

                <label for="discount"><b>Discount</b></label>
                <input type="text" name="discount"value ="${prod.discount}">


                <label for="active"><b>Active</b></label>
                <input type="text" name="active"value ="${prod.active}">


                <label for="category"><b>Category</b></label>
                <select name = "categoryName"id ="category">
                    <c:forEach var = "catD" items ="${cat}">
                        <option>${catD.categoryName}</option>
                    </c:forEach>
                </select>
 
                <label for="productPic"><b>Picture</b></label>
                <input type="file" name="productPic"value ="${prod.productPic}">

                <hr>
                <button type="submit" class="updateBtn">Update</button>
                <button type ='button' class ="cancelBtn"><a href="admin.jsp">Cancel</a></button>

            </form>
               
        </div>

    </body>
</html>
 