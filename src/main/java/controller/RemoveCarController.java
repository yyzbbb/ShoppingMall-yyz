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


@WebServlet("/removecar.do")
public class RemoveCarController extends HttpServlet{

    private static final long serialVersionUID = 7804524886360637172L;
    public RemoveCarController() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	System.out.println("进入removecar.do成功");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session= request.getSession();
            String id = request.getParameter("id");

            Object user_id= session.getAttribute("user_id");
            System.out.println(id);
            //1查询
            String sql="SELECT * FROM goods WHERE goods_id=?";

            Connection connection= JDBCUtils.getConnection();
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
            }

            //2添加到数据库
            String sqladd="DELETE FROM cart WHERE goods_id=?";
            stmt =  connection.prepareStatement(sqladd);
            stmt.setString(1, good.getGoods_id());
            int res=stmt.executeUpdate();//执行sql语句
            if (res>0){
                System.out.println("删除成功");
            }

            //3返回购物车
            String carsql="select * from cart where userid=?";

            stmt =  connection.prepareStatement(carsql);
            stmt.setString(1, user_id.toString());

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

            }
            connection.close();

            request.getSession().setAttribute("carList", carList);
            response.sendRedirect("shoppingcart.jsp");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}