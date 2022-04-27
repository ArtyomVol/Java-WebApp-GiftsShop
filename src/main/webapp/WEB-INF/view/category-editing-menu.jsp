<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменение категории</title>
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
            <h4 class="mb-3 mt-1" style="font-size: 36px">Изменение категории</h4>
            <form id="categoryAddingForm" action="category-editing-menu-servlet" method="post">
                <div class="mb-3">
                    <label>Старое название категории</label>
                    <select id="selectName" class="form-control" name="select_name">
                        <c:forEach var="category" items="${requestScope.categories}">
                            <c:if test="${requestScope.categoryId == category.categoryId}">
                                <option id="category_id" value="${category.categoryId}" selected>${category.name}</option>
                            </c:if>
                            <c:if test="${requestScope.categoryId != category.categoryId}">
                                <option id="category_id" value="${category.categoryId}">${category.name}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" id="new_category_name" name="new_category_name"
                           placeholder="Новое название категории" value="${requestScope.newCategoryName}">
                </div>
                <button class="btn btn-brown btn-block" id="editing_button" type="submit">
                    Изменить категорию
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
