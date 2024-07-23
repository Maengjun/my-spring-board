<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .board-list {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-bottom: 20px;
        }
        .board-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
        }
        .board-item:nth-child(even) {
            background-color: #f2f2f2;
        }
        .board-item div {
            flex: 1;
        }
        .board-actions {
            display: flex;
            gap: 10px;
        }
        .board-actions a,
        .board-actions form button {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
        }
        .board-actions form button {
            background-color: #f44336;
        }
        .board-actions form button:hover,
        .board-actions a:hover {
            background-color: #45a049;
        }
        .board-actions form button:hover {
            background-color: #d32f2f;
        }
        .actions {
            display: flex;
            gap: 10px;
            margin-top: 20px;
        }
        .actions button {
            padding: 10px 20px;
            background-color: #008CBA;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .actions button:hover {
            background-color: #005f73;
        }
    </style>
</head>
<body>
<div class="container">
    <form action ="/board/search" method="get" style="display:inline">
        <input type="text" id="title" name="title">
        <button type="submit">검색</button>
    </form>
    <div class="board-list">
        <c:forEach var="board" items="${boards}">
            <div class="board-item">
                <div>${board.id}</div>
                <div><a href="/board/${board.id}">${board.title}</a></div>
                <div>${board.username}</div>
                <div class="board-actions">
                    <a href="/board/${board.id}/update">수정</a>
                    <form action="/board/${board.id}/delete" method="post" style="display:inline;">
                        <button type="submit">삭제</button>
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="actions">
        <form action="/board/insert" method="get" style="display:inline;">
            <button type="submit">추가</button>
        </form>
        <form action="/signup" method="get" style="display:inline;">
            <button type="submit">회원가입</button>
        </form>
    </div>
</div>
</body>
</html>
