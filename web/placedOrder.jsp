<%-- 
    Document   : placedOrder
    Created on : 24 Nov 2022, 10:28:16 AM
    Author     : Train
--%>


<%@page import="za.online.bean.Order"%>
<%@page import="za.online.enums.PaymentStatus"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String payStatus = (String) session.getAttribute("payStatus");
    Order  order = new Order();
    Order  order1 = new Order();
    order1 = (Order)session.getAttribute("order");
    if(order1!= null){
    order = order1;
    }else{
    order1 = order;
    }
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
                background-color:#DCDCDC;
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
                background-color:#454545;

                border-style: double;
                position: relative; 
                align-items: center;
                max-width: 347px;
                height: 15px;
                margin: 0 auto;

                margin-top: 100px;

            }
            .reg-Container1{
                -webkit-box-shadow: -1px 7px 13px 0px rgba(0,0,0,0.59);
                -moz-box-shadow: -1px 7px 13px 0px rgba(0,0,0,0.59);
                box-shadow: -1px 7px 13px 0px rgba(0,0,0,0.59);
                background-color:white;;
                gap: 0rem;
                align-items: center;
                max-width: 340px;
                height: 400px;
                margin: 0 auto;
                font: 500 100%/1.5 system-ui;
                margin-top: 4px;



            }
            .reg-Container1 img{
                height: 60px;
                margin-top: 40px;

            }
            .lterName h1{
                margin-top: 10px;
                font-size: 70px;
                text-align: center;
                display: flex;
                align-items: center;
                justify-content: center;
                font-size: 30px;
                text-shadow: 1px 1px;
            }
            reg-Container1 h1{
                font-size: 30px;
            }

        </style>
    </head>
    <body>
        <nav>
            <label class="logo">To Pie For</label>
            <ul class="nav_links">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="index.jsp">Logout</a></li>

            </ul>
        </nav>


        <div class="reg-Container">
            <div class="reg-Container1">
                <center>
                    <%if (payStatus == PaymentStatus.APPROVED.toString()) {%>
                    <img src="picture/done.png">
                    <%} else {%>
                    <img src="picture/err1.webp">
                    <%}%>

                    <div class="lterName">
                        <%if (payStatus == PaymentStatus.APPROVED.toString()) {%>
                        <h1>Payment Successfully</h1>
                        <%} else {%>
                        <h1>Payment Unsuccessfully</h1>
                        <%}%>
                    </div>
                    <h>To Pie For is very humbled for your support. 
                        We feel more special to handle your desired products.<br>
                        Thank you for the support</h>
                        <%if (payStatus == PaymentStatus.APPROVED.toString()) {%>
                    <h1>Order number:</h1>
                    <hr>

                    <p><%=order.getOrderId()%></p>
                    <%} else {%>
                    <p></p>
                    <%}%>


                    <hr>
                    <h><br>
                        Thank you!!</h>
                </center>

            </div>
        </div>

    </body>
</html>
