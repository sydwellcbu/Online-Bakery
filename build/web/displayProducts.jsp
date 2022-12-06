<%-- 
    Document   : displayProducts
    Created on : Nov 3, 2022, 1:53:42 PM
    Author     : TRAIN 20
--%>

<%@page import="za.online.service.impl.AdminServiceImpl"%>
<%@page import="za.online.service.AdminService"%>
<%@page import="za.online.bean.Product"%>
<%@page import="java.util.List"%>
<%@page import="za.online.service.impl.ProductServiceImpl"%>
<%@page import="za.online.service.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    AdminService productData = new AdminServiceImpl();
   Product product = new Product();
    List<Product> prod = productData.viewAllProduct();
    request.setAttribute("productList", prod);
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
                max-width: 800px;

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
            .container input{
                margin-left: 20px;
                width: 90px;
                height: 20px;


            }
            label
            .container label{
                margin-left: 60px;



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
                <li><a href="admin.jsp">Home</a></li>
                <a href="addProduct.jsp">
               <li> <a href="addProduct.jsp"><img src="picture/addProductIcon.png" /></a></li>
              
               
            </ul>
        </nav>

        <div class="lterName">
            <h1>Products in store</h1>
        </div>

        <div class="container">
    <form type ="POST" method ="product">

            <table>
               
                 <tr>
                        <th scope="col">Product Picture</th>
                        <th scope="col">Product Id </th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Product Description</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">Discount</th>
                        <th scope="col">Status</th>
                        <th scope="col">Posted Date</th>
                        <th scope="col">Action</th>
                    </tr>
                
                <tr>
                            <c:forEach var = "product" items ="${productList}">
                            
                            <td>
                          <div>
                                <img src ="${product.productPic}"></img> 
                          </div>
                          </td>
                            <td>${product.productId}</td>
                            <td>${product.productName}</td>
                            <td>${product.productDesc}</td>
                            <td>${product.quantity}</td>
                            <td>${product.price}</td>
                            <td>${product.discount}</td>
                            <td>${product.active}</td>
                           
                            <td>${product.postedDate}</td>
                          
                            <td><a href ="editProduct.jsp?id=${product.productId}">Edit</a>
                            <a href ="DeleteProduct?id=${product.productId}">Delete</a></td>
                        </tr>
                </tr>
                        
                    </c:forEach>
                        </form>
                      
                    </td>
                    
           


            </table>
        </div>
    </body>
</html>
