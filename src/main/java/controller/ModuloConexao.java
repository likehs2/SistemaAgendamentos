package controller;

import java.sql.*;


public class ModuloConexao{
    public static Connection conector(){
        Connection conexao = null;
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/oficina";
        String user = "postgres";
        String password = "root";
        
        try{
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //System.out.println(e);
            return null;
        }


    }//fim Connection

}//fim ModuloConexao