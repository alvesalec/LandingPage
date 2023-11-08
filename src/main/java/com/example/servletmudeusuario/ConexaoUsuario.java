package com.example.servletmudeusuario;

import java.sql.*;

public class ConexaoUsuario {
    //        Atributos
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;


    //    Método para conectar no banco
    public boolean conectar() {
        try {

//        Informando qual driver de conexão será utilizado pelo DriverManage

            Class.forName("org.postgresql.Driver");

//    Criando a conexão com o DB
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://dpg-ckarhr9kms5s739c7teg-a.oregon-postgres.render.com:5432/dbtodostec", "henry_gois", "SDrwrXynodOoSWlcqES3ICuOKZrdrkQH"
            );

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return false;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        return true;
    }


    // Método para desconectar do banco
    public void desconectar() {
        try {


            if (conn != null && !conn.isClosed()) {
//            Desconectando do DB
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }


    //    Método para buscar tudo da tabela usuário
    public ResultSet buscarTudo(){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM usuario " );

            //Execução Do Comando SQL
            rs = pstmt.executeQuery();


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
        return rs;
    }

    //    Método para buscar da tabela usuário por id
    public ResultSet buscarPorID(int id){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM usuario where ncdusuario = "+id );

            //Execução Do Comando SQL
            rs = pstmt.executeQuery();


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
        return rs;
    }
    //    Método para buscar da tabela usuário por username
    public ResultSet buscarPorUsername(String username){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM usuario where cusername = ? ");
            pstmt.setString(1,username);

            //Execução Do Comando SQL
            rs = pstmt.executeQuery();


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
        return rs;
    }
    //    Método para buscar da tabela usuário por email
    public ResultSet buscarPorEmail(String email){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM usuario where cemail = ? ");
            pstmt.setString(1,email);

            //Execução Do Comando SQL
            rs = pstmt.executeQuery();


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
        return rs;
    }
    //    Método para buscar da tabela usuário por conta ativa ou desativa
    public ResultSet buscarPorStatus(String status){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM usuario where ncontaativa = cast(? as varchar)");
            pstmt.setString(1,status);
            //Execução Do Comando SQL
            rs = pstmt.executeQuery();


        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
        return rs;
    }

    //    Método para inserir usuário
    public boolean inserir(String nome, String nomeUsuario, String senha,String telefone, String email, int pronome, int genero, int sexualidade, String descricao) {
        try {
            conectar();//Abrindo conexão com o banco
            pstmt = conn.prepareStatement("INSERT into usuario (cnome,cusername, csenha, ctelefone,dcadastro,cemail,ncontaativa,ncdpronome,ncdgenero,ncdsexualidade,cdescricao) VALUES (?,?,?,?,current_date,?,'1',?,?,?,?)");
            pstmt.setString(1, nome);
            pstmt.setString(2, nomeUsuario);
            pstmt.setString(3, senha);
            pstmt.setString(4, telefone);
            pstmt.setString(5, email);
            pstmt.setInt(6, pronome);
            pstmt.setInt(7, genero);
            pstmt.setInt(8, sexualidade);
            pstmt.setString(9, descricao);
            return pstmt.execute();//Executando o comando sql do preparedStatement
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            desconectar();
        }

    }



}

