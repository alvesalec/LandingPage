package com.example.servletmude;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletBuscaPostId", value = "/ServletBuscaPostId")
public class ServletBuscaPostId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servelet que busca um post somente por identificador que pode ser identificador tanto do post quanto do usuário.
        //Definindo parâmetros vindo do HTML

        String escolha = request.getParameter("tabelaPost");
        String valorBuscar = request.getParameter("valorProcurado");
        request.setAttribute("valorBuscar", valorBuscar);

        if (escolha.equals("user")) {

            try {

                //Mandar para tela de busca do post pelo identificado do usuário que fez o post
                request.getRequestDispatcher("BuscarPostIDUser.jsp").forward(request, response);

            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        }
        if (escolha.equals("post")) {

            try {

                //Mandar para tela de busca do post pelo identificado do post
                request.getRequestDispatcher("BuscarPostIDPost.jsp").forward(request, response);

            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        }
    }
}
