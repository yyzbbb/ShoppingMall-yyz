<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑商品</title>
    <link rel="stylesheet" type="text/css" href="../../css/3-1-2.css"/>
</head>
<body>
<%
    Connection conn = null;
    Statement stmt = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/e-commerce_store",
                "root", "NEUph$PQ9e");
        stmt = conn.createStatement();

        if (conn != null) {

            String goodsId = request.getParameter("id"); // 获取商品ID参数

            ResultSet rs = null;
            String sql = "SELECT * FROM goods WHERE goods_id = '" + goodsId + "';";  // 根据商品ID查询语句
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                // 获取商品信息
                String goodsid = rs.getString("goods_id");
                String goodsName = rs.getString("goods_name");
                String details = rs.getString("details");
                String unitPrice = rs.getString("unitprice");
                String goodsState = rs.getString("goods_state");
                String stock = rs.getString("stock");
                String category = rs.getString("category");
                String photo = rs.getString("photo");
                String createTime = rs.getString("create_time");
                String factory = rs.getString("factory");
                %>

                <form action="<%=request.getContextPath() %>/updategood.do?id=<%= goodsId %>" method="post"> <!-- 根据你的需求，将表单提交到相应的处理程序 -->
                    商品ID：<input type="text" name="goods_id" value="<%= goodsId %>"><br>
                    商品名称：<input type="text" name="goods_name" value="<%= goodsName %>"><br>
                    单价：<input type="text" name="unitprice" value="<%= unitPrice %>"><br>
                    详细介绍：<input type="text" name="details" value="<%= details %>"><br>
                    商品类别：<input type="text" name="category" value="<%= category %>"><br>
                    图片：<input type="text" name="photo" value="<%= photo %>"><br>
                    库存数量：<input type="text" name="stock" value="<%= stock %>"><br>
                    生产厂家：<input type="text" name="factory" value="<%= factory %>"><br>
                    商品状态：<input type="text" name="goods_state" value="<%= goodsState %>"><br>
                    <input type="hidden" name="create_time" value="<%= createTime %>">
                    <input type="submit" value="保存">
                </form>

                <%
            } else {
                out.print("未找到该商品！");
            }
        } else {
            out.print("连接失败！");
        }
    } catch (Exception e) {
        //e.printStackTrace();
        out.print("数据库连接异常！");
    }
%>
</body>
</html>