package shop_servlet;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Register {
	
	//注册方法，用于将用户信息插入到数据库中,参数包括用户名、用户ID、密码、电子邮件、出生日期、电话号码和地址。
    public Integer register(String username, String user_id, String password, String email,String birth,String phone,String address) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/e-commerce_store",
                    "root","NEUph$PQ9e");
            
            stmt = conn.createStatement();
            String date = getCurDatetiment();
            String sql = "insert into user(username, user_id, password, email, birth, phone, address, createTime)value('"
                    + username +"','"+ user_id +"','"+ password +"','"+ email +"','"+ birth +"','"+ phone +"','"+
                    address +"','"+ date+"') ";

            Integer rtn = stmt.executeUpdate(sql);
            if (rtn>0){
                System.out.println("添加成功");
            }
            System.out.println(conn);
            return rtn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // TODO 自动生成的方法存根
        return 0;
    }
    
    //私有方法，用于获取当前日期和时间的字符串表示。
    private String getCurDatetiment() {
        // TODO 自动生成的方法存根
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    //登录方法，用于验证用户ID和密码是否匹配。
    public boolean login(String user_id, String password) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/e-commerce_store",
                    "root","NEUph$PQ9e");
            stmt = conn.createStatement();

            String sql = "select * from user where user_id='"+ user_id +"' and password='"+ password +"'";
            ResultSet rs = stmt.executeQuery(sql);
            boolean isLogin = false;
            if(rs.next()) {
                isLogin = true;
            }
            return isLogin;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // TODO 自动生成的方法存
        return false;
    }
}