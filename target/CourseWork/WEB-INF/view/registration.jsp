<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <c:import url="/WEB-INF/view/fragment/head.jsp"></c:import>
</head>
<body>
<div class="container-fluid">
    <div class="text-center">
        <pre><label style="color:red">${requestScope.errorCode}</label></pre>
    </div>
    <div class="row mt-3">
        <div class="col-3"></div>
        <div class="card col-md-6 order-md-1 text-center mt-5">
            <h4 class="mb-3 mt-1" style="font-size: 40px">Регистрация</h4>
            <div class="row">
                <div class="col-md-6">
                    <form class="needs-validation" novalidate="" id="registrationForm" action="registration-servlet"
                          method="post">
                        <div class="mb-3">
                            <input type="text" class="form-control" id="first_name" name="first_name"
                                   placeholder="Имя" value="${requestScope.registrationFirstName}">
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" id="last_name" name="last_name"
                                   placeholder="Фамилия"
                                   value="${requestScope.registrationLastName}">
                        </div>
                        <div class="mb-3">
                            <input type="text" class="form-control" id="username" name="username" placeholder="Логин"
                                   value="${requestScope.registrationUsername}">
                        </div>
                        <div class="mb-3">
                            <input type="password" id="password" name="password" class="form-control"
                                   placeholder="Пароль" required="">
                        </div>
                        <div class="mb-3">
                            <input type="password" class="form-control" id="repeat_password" name="repeat_password"
                                   placeholder="Повторите пароль" required="">
                        </div>
                        <button class="btn btn-brown btn-block" id="registrationBtn" type="submit">
                            Регистрация
                        </button>
                        <a class="btn btn-brown btn-block" href="${pageContext.request.contextPath}/login">
                            Вернуться ко входу
                        </a>
                    </form>
                </div>
                <div class="col-md-5 ml-4">
                    <img class="img-fluid mt-5" src="${pageContext.request.contextPath}/media/present.png"
                         alt="Подарок">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>