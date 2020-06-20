<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
       <h1>WELCOME ALIENS!</h1>
       <form action="addAlien">
        <p>Alien id:<input type="text" name="aid"><br></p>
        <p>Alien Name:<input type="text" name="aname"><br></p>	
        <input type="submit" value="Submit"><br>
       </form> 
       
        <form action="getAlien">
        
           Enter Alien id to be searched: <input type="text" name="alienId">
           <input type="submit" value="Search Alien"><br>
          
        </form>
       <br>
       <br>
       <form action="deleteAlien">
       
           Enter Alien id to be deleted: <input type="text" name="alienId">
         <input type="submit" value="Delete Alien"> <br>
       </form>
        
       
</body>
</html>