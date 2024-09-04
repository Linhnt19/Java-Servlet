<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="container">
    <h2 style="display: flex;justify-content: center;margin: 10px">Quản lý Video</h2>
<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Description</th>
        <th scope="col">Active</th>
        <th scope="col">Poster</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${listSize==0}">
        <tr>
            <td colspan="6"><p class="text-danger">No item found</p></td>
        </tr>
    </c:if>
    <c:if test="${listSize!=0}">
    <c:forEach items="${list}" var="u">
    <tr>
        <th scope="row">${u.id}</th>
        <td>${u.title}</td>
        <td>${u.description}</td>
        <td>${u.active?"Yes":"No"}</td>
        <td style="display: flex;justify-content: center;height: 50px"><img class="card-img-top" src="${u.poster}" alt="">
        </td>
<%--        <td>${u.poster}</td>--%>
<%--        <td><img src="${u.poster}" alt=""></td>--%>
        <td>
            <a href="update_user2?id=${u.id}"><button type="button" class="btn btn-success">Update</button></a>
            <a href="delete_user2?id=${u.id}"><button type="button" class="btn btn-danger" onclick="return confirm('Ban co muon xoa khong?')">Delete</button></a>
        </td>
    </tr>
    </c:forEach>
    </c:if>
    </tbody>
</table>
    <a href="add_user2"><button type="button" class="btn btn-primary">Add Video</button></a>

</body>
</html>
