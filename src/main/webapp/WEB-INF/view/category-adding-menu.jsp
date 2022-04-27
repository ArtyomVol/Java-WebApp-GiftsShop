<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление категории</title>
    <c:import url="/WEB-INF/view/fragment/head.jsp"></c:import>
</head>
<body>
<div class="container-fluid">
    <div class="text-center">
        <pre><label style="color:red">${requestScope.errorCode}</label></pre>
        <pre><label style="color:green">${requestScope.successCode}</label></pre>
    </div>
    <div class="row mt-3">
        <div class="col-4"></div>
        <div class="card col-md-4 order-md-1 text-center mt-5">
            <h4 class="mb-3 mt-1" style="font-size: 36px">Добавление категории</h4>
            <form id="categoryAddingForm" action="category-adding-menu-servlet" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" id="category_name" name="category_name"
                           placeholder="Название категории" value="${requestScope.categoryName}">
                </div>
                <button class="btn btn-brown btn-block" id="adding_button" type="submit">
                    Добавить категорию
                </button>
                <a class="btn btn-brown btn-block mb-2" href="${pageContext.request.contextPath}/categories-editing-menu">
                    Вернуться
                </a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
