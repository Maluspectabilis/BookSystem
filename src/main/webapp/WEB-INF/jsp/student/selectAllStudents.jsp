<%--
  Created by IntelliJ IDEA.
  User: 14749
  Date: 2023/5/27
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.*" %>
<%--<html>
<head>
    <title>查询所有学生信息</title>
</head>
<body>
<form action="" id="myform" method="post">
  <div class="result-content">
    <table class="result-tab" width="60%" border="1">
      <tr>
        <th>姓名</th>
        <th>学号</th>
        <th>年龄</th>
        <th>密码</th>
        <th>性别</th>
        <th>专业</th>
        <th>账号</th>
      </tr>
      <c:forEach var="student" items="${students}" >
        <tr>
          <td align="center">${student.studentName}</td>
          <td align="center">${student.studentNumber}</td>
          <td align="center">${student.age}</td>
          <td align="center">${student.password}</td>
          <td align="center">${student.sex}</td>
          <td align="center">${student.major}</td>
          <td align="center">${student.account}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</form>
<a href="${pageContext.request.contextPath}/Admin/adminMainInit">返回管理端主界面</a>
</body>
</html>--%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>查询所有学生信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="//cdn.staticfile.org/layui/2.8.3/css/layui.css" rel="stylesheet">
  <style>
    .result-tab {
      width: 60%;
      border-collapse: collapse;
      margin: 20px auto;
    }

    .result-tab th,
    .result-tab td {
      padding: 10px;
      border: 1px solid #ddd;
    }

    .result-tab th {
      background-color: #f5f5f5;
      font-weight: bold;
    }

    .result-tab tr:nth-child(even) {
      background-color: #f2f2f2;
    }

    .result-tab tr:hover {
      background-color: #ddd;
    }
  </style>
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
      <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">查询所有学生信息</a></li>
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
          <dd><a href="${pageContext.request.contextPath}/System/adminLoginInit">退出系统</a></dd>
        </dl>
      </li>
      <li class="layui-nav-child" lay-header-event="menuRight" lay-unselect>
        <a href="javascript:;">
          <a href="${pageContext.request.contextPath}/System/adminLoginInit">退出系统</a>
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
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Admin/adminMainInit?name=${name}&account=${account}">开始窗口</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Book/selectAllBooks?name=${name}&account=${account}">查询所有书本信息/借书</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Book/addBookInit?name=${name}&account=${account}">输入书本信息</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Student/addStudentInit?name=${name}&account=${account}">新增学生信息</a></li>
        <li class="layui-nav-item" style="background-color: #16baaa;"><a href="${pageContext.request.contextPath}/Student/selectAllStudents?name=${name}&account=${account}">查询所有学生信息</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Admin/AdminShowOneInit?name=${name}&account=${account}">查询单个学生/图书信息</a></li>

        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/HaveBooks/showAll2?name=${name}&account=${account}">还书</a></li>
      </ul>
    </div>
  </div>
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
      <blockquote class="layui-elem-quote layui-text">
        查询所有学生信息
      </blockquote>
      <div class="layui-card layui-panel">
        <div class="layui-card-header">

        </div>
        <div class="layui-card-body">
          <table class="result-tab" width="60%" border="1">
            <tr>
              <th>姓名</th>
              <th>学号</th>
              <th>年龄</th>
              <th>密码</th>
              <th>性别</th>
              <th>专业</th>
              <th>账号</th>
            </tr>
            <c:forEach var="student" items="${students}" >
              <tr>
                <td align="center">${student.studentName}</td>
                <td align="center">${student.studentNumber}</td>
                <td align="center">${student.age}</td>
                <td align="center">${student.password}</td>
                <td align="center">${student.sex}</td>
                <td align="center">${student.major}</td>
                <td align="center">${student.account}</td>
              </tr>
            </c:forEach>
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

    //头部事件
    // util.event('lay-header-event', {
    //   menuLeft: function(othis){ // 左侧菜单事件
    //     layer.msg('展开左侧菜单的操作', {icon: 0});
    //   },
    //   menuRight: function(){  // 右侧菜单事件
    //     layer.open({
    //       type: 1,
    //       title: '更多',
    //       content: '<div style="padding: 15px;">处理右侧面板的操作</div>',
    //       area: ['260px', '100%'],
    //       offset: 'rt', // 右上角
    //       anim: 'slideLeft', // 从右侧抽屉滑出
    //       shadeClose: true,
    //       scrollbar: false
    //     });
    //   }
    // });
  });
</script>
</body>
</html>