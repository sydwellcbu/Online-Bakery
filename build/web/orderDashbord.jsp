<%-- 
    Document   : orderDashbord
    Created on : Nov 24, 2022, 10:47:37 AM
    Author     : TRAIN 20
--%>

<%@page import="za.online.service.impl.OrderServiceImpl"%>
<%@page import="za.online.bean.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.online.service.OrderService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    OrderService order = new OrderServiceImpl();
    List<Order> orders = (ArrayList) session.getAttribute("orderUsers");

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
               

            </ul>
        </nav>
        <div class="reg-Container">
            <div class="dash">
                <div class="dash1">
                    <div class="dash2">
                        <a href="OrdersAdmin?action=all">
                            <img src="picture/alll.png">
                            <h  style='font-family: Verdana, sans-serif;'> All Orders</h></a>
                        <div class="dash2">
                            <a href="OrdersAdmin?action=pending">
                                <img src="picture/pending.webp">
                                <h style='font-family: Verdana, sans-serif;'>Pending Orders</h></a>
                            <div class="dash2">
                                <a href="OrdersAdmin?action=complete">
                                    <img src="picture/completed.png">
                                    <h style='font-family: Verdana, sans-serif;'>Completed Orders</h></a>
                                <div class="dash2">
                                    <a href="OrdersAdmin?action=dispached">
                                        <img src="picture/dispatch.webp">
                                        <h style='font-family: Verdana, sans-serif;'>Dispatched</h></a>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <p style =" margin-top:140px; margin-left: 83%";><b>Sort by:</b></p>

        <select   onChange="window.location.href = this.value" style =" margin-top: 5px; margin-left: 82%; "name ="sort">
            <option value="OrdersAdmin?action=order">Order#</option>
            <option value="OrdersAdmin?action=date">Date</option>
            </select>
        
        

<center>

    <table  style =" margin-top:10px;">
        <tr>
            <th>Order#</th>
            <th>Date </th>
            
            <th>Status</th>
            <th>User#</th>
            <th>Action</th>

        </tr>

        <tr>

            <%for (Order userOrders : orders) {%>

            <td><%=userOrders.getOrderId()%></td>
            <td><%=userOrders.getOrderDate()%></td>
           
            <td><%=userOrders.getOrderStatus()%></td>
            <td><%=userOrders.getCustomerId()%></td>

            <td> <a href ="OrdersAdmin?action=del&id=<%=userOrders.getOrderId()%>">Delete</a></td>
        </tr>


        <%}%> 



    </table>
</center>

</body>
</html>
