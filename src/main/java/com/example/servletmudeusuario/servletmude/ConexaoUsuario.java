package com.example.servletmudeusuario.servletmude;

import java.sql.*;

//        Atributos

public class ConexaoUsuario {
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


    //    Método para banir usuário, ou seja, desativar a conta dele por id
    public int desativarPorID( int id) {
        try {
            conectar();//Abrindo a conexão com o banco
            pstmt = conn.prepareStatement("UPDATE usuario SET ncontaativa = cast(0 as varchar) WHERE ncdusuario = "+id);
            return pstmt.executeUpdate();//Executando o comando sql do PreparedStatement


        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            desconectar();
        }
    }
}
