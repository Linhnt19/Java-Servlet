<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="container">
    <h2 style="display: flex;justify-content: center;margin: 10px">Quản lý người dùng</h2>
<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Password</th>
        <th scope="col">Email</th>
        <th scope="col">Fullname</th>
        <th>Admin</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
    <tr>
        <th scope="row">${u.id}</th>
        <td>${u.password}</td>
        <td>${u.email}</td>
        <td>${u.fullname}</td>
        <td>${u.admin?"Yes":"No"}</td>
        <td><a href="update_user?id=${u.id}"><button type="button" class="btn btn-success">Update</button></a>
            <a href="delete_user?id=${u.id}"><button type="button" class="btn btn-danger" onclick="return confirm('Ban co muon xoa khong?')">Delete</button></a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
    <a href="add_user"><button type="button" class="btn btn-primary">Add User</button></a>

</body>
</html>
