<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Title</title>
    <style>
        <%@include file="/wiews/css/style.css"%>
    </style>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script type="text/javascript">
        <%@include file="/wiews/main.js"%>
    </script>

</head>
<body>
<div>
    <div class="form-style-2-heading">
        Список всех Студентов
    </div>
    <table class="w3-table-all">
        <tr class="w3-red">
            <td>Имя</td>
            <td>Фамилия</td>
            <td>Oтчество</td>
            <td>Возраст</td>
            <td>Пол</td>
            <td>Действия</td>
            <td>
        </tr>
        <c:forEach items="${usersFromServer}" var = "user">
            <tr>
                <td class=w3-round-small>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.middleName}</td>
                <td>${user.birthDate}</td>
                <td>${user.gender}</td>
                <td>
                    <form method="post">
                        <input type="hidden" name="id" value="${user.firstName}">
                        <input type="hidden" name="name" value="${user.lastName}">
                        <input type="hidden" name="name" value="${user.middleName}">
                        <input type="hidden" name="name" value="${user.birthDate}">
                        <input type="hidden" name="name" value="${user.gender}">
                        <button  type="submit" name="delete" value="${user.id}">Удалить</button>
                    </form>
                    <button  class="editUser" onclick="disp()" value="${user.id}">Изменить2</button>
                </td>
            </tr>
            <div class="center" id="${user.id}"  style="display:none;">
                <form method="post" >
                    <div class="row">
                        <div class="col">
                            <input type="text" id="first-name" name="first-name" nameclass="form-control" placeholder="${user.firstName}">
                        </div>
                        <div class="col">
                            <input type="text" id="last-name" name="last-name" class="form-control" placeholder="${user.lastName}">
                        </div>
                        <div class="col">
                            <input type="text" id="middle-name" name="middle-name"  class="form-control" placeholder="${user.middleName}">
                        </div>
                        <div class="col">
                            <input class="input-field" type="text" id="birthDate" name="birthDate" placeholder="${user.birthDate}">
                        </div>
                        <select name="gender">
                            <option value="FEMALE">жен.</option>
                            <option value="MALE">муж.</option>
                        </select>

                        <button type="submit" name="update" value="${user.id}">Внести изменения</button>
                    </div>
                </form>
            </div>
        </c:forEach>
    </table>
</div>
</body>
</html>