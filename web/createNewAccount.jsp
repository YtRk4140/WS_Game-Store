<%@page import="han.registration.RegistrationInsertError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" confent="text/ntml; charset=UTE-2">
        <title>New Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        
        <form action="MainController" method="POST">
            Username* <input type="text" name="textUsername" value="<%= request.getParameter("textUsername")%>" />(4 - 20 chars)<br/>
            <font color="red">
                    <%
                        HttpSession sessions = request.getSession();
                        RegistrationInsertError errors = (RegistrationInsertError)sessions.getAttribute("INSERTER");
                        if (errors != null) {
                            if (errors.getUsernameLengthErr() != null) {
                    %>
                                <%= errors.getUsernameLengthErr()%><br/>

                    <%  
                            }
                        }
                    %>
            </font>
            Password* <input type="password" name="textPassword" value="" />(4 - 30 chars)<br/>
            <font color="red">
                <%
                    if (errors != null) {
                        if (errors.getPasswordLengthErr()!= null) {
                %>
                            <%= errors.getPasswordLengthErr () %><br/>
                <%  
                        }
                    }
                %>
            </font>
            Confirm* <input type="password" name="textConfirm" value=""/><br/>
            <font color="red">
                <%
                    if (errors != null) {
                        if (errors.getConfirmNotMatch()!= null) {
                %>
                            <%= errors.getConfirmNotMatch()%><br/>
                <%  
                        }
                    }
                %>
            </font>
            Last name <input type="text" name="textLastName" value="<%= request.getParameter("textLastName")%>" />(2 - 50 chars)<br/>
            <font color="red">
                <%
                    if (errors != null) {
                        if (errors.getLastNameLengthErr()!= null) {
                %>
                            <%= errors.getLastNameLengthErr()%><br/>
                <%  
                        }
                    }
                %>
            </font>
            <input type="submit" value="Create New Account" name="btAction"/>
            <input type="reset" value="Reset"/>
        </form><br/>
        <font color="red">
            <%
                if (errors != null) {
                    if (errors.getUsernameIsExisted()!= null) {
            %>
                        <%= errors.getUsernameIsExisted()%><br/>
            <%  
                    }
                }
            %>
        </font>
    </body>
</html>
