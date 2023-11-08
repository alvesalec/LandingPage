<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: alecsilva-ieg
  Date: 06/11/2023
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Mude!</title>
  <link rel="stylesheet" href="style.css">
  <link rel="icon" href="../imagens/borboleta.png">
<body>
<header>
  <img id="borboleta" src="../imagens/borboleta.png">
  <p id="boasVindas">Boas vindas, usuário!</p>
</header>
<div id="card1">
  <div id="container">
    <div id="top">
      <h5>Opa...</h5>
    </div>
    <div id="recado">
      <p id="escrita">Um erro foi localizado! <br> Não foi possível realizar sua operação :( <br> Erro do tipo:
        <%
          Object tipoErro = request.getAttribute("tipoErro");
          String novoValorBuscar = String.valueOf(tipoErro);
        %>
        <%=novoValorBuscar%>
      </p>
    </div>
    <br>
    <button id='botaoVoltar' type='submit' formaction="index.html">Voltar para o início</button>
  </div>
</div>
</form>


</body>
</html>
