<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center">
<tr>
<td align="center">
<form action="save-user" method="post"><b>register Here</b>
<div class="container">

    <label for="uname"><b>username</b></label>
    <input type="text" placeholder="Enter username" name="username" required value="${ user.username}"><br>

<label for="fname"><b>firstname</b></label>
    <input type="text" placeholder="Enter firstname" name="firstname" required value="${ user.firstname}"><br>

<label for="lname"><b>lastname</b></label>
    <input type="text" placeholder="Enter lastname" name="lastname" required value="${ user.lastname}"><br>

<label for="age"><b>age</b></label>
    <input type="text" placeholder="Enter age" name="age" required value="${ user.age}"><br>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required value="${ user.password}"><br>

    <button type="submit" value="Register">Register</button>
    </div>
  
  
  </td>
  </tr>
  </table>
</body>
</html>