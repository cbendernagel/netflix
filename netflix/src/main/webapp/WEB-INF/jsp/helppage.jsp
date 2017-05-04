<%-- 
    Document   : helppage
    Created on : May 4, 2017, 1:31:22 PM
    Author     : pliao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <p>Customers:<br>
-sign in using your account id<br>
-navigate to the movies page where you can add <br>
movies to your queue and rent them by clicked <br>
the buttons that are clearly labeled. A customer rep <br>
must approve your order.<br>
-You can view your account, orders and queue in the account page.<br>
-The Movie page will allow you to filter movies by genre and <br>
when you click on a movie you can view its info<br>
        This is where you would add to your queue or rent.</p>

<p>Customer Rep:<br>
-log in with your id<br>
-Approve orders by clicking the button<br>
-Have access to customer account information which they can <br>
edit on the customer page.</p>

<p>Manager:<br>
    -log in with id<br>
    -to edit customer,movie, employee just type in the new<br>
and hit submit</p>

    </body>
</html>
