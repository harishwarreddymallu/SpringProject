<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
 <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/index.css"></c:url>">
 <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 1200px;
            margin: 20px auto;
            padding:2%;
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 30px;
        }

        .card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: transform 0.3s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-bottom: 1px solid #ddd;
        }

        .card-content {
            padding: 20px;
        }

        .card-title {
            font-size: 1.5rem;
            margin-bottom: 5px;
        }

        .card-description {
            color: #555;
        }
    </style> 
    </head>
<body>
 <script>

        function go() {

            window.location

                    .replace(

                            "getLoginPage",

                            'window',

                            'toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');

            self.close()

        }

    </script>

<header style="margin-top:-2%;">
       <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRuTJM9SBUQWmzBkXoyaF9XfPtoStoBOd3KA&usqp=CAU" width="50px" height="50px" style="padding-left:5px;padding-top:5px">
        <h1 style="margin-top:-5%;margin-left:23%">
    <span style="color:red"id="first">V</span>
        <span style="color:blue">A</span>
        <span style="color:#055E68">C</span>
        <span style="color:#FF0060">C</span>
        <span style="color:green">I</span>
        <span style="color:purple"id="first">N</span>
        <span style="color:#3E065F">A</span>
        <span style="color:#DB005B">T</span>
        <span style="color:brown">I </span>
        <span style="color:#FF2171">O</span>
        <span style="color:purple">N</span>
        <span style="color:#2A1A5E">  </span>
        <span style="color:#950101">D</span>
        <span style="color:blue">E</span>
        <span style="color:#012C0B"id="first">T</span>
        <span style="color:brown">A</span> 
        <span style="color:#FF0060">I</span>
        <span style="color:green">L</span>
        <span style="color:purple"id="first">S</span>
         <h5 align="right" style="margin-top:-73px;margin-bottom:6%;padding:15px;color:black;font-family:Garamond, serif;"><% out.println(session.getAttribute("EMAIL"));%></h5>
        <div class="b">
        <%if (session.getAttribute("EMAIL").equals("")) {%>

	    <a href="getLoginPage"><b>Login </b></a>
	
	    <%} else {%>
	
	    <a href="javascript:go()"><button>Logout</button></a>
	
	    <%}%>
       
   		
		
   		<form action="addmember" method="post"  style="margin-top:5%;margin-left:-860px;margin-top:-2px;">
		
		<input type="submit" value="AddMember"> 
		</form>
		</div>
  		
        </h1>
       
     </header>
     
     
     
     
     <div class="container">
    <div class="card">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNYHx2su9nOj-aa-y1levvH7eWRcuqdRP32w&usqp=CAU" alt="Card Image">
        <div class="card-content">
            <h2 class="card-title" align="center">Register Id</h2>
            <p class="card-description" align="center" style="color:red"><% out.println(session.getAttribute("ID"));%></p>
        </div>
    </div>
    <div class="card">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQH2SXiEUazRgizIP2HftqG_Hlf0DJfKYwXNQ&usqp=CAU" alt="Card Image">
        <div class="card-content">
            <h2 class="card-title" align="center">Name</h2>
            <p class="card-description" align="center" style="color:red"><% out.println(session.getAttribute("NAME"));%></p>
        </div>
    </div>
    <div class="card">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ25XBp_0Z0RMaf8skRAid5_oWygnBZUXiHcg&usqp=CAU" alt="Card Image">
        <div class="card-content">
            <h2 class="card-title" align="center">Total Registrations</h2>
            <p class="card-description" align="center" style="color:red"><% out.println(session.getAttribute("ADDMEMBER"));%></p>
        </div>
    </div>

   

    
</div>
     
     
		
    <footer><marquee>HEALTH IS WEALTH</marquee></footer>
   
</body>
</html>
