<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2022/1/6
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<html>
    <head>
    	<meta charset="UTF-8">
        <title>销售列表</title>
        <link rel="stylesheet" type="text/css" href="../css/3-1.css"/>
    </head>
    <body>
        <%
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/e-commerce_store",
                        "root","NEUph$PQ9e");
                stmt = conn.createStatement();

                if(conn != null){
                 
        %>
        
        <table border="2">
            <tr class=header>
                <td width="100" goods_id="title">商品编号</td>
                <td width="100" goods_name="title">销售数量</td>
                 

            </tr>
            <%
                ResultSet rs = null;
                String sql = "SELECT * FROM sale;";  //查询语句
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {%>
            <tr>
                <td width="100" ><%=rs.getString("goods_id") %></td>
                <td width="100" ><%=rs.getString("number") %></td>

            </tr>
            <%
            	}
                    }else{
                        out.print("连接失败！");
                    }
                }catch (Exception e) {
                    //e.printStackTrace();
                    out.print("数据库连接异常！");
                }
            %>
        </table>
    </body>
</html>