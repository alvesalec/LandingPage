package com.example.servletmudeusuario.servletmudeusuario;

import com.example.servletmudeusuario.servletmudeusuario.ConexaoUsuario;
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
            if(verificaNum(telefone)){
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
                //Se a pessoa digitar um número inválido ele manda para tela de erro com a mensagem
                String e = "Digite um número válido";
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

    public static boolean verificaNum(String telefone){
        //retira todos os caracteres não-numéricos (incluindo espaço,tab, etc)
    telefone = telefone.replaceAll("\\D","");

            if (!(telefone.length() >= 10 && telefone.length() <= 11)) return false;

            if (telefone.length() == 11 && Integer.parseInt(telefone.substring(2, 3)) != 9) return false;

            java.util.regex.Pattern p = java.util.regex.Pattern.compile(telefone.charAt(0)+"{"+telefone.length()+"}");
            java.util.regex.Matcher m = p.matcher(telefone);
            if(m.find()) return false;

            Integer[] codigosDDD = {
            11, 12, 13, 14, 15, 16, 17, 18, 19,
            21, 22, 24, 27, 28, 31, 32, 33, 34,
            35, 37, 38, 41, 42, 43, 44, 45, 46,
            47, 48, 49, 51, 53, 54, 55, 61, 62,
            64, 63, 65, 66, 67, 68, 69, 71, 73,
            74, 75, 77, 79, 81, 82, 83, 84, 85,
            86, 87, 88, 89, 91, 92, 93, 94, 95,
            96, 97, 98, 99};

            if ( java.util.Arrays.asList(codigosDDD).indexOf(Integer.parseInt(telefone.substring(0, 2))) == -1) return false;
            Integer[] prefixos = {2, 3, 4, 5, 7};

            if (telefone.length() == 10 && java.util.Arrays.asList(prefixos).indexOf(Integer.parseInt(telefone.substring(2, 3))) == -1) return false;

            return true;
            }
}


