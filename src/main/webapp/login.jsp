<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>注册登录页</title>
	<%--引入了一个名为"public.css"的CSS样式文件，用于设置公共的样式。--%>
	<link rel="stylesheet" type="text/css" href="css/public.css"/>
	<%--引入了一个名为"login.css"的CSS样式文件，用于设置登录页面的样式。--%>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<%--引入了jQuery库，用于简化JavaScript代码的编写。--%>
	<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
	<%--引入了一个名为"jquery.validate.min.js"的JavaScript文件，用于表单验证。--%>
	<script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
	<%--引入了一个名为"login.js"的JavaScript文件，用于处理登录页面的交互逻辑。--%>
	<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="head">
    	<div class="shouye_head">
    		<a href=#>羊城商城</a>
    	</div>
    </div>
    <div class="dowebok" id="dowebok">
        <!-- 注册 -->
        <div class="form-container sign-up">
        	<!-- 这是一个表单开始的标签，action属性指定了表单提交的目标URL，method="post"表示使用POST方式提交表单，class="register"为表单添加了一个CSS类名。 -->
            <form action="<%=request.getContextPath() %>/register.do" method="post" class="register">
                <h1>注册</h1>
                <input type="text"  id="username" name="username" placeholder="请输入用户名" />
                <input type="text"  id="user_id" name="user_id" placeholder="请输入账号" />
                <input type="password" id="pwd" name="password" placeholder="请输入密码" />
                <input type="password" id="second_pwd" name="second_pwd" placeholder="请再次输入密码" />
                <input id="email" id="email" name="email" type="email" placeholder="请输入正确的邮箱格式">
                <input type="text" id="birth" name="birth" placeholder="出生日期 以YYYY-MM-DD格式" />
                <input type="text" id="phone" name="phone" placeholder="手机号码" />
                <input type="text" id="address" name="address" placeholder="收货地址" />
                <button>注册</button>
            </form>
        </div>
        
        <!-- 登录 -->
        <div class="form-container sign-in">
            <form action="<%=request.getContextPath() %>/login.do" method="post" class="sign">
                <h1>登录</h1>
                <input type="text" name="user_id" placeholder="请输入账号"/>
                <input type="password"  name="password" placeholder="请输入密码"/>
                <a href="###">忘记密码？</a>
                <button>登录</button>
            </form>
        </div>
        
        <!-- 两边的蒙版 -->
        <div class="overlay-container">
            <div class="overlay">
                <!-- 登录蒙版 -->
                <div class="overlay-panel mask-left">
                    <h1>已有帐号？</h1>
                    <p>快去登录，开启您的奇妙旅程</p>
                    <button class="ghost" id="signIn">登录</button>
                </div>
                <!-- 注册蒙版 -->
                <div class="overlay-panel mask-right">
                    <h1>没有帐号？</h1>
                    <p>立即注册加入我们，开启您的奇妙旅程吧</p>
                    <button class="ghost" id="signUp">注册</button>
                </div>
            </div>
        </div>
     </div>
</body>
</html>