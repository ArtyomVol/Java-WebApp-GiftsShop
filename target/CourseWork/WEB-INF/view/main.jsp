<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="min-height: 100%; position:relative">
<head>
    <title>Presents</title>
    <c:import url="/WEB-INF/view/fragment/head.jsp"></c:import>
</head>
<body style="min-height: 100%; position:relative">

<div class="container-fluid">
    <c:import url="/WEB-INF/view/fragment/header.jsp"></c:import>
    <div class="row">
        <div class="col-2" style="padding-right: 0; padding-left: 0">
            <c:import url="/WEB-INF/view/fragment/categories.jsp"></c:import>
            <c:import url="/WEB-INF/view/fragment/left-admin-panel.jsp"></c:import>
        </div>
        <div class="col-10" style="padding-right: 0; padding-left: 0; min-height: 275px;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-5">
                        <c:import url="/WEB-INF/view/fragment/searcher.jsp"></c:import>
                    </div>
                    <div class="col-3">
                        <form method="get" action="${pageContext.request.contextPath}/items-sort-asc-servlet">
                            <button class="btn btn-brown btn-block mt-2">По возрастанию цены</button>
                            <input type=hidden name="search_text" value="${requestScope.itemSearch}">
                            <input type=hidden name="category_name" value="${requestScope.categoryName}">
                        </form>
                    </div>
                    <div class="col-3">
                        <form method="get" action="${pageContext.request.contextPath}/items-sort-desc-servlet">
                            <button class="btn btn-brown btn-block mt-2">По убыванию цены</button>
                            <input type=hidden name="search_text" value="${requestScope.itemSearch}">
                            <input type=hidden name="category_name" value="${requestScope.categoryName}">
                        </form>
                    </div>
                </div>
            </div>
            <c:if test="${requestScope.itemSearch != null && requestScope.itemSearch != ''}">
                <h4 class="mb-0" style="font-size: 20px">По запросу "${requestScope.itemSearch}"
                    найдено ${requestScope.items.size()} товаров</h4>
            </c:if>
            <h4 class="mb-0" style="font-size: 40px">${requestScope.categoryName}</h4>
            <c:import url="/WEB-INF/view/fragment/items.jsp"></c:import>
        </div>
    </div>
    <c:import url="/WEB-INF/view/fragment/footer.jsp"></c:import>
</div>
</body>
</html>
