<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% if (session.getAttribute("adminUserName") == null ) {
    request.getRequestDispatcher("login.jsp").forward(request, response);
 } else {
    request.getRequestDispatcher("admin_panel.jsp").forward(request, response);
}%>

<jsp:include page="footer.jsp" />