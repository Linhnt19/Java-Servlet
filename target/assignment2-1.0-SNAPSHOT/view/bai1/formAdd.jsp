<%--
  Created by IntelliJ IDEA.
  User: Ngo Nhan
  Date: 7/19/2024
  Time: 7:14 AM
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="container">
<h2 style="display: flex;justify-content: center;margin: 10px">Form add user</h2>
<form action=""  method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">ID</label>
        <input type="text" class="form-control" id="idName" aria-describedby="emailHelp" name="id"  value="${param.id != null ? param.id : (user != null ? user.id : '')}">
        <c:if test="${not empty error3}">
            <span style="color: red;">${error3}</span>
        </c:if>
        <span style="color: red;">${errorId}</span>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email"  value="${param.email != null ? param.email : (user != null ? user.email : '')}">
        <c:if test="${not empty error2}">
            <span style="color: red;">${error2}</span>
        </c:if>
        <span style="color: red;">${errorEmail}</span>
    </div>

<%--    pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,}$" title="Độ dài lớn hơn hoặc bằng 6, chứa ít nhất 1 chữ số và ít nhất 1 chữ cái"--%>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="text" class="form-control" id="exampleInputPassword1" name="password" value="${param.password != null ? param.password : (user != null ? user.password : '')}">
        <span style="color: red;">${errorPassword}</span>
        <span style="color: red;">${errorPassword2}</span>
    </div>

    <div class=" mb-3">
        <label for="exampleInputEmail1" class="form-label">Fullname</label>
        <input type="text" class="form-control" id="idFullName" aria-describedby="emailHelp" name="fullname" value="${param.fullname != null ? param.fullname : (user != null ? user.fullname : '')}">
        <span style="color: red;">${errorFullname}</span>
    </div>
    <div class="mb-3 form-check">
        <label class=" form-check-label" for="exampleCheck1">Admin</label>
        <input type="checkbox" class="form-check-input" id="exampleCheck1" name="admin" ${param.admin != null || (User != null && User.admin) ? 'checked' : ''}>

    </div>
    <button class="btn btn-primary" onclick="return confirm('Ban co muon them khong?')">Add</button>
        <a href="quay_ve"><button type="button" class="btn btn-secondary">Cancel</button></a>
</form>
</body>
</html>
