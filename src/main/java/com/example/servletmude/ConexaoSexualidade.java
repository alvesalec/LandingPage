package com.example.servletmude;

import java.sql.*;

public class ConexaoSexualidade {
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


    //    Método para remover da tabela sexualidade tanto por id quanto por descrição

    public boolean inserir(String nome) {
        try {
            conectar();//Abrindo conexão com o banco
            pstmt = conn.prepareStatement("INSERT into tipo_sexualidade (cdescricao) VALUES (lower(?))");
//                            Setando o valor dos parâmetro
            pstmt.setString(1, nome);
            return pstmt.execute();//Executando o comando sql do preparedStatement
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            desconectar();
        }

    }


    //    Método para remover da tabela sexualidade tanto por id quanto por descrição
    public boolean remover(String nomeCampo, String parametro) {
        String remover = null;
        try {
            conectar();
            if (nomeCampo.equals("cdescricao")) {
                pstmt = conn.prepareStatement("DELETE from tipo_sexualidade WHERE " + nomeCampo + " = ?");
                pstmt.setString(1, parametro);
            }else if (nomeCampo.equals("ncdsexualidade")){
                pstmt = conn.prepareStatement("DELETE from  tipo_sexualidade WHERE " + nomeCampo + " = ?");
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



    //    Método para alterar a tabela sexualidade que recebe como parametro o campo de condição,
//    a condição e o novo valor
    public int alterar( String campoParametro, String valorComparativo, String novoValor) {
        try {
            conectar();//Abrindo a conexão com o banco
            pstmt = conn.prepareStatement("UPDATE tipo_sexualidade SET cdescricao = lower(?) WHERE "+ campoParametro+ " = ?");

            if (campoParametro.equals("ncdsexualidade") ){
                pstmt.setString(1,novoValor );
                pstmt.setInt(2, Integer.valueOf(valorComparativo));
                return pstmt.executeUpdate();//Executando o comando sql do PreparedStatement
            }else if(campoParametro.equals("cdescricao")){
                pstmt.setString(1,novoValor );
                pstmt.setString(2, valorComparativo.toLowerCase());
                return pstmt.executeUpdate();//Executando o comando sql do PreparedStatement
            }




        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            desconectar();
        }
        return 0;
    }
    //    Método para buscar tudo da tabela sexualidade
    public ResultSet buscarTudo(){

        try{

            conectar();//Abrindo a conexão com o banco
            //Comando SQL Para Selecionar os dados das tabelas
            pstmt = conn.prepareStatement("SELECT * FROM tipo_sexualidade " );

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

    //    Método para buscar em específico da tabela sexualidade, pode procurar tanto por id quanto por
//     descrição
    public ResultSet buscar(String campoParametro, String valorComparacao){

        try{
            conectar();//Abrindo a conexão com o banco
            if (campoParametro.equals("ncdsexualidade") ){
                //Comando SQL Para Selecionar os dados das tabelas
                pstmt = conn.prepareStatement("SELECT * FROM tipo_sexualidade WHERE " + campoParametro + " = " + Integer.valueOf(valorComparacao));
            }else {
                //Comando SQL Para Selecionar os dados das tabelas
                pstmt = conn.prepareStatement("SELECT * FROM tipo_sexualidade WHERE " + campoParametro + " = '" + valorComparacao+"'");
            }

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
}
