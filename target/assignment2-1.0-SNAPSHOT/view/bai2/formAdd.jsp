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
<h2 style="display: flex;justify-content: center;margin: 10px">Form add Video</h2>
<form action=""  method="post">
    <div class="mb-3">
        <label class="form-label">ID</label>
        <input type="text" class="form-control" id="idName" aria-describedby="emailHelp" name="id"  value="${param.id != null ? param.id : (video != null ? video.id : '')}">
        <c:if test="${not empty error}">
            <span style="color: red;">${error}</span>
        </c:if>
<%--        <c:if test="${not empty error1}">--%>
<%--            <span style="color: red;">${error1}</span>--%>
<%--        </c:if>--%>
        <span style="color: red;">${errorId}</span>
    </div>
    <div class="mb-3">
        <label  class="form-label">Title</label>
        <input type="text" class="form-control" id="idTitle" aria-describedby="emailHelp" name="title"  value="${param.title != null ? param.title : (video != null ? video.title : '')}">
<%--        <c:if test="${not empty error2}">--%>
<%--            <span style="color: red;">${error2}</span>--%>
<%--        </c:if>--%>
        <span style="color: red;">${errorTitle}</span>
    </div>


    <div class="mb-3">
        <label  class="form-label">Description</label>
        <textarea class="form-control" id="idDescription" rows="3" name="description">${param.description != null ? param.description : (video != null ? video.description : '')}</textarea>
    </div>

    <div class=" mb-3 form-check">
        <label  class="form-label">Active</label>
        <input type="checkbox" class="form-check-input" id="idActive" aria-describedby="emailHelp" name="active" ${param.active != null || (video != null && video.active) ? 'checked' : ''}>
    </div>
    <div class="mb-3 ">
        <label class=" form-check-label" >Poster</label>
        <input type="text" class="form-control" id="idPoster" name="poster"  value="${param.poster != null ? param.poster : (video != null ? video.poster : '')}">
<%--        <c:if test="${not empty error3}">--%>
<%--            <span style="color: red;">${error3}</span>--%>
<%--        </c:if>--%>
        <span style="color: red;">${errorPoster}</span>
    </div>
    <button class="btn btn-primary" onclick="return confirm('Ban co muon them khong?')">Add</button>
        <a href="quay_ve2"><button type="button" class="btn btn-secondary">Cancel</button></a>
</form>
</body>
</html>