<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="container">
<h2>hello world</h2>
${depts}
<div style="text-align: center">
    <h2>${res}</h2>
    <table border="1">
        <thead>
        <tr>
            <td>部门编号</td>
            <td>部门名称</td>
            <td>部门位置</td>
            <td>修改</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dept" items="${depts}">
            <tr>
                <form>
                    <td><input type="text" value="${dept.deptno}"></td>
                    <td><input type="text" value="${dept.dname}"></td>
                    <td><input type="text" value="${dept.loc}"></td>
                </form>
            </tr>
        </c:forEach>
        <tr>
            <form action="${pageContext.request.contextPath}/add.do" method="post">
                <td><input type="text" name="deptno"></td>
                <td><input type="text" name="dname"></td>
                <td><input type="text" name="loc"></td>
                <td><input type="submit" value="添加"></td>
            </form>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
