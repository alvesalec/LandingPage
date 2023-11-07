package com.example.servletmude;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletBuscar", value = "/operacao-buscar-tudo")
public class ServletBuscarTudo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para buscar todos os valores de uma tabela
        //Definindo parâmetros vindo do HTML

        String tabela = request.getParameter("buscarTudo");

        if (tabela.equals("gen")) {

            try {
                request.getRequestDispatcher("BuscarGeneroTudo.jsp").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }
        }
        if (tabela.equals("sex")) {

            try {
                request.getRequestDispatcher("BuscarSexualidadeTudo.jsp").forward(request, response);
            } catch (Exception e) {

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        }
        if (tabela.equals("pron")) {

            try {
                request.getRequestDispatcher("BuscarPronomeTudo.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        }
        if (tabela.equals("post")) {

            try {
                request.getRequestDispatcher("BuscarPostTudo.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }
        }
    }
}
