<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A layout example that shows off a responsive product landing page.">
    <title>로그인</title>
</head>
<body class="join">

    <div>
        <form action="${path }/user/login.do" method="PUT">
            <div>
                <input type="text" name="id" id="id" placeholder="아이디/이메일" required /><br/>
                <input type="password" name="pw" id="pw" placeholder="비밀번호" required />
                <button type="submit">로그인하기</button>
                <c:if test="${not empty message }"><p style="color:red;">로그인에 실패했습니다</p></c:if>
            </div>
        </form>
    </div>

</body>
</html>