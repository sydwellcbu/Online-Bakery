<%-- 
    Document   : product
    Created on : Nov 1, 2022, 10:43:16 AM
    Author     : TRAIN 20
--%>

<%@page import="java.util.List"%>
<%@page import="za.online.bean.Product"%>
<%@page import="za.online.dao.impl.ProductDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
   int id = Integer.parseInt(request.getParameter("id"));
 ProductDAOImpl p = new ProductDAOImpl();
    Product product = new Product();
   List<Product> prod = p.categoryProduct(id);
    request.setAttribute("productList", prod);
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
                margin-top:10px;
            }
     
      

     


            .user-data img{

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
            <label class="logo">PRODUCTS</label>
            <ul class="nav_links">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="Userprofile.jsp">Profile</a></li>
                <li><a href="index.jsp">Log out</a></li>

                <li> <a href="cart.jsp"><img src="picture/shopping-cart-icon.webp" alt="" /></a></li>
            </ul>
        </nav>




        <div class="lterNameinput">
            <label for="gsearch">Search product:</label>
            <input type="search" id="gsearch" name="gsearch">
            <input type="submit">

        </div>
        <div class="lterName">
            <h1>Breads</h1>

        </div>


        <div class="flex-container">





            <div class="fo-group">

               <c:forEach var = "prod" items ="${productList}">
                 <form method="POST" action="CatgeoryProducts" >


                    <div class="user-data">
                        <center>
                        <div class="group-data">
                           
                            <p id="_role"  style="color:red; font-weight: bold;  font-size: 20px">10% OFF</p>
                        </div>
                            </center>
                         <img src="${prod.productPic}" alt="h" height="" width="500" /><img>
                    </div>




                    <div class="fo-group1">


                        <div class="group-data">
                         <p>${prod.productName}</p>
                        </div>


                        <div class="fo-group2">

                            <div class="group-data">
                          <p>${prod.productDesc}</p> 
                            </div>
                        </div>

                      
                        <div class="group-data">
                            <p id="_role"style="color:blue; font-weight: bold; font-size: 20px">R${prod.price}</p>
                        </div>
                        
                        <div class="group-data">
                            <input type="submit" value="Add to cart" />
                        </div>
                    </div>


            </div>

        </form>
                         </c:forEach>
    </div> 




</div>



</body>
</html>