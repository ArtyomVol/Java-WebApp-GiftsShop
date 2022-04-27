<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<c:if test="${sessionScope.account != null && sessionScope.account.roleId == 1}">
    <form action="${pageContext.request.contextPath}/categories-editing-menu" method="get"
          style="margin-bottom: 5px">
        <button class="btn btn-brown btn-block mt-1" style="width: 200px; margin-left: 15px; font-size: 14px">
            Редактирование категорий
        </button>
    </form>
    <form action="${pageContext.request.contextPath}/item-adding-menu-servlet"
          method="get" style="margin-bottom: 5px">
        <button class="btn btn-brown btn-block" style="width: 200px; margin-left: 15px">
            Добавить товар
        </button>
    </form>
    <form action="${pageContext.request.contextPath}/news-adding-menu"
          method="get">
        <button class="btn btn-brown btn-block" style="width: 200px; margin-left: 15px">
            Добавить новость
        </button>
    </form>
</c:if>
</body>
