<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <form method="post" action="i.do">
        <input hidden name="action" value="login">
        <div class="form-group">
            <label class=""form-label>Email address</label>
            <input type="email" class="form-control" name="email">
        </div>
        <div class="form-group">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="password">
        </div>
        <small><a href="#">Mot de passe oublié ?</a></small>
        <small><a href="#">Pas encore membre ? Inscrivez-vous</a></small>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    <div class="alert alert-danger" role="alert">

    </div>
</div>

<jsp:include page="footer.jsp" />