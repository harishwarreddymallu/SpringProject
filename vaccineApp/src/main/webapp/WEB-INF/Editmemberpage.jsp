<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddMemberRegister Page</title>
 <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/index.css"></c:url>">
   <style>header{
    border:1px solid grey;
    background-color:#10EAF0;

    
}
body {
  background-image: url('https://www.pixelstalk.net/wp-content/uploads/images1/Backgrounds-Medical-HD.jpg' );
  background-size: cover;
}
footer{
    border:1px solid grey;
    background-color: #10EAF0;
    text-align:center;
    padding-top:2% ;
    padding-bottom:3%;
	}	
form{

	border:1px grey 
}
.form-container {
	max-width: 400px;
	margin: 0 auto;
	background: #FCFFB2;
    padding: 20px;
    margin-top:-4%;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-container input[type="text"],
.form-container input[type="email"],
.form-container input[type="password"],
.form-container input[type="number"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    margin-bottom: 10px;
    box-sizing: border-box;
}

.form-container input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
}

.form-container input[type="submit"]:hover {
    background-color: #45a049;
}
.b{
	margin-top:-6%;
	padding-left:85%;
	
	}
			
	 
   </style>
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
         <h5 align="right" style="margin-top:-73px;padding:15px;color:black;font-family:Garamond, serif;"><% out.println(session.getAttribute("EMAIL"));%></h5>
</h1>
 </header>
<br>
<h4 align="center" style="margin-top:-15px;color:red">${responseMessage}</h4>
 <div class="form-container">
 	<h3 align="center">Update Member Details</h3>
		    <img src="https://cdn-icons-png.flaticon.com/128/4449/4449949.png" width="50px" height="50px" style="padding-left:45%;">
        	<form  action="${pageContext.request.contextPath}/updateMember"  >

			Id
            <input type="number" id="memberid" name="memberid" required value="${ID}">
			
		    
            Name
            <input type="text" id="membername" name="membername" required value="${NAME}">

            Gender<br><br>
            <input type="radio" value="Male" id="Male" name="gender"  value="${GENDER}" required>Male
            
           	<input type="radio" value="Female" id="Female" name="gender"  value="${GENDER}" required>Female<br><br>

            Date Of Birth<br><br>
            <input type="date" id="dob" name="dob"  required value="${DATE_OF_BIRTH}"><br><br>
            Id Proof<br><br>
          	<select id="idProof" name="idProof" value="${IDPROOF}">
			    <option value="aadhar">Aadhar Card</option>
			    <option value="pancard">PAN Card</option>
			    <option value="drivinglicense">Driving License</option>
			</select>
			<br><br>
			 Id Proof No
            <input type="text" id="idproofno" name="idproofno" value="${ID_PROOF_NO}" required>
			<br>
			Vaccine Type<br><br>
          	<select id="idProof" name="vaccinetype" value="${VACCINE_TYPE}">
			    <option value="Covishield">Covishield</option>
			    <option value="Covaxin">Covaxin</option>
			    <option value="Covovax">Covovax</option>
			    <option value="Corbevax">Corbevax</option>
			    <option value="Sinopharm COVID-19 vaccine">Sinopharm COVID-19 vaccine</option>
			    <option value=""></option>
			</select><br><br>
			
			No Of Doses<br><br>
			<select id="idProof" name="noofdoses" value="${DOSE}">
			    <option value="1">1</option>
			    <option value="2">2</option>
			    <option value="3">3</option>
			</select>
			 <br><br>
			 Reference Email
            <input type="email" id="refemail" name="refemail" required value="${REF_EMAIL}">
            <input type="submit" value="Edit">
            
        </form>
</div>
    <footer ></footer>
    
   
</body>
</html>
