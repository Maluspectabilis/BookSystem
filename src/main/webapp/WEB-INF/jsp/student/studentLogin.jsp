<%--
  Created by IntelliJ IDEA.
  User: 14749
  Date: 2023/5/24
  Time: 8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
<head>
    <title>登录</title>
</head>
<body>
<div>学生端登录/注册</div>
<form action="${pageContext.request.contextPath}/System/studentLogin" method="post">
    <div>${msg}</div>
    账号：<input type="text" name="account"/><br/>
    密&nbsp;&nbsp;码：
    <input type="password" name="password" /><br/>
    <input type="submit" value="登录"/>
    <a href="${pageContext.request.contextPath}/System/studentRegisterInit">注册</a>
    <a href="${pageContext.request.contextPath}/System/adminLoginInit">管理员端登录/注册</a>
</form>
</body>
</html>--%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Demo</title>
    <!-- 请勿在项目正式环境中引用该 layui.css 地址 -->
    <link href="//unpkg.com/layui@2.8.3/dist/css/layui.css" rel="stylesheet">
</head>
<body>

<style>

    body {
        background-image: url('https://th.bing.com/th/id/R.49c4146ff637496e77ef3affea1f479e?rik=VLRRJSqQpNXfYw&riu=http%3a%2f%2fwww.pooban.com%2fimages%2f201511%2fgoods_img%2f2070_G_1447002953795.png&ehk=ZkpFUBEiUFQjHFSkxL7PDi%2b9yRs%2b3AheNMtiwYBdxcU%3d&risl=&pid=ImgRaw&r=0');

        background-size: cover;
    }

    .main {
        margin: 0 auto;
        padding-left: 25px;
        padding-right: 25px;
        padding-top: 15px;
        width: 350px;
        height: 270px;
        background: #F0F8FF;
        /*以下css用于让登录表单垂直居中在界面,可删除*/
        position: absolute;
        top: 50%;
        left: 50%;
        margin-top: -175px;
        margin-left: -175px;
    }

    .title {
        width: 100%;
        height: 40px;
        line-height: 40px;
        font-weight:bold;
        text-align:center;
        font-size:30px;
    }

    #ww:hover {
        background-color: #cccccc;
    }

    .demo-login-container{width: 320px; margin: 21px auto 0;}
    .demo-login-other .layui-icon{position: relative; display: inline-block; margin: 0 2px; top: 2px; font-size: 26px;}
</style>

<div class="main">

    <div class="title">
        学生端
    </div>
    <div style="color: crimson">${msg}</div>
    <form class="layui-form" action="${pageContext.request.contextPath}/System/studentLogin" method="post">
        <div class="demo-login-container">
            <div class="layui-form-item">
                <div class="layui-input-wrap">
                    <div class="layui-input-prefix">
                        <i class="layui-icon layui-icon-username"></i>
                    </div>
                    <input type="text" name="account" value="" lay-verify="required" placeholder="账   号" lay-reqtext="请填写账号" autocomplete="off" class="layui-input" lay-affix="clear">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-wrap">
                    <div class="layui-input-prefix">
                        <i class="layui-icon layui-icon-password"></i>
                    </div>
                    <input type="password" name="password" value="" lay-verify="required" placeholder="密   码" lay-reqtext="请填写密码" autocomplete="off" class="layui-input" lay-affix="eye">
                </div>
            </div>
<%--            <div class="layui-form-item">--%>
<%--                <div class="layui-row">--%>
<%--                    <div class="layui-col-xs7">--%>
<%--                        <div class="layui-input-wrap">--%>
<%--                            <div class="layui-input-prefix">--%>
<%--                                <i class="layui-icon layui-icon-vercode"></i>--%>
<%--                            </div>--%>
<%--                            <input type="text" name="captcha" value="" lay-verify="required" placeholder="验证码" lay-reqtext="请填写验证码" autocomplete="off" class="layui-input" lay-affix="clear">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="layui-col-xs5">--%>
<%--                        <div style="margin-left: 10px;">--%>
<%--                            <img src="https://www.oschina.net/action/user/captcha" onclick="this.src='https://www.oschina.net/action/user/captcha?t='+ new Date().getTime();">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <%--        <div class="layui-form-item">--%>
            <%--            <input type="checkbox" name="remember" lay-skin="primary" title="记住密码">--%>
            <%--            <a href="#forget" style="float: right; margin-top: 7px;">忘记密码？</a>--%>
            <%--        </div>--%>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="demo-login">登录</button>
            </div>
            <div class="layui-form-item demo-login-other">

                <%--            <span style="padding: 0 21px 0 6px;">--%>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/System/studentRegisterInit"  style="color: #16baaa;align-content: center" id="ww">学生注册帐号</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/System/adminLoginInit" style="color: #16baaa;align-content: center" id="ww">管理端登录/注册</a>
                <%--            </span>--%>
            </div>
        </div>
    </form>
</div>

<!-- 请勿在项目正式环境中引用该 layui.js 地址 -->
<script src="//unpkg.com/layui@2.8.3/dist/layui.js"></script>
<script>
    layui.use(function(){
        var form = layui.form;
        var layer = layui.layer;
        // 提交事件
        form.on('submit(demo-login)', function(data){
            var field = data.field; // 获取表单字段值
            // 显示填写结果，仅作演示用
            layer.alert(msg);
            // 此处可执行 Ajax 等操作
            // …
            return true; // 阻止默认 form 跳转
        });
    });
</script>
</body>
</html>
