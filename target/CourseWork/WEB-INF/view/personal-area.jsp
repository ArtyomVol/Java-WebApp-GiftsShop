<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
    <c:import url="/WEB-INF/view/fragment/head.jsp"></c:import>
</head>
<body>
<div class="container-fluid">
    <c:import url="/WEB-INF/view/fragment/header.jsp"></c:import>
    <div class="row">
        <div class="col-2" style="padding-right: 0; padding-left: 0">
            <c:import url="/WEB-INF/view/fragment/categories.jsp"></c:import>
            <c:import url="/WEB-INF/view/fragment/left-admin-panel.jsp"></c:import>
        </div>
        <div class="col-10" style="min-height: 275px">
            <div class="row">
                <div class="col-5">
                    <c:import url="/WEB-INF/view/fragment/searcher.jsp"></c:import>
                </div>
            </div>
            <h4 class="mb-3 mt-1">Имя: ${sessionScope.account.firstName}</h4>
            <h4 class="mb-3 mt-1">Фамилия: ${sessionScope.account.lastName}</h4>
            <h4 class="mb-3 mt-1">Логин: ${sessionScope.account.username}</h4>
            <c:if test="${requestScope.purchases.size() == 0}">
                <h4 class="mb-3 mt-1" style="font-size: 40px">Список покупок пуст</h4>
            </c:if>
            <c:if test="${requestScope.purchases.size() > 0}">
                <h4 class="mb-3 mt-1" style="font-size: 40px">Покупки</h4>
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Товар</th>
                            <th scope="col">Название</th>
                            <th scope="col">Стоимость</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="purchase" items="${requestScope.purchases}">
                            <tr>
                                <th style="width: 60px">
                                    <img src="${pageContext.request.contextPath}/media/${purchase.item.imageLink}"
                                         style="height: 50px; width: 50px; display: block;">
                                </th>
                                <td>
                                    <label>${purchase.item.name}</label>
                                </td>
                                <td>${purchase.item.cost} бел. руб.</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td class="text-center" colspan="3">Общая стоимость: ${requestScope.totalCost} бел. руб.</td>
                        </tr>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    <c:import url="/WEB-INF/view/fragment/footer.jsp"></c:import>
</div>
</body>
</html>
