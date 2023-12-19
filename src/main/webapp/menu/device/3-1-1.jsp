<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>添加商品</title>
	<link rel="stylesheet" type="text/css" href="../../css/3-1-1.css"/>

</head>
<body>
	<h1>添加商品信息</h1>
     <form action="<%=request.getContextPath() %>/creategood.do" method="post">
        <label for="goods_id">商品ID:</label>
        <input type="text" id="goods_id" name="goods_id"><br><br>
        
        <label for="goods_name">商品名称:</label>
        <input type="text" id="name" name="goods_name"><br><br>
        
        <label for="unitprice">商品价格:</label>
        <input type="text" id="unitprice" name="unitprice"><br><br>
        
        <label for="details">商品详情:</label>
        <textarea id="details" name="details"></textarea><br><br>
        
        <label for="photo">商品图片:</label>
        <input type="file" id="photo" name="photo"><br><br>
        
        <label for="category">商品类别:</label>
        <select id="category" name="category">
            <option value="手机">手机</option>
            <option value="服装">服装</option>
            <option value="电器">电器</option>
            <option value="图书">图书</option>
        </select><br><br>
        
        <label for="stock">商品货存:</label>
        <input type="text" id="stock" name="stock"><br><br>
        
        <label for="factory">生产厂家:</label>
        <input type="text" id="factory" name="factory"><br><br>
        
        <label for="goods_status">上架状态:</label>
        <input type="radio" id="published" name="published" value="published">
        <label for="published">已上架</label>
        <input type="radio" id="unpublished" name="unpublished" value="unpublished">
        <label for="unpublished">未上架</label><br><br>
        
        <input type="submit" value="添加商品">
    </form>
</body>
</html>