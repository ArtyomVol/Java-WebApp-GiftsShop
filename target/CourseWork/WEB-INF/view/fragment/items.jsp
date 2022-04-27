<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${requestScope.items.size() != 0}">
    <div class="album pt-3 bg-light">
        <div class="container-fluid">
            <div class="row">
                <c:forEach var="item" items="${requestScope.items}">
                    <div class="col-md-3">
                        <div class="card mb-4 box-shadow">
                            <a href="${pageContext.request.contextPath}/main/item-info?item_id=${item.itemId}">
                                <img class="card-img-top"
                                     src="${pageContext.request.contextPath}/media/${item.imageLink}"
                                     style="height: 225px; width: 100%; display: block;">
                            </a>
                            <div class="card-body text-center" style="height: 125px">
                                <p class="card-text">${item.name}</p>
                                <label style="color: black; font-weight: bold">${item.cost} бел. руб.</label>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${requestScope.items.size() == 0}">
    <h4 class="mb-3 mt-1 text-center" style="font-size: 32px">Товары не найдены ༼ つ ಥ_ಥ ༽つ</h4>
</c:if>
