package controller;

import beans.Car;
import beans.Good;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import service.UserService2;


@WebServlet("/reset.do")
public class ResetUserController extends HttpServlet{

    private static final long serialVersionUID = 7804524886360637172L;
    public ResetUserController() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session= request.getSession();
            
            String id = request.getParameter("id");
            System.out.println(id);
            System.out.println(1);
            
            String sql="DELETE FROM user WHERE user_id=?";
            Connection connection= JDBCUtils.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(sql);
            stmt.setString(1, id);
            int res=stmt.executeUpdate();//执行sql语句
            if (res>0){
                System.out.println("删除成功");
            }
            connection.close();
            response.sendRedirect("login.jsp");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}