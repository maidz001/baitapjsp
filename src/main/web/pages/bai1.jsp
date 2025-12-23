<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Co Ban</title>
    <style>
      table{
      margin-bottom: 20px;
        border-collapse: collapse;
      }
      td{
        width: 100px;
        text-align: center;
        border:1px solid black;
      }
    </style>
</head>
<body>
    <h1>Bai 1</h1><table>
        <c:forEach var="so" begin="1" end="10">

                <tr>
                  <td>${so} x 2</td>
                  <td>${so*2}</td>
                </tr>

        </c:forEach></table>
        <h1>Bai 2</h1><table>
            <c:forEach var="so" begin="1" end="10">

                    <tr>
                      <td>${so} x 3</td>
                      <td>${so*3}</td>
                    </tr>

            </c:forEach>   </table>
                    <h1>Bai 3</h1>
                    <table>
                        <c:forEach var="so" begin="1" end="10">

                                <tr>
                                  <td>2 x ${so}</td>
                                  <td>${so*2}</td>
                                </tr>

                        </c:forEach>
                        </table>
                        <h1>Bai 4</h1>

                                            <c:forEach var="sonhan" begin="1" end="10">
                                           <table>
                                                <c:forEach var="so" begin="1" end="10">

                                                        <tr>
                                                          <td>${so} x ${sonhan}</td>
                                                          <td>${so*sonhan}</td>
                                                        </tr>

                                                </c:forEach>
                                                </table>
                                                </c:forEach>

</body>
</html>
