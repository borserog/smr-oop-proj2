package modelo;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

public class Produto {
		private String nome;
		private double preco;
		private Prateleira prateleira;
		
		public Produto(String nome,  double preco) {
			super();
			this.nome = nome;
			this.preco = preco;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getPreco() {
			return preco;
		}
		public void setPreco(double preco) {
			this.preco = preco;
		}		
		
		//---------------------------------------
		public Prateleira getPrateleira() {
			return prateleira;
		}
		public void setPrateleira(Prateleira prateleira) {
			this.prateleira = prateleira;
		}
		@Override
		public String toString() {
			return "Produto [" + (nome != null ? "nome=" + nome + ", " : "")
					+ "preco=" + preco + ", "
					+ (prateleira != null ? "prateleira=" + prateleira.getId() : "sem prateleira")
					+ "]";
		}
		
	
}
