<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.item.name}</title>
    <c:import url="/WEB-INF/view/fragment/head.jsp"></c:import>
</head>
<script>
    function confirmation() {
        if (confirm("Вы действительно хотите удалить товар?")) {
            document.getElementById('choice').value = 1;
        } else {
            document.getElementById('choice').value = 0;
        }
        document.forms['form1'].submit();
    }
</script>
<body>
<div class="container-fluid">
    <c:import url="/WEB-INF/view/fragment/header.jsp"></c:import>
    <div class="row">
        <div class="col-2" style="padding-right: 0; padding-left: 0">
            <c:import url="/WEB-INF/view/fragment/categories.jsp"></c:import>
            <c:import url="/WEB-INF/view/fragment/left-admin-panel.jsp"></c:import>
        </div>
        <div class="col-10">
            <div class="card text-center mt-2">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-4 mt-3 mb-3">
                            <img class="img-fluid"
                                 src="${pageContext.request.contextPath}/media/${requestScope.item.imageLink}"
                                 style="height: 300px; width: 300px; display: block;">
                        </div>
                        <div class="col-8 mt-3 mb-3">
                            <label style="color: black; font-size: 25px; font-weight: bold">${requestScope.item.name}</label><br>
                            <label style="color: black; font-size: 20px;">Категория: ${requestScope.categoryName}</label><br>
                            <label style="color: black; font-size: 20px;">Описание: ${requestScope.item.description}</label><br>
                            <label style="color: black; font-size: 20px; font-weight: bold">Стоимость: ${requestScope.item.cost}
                                бел. руб.</label><br>
                            <c:if test="${sessionScope.account != null && sessionScope.account.roleId == 2}">
                                <form action="${pageContext.request.contextPath}/item-adding-to-shopping-cart-servlet">
                                    <button class="btn btn-brown">В корзину</button>
                                    <input type=hidden id="itemId" name="item_id" value=${requestScope.item.itemId}>
                                </form>
                            </c:if>
                            <c:if test="${sessionScope.account != null && sessionScope.account.roleId == 1}">
                                <div class="row">
                                    <div class="col-4"></div>
                                    <div class="col-2">
                                        <form action="${pageContext.request.contextPath}/item-editing-servlet"
                                              method="get">
                                            <input type=hidden id="itemId" name="item_id"
                                                   value=${requestScope.item.itemId}>
                                            <button class="btn btn-brown">
                                                Изменить
                                            </button>
                                        </form>
                                    </div>
                                    <div class="col-2">
                                        <form class="item-del" novalidate="" name="form1"
                                              action="${pageContext.request.contextPath}/item-deleting-servlet"
                                              method="get">
                                            <button class="btn btn-brown" onClick="confirmation()">Удалить</button>
                                            <input type=hidden id="choice" name="choice">
                                            <input type=hidden name="item_id" value="${requestScope.item.itemId}">
                                        </form>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="/WEB-INF/view/fragment/footer.jsp"></c:import>
</div>
</body>
</html>
