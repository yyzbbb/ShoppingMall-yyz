package controller;

import shop_servlet.Register;
import utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;


@WebServlet("/creategood.do")
public class CreateGoodController extends HttpServlet{

	private static final long serialVersionUID = 7804524886360637172L;
    public CreateGoodController() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	System.out.println("进入成功!");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String goods_id = request.getParameter("goods_id");
            System.out.println(goods_id);
            String goods_name = request.getParameter("goods_name");
            System.out.println(goods_name);
            String price = request.getParameter("unitprice");
            System.out.println(price);
            BigDecimal unitprice = new BigDecimal(price);
            String details = request.getParameter("details");
            System.out.println(details);
            String photo = request.getParameter("photo");
            photo="images/carts/"+photo;
            System.out.println(photo);
            String category = request.getParameter("category");
            System.out.println(category);
            String stock = request.getParameter("stock");
            System.out.println(stock);
            String factory = request.getParameter("factory");
            System.out.println(factory);
            String published = request.getParameter("published");
            System.out.println(published);
            String unpublished = request.getParameter("unpublished");
            System.out.println(unpublished);
            String goods_state;
            if(published==null)
            {
            	goods_state="1";
            }
            else {goods_state="0";}
            System.out.println(goods_state);
            String date = getCurDatetiment();
            
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/e-commerce_store",
                    "root","NEUph$PQ9e");
            //String date = getCurDatetiment();
            
            HttpSession session= request.getSession();
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
            
            String sql = "insert into goods(goods_id, goods_name, unitprice, details, photo, category, stock, factory,goods_state,create_time,update_time)value('"
                    + goods_id +"','"+ goods_name +"','"+ unitprice +"','"+ details +"','"+ photo +"','"+ category +"','"+
                    stock +"','"+ factory+"','"+goods_state+"','"+date+"','"+date+"') ";
            //Connection connection= JDBCUtils.getConnection();
            PreparedStatement stmt =  conn.prepareStatement(sql);
            
            //stmt.setString(1, id);
            //ResultSet rs = stmt.executeQuery();
            //2添加到数据库
            int res=stmt.executeUpdate();//执行sql语句
            if (res>0){
                System.out.println("添加成功");
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
            conn.close();

            //request.getSession().setAttribute("carList", carList);
            response.sendRedirect("./menu/device/3-1.jsp");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String getCurDatetiment() {
        // TODO 自动生成的方法存根
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}