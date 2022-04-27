<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
    <c:import url="/WEB-INF/view/fragment/head.jsp"></c:import>
</head>
<body>
<div class="container-fluid">
    <div class="text-center">
        <pre><label style="color:red">${requestScope.errorCode}</label></pre>
    </div>
    <div class="row mt-5">
        <div class="col-3"></div>
        <div class="card col-md-6 order-md-1 text-center mt-5">
            <h4 class="mb-3 mt-1" style="font-size: 40px">Вход</h4>
            <form class="needs-validation" novalidate="" id="loginForm" action="login-servlet" method="get">
                <div class="row">
                    <div class="col-md-6">
                        <div class="mb-3">
                            <input type="text" class="form-control" id="username" name="username" placeholder="Логин"
                                   value="${requestScope.loginUsername}">
                        </div>
                        <div class="mb-3">
                            <input type="password" id="password" name="password" class="form-control"
                                   placeholder="Пароль" required="">
                        </div>
                        <button class="btn btn-brown btn-block">Войти</button>
                        <a class="btn btn-brown btn-block" href="${pageContext.request.contextPath}/registration">
                            Регистрация
                        </a>
                        <a class="btn btn-brown btn-block" href="${pageContext.request.contextPath}/main">
                            Войти как гость
                        </a>
                    </div>
                    <div class="col-md-5 ml-4">
                        <img class="img-fluid" src="${pageContext.request.contextPath}/media/present.png"
                             alt="Подарок">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/login"><label>login</label></a>
<a href="${pageContext.request.contextPath}/registration"><label>registration</label></a>
<a href="${pageContext.request.contextPath}/main"><label>main</label></a>
</body>
</html>
--%>