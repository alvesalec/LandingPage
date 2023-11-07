//Tela de alteração

package com.example.servletmude;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletTelaInicial", value = "/operacoes-iniciais")
public class ServletTelaInicial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet para escolher a operação que quer fazer na administração
        //Definindo parâmetros vindo do HTML

        String opcao = request.getParameter("plataforma");

        if (opcao.equals("In")){
            try {
                request.getRequestDispatcher("Inserir.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (opcao.equals("Alt")){
            try {
                request.getRequestDispatcher("Alterar.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (opcao.equals("BuscEspec")){
            try {
                request.getRequestDispatcher("BuscarEspec.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (opcao.equals("BuscarTudo")){
            try {
                request.getRequestDispatcher("BuscarTudo.html").forward(request, response);
            } catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (opcao.equals("Rem")){
            try {
                request.getRequestDispatcher("Remover.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
        if (opcao.equals("Desa")){
            try {
                request.getRequestDispatcher("DesativarUsuario.html").forward(request, response);
            }catch (Exception e){

                //Passa o tipo de erro para a próxima tela.
                request.setAttribute("tipoErro", e);
                request.getRequestDispatcher("erro.jsp");
            }
        }
    }
}


