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


@WebServlet("/deletegood.do")
public class DeleteGoodController extends HttpServlet{

    private static final long serialVersionUID = 7804524886360637172L;
    public DeleteGoodController() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session= request.getSession();
            String id = request.getParameter("id");

           // Object user_id= session.getAttribute("user_id");
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
            
            String sql="DELETE FROM goods WHERE goods_id=?";
            Connection connection= JDBCUtils.getConnection();
            PreparedStatement stmt =  connection.prepareStatement(sql);
            stmt.setString(1, id);
            //ResultSet rs = stmt.executeQuery();
            //2添加到数据库
            int res=stmt.executeUpdate();//执行sql语句
            if (res>0){
                System.out.println("删除成功");
            }
/*
            //3返回购物车
            String carsql="select * from goods";
            stmt =  connection.prepareStatement(carsql);

            //查询商品

            rs = stmt.executeQuery();
            Car car=null;
            List<Car> carList=new ArrayList<>();


            while (rs.next()) {
                car=new Car();
                car.setGoods_id(rs.getString("goods_id"));
                car.setGoods_name(rs.getString("goods_name"));
                car.setUnitprice(rs.getString("unitprice"));
                car.setQuantity(rs.getString("quantity"));
                car.setPic(rs.getString("pic"));
                carList.add(car);

            }*/
            connection.close();

            //request.getSession().setAttribute("carList", carList);
            response.sendRedirect("./menu/device/3-1.jsp");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}