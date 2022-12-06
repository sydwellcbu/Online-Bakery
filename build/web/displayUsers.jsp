<%-- 
    Document   : displayUsers
    Created on : Nov 13, 2022, 9:25:12 PM
    Author     : Aubrey
--%>

<%@page import="za.online.service.impl.CustomerServiceImpl"%>
<%@page import="za.online.service.CustomerService"%>
<%@page import="za.online.bean.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    CustomerService customers = new CustomerServiceImpl();
   Customer customer = new Customer();
    List<Customer> customerList = customers.viewAllCustomers();
    request.setAttribute("customerList", customerList);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                  box-shadow: 0px 1px 20px -3px rgba(0,0,0,0.75);
                display: flex;
                padding: 1rem;
                grid-template-columns: 300px 1fr;
                gap: 1rem;
                align-items: center;
                max-width:68%;

                margin: 0 auto;
                font: 500 100%/1.5 system-ui;
                margin-top: 20px;
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
               
            </ul>
        </nav>

        <div class="lterName">
            <h1>Users</h1>
        </div>

        <div class="container">
    <form type ="POST" method ="product">

            <table>
               
                 <tr>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Customer Id</th>
                        <th scope="col">Email Address</th>
                        <th scope="col">Contacts</th>
                        <th scope="col">Title</th>
                        <th scope="col">Admin Status</th>
                        <th scope="col">Status</th>
                        <th scope="col">Action</th>
                     
                    </tr>
                
                <tr>
                            <c:forEach var = "customer" items ="${customerList}">
                           
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.customerId}</td>
                            <td>${customer.email}</td>
                            <td>${customer.telephone}</td>
                            <td>${customer.tittle}</td>
                            <td>${customer.isAdmin}</td>
                            <td>${customer.active}</td>
                           
                            
                            <td> <a href ="DeleteProduct?id=${customer.customerId}">Delete</a></td>
                       
                </tr>
                        
                    </c:forEach>
                        </form>
                      
                    </td>
                    
           


            </table>
        </div>
    </body>
</html>
