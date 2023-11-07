package com.example.servletmude;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletDesativarUsuario", value = "/operacoes-desativar")
public class ServletDesativarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para desativar um usuário
        //Definindo parâmetros vindo do HTML

        String usuario = request.getParameter("usuarioDesativar");

        try {
            ConexaoUsuario conexaoUsuario = new ConexaoUsuario();
            conexaoUsuario.desativarPorID(Integer.valueOf(usuario));
        }catch (Exception e){

            //Passa o tipo de erro para a próxima tela.
            request.setAttribute("tipoErro", e);
            request.getRequestDispatcher("erro.jsp").forward(request,response);
        }
    }
}
