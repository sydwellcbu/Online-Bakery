<%-- 
    Document   : product
    Created on : Nov 1, 2022, 10:43:16 AM
    Author     : TRAIN 20
--%>

<%@page import="za.online.bean.OrderLineItem"%>
<%@page import="za.online.service.impl.OrderLineItemServiceImpl"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.online.service.impl.ProductServiceImpl"%>
<%@page import="za.online.service.ProductService"%>
<%@page import="za.online.bean.Category"%>
<%@page import="za.online.dao.CategoryDAO"%>
<%@page import="za.online.dao.impl.CategoryDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="za.online.bean.Product"%>
<%@page import="za.online.dao.impl.ProductDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    DecimalFormat dcf = new DecimalFormat("#.00");
    DecimalFormat dcf1 = new DecimalFormat("#.##");
    ProductService productData = new ProductServiceImpl();
    Product product = new Product();
    List<Product> prod;
    prod = (ArrayList) session.getAttribute("items");
    //----------------------------------------------------------
    OrderLineItemServiceImpl olit = new OrderLineItemServiceImpl();
    List<OrderLineItem> myCart = new ArrayList();

    myCart = (ArrayList) session.getAttribute("OrderLineItem");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
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

                justify-content: center;

                text-shadow: 2px 2px;

            }

            .lterNameinput{
                margin-top: 30px;
                justify-content: center;
            }

            .container fo{
                display: flex;
                margin-top: 5px;

            }

            .container input{
                margin-left: 20%;
                width: 90px;
                height: 20px;


            }
            label
            .container label{
                margin-left: 30%;



            }

            fo{
                margin-left: 30%;
                margin-top: 20px;
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
            hr {
                border: 1px solid lightgrey;
                width: 100%;
            }

            .wrapper{
                margin: 0 auto;
                width: 100%;


            }
            .header{
                background-color: #3AF49B;
                width: 100%;
                height: 150px;
            }


            .flex-container{

                display: flex;
                flex-wrap: wrap;
                justify-content: center;



            } 


            .fo-group{
                margin-left: 15px;
                border-radius: 8px;
                margin-top: 20px;
                flex-basis: 200px;
                height: 400px;
                background-color: #E5E4E2;
                position: relative ;
                border: 5px solid lightgrey;
            }

            .fo-group1{
                height: 30px;
                margin-left:5px;
                margin-top:0px;

            }

            .fo-group2{

                height: 70px;
                margin-left:10px;
                margin-top:10px;
            }


            .fo-group3{


                margin-left:5px;
                margin-top:40px;
            }

            .group-data9{
                margin-top: 5px;
                display: flex;
            }
            .group-data9 img{
                margin-left: 20px;
                height: 25px;
                max-width: 25px;
            }

            .group-data9 p{
                margin-left: 55%;
                margin-top: 10px;
            }
            .user-data img{
                margin-top: 5px;
                width:330px;
                max-height: 200px;
                border-radius: 8px;
                position: relative;
            }

            .group-data #_name{

                font-size: 1.5em;
                font-weight: 80;



            }


            .group-data #_contact{

                font-size: 1em;
                font-weight: 40;


                color: #066336;

            }



        </style>
    </head>
    <body>

        <nav>
            <label class="logo">To Pie For</label>
            <ul class="nav_links">
                <%                          if (session.getAttribute("UserSession") == null) {

                %>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Login</a></li>

                <% } else {

                %>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="LogOut">Log out</a></li>
                <li><a href="cart.jsp">Cart(<%=olit.numberOfOrderlineItems(myCart)%>)</a></li>
                <li> <a href="cart.jsp"><img src="picture/shopping-cart-icon.webp" alt="" /></a></li>
                <li> <a href="Userprofile.jsp"><img src="picture/profile.png" alt="" /></a></li>
                        <% }%>
            </ul>
        </nav>

        <div class="lterName">
            <h1>Searched Products</h1>

        </div>


        <div class="flex-container">


            <%  for (Product prod1 : prod) {%>


            <%double disPrice = prod1.getPrice() - (prod1.getPrice() * (prod1.getDiscount() / 100));%>


            <div class="fo-group">




                <div class="user-data">
                    <center>
                        <div class="group-data9">



                            <a  <% if (session.getAttribute("UserSession") == null) { %>

                                <%if (prod1.getQuantity() < 1) {%>
                                <p id="_role"  style="color:red; font-weight: bold;  font-size: 20px">Out of stock!</p>
                                <%} else {%>
                                href="login.jsp"><img src="picture/AddtoCartIcon.png" type ='button' class ="cancelBtn"> </a>
                                <%}%>
                                <%} else {%>

                            <%if (prod1.getQuantity() < 1) {%>
                            <p id="_role"  style="color:red; font-weight: bold;  font-size: 20px">Out of stock!</p>
                            <%} else {%>
                            <a   href="CartServlet?productId=<%=prod1.getProductId()%>"><img src="picture/AddtoCartIcon.png" type ='button' class ="cancelBtn"> </a>
                                <%}%>
                                <%}%>


                            <%if (prod1.getDiscount() > 0 && (prod1.getQuantity() > 0)) {%>
                            <p id="_role"  style="color:red; font-weight: bold;  font-size: 20px"><%=dcf1.format(prod1.getDiscount())%>% OFF </p>

                            <%}
                            %>

                        </div>
                    </center>

                    <img src="<%=prod1.getProductPic()%>"alt="h" height="" width="500" /><img>

                </div>




                <div class="fo-group1">


                    <div class="group-data">
                        <p style="color:black; font-weight: bold; font-size: 20px" ><%=prod1.getProductName()%></p>
                    </div>

                    <div class="fo-group2">

                        <div class="group-data">
                            <p style="color:black;  font-size: 15px; font-weight: bold;"> <%=prod1.getProductDesc()%></p>

                        </div>



                        <div class="group-data3">



                            <p id="_role"style="color:blue; font-weight: bold; font-size: 20px"><% if (prod1.getDiscount() > 0) {%>It Was R<%=dcf.format(prod1.getPrice())%><%} else {%>Price is R<%=dcf.format(prod1.getPrice())%> <%}%></p>

                            <% if (prod1.getDiscount() > 0) {%>
                            <del> <p id="_role"style="color:red;font-weight: bold; font-size: 20px">Now R <%=dcf.format(disPrice)%></p></del>
                            <%}%>
                        </div>

                    </div>


                </div>
            </div>
            <%}%>



        </div> 




    </body>
</html>

