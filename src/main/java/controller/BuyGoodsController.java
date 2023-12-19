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

@WebServlet("/buygood.do")
public class BuyGoodsController extends HttpServlet{

    private static final long serialVersionUID = 7804524886360637172L;
    public BuyGoodsController() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	System.out.println("进来了成功");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session= request.getSession();
            String user_id = request.getParameter("userId");
            //Object user_id= session.getAttribute("user_id");
            
            //1查询
            //String sql="SELECT * FROM goods WHERE goods_id=?";

            /*Connection connection= JDBCUtils.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            Good good=new Good();

            while (rs.next()) {
                good.setGoods_id(rs.getString("goods_id"));
                good.setGoods_name(rs.getString("goods_name"));
                good.setUnitprice(rs.getString("unitprice"));
                good.setDetails(rs.getString("details"));
                good.setPic(rs.getString("photo"));
            }*/
            String qrysql="select * from cart where userid=?";
            String sql="DELETE FROM cart WHERE userid=?";
            Connection connection= JDBCUtils.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(qrysql);
            stmt.setString(1, user_id);
            ResultSet rs = stmt.executeQuery();
            String goodsId;
            int quantity=0;
            while(rs.next()) {
            	 goodsId = rs.getString("goods_id");
                 quantity = rs.getInt("quantity");
                 String editSql = "UPDATE sale SET number=? WHERE goods_id=?";
                 PreparedStatement insertStmt = connection.prepareStatement(editSql);
                 insertStmt.setString(2, goodsId);
                 insertStmt.setInt(1, quantity);
                 int insertRes = insertStmt.executeUpdate();
                     System.out.println("销售记录插入成功");
                 
            }
            
            stmt=  connection.prepareStatement(sql);
            stmt.setString(1, user_id);
            int res=stmt.executeUpdate();//执行sql语句
            if (res>0){
                System.out.println("删除成功");
            }
            //ResultSet rs = stmt.executeQuery();
            //2添加到数据库

            
            connection.close();
            System.out.println("成功!!!");
            //request.getSession().setAttribute("carList", carList);
            //response.sendRedirect("./menu/device/3-1.jsp");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}