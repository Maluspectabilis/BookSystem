<%--
  Created by IntelliJ IDEA.
  User: 14749
  Date: 2023/5/24
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生端注册</title>
  <style>
    form {
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    #w {
      margin-top: 20px;
      font-size: 24px;
      text-align: center;
    }

    input[type="text"], input[type="password"] {
      padding: 10px;
      margin-bottom: 15px;
      border-radius: 5px;
      border: none;
      background-color: #f2f2f2;
      width: 300px;
    }

    input[type="submit"] {
      background-color: #16baaa;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #0D47A1;
    }

    a {
      margin-top: 20px;
    }

    .main {
      /*以下css用于让登录表单垂直居中在界面,可删除*/
      position: absolute;
      top: 50%;
      left: 50%;
      margin-top: -175px;
      margin-left: -175px;
    }

  </style>
</head>
<body>
<div class="main">
  <form action="${pageContext.request.contextPath}/System/studentRegister" method="post">
    <div id="w">学生端注册</div>
    <div style="color: crimson">${msg}</div>
    <br>
    姓名：<input type="text" name="studentName" placeholder="姓名"/><br/>
    学号：<input type="text" name="studentNumber" placeholder="学号"/><br/>
    年龄：<input type="text" name="age" placeholder="年龄"/><br/>
    专业：<input type="text" name="major" placeholder="专业"/><br/>
    性别：<input type="text" name="sex" placeholder="性别"/><br/>
    账号：<input type="text" name="account" placeholder="账号"/><br/>
    密码：<input type="text" name="password" placeholder="密码"/><br/>
    <input type="submit" value="注册"/>
    <a href="${pageContext.request.contextPath}/System/adminLoginInit">管理员端登录/注册</a>

  </form>
</div>

<script>
  // 获取表单元素
  const form = document.querySelector('form');
  const adminNameInput = document.querySelector('input[name="studentName"]');
  const accountInput = document.querySelector('input[name="studentNumber"]');
  const ageInput = document.querySelector('input[name="age"]');
  const ageInput2 = document.querySelector('input[name="age"]');
  // const phoneNumberInput = document.querySelector('input[name="major"]');
  const sexInput = document.querySelector('input[name="sex"]');
  const sexInput1 = document.querySelector('input[name="account"]');
  const passwordInput = document.querySelector('input[name="password"]');

  // 表单验证
  function validateForm() {
    let isValid = true;

    if (adminNameInput.value.trim() === '') {
      adminNameInput.style.border = '1px solid red';
      isValid = false;
    } else {
      adminNameInput.style.border = 'none';
    }

    if (accountInput.value.trim() === '') {
      accountInput.style.border = '1px solid red';
      isValid = false;
    } else {
      accountInput.style.border = 'none';
    }

    if (ageInput.value.trim() === '' || isNaN(ageInput.value)) {
      ageInput.style.border = '1px solid red';
      isValid = false;
    } else {
      ageInput.style.border = 'none';
    }

    if (ageInput2.value.trim() === '' || isNaN(ageInput2.value)) {
      ageInput2.style.border = '1px solid red';
      isValid = false;
    } else {
      ageInput2.style.border = 'none';
    }

    if (sexInput.value.trim() === '') {
      sexInput.style.border = '1px solid red';
      isValid = false;
    } else {
      sexInput.style.border = 'none';
    }

    if (sexInput1.value.trim() === '') {
      sexInput1.style.border = '1px solid red';
      isValid = false;
    } else {
      sexInput1.style.border = 'none';
    }

    if (passwordInput.value.trim() === '') {
      passwordInput.style.border = '1px solid red';
      isValid = false;
    } else {
      passwordInput.style.border = 'none';
    }

    return isValid;
  }

  // 表单提交
  form.addEventListener('submit', (event) => {
    event.preventDefault();

    if (validateForm()) {
      form.submit();
    }
  });
</script>
</body>
</html>
