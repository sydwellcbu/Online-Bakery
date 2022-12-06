<%-- 
    Document   : cart
    Created on : Nov 2, 2022, 10:22:23 AM
    Author     : TRAIN 20
--%>

<%@page import="za.online.bean.Product"%>
<%@page import="za.online.service.impl.ProductServiceImpl"%>
<%@page import="za.online.bean.Customer"%>
<%@page import="za.online.service.impl.OrderServiceImpl"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.online.service.impl.OrderLineItemServiceImpl"%>
<%@page import="za.online.bean.OrderLineItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    DecimalFormat dcf = new DecimalFormat("#.00");
    OrderLineItemServiceImpl olit = new OrderLineItemServiceImpl();
    OrderServiceImpl osi = new OrderServiceImpl();
    List<OrderLineItem> myCart1 = new ArrayList();
    List<OrderLineItem> myCart = new ArrayList();
//      String errorMsg =null;
//    errorMsg = (String) request.getAttribute("errors");
    ProductServiceImpl psi = new ProductServiceImpl();
    Product product = new Product();
  
// String email = (String) session.getAttribute("UserSession");
    myCart = (ArrayList) session.getAttribute("OrderLineItem");
    if (myCart == null) {
        myCart = myCart1;
    }
%>
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
    .Cart-Container{

        box-shadow: 0px 1px 20px -3px rgba(0,0,0,0.75);

        padding: 1rem;
        grid-template-columns: 300px 1fr;


        max-width: 1000px;

        margin: 0 auto;
        font: 500 100%/1.5 system-ui;
        margin-top: 50px;

    }

    .Header{
        margin: auto;

        display: flex;
        justify-content: space-between;
        align-items: center;
    }


    .Action{
        font-size: 14px;
        font-family: 'Open Sans';
        font-weight: 600;

        cursor: pointer;
        border-bottom: 1px solid #E44C4C;
    }
    .Cart-Items{
        display: flex;

        width: 90%;
        height: 20%;

        justify-content: space-between;
        align-items: center;
    }

    .image-box{
        width: 5px;

    }


    .counter{
        width: 15%;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .btn{
        width: 40px;
        height: 40px;
        border-radius: 50%;
        background-color: #d9d9d9;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 20px;
        font-family: 'Open Sans';
        font-weight: 900;
        color: #202020;
        cursor: pointer;
    }

    .remove{

        font-size: 14px;
        font-family: 'Open Sans';
        font-weight: 600;
        color: #E44C4C;
        cursor: pointer;
    }
    hr{
        width: 100%;


    }
    .checkout{

        margin-right: 5%;
        width: 28%;
    }

    .total{
        width: 100%;
        display: flex;
        justify-content: space-between;
    }


    .items{
        font-size: 16px;
        font-family: 'Open Sans';
        font-weight: 500;
        color: #909090;
        line-height: 10px;
    }
    .total-amount{
        font-size: 36px;
        font-family: 'Open Sans';
        font-weight: 900;
        color: #202020;
    }
    .button{
        margin-top: 5px;
        width: 60%;
        height: 40px;
        border: none;
        background: linear-gradient(to bottom right, #B8D7FF, #8EB7EB);
        border-radius: 20px;
        cursor: pointer;
        font-size: 16px;
        font-family: 'Open Sans';
        font-weight: 600;
        color: #202020;
    }
    .add{
        margin-top: 5px;
        width: 100%;
        height: 40px;
        border: none;
        background: linear-gradient(to bottom right, #B8D7FF, #8EB7EB);
        border-radius: 20px;
        cursor: pointer;
        font-size: 16px;
        font-family: 'Open Sans';
        font-weight: 600;
        color: #202020;
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
</style>
</head>
<!DOCTYPE html>
<html>
    <head
        <body>
    <nav> 
        <label class="logo">To Pie For</label>
        <ul class="nav_links">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">Contact</a></li>
            <li><a href="product.jsp">View Product</a></li>

        </ul>
    </nav>





    <center>
        <div class="Cart-Container">
            <%
                if (session.getAttribute("UserSession") != null) {

            %>

            <p style="font-size: 18px; font-family: 'Open Sans'; font-weight: 700; color: #202020;"> <%if (myCart.size() == 0) {%>Your Cart Is Empty<%}%></p>
            <form method="Post" action="">
                <div class="Header">
                    <p style="font-size: 25px; font-family: 'Open Sans'; font-weight: 700; color: #202020;"class="Heading">Shopping Cart</p>
                    <%if (myCart.size() > 1) {%>
                    <div class='Action' ><a href="DeleteFromCart?action=deleteAll">Remove all</a></div>
                    <%}%>
                </div>
                <hr>
                <hr>

                <%

                    for (OrderLineItem cart : myCart) {

                %>
                <div class="Cart-Items">



                    <div class="image-box">
                        <img src="<%=cart.getProductPic()%>" style="  margin-top: 5px; width:100px;  border-radius: 8px;  position: relative;" />
                    </div>
                    <div class="about">
                        <h1 style="font-size: 18px; margin-left: -20px; font-family: 'Open Sans'; font-weight: 700; color: #202020; width: 400px" class="title"><%=cart.getProductName()%></h1>




                    </div>
                    <div class="counter">


                        <div style = "top: 3px;"class="btn"><a href="DeleteFromCart?action=sub&id=<%=cart.getProductId()%>"><%if (cart.getQuantity() > 1) {%>-<%}%></div> 
                        <div class="count"><%=cart.getQuantity()%></div>
               
                        
                     
                        
                        <div type="button" class="btn"><a href="DeleteFromCart?action=add&id=<%=cart.getProductId()%>">+</div>
                    </div>

                    <div class='prices'>
                        <div style="font-size: 18px; font-family: 'Open Sans'; font-weight: 700; color: #202020;" class='amount'>R<%=dcf.format(cart.getProductPrice())%></div>

                        <div class='remove' ><a href="DeleteFromCart?action=delete&id=<%=cart.getProductId()%>"><u>Remove</u></a></div>
                    </div>


                </div>
            </form>
            <hr> 
            <hr>
            <% }%>
            <hr> 
            <div class='checkout'>
                <div class='total'>
                    <div>
                        <div style="font-size: 18px; font-family: 'Open Sans'; font-weight: 700; color: #202020;" class='Subtotal'>Sub-Total</div>
                        <div class='items'> <%=olit.numberOfOrderlineItems(myCart) + "  "%>items</div>
                    </div>
                    <div style="font-size: 20px; font-family: 'Open Sans'; font-weight: 700; color: #202020;" class='total-amount'>R<%= dcf.format(osi.calTotAmnt(myCart))%></div>
                </div>
                <%if (myCart.size() > 0) {%>

                <a href="product.jsp"> <button class="button">Continue Shopping<button></a>
                            <a href="paymentMethod.jsp"> <button class='button'>Proceed to Checkout</button></a>
                            <%} else {%>
                            <a href="product.jsp"> <input type ="button" class='button' value = "Start Shopping"></input></a>
                                <%}%>
                            </div>

                            </div>


                            </center>



                            <% } else {

                            %>

                            <h3>Please Log In</h3>

                            <a href ="login.jsp" ><p>Click here</p></a>
                            <%}%>

                            </body>
                            </html>