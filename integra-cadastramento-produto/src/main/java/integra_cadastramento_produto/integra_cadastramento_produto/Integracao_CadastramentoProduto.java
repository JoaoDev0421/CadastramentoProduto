package integra_cadastramento_produto.integra_cadastramento_produto;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Integracao_CadastramentoProduto {

	
	  private static String url ="jdbc:postgresql://localhost:5432/CadastramentoProduto";
	  private static String passoword="admin";
	  private static String user = "postgres";
	  private static Connection connection = null;
	  
	  
	  static {
		  
		   Conectar();
	  }
	  
	  //Construtor Integracao
	  public Integracao_CadastramentoProduto() {
		
		    Conectar();
	 }
  
	 // Metodo Conectar
	 public  static void Conectar() {

		     try {
		    	 
		    	    if (connection == null) {
		    	    	
		    	    	  Class.forName("org.postgresql.Driver");
		    	    	  connection = DriverManager.getConnection(url, user, passoword);
		    	    	  connection.setAutoCommit(false);
		    	    	  System.out.println("Conectado com Sucesso!!");
		    	    }

		     }catch (Exception e) {
		    	  e.printStackTrace();
		     }
	}
	  
	   // Metodo Connection
	   public static Connection getConnection() {
		return connection;
	   }

}
