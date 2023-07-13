package Estrutura_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integra_cadastramento_produto.integra_cadastramento_produto.Integracao_CadastramentoProduto;
import modelo_tabela_cadastramentoproduto.modelo_tabela_cadastramento_produto;

public class Estrutura_DAO {

	
	   private Connection connection;
	   
	   
	   //Construtor Estrutura _DAO
	   
	   public Estrutura_DAO() {
		
		    connection = Integracao_CadastramentoProduto.getConnection();
	   }
	   
	   // Metodo (-----------------------------INSERT--------------------)
	   public void Insert(modelo_tabela_cadastramento_produto modelo_tabela_cadastramento_produto) {
		   
		     String sql_insert = "insert into CadastramentoProduto (nome,codigo,preco)values (?,?,?)";
		     
		     try {
				PreparedStatement preparacao_insert = connection.prepareStatement(sql_insert);
				
	
				preparacao_insert.setString(1, modelo_tabela_cadastramento_produto.getNome());
				preparacao_insert.setString(2, modelo_tabela_cadastramento_produto.getCodigo());
				preparacao_insert.setString(3, modelo_tabela_cadastramento_produto.getPreco());
				
				preparacao_insert.execute();
				connection.commit();
			} catch (SQLException e) {
				
				try {
					connection.rollback();
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

	   }

	   // Metodo (------------------------Listagem Integral----------------)
	   public List<modelo_tabela_cadastramento_produto> listagem_integral () throws Exception{
		   
		    List<modelo_tabela_cadastramento_produto> lista = new ArrayList<modelo_tabela_cadastramento_produto>();
		    
		    String sql_listagemIntegral = "select * from CadastramentoProduto";
		    
		 
				PreparedStatement  preparacao_listagem_integral  = connection.prepareStatement(sql_listagemIntegral);
				ResultSet resultado = preparacao_listagem_integral.executeQuery();
				
				while(resultado.next()) {
					
					   modelo_tabela_cadastramento_produto modelo_mostra = new modelo_tabela_cadastramento_produto();
					  
					  modelo_mostra.setId(resultado.getLong("id"));
					  modelo_mostra.setNome(resultado.getString("nome"));
					  modelo_mostra.setCodigo(resultado.getString("codigo"));
					  modelo_mostra.setPreco(resultado.getString("preco"));
					  
					  lista.add(modelo_mostra);
				}
		    return lista;
	   }
	   
	   // Metodo (---------------------------Consulta Unitaria--------------)
	   public modelo_tabela_cadastramento_produto listagem_unica (long id ) throws Exception{
		   
		   modelo_tabela_cadastramento_produto retorno = new modelo_tabela_cadastramento_produto();
		    
		    String sql_listagemIntegral = "select * from CadastramentoProduto where id = " + id;
	
				PreparedStatement  preparacao_listagem_integral  = connection.prepareStatement(sql_listagemIntegral);
				ResultSet resultado = preparacao_listagem_integral.executeQuery();
				
				while(resultado.next()) {
					
					
					  
					  retorno.setId(resultado.getLong("id"));
					  retorno.setNome(resultado.getString("nome"));
					  retorno.setCodigo(resultado.getString("codigo"));
					  retorno.setPreco(resultado.getString("preco"));
					  
				
				}
		    return retorno;
	   }
	   
	   
	   // Metodo (----------------------------Atualizacao--------------------------)
	   public void atualizacao (modelo_tabela_cadastramento_produto modelo_tabela_cadastramento_produto) {
		
		   try {
			  String sql_atualizar = "update CadastramentoProduto set nome = ? where id = " + modelo_tabela_cadastramento_produto.getId();
			  
			
				PreparedStatement preparacao_atualizar =  connection.prepareStatement(sql_atualizar);
				
				preparacao_atualizar.setString(1, modelo_tabela_cadastramento_produto.getNome());
				preparacao_atualizar.execute();
				connection.commit();
			} catch (SQLException e) {
				
				try {
					connection.rollback();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	   
	   //Metodo  (--------------------------Deletar-------------------------)
	   public void  deletar (long id ) {
		   
		    String sql_deletar = "delete from CadastramentoProduto where id = " + id;
		    
		    try {
				PreparedStatement preparacao_deletar = connection.prepareStatement(sql_deletar);
				
				preparacao_deletar.execute();
				connection.commit();
				
			} catch (SQLException e) {
			
				  try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		    
	   }

 }
