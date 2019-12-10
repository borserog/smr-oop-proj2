package modelo;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
import java.util.ArrayList;


public class Prateleira {
	private int id;
	private double tamanho;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	public Prateleira(int id, double t) {
		super();
		this.id = id;
		this.tamanho = t;
	}
	public void adicionar(Produto p){
		produtos.add(p);
		p.setPrateleira(this);		//criar relacionamento bidirecional
	}
	public void remover(Produto p){
		produtos.remove(p);
		p.setPrateleira(null); 		//remover relacionamento bidirecional
	}

	public Produto localizar(String nome){
		for(Produto p : produtos){
			if(p.getNome().equals(nome))
				return p;
		}
		return null;
	}
	

	public int getTotalProdutos(){
		return produtos.size();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPesoMaximo() {
		return tamanho;
	}
	public void setPesoMaximo(double t) {
		this.tamanho = t;
	}
	

	@Override
	public String toString() {
		String texto = "Prateleira [id=" + id + ", tamanho=" + tamanho ;
		texto += ", produtos:";
		if (produtos.isEmpty())
			texto += " vazia";
		else 	
			for(Produto p: produtos) 
				texto += " " + p.getNome() ;

		return texto + "]";
	}


}
	


