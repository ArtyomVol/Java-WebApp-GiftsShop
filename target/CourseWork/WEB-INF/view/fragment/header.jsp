<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid" style="padding-left: 0; padding-right: 0">
    <nav class="navbar navbar-expand-md navbar-light bg-white sticky-top">
        <a href="${pageContext.request.contextPath}/main">
            <img class="img-fluid" type="button" src="${pageContext.request.contextPath}/media/logo.png" alt="Лого">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/main">Главная <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/news-display-servlet">Новости</a>
                </li>
            </ul>
            <span class="navbar-text">
                <ul class="navbar-nav mr-auto">
                    <c:if test="${sessionScope.account != null && sessionScope.account.roleId == 1}">
                        <li class="nav-item">
                            <label class="nav-link" style="color: mediumblue">Администратор</label>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" style="color: black"
                           href="${pageContext.request.contextPath}/personal-area-servlet">${sessionScope.account.username}</a>
                    </li>
                    <li class="nav-item">
                        <c:if test="${sessionScope.account != null && sessionScope.account.roleId == 2}">
                            <form action="${pageContext.request.contextPath}/shopping-cart-servlet" method="post">
                                <button class="card">
                                    <img class="img-fluid" type="button" style="width: 50px; height: 50px"
                                      src="${pageContext.request.contextPath}/media/shopping_cart.png" alt="Cart">
                                </button>
                            </form>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${sessionScope.account == null}">
                            <a class="nav-link" style="padding-bottom: 0px; padding-top: 0px"
                               href="${pageContext.request.contextPath}/login">Вход</a>
                            <a class="nav-link" style="padding-bottom: 0px; padding-top: 0px"
                               href="${pageContext.request.contextPath}/registration">Регистрация</a>
                        </c:if>
                        <c:if test="${sessionScope.account != null}">
                            <a class="nav-link mt-2" style="padding-bottom: 0px; padding-top: 0px"
                               href="${pageContext.request.contextPath}/log-out">Выход</a>
                        </c:if>
                    </li>
                </ul>
            </span>
        </div>
    </nav>
</div>
