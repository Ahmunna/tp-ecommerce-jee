<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Product" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp" />
<% List<Product> products = (List<Product>) request.getAttribute("products"); %>
<div class="container">
    <div class="d-flex justify-content-around flex-row m-2">
        <c:forEach items="${products}" var="product">
            <div class="card" style="width: 18rem;">
                <img src="assets/product.png" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${product.designation}</h5>
                    <p class="card-text">Prix : ${product.price}</p>
                    <a href="#" class="btn btn-primary">Ajouter au panier</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<jsp:include page="footer.jsp" />