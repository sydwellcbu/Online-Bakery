<%-- 
    Document   : category
    Created on : Nov 2, 2022, 2:54:47 PM
    Author     : TRAIN 20
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            .reg-Container{

                background-color: rgba(255, 255, 255, 0.8);
                -webkit-box-shadow: 0px 1px 20px 14px rgba(0,0,0,0.75);
                -moz-box-shadow: 0px 1px 20px 14px rgba(0,0,0,0.75);
                box-shadow: 0px 1px 20px 14px rgba(0,0,0,0.75);

                padding: 1rem;
                grid-template-columns: 300px 1fr;
                gap: 1rem;
                align-items: center;
                max-width: 700px;

                margin: 0 auto;
                font: 500 100%/1.5 system-ui;
                margin-top: 50px;

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

         

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                border: none;
                background: #f1f1f1;
            }
            
          

            input[type=text]:focus, input[type=password]:focus {
                background-color: #ddd;
                outline: none;
            }

            hr {
                border: 2px solid #f1f2f2;
                margin-bottom: 25px;
            }

           
            .registerbtn {
                background-color: #04AA6D;
                color: white;
                padding: 10px 3px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 20%;
               
            }

            .registerbtn:hover {
                opacity: 1;
            }

       
            a {
                color: dodgerblue;
            }

           
            .signin {
                
                text-align: center;
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
        </style>
    </head>
    <body>
        <nav>
            <label class="logo">BAKERY</label>
            <ul class="nav_links">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="cart.jsp">View Cart</a></li>
                <img src="picture/shopping-cart-icon.webp" alt="" />
            </ul>
        </nav>
<div class="lterName">
            <h1>Admin Portal</h1>

        </div>
        <div class="reg-Container">



            <form method="" action="">

                <br>
                
                    
                        <h1>Edit Profile</h1>
                       
                        <hr>

                        <h for="First_name"><b>First Name</b></h>
                        <input type="text" placeholder="Enter your first name" name="First_name">

                        <label for="Last_name"><b>Last Name</b></label>
                        <input type="text" placeholder="Enter your last name" name="Last_name" >

                        <label for="contact"><b>Contact</b></label>
                        <input type="text" placeholder="Enter your contact number" name="Contact">

                        <label for="Address"><b>Address</b></label>
                        <input type="text" placeholder="Enter your Address" name="Address"

                               <label for="email"><b>Email</b></label>
                        <input type="text" placeholder="Enter Email" name="email" >

                        
                        <hr>
                        
                             <button type="submit" class="registerbtn">Save</button>
                    

                   
                       

                
            </form>




        </div>











        <footer>

            <ul>
                <p>The bakery management system 
                    provides you with your bakery’s data.
                    Daily sales, staff, accounting, customer,
                    delivery reports and more can be run on 
                    your bakery’s POS system. <br> Data comparison
                    is another feature that will give you 
                    a better insight into your ways and methods.
                    All information is on a single platform 
                    and can be accessed from anywhere.</p>
            </ul>
        </footer>
    </body>
</html>
