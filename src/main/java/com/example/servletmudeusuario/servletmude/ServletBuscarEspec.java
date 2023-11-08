package com.example.servletmudeusuario.servletmude;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ResponseCache;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ServletBuscarEspec", value = "/operacao-buscar-espec")
public class ServletBuscarEspec extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para buscar um valor específico de uma tabela
        //Definindo parâmetros vindo do HTML e "setando" atributos para mandar para próxima página

        String tabela = request.getParameter("tabelaBuscarEspec");
        String campo = request.getParameter("campoBuscarEspec");
        String valorBuscar = request.getParameter("buscarEspec");
        request.setAttribute("campo", campo);
        request.setAttribute("valorBuscar", valorBuscar);

        if (tabela.equals("gen")) {
            try {

                //Mandando para próxima tela
                request.getRequestDispatcher("BuscarGeneroEspec.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        }
        if (tabela.equals("sex")) {

            try {

                //Mandando para próxima tela
                request.getRequestDispatcher("BuscarSexualidadeEspec.jsp").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        }
        if (tabela.equals("pron")) {

            try {

                //Mandando para próxima tela
                request.getRequestDispatcher("BuscarPronomeEspec.jsp").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        }
        if (tabela.equals("post")) {

            try {
                if (campo.equals("ncdpost")) {

                    //Mandando para próxima tela
                    request.getRequestDispatcher("BuscarPostID.jsp").forward(request, response);
                } else {

                    //Mandando para próxima tela
                    request.getRequestDispatcher("BuscarGeneroTudo.jsp").forward(request, response);

                }
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }
        }
    }

}