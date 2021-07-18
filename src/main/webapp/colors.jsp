<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список цветов</title>
</head>
<body>
<section>
    <table border="1" cellpadding="8" cellspacing="0" style="margin: auto">
        <tr>
            <th>Номер</th>
            <th>Цвет</th>
        </tr>
        <jsp:useBean id="items" scope="request" type="java.util.List"/>
        <c:forEach items="${items}" var="item">
            <jsp:useBean id="item" type="rostelecom.model.ColorItem"/>
            <tr>
                <td>${item.number}</td>
                <td>${item.name}</td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
