package Exe_Start;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Estrutura_DAO.Estrutura_DAO;
import integra_cadastramento_produto.integra_cadastramento_produto.Integracao_CadastramentoProduto;
import modelo_tabela_cadastramentoproduto.modelo_tabela_cadastramento_produto;

public class Exe_class {

	
	 // Metodo Test ( Insert )
	 @Test
	   public void Exe_Insert () {
		   
		       Estrutura_DAO dao_insert = new Estrutura_DAO();
		       
		       modelo_tabela_cadastramento_produto modelo_insert = new modelo_tabela_cadastramento_produto();
		       
		        
                 modelo_insert.setNome("Corante Xadrez Vermelho");	
                 modelo_insert.setCodigo("7891323075225");
                 modelo_insert.setPreco("5.50");
                 
		       dao_insert.Insert(modelo_insert);
	   }
	 
	 
	 //Metodo (   Listagem Integral  )
	 
	 @Test
	 public void Exe_ListagemIntegral() throws Exception {
		 
		  Estrutura_DAO dao_ListagemIntegral = new Estrutura_DAO();
		  
		  List<modelo_tabela_cadastramento_produto> listagem = dao_ListagemIntegral.listagem_integral();
		  
		  for(modelo_tabela_cadastramento_produto modelo : listagem) {
			  
			   System.out.println(modelo.getNome());
		  }
	 }
	 
	 // Metodo ( Buscar Unitaria )
	 
	 
	 @Test
	 public void Exe_unica () {
		 
		  Estrutura_DAO dao_unico = new Estrutura_DAO();
		  
		  try {
			modelo_tabela_cadastramento_produto modelo = dao_unico.listagem_unica(2L);
	
			 System.out.println(modelo.getNome());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 }
	 
	 //Metodo  Atualizacao 
	 
	 @Test
	 public void Exe_Atualizar() {
		 
		  Estrutura_DAO  atualizar = new Estrutura_DAO();
		try {  
		  
			  modelo_tabela_cadastramento_produto modelo_atualizar =  atualizar.listagem_unica(0L);
			  modelo_atualizar.setNome("Corante Xadrez Preto");
			
			 atualizar.atualizacao(modelo_atualizar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
	 
	 // Metodo Delete
	 
	 @Test
	 public void Exe_Deletar() {
		 
		    Estrutura_DAO dao_deletar = new Estrutura_DAO();
		    
		    dao_deletar.deletar(0L);
	 }
}
