<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%
        String contextPath = request.getContextPath();
    %>
    <link href="<%=contextPath%>/css/login.css" rel="stylesheet">
</head>
<body>
<div id="mask" class="mask" style="display: none;"></div>
<main class="container">
    <div id="loginDiv" class="card">
        <div class="card-body">
            <form method="post" id="fm1" action="<%=contextPath%>/login">
                <div>
                    <img src="<%=contextPath%>/images/logo.png" style="margin-left: 43px;">
                </div>
                <div class="error"></div>
                <section class="form-group">
                    <div class="input-wrapper">
                        <input class="form-control required" id="username" name="username" type="text" autocomplete="off" placeholder="请输入账号">
                    </div>
                </section>
                <section class="form-group">
                    <div class="input-wrapper">
                        <input class="form-control required" type="password" id="password" name="password" autocomplete="off" placeholder="请输入密码">
                    </div>
                </section>
                <div class="btn-group">
                    <button class="btn btn-block btn-submit" type="submit">登 录</button>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
