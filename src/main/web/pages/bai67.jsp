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
      td{
        width: 100px;
        text-align: left;

      }
      div{

              width: 370px;
              padding-left: 25px;
              padding-bottom: 30px;
              padding-top: 28px;
              padding-right: 150px;
              border: 3px solid rgb(132, 243, 130);


      }
      #td1{
        text-align: center;
      }
      .nhan{
      width:120px;
      hight:20px;
            padding:6px;
      }
      button{
      width:40px;
      padding:6px;
      }
    </style>
</head>
<body>
                    <h1>Bai 6</h1>
                    <div>
                      <form action="${pageContext.request.contextPath}/home?action=bai6" method="POST">
<table>
  <tr>
    <td>Ma</td>
    <td><input type="text" name="ma" id=""></td>
  </tr>
  <tr>
    <td>Ho va Ten</td>
  <td><input type="text" name="ten"></td>
</tr>
  <tr>
    <td>ngay sinh</td>
    <td><input type="date" name="ngaysinh" id=""></td>
  </tr>
  <tr>
    <td>gioi tinh</td>
    <td><input type="checkbox" name="gioitinh" value="nam" id="">nam</td>
  </tr>
  <tr>
    <td id="td1" colspan="2"><button type="submit">Gui</button></td>
  </tr>
</table>
                      </form>
                    </div>

<h1>Bai 7</h1>
<form method="get">
    A: <input type="text" name="a" class="nhan"/>
    B: <input type="text" name="b" class="nhan" />
    <button type="submit">=</button>
    KQ: <input type="text" class="nhan" value= <%
    try{
    if(request.getParameter("a")!=null&&request.getParameter("b")!=null){
                           int a = Integer.parseInt(request.getParameter("a"));
                                                  int b = Integer.parseInt(request.getParameter("b"));
                                                  out.print(a * b);  }
    }
    catch(Exception e){
    out.print("loi");
    }

            %>>
</form>
</body>
</html>
