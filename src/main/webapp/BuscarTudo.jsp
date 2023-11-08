<%@ page import="com.example.servletmudeusuario.ConexaoUsuario" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: alecsilva-ieg
  Date: 06/11/2023
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mude!</title>
    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="imagens/borboleta.png">
</head>
<body>
<header>
    <img id="borboleta" src="imagens/borboleta.png">
    <p id="boasVindas">Boas vindas, usuário!</p>
</header>
<h1 id="nomeLista">Lista de usuários</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Username</th>
        <th>Status</th>
        <th>Descricão</th>
        <th>Telefone</th>
        <th>Pronome</th>
        <th>Genêro</th>
        <th>Sexualidade</th>
    </tr>
    <%
        ConexaoUsuario conexaoUsuario = new ConexaoUsuario();
        ResultSet rs = conexaoUsuario.buscarTudo();
        if (rs != null) {
            try {
                while (rs.next()) {
    %>
    <tr>
        <td id="idTabelas"><%=rs.getInt("ncdusuario")%></td>
        <td><%=rs.getString("cnome")%></td>
        <td><%=rs.getString("cusername")%></td>
        <td><%=rs.getInt("ncontaativa")%></td>
        <td><%=rs.getString("cdescricao")%></td>
        <td><%=rs.getString("ctelefone")%></td>
        <td><%=rs.getInt("ncdpronome")%></td>
        <td><%=rs.getInt("ncdgenero")%></td>
        <td><%=rs.getInt("ncdsexualidade")%></td>
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
