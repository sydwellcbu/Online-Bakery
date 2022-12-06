<%-- 
    Document   : editCategory
    Created on : Nov 7, 2022, 1:49:52 PM
    Author     : Aubrey
--%>

<%@page import="za.online.bean.Category"%>
<%@page import="za.online.dao.impl.CategoryDAOImpl"%>
<%@page import="za.online.dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    
    int id = Integer.parseInt(request.getParameter("id"));
    CategoryDAO categoryData = new CategoryDAOImpl();
    Category categoryInst = categoryData.getCategory(id);
    request.setAttribute("editCat", categoryInst );
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit category Page</title>
    </head>
    <style>
        
        
         body{
                
                background-color:white;
                font-family: montserrat;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }
          .reg-Container{

             
                padding: 1rem;
                grid-template-columns: 300px 1fr;
                gap: 1rem;
                align-items: center;
                max-width: 700px;

                margin: 0 auto;
                font: 500 100%/1.5 system-ui;
                margin-top: 50px;

            }
           
    </style>
    <body>
       
        <h1 align = "center" >Edit category </h1>
        
       
        <div class="reg-Container">
        
                <form "method="POST" action ="EditServlet">
                <h for="CategoryId"><b>Category Id</b></h>
                <br>
                 <input type="text"  name="categoryId"  value ="${editCat.categoryId}">
                 <br>
                   
                <h for="Category_name"><b>Category Name</b></h>
                <br>
                <input type="text"  name="Category_name" value ="${editCat.categoryName}">
                <br>
                 <br>
                   
                <h for="Category_name"><b>Active</b></h>
                <br>
                <input type="text"  name="active" value ="${editCat.active}">
                <br>
                <h for="Category_pic"><b>Category Picture</b></h>
                  <br>
                <input type="file" name ="Category_pic" value="${editCat.categoryPic}"/>
                <hr>

                <input type="submit" value="UPDATE">
             </form>
        </div>
       
        
       
        
    </body>
</html>
