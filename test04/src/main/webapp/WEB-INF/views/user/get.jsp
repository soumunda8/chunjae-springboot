<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세정보</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css" integrity="sha384-X38yfunGUhNzHpBaEBsWLO+A0HDYOQi8ufWDkZ0k9e0eXz/tH3II7uKZ9msv++Ls" crossorigin="anonymous">
    <style>
        .l-content {width:1200px;margin:25vh auto 0;}
        .l-content > table {margin:0 auto;}
    </style>
</head>
<body>
<div class="l-content">
    <table class="pure-table pure-table-horizontal">
        <tbody>
        <tr>
            <th>이름</th>
            <td>${user.userName }</td>
        </tr>
        <tr>
            <th>아이디</th>
            <td>${user.EName }</td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>${user.tel }</td>
        </tr>
        <tr>
            <th>이메일</th>
            <td>${user.email }</td>
        </tr>
        <tr>
            <th>포인트</th>
            <td>${user.point }</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>