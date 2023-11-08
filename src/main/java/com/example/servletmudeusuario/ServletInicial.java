package com.example.servletmudeusuario;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletInicial", value = "/operacoes-iniciais")
public class ServletInicial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet que leva para a próxima página baseado na ação escolhida
        //Definindo parâmetros vindo do HTML

        String escolha = request.getParameter("escolhaInicial");

        if (escolha.equals("busc")){

            try {

                //"Setando um objeto e mandando para próxima tela
                request.getRequestDispatcher("Buscar.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (escolha.equals("cad")){

            try {

                //"Setando um objeto e mandando para próxima tela
                request.getRequestDispatcher("Inserir.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
    }
}
