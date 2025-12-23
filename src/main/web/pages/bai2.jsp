<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Co Ban</title>
    <style>
      table{
        border-collapse: collapse;
      }
      #tb1 td{
        width: 100px;
        text-align: center;
        border:1px solid black;
      }
      #tb2 td{
       padding-left: 10px;

      }
      div{
        width: 370px;
        padding-left: 25px;
        padding-bottom: 30px;
        padding-top: 30px;
        padding-right: 150px;
        border: 3px solid rgb(132, 243, 130);

      }
      button{
        border: 0.1px;
        background-color: rgb(201, 201, 202);;
        border-radius: 5px;
      }
    </style>
</head>
<body>
                    <h1>Bai 4</h1><table id="tb1">

                        <c:forEach var="list" items="${listGT}" varStatus="st">
<tr>
                                  <td> ${st.count}!</td>
                                  <td>${list}
                                  </td>
                                </tr>
</c:forEach>

                        </table>
 <h1>Bai 5</h1>
 <div>
  <table id="tb2">
   <tr>
     <td>nhap ten</td>
     <form action="${pageContext.request.contextPath}/home?action=bai5" method="POST">
     <td><input type="text" name="name"></td>
     <td><button>Gui</button></td></form>
   </tr>
  </table>
</div>
</body>
</html>
