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
        .form-container {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }
        .form-row {
            display: flex;
            gap: 10px;
            align-items: center;
        }
        .form-row label {
            flex: 0 0 100px;
            font-weight: bold;
        }
        .form-row input[type="text"] {
            flex: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-row button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-row button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/board/insert" method="Post" class="form-container">
        <div class="form-row">
            <label for="title">제목:</label>
            <input type="text" id="title" name="title">
        </div>
        <div class="form-row">
            <label for="content">설명:</label>
            <input type="text" id="content" name="content">
        </div>
        <div>
            <button type="submit">추가하기</button>
        </div>
    </form>
</div>
</body>
</html>