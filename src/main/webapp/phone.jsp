<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>商品详情页</title>
	<link rel="stylesheet" type="text/css" href="css/public.css"/>
	<link rel="stylesheet" type="text/css" href="css/phone.css"/>
</head>
<body>
 	<div class="head">
      <div class="shouye_head">
          <div class="shou_head">
          	  <span>商品详情</span>
              <span>&nbsp;&nbsp;&nbsp;</span>
          </div>
         
          <div class="car">
              <a href="shoppingcart.jsp"><img src="images/购物车.png" height="28px">
                  <span>购物车</span>
              </a>
          </div>
          <div class="login">
              <div><a href="login.jsp">登录</a></div>
              <div><a href="login.jsp">注册</a></div>
          </div>
      </div>
    </div>
     <%--
    <div class="search_kuang">
	     <div class="search">
	         <input type="text" class="text">
	         <button><img src="images/搜索图标.png" width="40px"></button>
	     </div>
    </div>
    --%>
    
    <div class="xi_nav">
         <div class="wrap">
             <ul class="menu-list">
                 <li class="menu"><a href="home.jsp">首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                 <li class="menu"><a href="#">全部分类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                 <li class="menu"><a href="#">新品上市&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                 <li class="menu"><a href="#">热卖推荐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
             </ul>
         </div>
     </div>
    
    <div class="w">
         <div class="preview" id="preview">
             <div class="photo_xi">
                 <img src="${good.pic}" width="350px">
             </div>
         </div>
         <div class="itemInfo-wrap">
             <div class="x-goodsname">
                 <h3>${good.goods_name}</h3>
             </div>
             <div class="news">
                 <div class="" >
                     ${good.details}
                 </div>
             </div>
             <div class="x-price">
                 <span>￥</span>
                 <div class="x-price_num">${good.unitprice}</div>
             </div>
             <div class="x-action">
                 <div class="liji">
                     <a href="#">立即购买</a>
                 </div>
                 <div class="add_cart">
                     <a href="./addcar.do?id=${good.goods_id}">加入购物车</a>
                 </div>
             </div>
         </div>

        </div>

</body>
</html>