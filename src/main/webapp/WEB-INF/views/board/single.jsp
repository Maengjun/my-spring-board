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
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .board-info, .comments {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-bottom: 20px;
        }
        .board-info div, .comment-item {
            display: flex;
            justify-content: space-between;
            padding: 10px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
        }
        /*.board-info div:nth-child(even), .comment-item:nth-child(even) {*/
        /*    background-color: #f2f2f2;*/
        /*}*/
        .comment-form {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
        }
        .comment-form input[type="text"] {
            flex: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .comment-form button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .comment-form button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="board-info">
        <div>
            <span>ID:</span>
            <span>${board.id}</span>
        </div>
        <div>
            <span>제목:</span>
            <span>${board.title}</span>
        </div>
        <div>
            <span>설명:</span>
            <span>${board.content}</span>
        </div>
    </div>
    <form class="comment-form" action="/comment/${board.id}" method="Post">
        <label for="content">댓글을 다세요:</label>
        <input type="text" id="content" name="content">
        <button type="submit">완료</button>
    </form>
    <div class="comments">
        <c:forEach var="comments" items="${comment}">
            <div class="comment-item">
                <span>${comments.content}</span>
                <span>${comments.username}</span>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>


