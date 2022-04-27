<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<div class="dropdown">
    <div class="container-fluid">
        <button class="btn btn-brown btn-block mt-2" style="width: 200px;">Категории</button>
        <div class="dropdown-content">
            <c:forEach var="category" items="${requestScope.categories}">
                <a id="category"
                   href="${pageContext.request.contextPath}/main/category?category_id=${category.categoryId}">${category.name}</a>
            </c:forEach>
        </div>
    </div>
</div>
</body>
