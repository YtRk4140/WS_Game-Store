<%-- 
    Document   : viewCart
    Created on : Mar 10, 2023, 12:38:33 AM
    Author     : WINDOWS
--%>

<%@page import="java.util.Map"%>
<%@page import="han.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Game Store</title>
        </head>
        <body>
            <h1>Your Cart includes </h1>
            <%
                if (session != null) {
                    CartObj cart = (CartObj) session.getAttribute("CART");
                    if (cart != null) {
                        if (cart.getItems() != null) {
            %>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <form action="MainController">
                                    <%
                                        float total = 0;
                                        Map<String, Map<Float, Integer>> items = cart.getItems();
                                        int count = 0;
                                        for (Map.Entry item: items.entrySet()) {
                                        String title = (String)item.getKey();
                                            Map<Float, Integer> infos = cart.getItemsValue(title);
                                            
                                    %>
                                    <tr>
                                        <td>
                                            <%= ++count %>
                                        </td>
                                        <td>
                                            <%= item.getKey() %>
                                        </td>
                                        <td>
                                            <%
                                            for (Map.Entry info: infos.entrySet()) {
                                                int num = (Integer)info.getValue();
                                                float price = (float)info.getKey();
                                            %>
                                                <%= num %>
                                            
                                        </td>
                                        <td>
                                            
                                                $<%= price %> USD
                                            <%
                                                
                                                float totalPrice = price*num;
                                                total = total + totalPrice;
                                            }
                                            %>
                                        </td>
                                        <td>
                                            <input type="checkbox" name="chkItem" value="<%= item.getKey() %>"/>
                                        </td>
                                    </tr>

                                    <%
                                        }
                                    %>
                                    <tr>
                                        <td>
                                            TOTAL
                                        </td>
                                        <td colspan="4">
                                            $<%= (double) Math.round(total*100)/100 %> USD
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">
                                            <a href="gameStore.html">Add More Items to Your Cart</a>
                                        </td>
                                        <td colspan="2">
                                            <input type="submit" value="Remove Selected Items" name="btAction" />
                                        </td>
                                    </tr>
                                </form>
                            </tbody>
                        </table>
        <%
                        return;
                    }
                }
            }
        %>
        <h2 style="color: red">No cart is existed</h2>
        <a href="gameStore.html">Add More Items to Your Cart</a>
    </body>
</html>

