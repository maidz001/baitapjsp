package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class BaiTapServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "bai5":
                try {
                    bai5(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "bai6":
                try {
                    bai6(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
        action = "";
    }
    switch (action) {
        case "bai4":
            try {
                bai4(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            break;
        case "bai5":
            try {
                bai5(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            break;
        case "bai6":
            try {
                bai6(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            break;
    }
}
    private void bai5(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, ServletException, IOException{
        String name=request.getParameter("name");
        request.setAttribute("name",name);
        request.getRequestDispatcher("pages/bai5.jsp").forward(request,response);
    }
private void bai4(HttpServletRequest request, HttpServletResponse response) throws
        SQLException, ServletException, IOException{
    List<Integer> l = new ArrayList<>();

    for (int i = 1; i <= 10; i++) {
        l.add(tinhGiaiThua(i));
    }

    request.setAttribute("listGT", l);
    request.getRequestDispatcher("/pages/bai2.jsp")
            .forward(request, response);
}
    private int tinhGiaiThua(int so) {
        int gt = 1;
        for (int i = so; i > 0; i--) {
            gt *= i;
        }
        return gt;
    }
    private void bai6(HttpServletRequest request, HttpServletResponse response) throws
            SQLException, ServletException, IOException{
           ArrayList l=new ArrayList();
           String ma=request.getParameter("ma");
           String ten=request.getParameter("ten");
           String ngaysinh=request.getParameter("ngaysinh");
           String gioitinh=request.getParameter("gioitinh");
           if(gioitinh==null){
               gioitinh="nu";
           }
           l.add(ma);
           l.add(ten);
           l.add(ngaysinh);
           l.add(gioitinh);
           request.setAttribute("thongtin",l);
           request.getRequestDispatcher("pages/bai6.jsp").forward(request,response);

    }
}
