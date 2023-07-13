package modelo_tabela_cadastramentoproduto;

public class modelo_tabela_cadastramento_produto {

	
	  private long id;
	  private String nome;
	  private String codigo;
	  private String preco;
	  
	  
	  
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "modelo_tabela_cadastramento_produto [id=" + id + ", nome=" + nome + ", codigo=" + codigo + ", preco="
				+ preco + "]";
	}
	  
	 
	
}
