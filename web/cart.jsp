<%@ page import="entities.Cart" %>
<%@ page import="java.util.Collection" %>
<%@ page import="entities.Order" %>
<%@ page import="entities.OrderLine" %>
<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Collection<OrderLine> items = (Collection<OrderLine>) session.getAttribute("cart");%>
<% if (items.size() == 0) { %>
<div class="container m-5">
    <div class="alert alert-secondary" role="alert">Votre panier est vide !</div>
</div>
<% } else {
    Cart cart = (Cart) session.getAttribute("cart");
%>
<div class="container m-3">
    <table class="table">
        <thead>
            <th scope="col">name</th>
            <th scope="col">price</th>
            <th scope="col">quantity</th>
            <th scope="col">total</th>
        </thead>
        <tbody>
            <c:forEach var="orderLine" items="cart">
                <tr>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<% }%>



<jsp:include page="footer.jsp" />