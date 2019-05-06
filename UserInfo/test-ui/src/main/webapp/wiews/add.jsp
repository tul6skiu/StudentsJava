<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Add user</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label for="last-name">Фамилия:
                <input type="text" id="last-name" name="last-name"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label><br />

            <label for="first-name">Имя:
                <input  type="text" id="first-name" name="first-name"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label><br />
            </label>

            <label for="middle-name">Отчество:
                <input type="text" id="middle-name" name="middle-name"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label><br />

            <label for="birthDate">Дата рождения
                <input class="input-field" type="text" id="birthDate" name="birthDate">
            </label>
            <select name="gender">
                <option value="FEMALE">жен.</option>
                <option value="MALE">муж.</option>
            </select>
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large"  onclick="location.href='http://localhost:8080/Students_war_exploded/'">Back to main</button>
</div>
</body>
</html>