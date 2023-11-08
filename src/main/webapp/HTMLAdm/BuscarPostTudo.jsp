<%@ page import="com.example.servletmude.ConexaoPost" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: alecsilva-ieg
  Date: 05/11/2023
  Time: 16:59
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
<h1 id="nomeLista">Lista de Post</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Texto</th>
    </tr>
    <%
        ConexaoPost conexaoPost = new ConexaoPost();
        ResultSet rs = conexaoPost.buscarTudo();
        if (rs != null) {
            try {
                while (rs.next()) {
    %>
    <tr>
        <td id="idTabelas"><%=rs.getInt("ncdpost")%></td>
        <td><%=rs.getString("ctexto")%></td>
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
