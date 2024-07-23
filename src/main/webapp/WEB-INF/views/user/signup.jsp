<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<%--<c:forEach var="board" items="${boards}">--%>
<table>
    <form action="/signup" method="POST" style="display:inline;">
        <td>아이디: <input type = "text" name = "username"></td>
        <td>비밀번호: <input type = "text" name = "password"></td>
        <td>비밀번호확인: <input type = "text" name = "password2"></td>
        <button type = "submit">회원가입하기</button>
    </form>

</table>
<%--</c:forEach>--%>
</body>
</html>