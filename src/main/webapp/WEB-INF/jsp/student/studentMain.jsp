<%--
  Created by IntelliJ IDEA.
  User: 14749
  Date: 2023/5/26
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>学生端主窗口</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<a href="${pageContext.request.contextPath}/Book/selectAllBooks">查询所有书本信息</a>--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学生端主窗口</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//cdn.staticfile.org/layui/2.8.3/css/layui.css" rel="stylesheet">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">操作选择</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">学生端</a></li>
            <%--      <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">nav 2</a></li>--%>
            <%--      <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">nav 3</a></li>--%>
            <li class="layui-nav-item">
                <%--        <a href="javascript:;">nav groups</a>--%>
                <%--        <dl class="layui-nav-child">--%>
                <%--          <dd><a href="javascript:;">menu 11</a></dd>--%>
                <%--          <dd><a href="javascript:;">menu 22</a></dd>--%>
                <%--          <dd><a href="javascript:;">menu 33</a></dd>--%>
                <%--        </dl>--%>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-sm-inline-block">
                <a href="javascript:;">
                    <img src="//unpkg.com/outeres@0.0.10/img/layui/icon-v2.png" class="layui-nav-img">
                    ${name}
                </a>
                <dl class="layui-nav-child">
                    <%--          <dd><a href="javascript:;">Your Profile</a></dd>--%>
                    <%--          <dd><a href="javascript:;">Settings</a></dd>--%>
                    <dd><a href="${pageContext.request.contextPath}/System/studentLoginInit">退出系统</a></dd>
                </dl>
            </li>
            <li class="layui-nav-child" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <a href="${pageContext.request.contextPath}/System/studentLoginInit">退出系统</a>
                </a>
            </li>
            <%--      <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>--%>
            <%--        <a href="javascript:;">--%>
            <%--          <i class="layui-icon layui-icon-more-vertical"></i>--%>
            <%--        </a>--%>
            <%--      </li>--%>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item" style="background-color: #16baaa;"><a href="${pageContext.request.contextPath}/Student/studentMainInit?name=${name}&account=${account}">开始窗口</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Book/StudentSelectAllBooks?name=${name}&account=${account}">查询所有书本信息/借书</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/HaveBooks/showAll?name=${name}&account=${account}">还书</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Student/StudentShowOneInit?name=${name}&account=${account}">查询单个书本信息/借书</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote layui-text">
                学生端
            </blockquote>
            <div class="layui-card layui-panel">
                <div class="layui-card-header">

                </div>
                <div class="layui-card-body" style=" text-align: center;padding: 250px;">
                    <span style="font-size: 80px; font-weight: bold; color: #333;">欢迎使用本系统！</span>
                </div>
            </div>
            <br><br>
        </div>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>

<script src="//cdn.staticfile.org/layui/2.8.3/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element;
        var layer = layui.layer;
        var util = layui.util;
        var $ = layui.$;
    });
</script>
</body>
</html>
