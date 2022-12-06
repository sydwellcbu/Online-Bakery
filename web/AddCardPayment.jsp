<%-- 
    Document   : AddCardPayment
    Created on : 24 Nov 2022, 1:04:00 PM
    Author     : Train
--%>

<%@page import="za.online.service.impl.CardPaymentServiceImpl"%>
<%@page import="za.online.bean.CardPayment"%>
<%@page import="za.online.bean.Customer"%>
<%@page import="za.online.bean.OrderLineItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.online.service.impl.OrderServiceImpl"%>
<%@page import="za.online.service.impl.OrderLineItemServiceImpl"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    DecimalFormat dcf = new DecimalFormat("#.00");
     OrderLineItemServiceImpl olit = new OrderLineItemServiceImpl();
     OrderServiceImpl osi = new OrderServiceImpl();
     List<OrderLineItem> myCart = new ArrayList();
     myCart = (ArrayList) session.getAttribute("OrderLineItem");
       Customer user = (Customer)session.getAttribute("UserSession");
    // String email = (String) session.getAttribute("UserSession");
    CardPayment card = new CardPayment();
    CardPaymentServiceImpl cardService = new CardPaymentServiceImpl();
   // int id = user.getCustomerId();
    card = cardService.getLastInsertedCard(user.getCustomerId());
    %>
    
    
<html>
    <head>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

        <link rel ="stylesheet" href="st.css"
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
            .lterName h1{
                margin-top: 20px;
                font-size: 25px;
                text-align: center;
                display: flex;
                align-items: center;
                justify-content: center;


            }

            .container {
                background-color: rgba(255, 255, 255, 0.8);
                border: 1px solid black;
                display: grid;
                padding: 1rem;
                grid-template-columns: 300px 1fr;
                gap: 1rem;
                align-items: center;
                max-width: 1200px;

                margin: 0 auto;
                font: 500 100%/1.5 system-ui;
                margin-top: 20px;
            }
            * {
                box-sizing: border-box;
            }

            .row {
                display: -ms-flexbox; 
                display: flex;

                flex-wrap: wrap;
                margin: 0 -16px;
            }


            .col-50 {
                -ms-flex: 50%; /* IE10 */
                flex: 50%;
            }

            .col-75 {
                -ms-flex: 75%; /* IE10 */
                flex: 75%;
            }

            .col-25,
            .col-50,
            .col-75 {
                padding: 0 16px;
            }

            .container1 {
                
                background-color: #f2f2f2;
                padding: 5px 20px 15px 20px;
                border: 1px solid lightgrey;
                border-radius: 3px;
                width: 100%;
                display: flex;
            }

            input[type=text] {
                width: 100%;
                margin-bottom: 20px;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            label col-50 {
                margin-bottom: 10px;
                display: block;
            }



            .btn {
                 background-color: black;
                color: white;
                padding: 12px;
                margin: 10px 0;
                border: none;
                width: 17%;
                border-radius: 3px;
                cursor: pointer;
                font-size: 17px;
                display: flex;
            }

            .btn:hover {
                background-color: #45a049;
            }

            a {
                color: #2196F3;
            }

            hr {
                border: 1px solid lightgrey;
            }

            span.price {
                float: right;
                color: grey;
            }

            @media (max-width: 800px) {
                .row {
                    flex-direction: column-reverse;
                }
                .col-25 {
                    margin-bottom: 20px;
                }
            }

            nav img{
                height:80px;
                margin-left: 20px;
            }
            .container2 {
                background-color: #f2f2f2;
                padding: 5px 20px 15px 20px;
                border: 1px solid lightgrey;
                border-radius: 3px;
            }
            .add{
                padding-top: 5px;
                font-size: 14px;
                font-family: 'Open Sans';
                font-weight: 600;
                color: blue;
                cursor: pointer;
            }

        </style>
    </head>
    <body>
        <nav>
            <label class="logo">To Pie For</label>
            <ul class="nav_links">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="index.jsp">Log out</a></li>
                <li><a href="cart.jsp">View Cart</a></li>
            

            </ul>
        </nav>


      <div class="col-25">
            <div class="container2">
                <h4>Your Order <span class="price" style="color:black"></i> <b><%=user.getEmail()%></b></span></h4>
                <div class='add'> <li><a href="cart.jsp">Edit your order </a></li>
                    <li><a href="#">Get the invoice</a></li></div>

                <hr>
                <div>
                    
               <%
                 
                 for (OrderLineItem cart : myCart) {
    
             %>
                    <hr>
                    
                   <p><%=cart.getQuantity()%>x   <%=cart.getProductName()%> <span class="price">R<%=dcf.format(cart.getProductPrice())%></span></p>         
                    <hr>
                   
                     <% }%>
                </div>
                <hr>
                <hr>
                <p>Total <span class="price" style="color:black"><b>R<%=dcf.format(osi.calTotAmnt(myCart))%></b></span></p>
            </div>
        </div>

        <div class="lterName">
            <h1>Complete the form for payments</h1>
        </div>

        <div class="col-75">
            <div class="container1">
                <form method = "post" action="addCard?ids=3">

                    <div class="row">
                        <div class="col-50">
                            <h3>Delivery Address</h3>
                            <label for="fname">Name</label>
                            <input type="text" id="fname" name="firstname" value="<%=user.getFirstName()+"  "%><%=user.getLastName()%>"readonly>
                            <label for="email"><i class="fa fa-envelope"></i> Email</label>
                            <input type="text" id="email" name="email" value="<%=user.getEmail()%>"readonly>
                            <label for="adr"><i class=""></i> Address</label>
                            <input type="text" id="adr" name="address" value="<%=user.getAddress()%>"readonly>
                         

                            <div class="row">
                                <div class="col-50">
                                  
                                 
                                </div>
                                <div class="col-50">
                                    
                                </div>
                            </div>
                        </div>

                        <div class="col-50">
                            <h3>Payment</h3>

                            <nav >
                                <center>
                                    <img src="picture/visa.webp" alt="" />
                                    <img src="picture/master.png" alt="" />
                                   <!-- <img src="discovery.png" alt="" /> !-->

                                </center>



                            </nav>
                            <label for="cname">Bank Name</label>
                            <input type="text" id="cname" name="cardname" value="" />
                            <label for="ccnum">Credit card number</label>
                            <input type="text" id="ccnum" name="cardnumber" value=""/>
                            <label for="expmonth">Exp Month</label>
                            <input type="text" id="expmonth" name="expmonth" value=""/>
                            <div class="row">
                                <div class="col-50">
                                    <label for="expyear">Exp Year</label>
                                    <input type="text" id="expyear" name="expyear" value=""/>
                                </div>
                                <div class="col-50">
                                    <label for="cvv">CVV</label>
                                    <input type="text" id="cvv" name="cvv" value="">
                                    <input type="hidden" id="userId" name="userId" value="<%=user.getCustomerId()%>">
                                </div>
                            </div>
                        </div>

                    </div>
                    <center>
                        <input name="pay" type="submit" value="Add New Card" class="btn"><a href="addCard?id="></a></input>
                    </center>

               </form>
            </div>
                                
        </div>




    </body>
</html>
