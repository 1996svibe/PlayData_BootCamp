<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%--<% response.sendRedirect("/main"); %>--%>
<h2>Hello World!</h2>
<c:redirect url = "/login"></c:redirect>
<%--<%--%>
<%--    if(session.getAttribute("uid") ==null)--%>
<%--%>--%>
<%--    <a>로그인</a>--%>
<%--<%--%>
<%--    if(session.getAttribute("uid") != null)--%>
<%--%>--%>
<%--    <a>로그아웃</a>--%>

<%--<c:if test = "${sessionScope.get('uid')!=null}"><a>로그아웃</a></c:if>--%>
<%--<c:if test = "${sessionScope.get('uid')==null}"><a>로그인</a></c:if>--%>
<%--<c:forEach begin = "0" end="10" step ="1" var="i">--%>
<%--    <c:choose>--%>
<%--    <c:when test="${i%2 ==0}">--%>
<%--        <h1>${i} 짝수</h1>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        <h1>${i} 홀수</h1>--%>
<%--    </c:otherwise>--%>
<%--    </c:choose>--%>
<%--</c:forEach>--%>
<%--<%--%>
<%--    for (int i = 0; i < 10; i++) {--%>
<%--        %>--%>
<%--<h1><%=i%></h1>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>
</body>
</html>
