<%-- 
    Document   : IngredientEdit
    Created on : 30 Nov 2022, 9:50:03 PM
    Author     : User
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


            .updateBtn {
                background-color: #04AA6D;
                color: white;
                padding: 10px 3px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 20%;

            }

            .updateBtn:hover {
                opacity: 1;
            }

            .cancelBtn {
                background-color: #04AA6D;
                color: red;
                padding: 10px 3px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 20%;

            }

            .cancelBtn:hover {
                opacity: 1;
            }
            cancelBtn

            a {
                color: dodgerblue;
            }


            .signin {

                text-align: center;
            }
        </style>
    </head>
    <body>
        <nav>
            <label class="logo">To Pie For</label>
            <ul class="nav_links">
            </ul>
        </nav>

        <div class="reg-Container">
            <form method="POST" action="">
                <br>
                <h1>Edit Ingredient</h1>

                <hr>

                <h for="ingredientName"><b>Ingredient Name</b></h>
                <hr>
                <input type="text"  name="ingredientName" value ="" >

                <h for="avail"><b>Available Stock</b></h>
                <hr>
                <input type="text"  name="avail" value ="" readonly="">

                <label for="minStock"><b>Minimum Stock</b></label>

                <input type="text"  name="minStock" value ="">

                <label for="maxStock"><b>Maximum Stock</b></label>

                
                <hr>
                <button type="submit" class="updateBtn">Update</button>
                <button type ='button' class ="cancelBtn"><a href="ingredient.jsp">Cancel</a></button>

            </form>
               
        </div>

    </body>
</html>
