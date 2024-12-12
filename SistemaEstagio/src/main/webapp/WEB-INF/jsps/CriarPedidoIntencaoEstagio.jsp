<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pedido Estagio</title>
</head>
<body>
    <form action="/SistemaEstagio/PedidoIntencaoEstagio" method="post">
        <label for="nome">Nome: </label><input type="text" name="nome">
        <label for="matricula">Matricula: </label><input type="text" name="matricula">
        <label for="IRA">IRA: </label><input type="number" name="IRA">
        <label for="cargaHorariaCumprida">Carga Horaria Cumprida: </label><input type="number" name="cargaHorariaCumprida">
        <label for="endereco">Endereco: </label><input type="text" name="endereco">
        
        <fieldset>
        <legend>Primeiro Estágio:</legend>
        <label for="sim">Sim </label>
        <input type="radio" id="sim" name="primeiroEstagio" value="1">
        <label for="nao">Não </label>
        <input type="radio" id="nao" name="primeiroEstagio" value="0">
		</fieldset>
        <label for="nomeEmpresa">Nome Empresa: </label><input type="text" name="nomeEmpresa">
        <label for="enderecoEmpresa">Endereco Empresa: </label><input type="text" name="enderecoEmpresa">
        <label for="modalidadeEstagio">Modalidade Estagio: </label><input type="text" name="modalidadeEstagio">
        <label for="cargaHorariaSemanal">Carga Horaria Semanal: </label><input type="number" name="cargaHorariaSemanal">
        <label for="valorBolsa">Valor Bolsa: </label><input type="text" name="valorBolsa">
        <label for="resumo">Resumo: </label><input type="text" name="resumo">
        <label for="relacaoConteudo">Relacao Conteudo: </label><input type="text" name="relacaoConteudo">
        <label for="motivoEstagio">Motivo Estagio: </label><input type="text" name="motivoEstagio">
        <input type="submit" value="Enviar">
    </form>
</body>
</html>