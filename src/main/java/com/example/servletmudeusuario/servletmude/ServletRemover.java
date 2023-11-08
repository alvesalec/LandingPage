package com.example.servletmudeusuario.servletmude;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletRemover", value = "/operacao-remocao")
public class ServletRemover extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para remover um valor de uma tabela
        //Definindo parâmetros vindo do HTML

        String tabela = request.getParameter("tabelaRem");
        String campo = request.getParameter("campoRem");
        String valorRemover = request.getParameter("valorRemovido");

        if (tabela.equals("gen")) {
            ConexaoGenero conexaoGen = new ConexaoGenero();
            try{
                if (campo.equals("ncd")){
                    campo = campo + "genero";
                }
                conexaoGen.remover(campo, valorRemover);
                request.getRequestDispatcher("sucesso.html").forward(request,response);

            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        } if (tabela.equals("sex")){
            ConexaoSexualidade conexaoSex = new ConexaoSexualidade();
            try{
                if (campo.equals("ncd")){
                    campo = campo + "sexualidade";
                }
                conexaoSex.remover(campo, valorRemover);
                request.getRequestDispatcher("sucesso.html").forward(request,response);

            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        } if (tabela.equals("pron")){
            ConexaoPronome conexaoPron = new ConexaoPronome();
            try {
                if (campo.equals("ncd")){
                    campo = campo + "pronome";
                }
                conexaoPron.remover(campo, valorRemover);
                request.getRequestDispatcher("sucesso.jsp").forward(request, response);

            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }
        } if (tabela.equals("post")){
            ConexaoPost conexaoPost = new ConexaoPost();
            try {
                if (campo.equals("ncd")){
                    campo = campo + "post";
                }
                else {
                    campo = "ctexto";
                }
                conexaoPost.remover(campo, valorRemover);
                request.getRequestDispatcher("sucesso.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }
        }
    }
}

