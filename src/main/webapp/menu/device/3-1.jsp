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
        <title>商品列表</title>
        <link rel="stylesheet" type="text/css" href="../../css/3-1.css"/>
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
        <a href="3-1-1.jsp"> 
        	<button type="button" >
        		添加商品
        	</button>
        </a>
        
        <table border="2">
            <tr class=header>
                <td width="80" goods_id="title">商品编号</td>
                <td width="100" goods_name="title">商品名称</td>
                <td width="80" goods_state="title">商品状态</td>
                <td width="80" unitprice="title">单价</td>
                <td width="80" stock="title">库存数量</td>
                <td width="80" category="title">商品类别</td>
                <td width="100" photo="title">图片</td>
                <td  details="title">详细介绍</td>
                <td width="80" create_time="title">上架时间</td>
                <td width="80" update_time="title">更新时间</td>
                <td width="100" >操作</td> 
                 

            </tr>
            <%
                ResultSet rs = null;
                String sql = "SELECT * FROM goods;";  //查询语句
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {%>
            <tr>
                <td width="80" ><%=rs.getString("goods_id") %></td>
                <td width="100" ><%=rs.getString("goods_name") %></td>
                <td width="80" ><%=rs.getString("goods_state") %></td>
                <td width="80"><%=rs.getString("unitprice") %></td>
                <td width="80"><%=rs.getString("stock") %></td>
                <td width="80"><%=rs.getString("category") %></td>
                <td width="100"><img src="../../<%=rs.getString("photo") %>" width="100px"></td>
                <td ><%=rs.getString("details") %></td>
                <td width="80"><%=rs.getString("create_time") %></td>
                <td width="80"><%=rs.getString("update_time") %></td>
                <td width="100"> <!-- 添加新的操作单元格 -->
                	<a href="3-1-2.jsp?id=<%=rs.getString("goods_id") %>"> 编辑 </a>
                    <a href="<%=request.getContextPath() %>/deletegood.do?id=<%=rs.getString("goods_id") %>">删除</a>
                </td>

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