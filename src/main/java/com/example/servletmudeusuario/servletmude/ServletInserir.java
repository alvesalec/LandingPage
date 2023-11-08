package com.example.servletmudeusuario.servletmude;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.InputMismatchException;

@WebServlet(name = "ServletInserir", value = "/operacao-insercao")
public class ServletInserir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para inserir um valor na tabela
        //Definindo parâmetros vindo do HTML

        String tabela = request.getParameter("tabelaInserir");
        String valorInserir = request.getParameter("valorInserido");

        if (tabela.equals("gen")) {
            ConexaoGenero conexaoGen = new ConexaoGenero();
            try {
            conexaoGen.inserir(valorInserir);
            request.getRequestDispatcher("sucesso.html").forward(request,response);
            } catch (Exception e) {

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        } if (tabela.equals("sex")){
            ConexaoSexualidade conexaoSex = new ConexaoSexualidade();
            try{
                conexaoSex.inserir(valorInserir);
                request.getRequestDispatcher("sucesso.html").forward(request,response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        } if (tabela.equals("pron")){
            ConexaoPronome conexaoPron = new ConexaoPronome();
            try {
                conexaoPron.inserir(valorInserir);
                request.getRequestDispatcher("sucesso.html").forward(request,response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        }
    }
}
