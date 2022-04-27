<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование категорий</title>
    <c:import url="/WEB-INF/view/fragment/head.jsp"></c:import>
</head>
<body>
<div class="container-fluid">
    <div class="row mt-3">
        <div class="col-4"></div>
        <div class="card col-md-4 order-md-1 text-center mt-5">
            <h4 class="mb-3 mt-1" style="font-size: 36px">Редактирование категорий</h4>
            <form id="categoryAdd" action="${pageContext.request.contextPath}/category-adding-menu" method="get">
                <button class="btn btn-brown btn-block" id="adding_btn" type="submit">
                    Добавить категорию
                </button>
            </form>
            <form id="categoryEdit" action="category-editing-menu-servlet" method="get">
                <button class="btn btn-brown btn-block" id="editing_btn" type="submit">
                    Изменить категорию
                </button>
            </form>
            <form id="categoryDelete" action="category-deleting-menu-servlet" method="get">
                <button class="btn btn-brown btn-block" id="deleting_btn" type="submit">
                    Удалить категорию
                </button>
            </form>
            <a class="btn btn-brown btn-block mb-3" href="${pageContext.request.contextPath}/main">
                Вернуться
            </a>
        </div>
    </div>
</div>
</body>
</html>
