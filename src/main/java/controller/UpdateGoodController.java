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


@WebServlet("/updategood.do")
public class UpdateGoodController extends HttpServlet{

	private static final long serialVersionUID = 7804524886360637172L;
    public UpdateGoodController() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String id=request.getParameter("id");
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
            System.out.println(photo);
            String category = request.getParameter("category");
            System.out.println(category);
            String stock = request.getParameter("stock");
            System.out.println(stock);
            String factory = request.getParameter("factory");
            System.out.println(factory);
            String goods_state= request.getParameter("goods_state");
            System.out.println(goods_state);
            String date = getCurDatetiment();
            String createtime= request.getParameter("create_time");
            System.out.println(createtime);
            
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/e-commerce_store",
                    "root","NEUph$PQ9e");
            
            
            HttpSession session= request.getSession();
           
            String sql="DELETE FROM goods WHERE goods_id=?";
            PreparedStatement stmt =  conn.prepareStatement(sql);
            stmt =  conn.prepareStatement(sql);
            stmt.setString(1, id);
            int res=stmt.executeUpdate();//执行sql语句
            if (res>0){
                System.out.println("删除成功");
            }
            
            String addsql = "insert into goods(goods_id, goods_name, unitprice, details, photo, category, stock, factory,goods_state,create_time,update_time)value('"
                    + goods_id +"','"+ goods_name +"','"+ unitprice +"','"+ details +"','"+ photo +"','"+ category +"','"+
                    stock +"','"+ factory+"','"+goods_state+"','"+createtime+"','"+date+"') ";
            stmt =  conn.prepareStatement(addsql);
            res=stmt.executeUpdate();//执行sql语句
            if (res>0){
                System.out.println("添加成功");
            }
            
            conn.close();

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