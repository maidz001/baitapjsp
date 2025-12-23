<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang Chu</title>
    <style>
        button {
            width: 200px;
            height: 40px;
            margin: 10px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<a href="pages/bai1.jsp">

    <button type="submit">Bài tập 1,2,3</button>

</a>
<form action="${pageContext.request.contextPath}/home?action=bai4" method="POST">
    <button type="submit">Bài tập 4,5</button>
</form>

<a href="pages/bai67.jsp">

    <button type="submit">Bài 6,7</button>
</a>

<form action="home3" method="get">
    <button type="submit">Thông báo</button>
</form>

</body>
</html>
