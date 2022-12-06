<%-- 
    Document   : index
    Created on : Oct 31, 2022, 11:56:40 AM
    Author     : TRAIN 20
--%>

<%@page import="za.online.bean.OrderLineItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="za.online.service.impl.OrderLineItemServiceImpl"%>
<%@page import="za.online.service.impl.OrderLineItemServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="za.online.bean.Category"%>
<%@page import="za.online.service.impl.CategoryServiceImpl"%>
<%@page import="za.online.service.CategoryService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    CategoryService categoryData = new CategoryServiceImpl();
    List<Category> category = categoryData.viewAllCategory();
    Category categoryInst = new Category();
    request.setAttribute("categoryList", category);
    //----------------------------
     OrderLineItemServiceImpl olit = new OrderLineItemServiceImpl();
    List<OrderLineItem> myCart = new ArrayList();
    //  session.setAttribute("OrderLineItem", myCart);
    myCart = (ArrayList) session.getAttribute("OrderLineItem");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>

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

            .background-image{

                background-size: cover;
                background-repeat: no-repeat;
                height: 100vh;
            }
            .wallpaper img{
                border: 1px solid #ddd;
                border-radius: 4px;
                width: 100%;
                height: 400px;


            }
            .lterName h1{
                margin-top: 30px;
                font-size: 70px;
                text-align: center;
                display: flex;
                align-items: center;
                justify-content: center;
                font-size: 70px;
                text-shadow: 2px 2px;
            }


            .image-gallery {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
                gap: 30px;
            }

            .image-gallery  li {
                flex-basis: 250px; 
            }

            .image-gallery li img {
                object-fit: cover;
                width: 100%;
                height: 100%;
                vertical-align: middle;
                border-radius: 10px;
            }
      <%-- overlay {
                position: absolute;
                width: 100%;
                height: 100%;
                background: rgba(57, 57, 57, 0.502);
                top: 0;
                left: 0;
                transform: scale(0);
                transition: all 0.2s 0.1s ease-in-out;
                color: #fff;
                border-radius: 5px;
                /* center overlay text */
                display: flex;
                align-items: center;
                justify-content: center;
                font-size: 70px;
                text-shadow: 2px 2px;

            } 

            /* hover */
            .image-gallery li:hover .overlay {

                margin-top: 40%;
                transform: scale(0.60);
            } --%>

            footer{
                margin-top: 20px;
                background: #505761;
                height: 80px;
                width: 100%;

            }

       footer p{
                color: white;
                font-size: 15px;
               
            
            }

            footer ul{
                display: flex;
                align-items: center;
                justify-content: center;

            }
            footer ul li{
                margin-left: 5%;

            }
            footer img{
                margin-top: 20px;
                height: 30px;

            }
            
            .badge {
                position: absolute;
                top: 25px;
                right: 20px;
                padding: 5px 10px;
                border-radius: 100%;
                background-color: blue;
                color: white;
            }

        </style>
    </head>
    <body>
      <nav>
            <label class="logo">To Pie For</label>
            <ul class="nav_links">
                
                    <%
                        if (session.getAttribute("UserSession") == null) {

                    %>
                  <li><a href="login.jsp">Login</a></li>
                  <li><a href="product.jsp">Products</a></li>
                

                 
              <% }else{  

              %>
            
                <li><a href="product.jsp">Products</a></li>
                     <li><a href="LogOut">Log out</a></li>
                     <li> <a href="Userprofile.jsp"><img src="picture/profile.png" alt="" /></a></li>
                   <li> <a href="cart.jsp"><img src="picture/shopping-cart-icon.webp" alt="" /></a></li>
                   <span class="badge"><%=olit.numberOfOrderlineItems(myCart)%></span>
                   
                
               <% }%>
            </ul>
        </nav>

     
        <div class="wallpaper">
            <img src="picture/pexels-suzy-hazelwood-1126359.jpg">

        </div>
        <div class="lterName">
            <h1>CATEGORIES</h1>

        </div>

        <div class="container">

            <ul class="image-gallery">
              
                   
                 <c:forEach var ="cat" items="${categoryList}">
                       <li>
                             <div class="overlay"><span>${cat.categoryName}</span></div> 
                             <a  href="CatgeoryProducts?id=${cat.categoryId}">
                            <img src ="${cat.categoryPic}"></img></a>
                                </li>
                    </c:forEach>
                    

            </ul>
        </div>
        

    </body>
    
     <footer>
           
            <ul>
                 <p>We provide quality services </p>
           
        </footer>
</html>
