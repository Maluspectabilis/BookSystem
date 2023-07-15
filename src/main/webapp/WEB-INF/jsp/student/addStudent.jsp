<%--
  Created by IntelliJ IDEA.
  User: 14749
  Date: 2023/5/27
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
<head>
    <title>新增学生信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Student/addStudent" method="post">
  <div>${msg}</div>
  姓名：<input type="text" name="studentName" placeholder="姓名"/><br/>
  学号：<input type="text" name="studentNumber" placeholder="学号"/><br/>
  年龄：<input type="text" name="age" placeholder="年龄"/><br/>
  专业：<input type="text" name="major" placeholder="专业"/><br/>
  性别：<input type="text" name="sex" placeholder="性别"/><br/>
  账号：<input type="text" name="account" placeholder="账号"/><br/>
  密码：<input type="text" name="password" placeholder="密码"/><br/>
  <input type="submit" value="注册"/>
</form>
</body>
</html>--%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>新增学生信息</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="//cdn.staticfile.org/layui/2.8.3/css/layui.css" rel="stylesheet">

  <style>
    form {
      width: 400px;
      margin: 0 auto;
      /*display: flex;*/
      /*flex-direction: column;*/
      align-items: center;
      /*background-color: #FFCCFF;*/
    }

    input[type=text], input[type=password] {

      font-size: 24px;
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      box-sizing: border-box;
      border: none;
      border-bottom: 2px solid #ccc;
    }

    input[type=submit] {
      background-color: #16baaa;
      color: white;
      padding: 14px 20px;
      /*margin: 8px 0;*/
      border-radius: 5px;
      border: none;
      cursor: pointer;
      margin-top: 20px;
    }

    .form-label {
      font-size: 20px;

      /*display: block;*/
      margin-bottom: 10px;
    }

    input[type=submit]:hover {
      background-color: #0D47A1;
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
      <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">新增学生信息</a></li>
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
        <li class="layui-nav-item" style="background-color: #16baaa;"><a href="${pageContext.request.contextPath}/Student/addStudentInit?name=${name}&account=${account}">新增学生信息</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Student/selectAllStudents?name=${name}&account=${account}">查询所有学生信息</a></li>
        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/Admin/AdminShowOneInit?name=${name}&account=${account}">查询单个学生/图书信息</a></li>

        <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/HaveBooks/showAll2?name=${name}&account=${account}">还书</a></li>
      </ul>
    </div>
  </div>
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
      <blockquote class="layui-elem-quote layui-text">
        新增学生信息
      </blockquote>
      <div class="layui-card layui-panel">
        <div class="layui-card-header">

        </div>
        <div class="layui-card-body">
          <form action="${pageContext.request.contextPath}/Student/addStudent?name=${name}" method="post" onsubmit="return validateForm()" name="myForm">
            <div>${msg}</div>
            <label class="form-label">姓名：<input type="text" name="studentName" placeholder=""/><br/>
              <label class="form-label">学号：<input type="text" name="studentNumber" placeholder=""/><br/>
            年龄：<input type="text" name="age" placeholder=""/><br/>
            专业：<input type="text" name="major" placeholder=""/><br/>
            性别：<input type="text" name="sex" placeholder=""/><br/>
            账号：<input type="text" name="account" placeholder=""/><br/>
            密码：<input type="text" name="password" /><br/>
            <input type="submit" value="注册" align="center"/>
          </form>
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

<script>
  function validateForm() {
    var name = document.forms["myForm"]["studentName"].value;
    var studentNumber = document.forms["myForm"]["studentNumber"].value;
    var age = document.forms["myForm"]["age"].value;
    var major = document.forms["myForm"]["major"].value;
    var sex = document.forms["myForm"]["sex"].value;
    var account1 = document.forms["myForm"]["account"].value;
    var password = document.forms["myForm"]["password"].value;

    if (name == "" || studentNumber == "" || age == "" || major == "" || sex == "" || account1 == "" || password == "") {
      alert("请填写完整信息");
      return false;
    }

    // 更多的验证代码...
  }
</script>
</body>
</html>