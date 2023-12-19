<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signin Page</title>
 <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/index.css"></c:url>"></head>
<body>
  <header style="margin-top:-1%;">
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
        <div class="b">
        
   		<form action="getRegisterPage" method="post" >
		
		<input type="submit" value="Signup"> 
		</form>
		</div>
  		
        </h1>
       
     </header>
		 <span style="color:red"><a href="index.jsp"><button >Back</button></a></span>
		 <br><br>
		 <h5 align="center" style="margin-top:-15px;color:red;">${responseMessage}</h5>
		 <br><br>
       <div class="form-container">
       
		
			<h3 align="center">SIGN IN</h3>
			<img src="https://cdn-icons-png.flaticon.com/128/4449/4449949.png" width="50px" height="50px" style="padding-left:42%;">
        <form action="userLoginpage" method="post">
			
		    
            <input type="email" id="EMAIL" name="email" placeholder="User Name" required>

            <input type="text" id="PASSWORD" name="password" placeholder="Password"  required>

            
            <input type="submit" value="Submit">
        </form>
        <br>
         <form action="updatePassword" method="post">
        	<input type="submit" value="ResetPassword">
        </form>
    </div>
    <footer style="margin-top:3%"></footer>
   
</body>
</html>