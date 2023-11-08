package com.example.servletmudeusuario;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletInserir", value = "/InserirUsuario")
public class ServletInserir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para cadastrar o usuário
        //Definindo parâmetros vindo do HTML

        String nome = request.getParameter("nomeReal");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        String genero = request.getParameter("escolhaGenero");
        String sexualidade = request.getParameter("escolhaSexualidade");
        String pronome = request.getParameter("escolhaPronome");
        String descricao = request.getParameter("desc");
        String senhacomparacao = request.getParameter("repetirSenha");

        if (senhacomparacao.equals( senha)) {

            try {

                //Chamando a função para inserir o usuário e jogando para tela de sucesso
                ConexaoUsuario conexaoUsuario = new ConexaoUsuario();
                conexaoUsuario.inserir(nome, username, senha, telefone, email, Integer.parseInt(pronome), Integer.parseInt(genero), Integer.parseInt(sexualidade), descricao);
                request.getRequestDispatcher("sucesso.html").forward(request, response);
            } catch (Exception e) {

                //Passa o tipo de erro para a próxima tela
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        } else {

            //Se a pessoa colocar a senha errada em alguma das verificações ele manda para tela de erro
            //com a mensagem
            String e = "As senhas precisam corresponder";
            request.setAttribute("tipoErro", e);
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}


