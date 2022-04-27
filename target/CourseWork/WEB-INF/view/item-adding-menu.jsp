<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление товара</title>
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
            <h4 class="mb-3 mt-1" style="font-size: 36px">Добавление товара</h4>
            <form id="itemAddingForm" action="item-adding-menu-servlet"
                  enctype='multipart/form-data' method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" id="item_name" name="item_name"
                           placeholder="Название товара" value="${requestScope.itemName}">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" id="item_description" name="item_description"
                           placeholder="Описание"
                           value="${requestScope.itemDescription}">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" id="item_cost" name="item_cost" placeholder="Цена"
                           value="${requestScope.itemCost}">
                </div>
                <div class="mb-2">
                    <input id="uploadedFileID" type="file" name="uploaded_file" accept="image/jpeg,image/png"/><br>
                </div>
                <div class="mb-3">
                    <label>Категория</label>
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
                <button class="btn btn-brown btn-block" id="additing_button" type="submit">
                    Добавить
                </button>
                <a class="btn btn-brown btn-block mb-3" href="${pageContext.request.contextPath}/main">
                    Вернуться
                </a>
            </form>
        </div>
    </div>
</div>
</body>
</html>