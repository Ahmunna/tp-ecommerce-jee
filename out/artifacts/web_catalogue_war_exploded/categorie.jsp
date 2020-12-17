<%@ page import="entities.Category" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Category> categories = (List<Category>) request.getAttribute("categories"); %>
<div class="container">
    <div class="d-flex justify-content-around flex-row m-2">
<c:forEach items="${categories}" var="categorie">
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="assets/ecommerce.png" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">${categorie.name}</h5>
            <p class="card-text">${categorie.description}</p>
            <a href="a.do?action=showProducts&categoryId=${categorie.idCategory}" class="btn btn-primary">Afficher</a>
        </div>
    </div>
</c:forEach>
    </div>
</div>




<jsp:include page="footer.jsp" />
