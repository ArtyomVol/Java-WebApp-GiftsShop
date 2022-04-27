<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новости</title>
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
                </div>
            </div>
            <div class="container-fluid">
                <c:forEach var="link" items="${requestScope.newsLinks}">
                    <div class="row">
                        <img class="img-fluid"
                             src="${pageContext.request.contextPath}/media/${link}" style="max-width: 1120px"
                             alt="news">
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <c:import url="/WEB-INF/view/fragment/footer.jsp"></c:import>
</div>
</body>
</html>
