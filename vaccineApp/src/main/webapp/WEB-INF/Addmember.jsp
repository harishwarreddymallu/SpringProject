<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddMemberRegister Page</title>
 <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/index.css"></c:url>">
    <script src="register.js"></script>
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
       
        
		
		</div>
		</h1>
		<a href="getallMemberDetails" ><button>ViewMembers</button></a>
	
  		
        
       
     </header>
     <span style="color:red"><form action="getHome"><input type="submit" value="Back"></form></span>
		 <br>
		 <h4 align="center" style="margin-top:-15px;color:red">${responseMessage}</h4>
		 
		 
		 
     
         <div class="form-container">
       
		
			<h3 align="center">Add Member</h3>
		    <img src="https://cdn-icons-png.flaticon.com/128/4449/4449949.png" width="50px" height="50px" style="padding-left:45%;">
        	<form  action="Addmemberreg" method="post" >

			
		    
            Name
            <input type="text" id="memberid" name="membername" required>

            Gender<br><br>
            <input type="radio" value="Male" id="Male" name="gender"  >Male
            
           	<input type="radio" value="Female" id="Female" name="gender"  >Female<br><br>

            Date Of Birth<br><br>
            <input type="date" id="dob" name="dob"  required><br><br>
            Id Proof<br><br>
          	<select id="idProof" name="idProof">
			    <option value="aadhar">Aadhar Card</option>
			    <option value="pancard">PAN Card</option>
			    <option value="drivinglicense">Driving License</option>
			</select>
			<br><br>
			 Id Proof No
            <input type="text" id="idproofno" name="idproofno" required>
			<br>
			Vaccine Type<br><br>
          	<select id="idProof" name="vaccinetype">
			    <option value="Covishield">Covishield</option>
			    <option value="Covaxin">Covaxin</option>
			    <option value="Covovax">Covovax</option>
			    <option value="Corbevax">Corbevax</option>
			    <option value="Sinopharm COVID-19 vaccine">Sinopharm COVID-19 vaccine</option>
			    <option value=""></option>
			</select><br><br>
			
			No Of Doses<br><br>
			<select id="idProof" name="noofdoses">
			    <option value="1">1</option>
			    <option value="2">2</option>
			    <option value="3">3</option>
			</select>
           <br><br>
            Reference Email
            <input type="email" id="refemail" name="refemail" required value="<%out.print(session.getAttribute("EMAIL"));%>">
           
        	
            <input type="submit" value="submit">
            
			
            
        </form>
       
    </div>
    
    
       <br><table border="1" width="100%" style="background-color:#FBE8E7;">
	<tr>
	<th>${Member_ID}</th>
	<th>${Member_NAME}</th>
	<th>${GENDER}</th>
	<th>${DATE_OF_BIRTH}</th>
	<th>${ID_PROOF}</th>
	<th>${ID_PROOF_NO}</th>
	<th>${VACCINE_TYPE}</th>
	<th>${DOSE}</th>
	<th>${EDIT}</th>
	<th>${DELETE}</th>
	</tr>
	
	<c:forEach var ="getMember" items="${getMember}">
       <tr>
        <td>${getMember.memberid} </td>
        <td>${getMember.membername} </td>
        <td>${getMember.gender}</td>
        <td>${getMember.dateofbirth}</td>
        <td>${getMember.idproof}</td>
        <td>${getMember.idproofno}</td>
        <td>${getMember.vaccinetype}</td>
        <td>${getMember.vaccinedose}</td>
        <td><a href="editMember/${getMember.memberid}"><button>Edit</button></a></td>
        <td><a href="deleteMember/${getMember.memberid}"><button>Delete</button></a></td>
        </tr>
        
        
         
      </c:forEach>
	
	
	</table>
	
    <footer></footer>
    
   
</body>
</html>