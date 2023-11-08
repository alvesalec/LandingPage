<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.servletmude.ConexaoPronome" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.servletmude.ConexaoSexualidade" %><%--
  Created by IntelliJ IDEA.
  User: alecsilva-ieg
  Date: 27/10/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mude!</title>
    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="./imagens/borboleta.png">
</head>
<body>
<header>
    <img id="borboleta" src="./imagens/borboleta.png">
    <p id="boasVindas">Boas vindas, desenvolvedor!</p>
</header>
<h1 id="nomeLista">Lista de Sexualidade</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Descrição</th>
    </tr>
    <%
        ConexaoSexualidade conexaoSex = new ConexaoSexualidade();
        ResultSet rs = conexaoSex.buscarTudo();
        if (rs != null) {
            try {
                while (rs.next()) {
    %>
    <tr>
        <td id="idTabelas"><%=rs.getInt("ncdsexualidade")%></td>
        <td><%=rs.getString("cdescricao")%></td>
    </tr>
    <%
            }
        } catch (SQLException e) {
                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
        }
    } else {
                //Passa o tipo de erro para a próxima tela.
                String e = "ResultSet vazio";
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
                    }
        %>

</table>
</body>
</html>
