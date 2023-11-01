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
        <form action="${path }/user/login.do" method="post">
            <table>
                <tr>
                    <th>아이디</th>
                    <td>
                        <input type="text" name="eName" id="eName" placeholder="아이디" required>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td>
                        <input type="password" name="ePassword" id="ePassword" placeholder="비밀번호" required>
                        <input type="password" name="pw2" id="pw2" placeholder="비밀번호 확인" required>
                    </td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td>
                        <input type="text" name="userName" id="userName" placeholder="이름" required>
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>
                        <input type="email" name="email" id="email" placeholder="이메일" required>
                    </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td>
                        <input type="text" name="address" id="address" placeholder="주소" required>
                    </td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td>
                        <input type="text" name="tel" id="tel" placeholder="전화번호" required>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>