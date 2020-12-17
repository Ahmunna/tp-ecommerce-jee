<jsp:include page="header.jsp" />
<div class="container m-2">
    <form method="post" action="admin">
        <input hidden name="action" value="addCategory">
        <div class="mb-3">
            <label class="form-label">Nom catégorie</label>
            <input type="text" class="form-control" name="categoryName" >
        </div>
        <div class="mb-3">
            <label class="form-label">Description</label>
            <input type="textarea" class="form-control" name="categoryDescription">
        </div>
        <div class="mb-3">
            <label class="form-label">Categorie Image</label>
            <input type="file" class="form-control" name="categoryImage">
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>
<jsp:include page="footer.jsp" />