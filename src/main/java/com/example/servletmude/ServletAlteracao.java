package com.example.servletmude;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAlteracao", value = "/operacao-alteracao")
public class ServletAlteracao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para alterar algum valor da tabela
        //Definindo parâmetros vindo do HTML

        String tabela = request.getParameter("tabelaAlt");
        String campo = request.getParameter("campoAlt");
        String valorAntigo = request.getParameter("valorAntigo");
        String valorNovo = request.getParameter("valorNovo");

        //Se o campo for "ncd" ele concatena "ncd" (nome que demos para o identificador ou ID) com "genero", "sexualidade" e
        // etc para que fique igual o nome da tabela no banco

        if (tabela.equals("gen")) {
            ConexaoGenero conexaoGen = new ConexaoGenero();
            try{
                if (campo.equals("ncd")){
                    campo = campo + "genero";
                }

                //Chama método para alterar

                conexaoGen.alterar(campo, valorAntigo, valorNovo);
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

                //Chama método para alterar

                conexaoSex.alterar(campo, valorAntigo, valorNovo);
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

                //Chama método para alterar

                conexaoPron.alterar(campo, valorAntigo, valorNovo);
                request.getRequestDispatcher("sucesso.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.

                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp").forward(request,response);
            }

        }
    }
}
