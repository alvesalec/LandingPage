package com.example.servletmudeusuario.servletmudeusuario;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletBuscar", value = "/operacao-buscar")
public class ServletBuscar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para buscar usuário de diferentes formas. Elas pode ser: buscar por usuário, e-mail,
        // username, ID ou por tudo.
        //Definindo parâmetros vindo do HTML

        String busca = request.getParameter("buscar");
        String valor = request.getParameter("valor");

        if (busca.equals("user")){
            try {

                //"Setando um objeto e mandando para próxima tela
                request.setAttribute("valor", valor);
                request.getRequestDispatcher("BuscarUsername.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (busca.equals("id")){
            try {

                //"Setando um objeto e mandando para próxima tela
                request.setAttribute("valor", valor);
                request.getRequestDispatcher("BuscarID.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (busca.equals("status")){
            try {

                //"Setando um objeto e mandando para próxima tela
                request.setAttribute("valor", valor);
                request.getRequestDispatcher("BuscarStatus.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (busca.equals("email")){
            try {

                //"Setando um objeto e mandando para próxima tela
                request.setAttribute("valor", valor);
                request.getRequestDispatcher("BuscarEmail.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (busca.equals("tudo")){
            try {

                //"Setando um objeto e mandando para próxima tela
                request.getRequestDispatcher("BuscarTudo.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
    }
}
