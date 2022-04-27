<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="searchForm" method="post"
      action="${pageContext.request.contextPath}/items-searcher-servlet?category_name=${requestScope.categoryName}">
    <input type="text" class="form-control mt-2" name="item_search"
           placeholder="Поиск" value="${requestScope.itemSearch}">
</form>