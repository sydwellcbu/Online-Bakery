<%-- 
    Document   : displayCategory
    Created on : Nov 4, 2022, 10:07:54 AM
    Author     : Aubrey
--%>

<%@page import="za.online.dao.impl.AdminDAOImpl"%>
<%@page import="za.online.dao.AdminDAO"%>
<%@page import="java.util.List"%>
<%@page import="za.online.bean.Category"%>
<%@page import="za.online.service.CategoryService"%>
<%@page import="za.online.service.impl.CategoryServiceImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    AdminDAO categoryData = new AdminDAOImpl();
    List<Category> category = categoryData.AdminviewAllCategory();
    Category categoryInst = new Category();
    request.setAttribute("categoryList", category);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            @media screen and (max-device-width:640px), screen and (max-width:640px) {
                .container {
                    Width: 100%!important;
                }
            }

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
            .lterName h1{
                margin-top: 30px;
                font-size: 50px;
                text-align: center;
                display: flex;
                align-items: center;
                justify-content: center;

                text-shadow: 2px 2px;

            }
            .lterName input{
                margin-top: 30px;
                margin-left: 21%;
                font-size: 20px;
                text-align: center;
                display: flex;
                align-items: center;
                justify-content: center;



            }

            .container {
                background-color: rgba(255, 255, 255, 0.8);
                -webkit-box-shadow: -1px 3px 32px -8px rgba(0,0,0,0.75);
                -moz-box-shadow: -1px 3px 32px -8px rgba(0,0,0,0.75);
                box-shadow: -1px 3px 32px -8px rgba(0,0,0,0.75);
                display: grid;
                padding: 1rem;
                grid-template-columns: 300px 1fr;
                gap: 1rem;
                align-items: center;
                max-width: 720px;

                margin: 0 auto;
                font: 500 100%/1.5 system-ui;
                margin-top: 20px;
            }
            .container form{

                display: flex;
                margin-top: 20px;

            }
            .container img {

                max-width: 50%;
                height: auto;
            }


            .container p{
                margin-left: 60px;
            }

            label
            .container label{
                margin-left: 60px;



            }

            form{
                margin-left: 35%;
                margin-top: 20px;
            }

            .remove{
                margin-left: 30px;
                padding-top: 5px;
                font-size: 14px;
                font-family: 'Open Sans';
                font-weight: 600;
                color: #E44C4C;
                cursor: pointer;
            }
            .update{
                margin-left: 30px;
                padding-top: 5px;
                font-size: 14px;
                font-family: 'Open Sans';
                font-weight: 600;
                color: blue;
                cursor: pointer;
            }
            hr {
                border: 2px solid #f1f2f2;
                margin-bottom: 25px;
            }


            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
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
            <label class="logo">Admin Portal</label>
            <ul class="nav_links">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="cart.jsp">View Cart</a></li>
                <img src="picture/shopping-cart-icon.webp" alt="" />
            </ul>
        </nav>

        <div class="lterName">
            <h1>Categories in store</h1>
        </div>

        <div class="container">
            <form method ="POST">
          
                <table>

                    <tr>
                        <th scope="col">Category Id</th>
                        <th scope="col">Category Name</th>
                        <th scope="col">Picture</th>
                        <th scope="col">Active</th>
                        <th scope="col">Update</th>
                        <th scope="col">Delete</th>
                    </tr>

                    <c:forEach var = "cat" items ="${categoryList}">
                        <tr> 
                           
                            <td>${cat.categoryId}</td>
                            <td>${cat.categoryName}</td>
                            <td><img src ="${cat.categoryPic}"></img> </td>
                            <td>${cat.active}</td>
                         
                            <td><a href ="editCategory.jsp?id=${cat.categoryId}"> Edit</a>
                            
                            </td> 
                            <td><a href ="DeleteCategory?id=${cat.categoryId}">Delete</a></td>
                          
                        </tr>
                    </c:forEach>
                        </form>
                    </div>
           

        </table>

</body>
</html>
