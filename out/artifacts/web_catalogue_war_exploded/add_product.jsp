<%@ page import="entities.Category" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Category> categories = (List<Category>) request.getAttribute("categories"); %>
<div class="container m-2">
    <form method="post" action="admin">
        <input hidden name="action" value="addProduct">
        <div class="mb-3">
            <label class="form-label">Designation produit</label>
            <input type="text" class="form-control" name="productDesignation" >
        </div>
        <div class="mb-3">
            <label class="form-label">Description</label>
            <input type="textarea" class="form-control" name="productDescription">
        </div>
        <div class="mb-3">
            <label class="form-label">Quantité</label>
            <input type="text" class="form-control" name="productQuantity">
        </div>
        <div class="mb-3">
            <label class="form-label">Prix</label>
            <input type="text" class="form-control" name="productPrice">
        </div>
        <div class="mb-3">
            <label class="form-label">Catégorie</label>
                <select name="productCategory">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.idCategory}">${category.name}</option>
                    </c:forEach>
                </select>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>
<jsp:include page="footer.jsp" />