package com.vffs.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.vffs.exceptions.SqlException;

public class ConexaoJDBC {
	 private static Connection connection = null;
	    private static String usuarioBD = "SA";
	    private static String senhaBD = "";
	    private static String path = "/home/valeria/eclipse-workspace/DesafioDatainfo/hsqldb/ArquivosBD/Datainfo";
	    private static String shutdown = ";shutdown=true"; //Quando a aplicação terminar, o BD deve estar apto a realizar shutdown. 
	    private static String writeDelay = ";hsqldb.write_delay=false"; //O BD deve executar o write (INSERT) assim que recebe esta instrução.
	    private static final String NOME_CLASSE_DRIVE_HSQLDB = "org.hsqldb.jdbc.JDBCDriver";
	    private static final String URL = "jdbc:hsqldb:file:" + path + shutdown + writeDelay;
	    
	    public static Connection getConnection() {
	        if (connection == null) {
	          try {
	          	Class.forName(NOME_CLASSE_DRIVE_HSQLDB);
	              connection =  DriverManager.getConnection(URL, usuarioBD, senhaBD);
	              
	          } catch (SQLException ex) {
	              System.out.println("Código erro" + ex.getErrorCode());
	              System.out.println(ex.getMessage());
	              throw new SqlException(ex);
	              
	          } catch (ClassNotFoundException e) {
	  			
	          	System.out.println("Código erro" + e.getException());
	              System.out.println(e.getMessage());
	  		}
	        }
	          
	          return connection;
	          
	      } 
	      
	      public static void desconectar(){
	          try{
	              if(connection != null){
	                  connection.close();
	                  connection = null;
	              }            
	          }catch(SQLException ex){
	          	System.out.println("Código erro" + ex.getErrorCode());
	              System.out.println(ex.getMessage());            
	          	 throw new SqlException(ex);
	          }
	      }

}
