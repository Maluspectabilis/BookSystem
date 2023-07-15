<%--
  Created by IntelliJ IDEA.
  User: 14749
  Date: 2023/6/1
  Time: 15:24
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
    <title>查询单个学生信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//cdn.staticfile.org/layui/2.8.3/css/layui.css" rel="stylesheet">

    <!-- 引入 Bootstrap 样式 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- 引入 jQuery 库 -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

    <style>
        /* 自定义样式 */
        .form-container {
            margin-top: 20px;
        }

        .bbtn btn-primary:hover {
            background-color: #0D47A1;
        }

        input[type=submit] {
            background-color: #16baaa;
            color: white;

        }

        th, td {
            text-align: center;
        }
    </style>

<%--    --%>

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
                <li class="layui-nav-item" ><a href="${pageContext.request.contextPath}/Student/studentMainInit?name=${name}&account=${account}">开始窗口</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Book/StudentSelectAllBooks?name=${name}&account=${account}">查询所有书本信息/借书</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/HaveBooks/showAll?name=${name}&account=${account}">还书</a></li>
                <li class="layui-nav-item" style="background-color: #16baaa;" ><a href="${pageContext.request.contextPath}/Student/StudentShowOneInit?name=${name}&account=${account}">查询单个书本信息/借书</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <blockquote class="layui-elem-quote layui-text">
                查询单个学生信息
            </blockquote>
            <div class="container">
                <h1 align="center">查询图书信息</h1>

                <!-- 表单 -->
                <form id="myform" name="" method="post" action="${pageContext.request.contextPath}/Student/studentShowOne?name=${name}&account=${account}">
                    <div class="form-container">
                        <label for="bookName">书名：</label>
                        <input type="text" id="bookName" name="bookName">
                        <button type="submit" class="btn btn-primary" style="background-color: #16baaa" onmouseover="this.style.backgroundColor='#0D47A1'" onmouseout="this.style.backgroundColor='#16baaa'">查询</button>
                    </div>
                </form>

                <!-- 表格 -->
                <div class="result-content">
                    <table id="book-table" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th align="center">书名</th>
                            <th align="center">价格</th>
                            <th align="center">作者</th>
                            <th align="center">数目</th>
                            <th align="center">操作选择</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty book}">
                            <tr>
                                <td align="center">${book.bookName}</td>
                                <td align="center">${book.bookPrice}</td>
                                <td align="center">${book.author}</td>
                                <td align="center">${book.number}</td>
                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/Book/borrowBook3?bookName=${book.bookName}&bookPrice=${book.bookPrice}&author=${book.author}&number=${book.number}&name=${name}&account=${account}">借书</a>
                                        <%--                      <a href="${pageContext.request.contextPath}/Book/returnBook2?bookName=${book.bookName}&bookPrice=${book.bookPrice}&author=${book.author}&number=${book.number}&name=${name}&account=${account}">还书</a>--%>
                                </td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
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
