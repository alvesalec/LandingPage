package com.example.servletmudeusuario.servletmude;

import java.sql.*;

//        Atributos
public class ConexaoPost {
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

    //    Método para buscar tudo da tabela  post
    public ResultSet buscarTudo(){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM post " );

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

    //  Método para buscar na tabela post por id do usuário
    public ResultSet buscarPorIDUser(int id){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM post where ncdusuario = "+id);


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

    //    Método para buscar na tabela de post por id do post
    public ResultSet buscarPorIDPost(int id){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM post where ncdpost = "+id);


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
    // Método para buscar post por texto
    public ResultSet buscarPorTextoPost(String texto){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM post where ctexto like '%"+texto+"%'");



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

    //    Método de remover post por id do post
    public boolean remover(String nomeCampo, String parametro) {
        try {
            conectar();
            if (nomeCampo.equals("cdescricao")) {
                pstmt = conn.prepareStatement("DELETE * FROM post where ctexto like '%"+parametro+"%'");
                pstmt.setString(1, parametro);
            }else if(nomeCampo.equals("ncdpost")) {
                pstmt = conn.prepareStatement("DELETE from post WHERE " + nomeCampo + " = ?");
                pstmt.setInt(1, Integer.valueOf(parametro));
            }
            return pstmt.execute();//Executando o comando sql do preparedStatement

        } catch (SQLException sql) {
            sql.printStackTrace();
            return false;
        } finally {
            desconectar();
        }
    }
}
