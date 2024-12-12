<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <form action="/SistemaEstagio/IndentificarUsuario" method="post">
        <label for="email">E-mail</label>
        <input type="text" name="email">
        <label for="senha">Senha</label>
        <input type="password" name="senha">
        <input type="submit" value="Enviar">
    </form>
</body>
</html>