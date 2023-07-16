<%-- 
    Document   : search
    Created on : Feb 10, 2023, 6:22:17 PM
    Author     : WINDOW
--%>
<%@page import="han.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <h1>Search Page</h1>
        <font color="red">
        <%  
            String user = "";
            if(user==""){
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for (Cookie cookie: cookies){
                    String tmp = cookie.getValue();
                    if(!tmp.equals("JSESSIONID")){
                        user = tmp;
                    }
                }
            }
                %>
                Welcome, <%=session.getAttribute("UserName")%><br/><br/>
    <%      
            }
        %>
        </font>
        Search by last name.
        <form action="MainController">
        Search Value <input type="text" name="txtSearchValue" value=""/></br>
        <input type="submit" value="Search" name="btAction" class="searchButton"/>
        </form>
        
        </br>
        <% 
            String searchValue = request.getParameter("txtSearchValue");
            
            if(searchValue != null){
                List<RegistrationDTO> result = (List<RegistrationDTO>)request.getAttribute("SEARCHRESULT");
                
                if(result != null){
                    %>
                    <table border='1'>
                        <thead>
                            <tr style='background-color:LightBlue'>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Lastname</th>
                                <th>Role</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int count = 0;
                                for (RegistrationDTO dto : result){
                                    String urlRewriting = "MainController?btAction=Delete&pk=" + dto.getUsername() + "&lastSearchValue=" + request.getParameter("txtSearchValue");
                            %>
                            <form action="MainController">
                            <tr>
                                <td>
                                    <%= ++count %>
                                </td>
                                <td>
                                    <%= dto.getUsername() %>
                                    <input type="hidden" name="txtUsername" value="<%= dto.getUsername() %>"/>
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" value="<%= dto.getPassword() %>"/>                                   
                                </td>
                                <td>
                                    <%= dto.getLastname() %>
                                    <input type="hidden" name="lastname" value="<%= dto.getLastname() %>"/>
                                </td>
                                <%
                                if (dto.isRole()==true) {
                                %>
                                <td>
                                    <%= dto.isRole() %><input type="checkbox" name="checkRole" value="<%= dto.isRole() %>" checked/>
                                </td>
                                <%
                                } else {
                                %>
                                <td>
                                    <%= dto.isRole() %><input type="checkbox" name="checkRole" value=""/>
                                </td>
                                <%
                                }
                                %>
                                <td>
                                    <a href="<%= urlRewriting %>">Delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="lastSearchValue" value="<%= request.getParameter("txtSearchValue") %>"/>
                                    <input type="submit" name="btAction" value ="Update"/>
                                </td>
                            </tr>
                            </form>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
            <%
                }else{
            %>
                <h2>No record is matched!!!</h2>
        <%
                }
            }
        %>
        <a href="gameStore.html">Click here to buy Games for your Game Console</a>
    </body>
</html>
