<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
 <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/index.css"></c:url>">
    <script src="register.js"></script>
</head>
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
        <span style="color:#012C0B">T</span>
        <span style="color:brown">A</span> 
        <span style="color:#FF0060">I</span>
        <span style="color:green">L</span>
        <span style="color:purple"id="first">S</span>
        <div class="b">
   		<form action="getLoginPage" method="post" >
		
		<input type="submit" value="Signin"> 
		</form>
		</div>
  		
        </h1>
       
     </header>
		 <span style="color:red"><a href="index.jsp"><button >Back</button></a></span>
		 <h4 align="center" style="margin-top:-15px;color:red">${responseMessage}</h4>
		 <script>
		    function validateForm() {
		        var password = document.getElementById("PASSWORD").value;
		        var confirmPassword = document.getElementById("confirmpassword").value;
		
		        if (password !== confirmPassword) {
		            alert("Password and Confirm Password do not match.");
		            return false; // Prevent the form from submitting
		        }
		
		        // Continue with form submission
		        return true;
		    }
</script>
		 
		 
       <div class="form-container">
       
		
			<h3 align="center">SIGN UP</h3>
		    <img src="https://cdn-icons-png.flaticon.com/128/4449/4449949.png" width="50px" height="50px" style="padding-left:45%;">
        <form id="registrationForm" action="userregister" method="post" onsubmit="return validateForm()">

			
		    
            Name
            <input type="text" id="NAME" name="name" required>

            Email
            <input type="email" id="EMAIL" name="email" required>

            Mobile No
            <input type="text" id="MOBILE_NO" name="mobileno" required>

            Gender<br><br>
            <input type="radio" value="Male" id="Male" name="gender"  required>Male
            
           	<input type="radio" value="Female" id="Female" name="gender"  required>Female<br><br>

            Date Of Birth<br>
            <br><input type="date" id="dob" name="dob"  required><br><br>
            
            Password<br>
            <input type="password" id="PASSWORD" name="password" required>
            
            
            Confirm Password
            <input type="password" id="confirmpassword" name="confirmpassword" required>
           
        	
            <input type="submit" value="submit">
            
			
            
        </form>
       
    </div>
    <footer></footer>
    
   
</body>
</html>