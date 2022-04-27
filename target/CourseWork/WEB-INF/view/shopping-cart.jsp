<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина</title>
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
            <c:if test="${requestScope.shoppingCarts.size() == 0}">
                <h4 class="mb-3 mt-1" style="font-size: 40px">Корзина пуста</h4>
            </c:if>
            <c:if test="${requestScope.shoppingCarts.size() > 0}">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Товар</th>
                        <th scope="col">Название</th>
                        <th scope="col">Стоимость</th>
                        <th scope="col">Удалить</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="shoppingCart" items="${requestScope.shoppingCarts}">
                        <tr>
                            <th style="width: 60px">
                                <img src="${pageContext.request.contextPath}/media/${shoppingCart.item.imageLink}"
                                     style="height: 50px; width: 50px; display: block;">
                            </th>
                            <td>
                                <label>${shoppingCart.item.name}</label>
                            </td>
                            <td>${shoppingCart.item.cost} бел. руб.</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/delete-item-from-shopping-cart-servlet?cart_id=${shoppingCart.id}"
                                      method="post">
                                    <button class="btn btn-brown btn-block">Удалить</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td class="text-center" colspan="3">Общая стоимость: ${requestScope.totalCost} бел. руб.</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/purchase-shopping-cart-servlet"
                                  method="post">
                                <button class="btn btn-brown btn-block">Купить</button>
                            </form>
                        </td>
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
