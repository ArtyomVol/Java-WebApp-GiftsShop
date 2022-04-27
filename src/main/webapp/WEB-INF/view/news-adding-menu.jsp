<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление новостей</title>
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
            <h4 class="mb-3 mt-1" style="font-size: 36px">Добавление новостей</h4>
            <form id="categoryAddingForm" action="news-adding-menu-servlet" method="post" enctype='multipart/form-data'>
                <div class="mb-2">
                    <input id="uploadedFileID" type="file" name="uploaded_file" accept="image/jpeg,image/png"/><br>
                </div>
                <button class="btn btn-brown btn-block" id="adding_button" type="submit">
                    Добавить новость
                </button>
                <a class="btn btn-brown btn-block mb-2" href="${pageContext.request.contextPath}/main">
                    Вернуться
                </a>
            </form>
        </div>
    </div>
</div>
</body>
</html>