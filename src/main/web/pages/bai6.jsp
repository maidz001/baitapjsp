<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>Thong tin USER</title>
    <style>
        body {
            background-color: white;
            font-family: Arial, sans-serif;
        }
        table {
            border-collapse: collapse;

            border: 1px solid black;
        }
        .message {
            margin-top: 5px;
            margin-left2px;
            font-weight: bold;
        }
        td{
        padding-right:50px;


        padding-left:8px;
        }
    </style>
</head>
<body>



<table>
<tr>
<td colspan="3"><h2>Thong tin USER</h2></td>
</tr>
    <tr>
        <td>Ma</td>
        <td>${thongtin[0]}</td>
    </tr>
    <tr>
        <td>Ho ten</td>
        <td>${thongtin[1]}</td>
    </tr>
    <tr>
        <td>Ngay sinh</td>
        <td>${thongtin[2]}</td>
    </tr>
    <tr>
        <td>Gioi tinh</td>
        <td>${thongtin[3]}</td>
    </tr>
    <tr><td colspan="2">
<div class="message">
<c:if test="${thongtin[3] eq 'nam'}">
    cam on ong da su dung dich vu
</c:if>

<c:if test="${thongtin[3] eq 'nu'}">
    cam on ba da su dung dich vu
</c:if>
</div></td></tr>
</table>

</body>
</html>
