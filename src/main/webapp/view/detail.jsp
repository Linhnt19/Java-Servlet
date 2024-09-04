<%@ include file="theme/navbar.jsp"%>
<div class="container mt-3">
    <div class="d-flex">
        <h3 style="flex:1">${video.title}</h3>
        <c:if test="${not empty sessionScope.username}">
            <div>
                <a class="btn btn-sm border-primary">Like</a>
                <a class="btn btn-sm border-primary">Unlike</a>
            </div>
        </c:if>

    </div>
    <iframe width="100%" height="600px" src="https://www.youtube.com/embed/${video.id}"  allowfullscreen></iframe>
</div>