/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO - Programação Orientada a Objetos
 * Prof. Fausto Ayres
 *
 */
package fachada;
import java.util.ArrayList;

import modelo.Prateleira;
import modelo.Produto;
import modelo.Pessoa;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	private static Pessoa logado;
	private static int idprateleira=0;	//autoincremento

	public static Pessoa login(String email, String senha) throws  Exception {
		if(logado!=null)
			throw new Exception("ja existe um usuario logado:"+logado.getEmail());
		
		Pessoa usu = repositorio.localizarUsuario(email,senha);
		if(usu==null)
			throw new Exception("email ou senha invalida:");
		logado = usu;
		return usu;
	}
	public static Pessoa logoff(String email, String senha) throws  Exception {
		if(logado==null)
			throw new Exception("nao existe um usuario logado:");
		
		Pessoa usu = repositorio.localizarUsuario(email,senha);
		if(usu==null)
			throw new Exception("email ou senha invalida:");
		if(usu!=logado)
			throw new Exception("este usuario nao esta logado:");
		
		logado = null; 
		return usu;
	}
	public static Pessoa getLogado() {
		return logado;
	}
	public static Pessoa cadastrarUsuario(String email, String senha) 
			throws  Exception{
		Pessoa usu = repositorio.localizarUsuario(email,senha);
		if (usu!=null)
			throw new Exception("cadastrar usuario - ja cadastrado:" + email);
		
		usu = new Pessoa(email,senha);
		repositorio.adicionar(usu);
		return usu;
	}
	
	public static Produto cadastrarProduto(String nome, double preco) 
			throws  Exception{
		
		if(logado==null)
			throw new Exception("operacao invalida - faca o login");
		
		Produto p = repositorio.localizarProduto(nome);
		if (p!=null)
			throw new Exception("cadastrar produto - produto ja cadastrado:" + nome);
		//criar produto e adicionar na repositorio
		p = new Produto(nome,preco);
		repositorio.adicionar(p);
		return p;
	}
	public static Prateleira cadastrarPrateleira(double tam)
			throws  Exception{
		if(logado==null)
			throw new Exception("operacao invalida - faca o login");

		//criar prateleira e adicionar na repositorio
		idprateleira++;
		Prateleira p = new Prateleira(idprateleira, tam);	
		repositorio.adicionar(p);
		return p;
	}
	public static void inserirProdutoPrateleira(int id, String nome) 
			throws  Exception {	
		if(logado==null)
			throw new Exception("operacao invalida - faca o login");

		Prateleira pt = repositorio.localizarPrateleira (id);
		if(pt == null) 
			throw new Exception("inserir produto na prateleira - prateleira nao cadastrada:" + id);

		Produto p = repositorio.localizarProduto(nome);
		if(p == null)
			throw new Exception("inserir produto na prateleira - produto nao cadastrado:" + nome);

		if(p.getPrateleira() != null)
			throw new Exception("inserir produto na prateleira - produto ja tem prateleira:"+p.getPrateleira().getId());

		pt.adicionar(p); 	//relacionar produto e prateleira
	}
	public static void removerProdutoPrateleira(String nome) 
			throws Exception{
		if(logado==null)
			throw new Exception("operacao invalida - faca o login");

		Produto p = repositorio.localizarProduto(nome);
		if(p == null)
			throw new Exception("remover produto da prateleira - produto nao cadastrado:" + nome);

		if(p.getPrateleira() == null)
			throw new Exception("remover produto da prateleira - produto nao tem prateleira:"+nome);

		Prateleira pt = p.getPrateleira();
		pt.remover(p); 	//relacionar produto e prateleira
	}
	public static Produto apagarProduto(String nome) 
			throws Exception {
		if(logado==null)
			throw new Exception("operacao invalida - faca o login");

		Produto prod = repositorio.localizarProduto(nome);
		if (prod==null)
			throw new Exception("apagar produto - produto inexistente:"+nome);

		repositorio.remover(prod);
		
		//remover da prateleira
		Prateleira prat = prod.getPrateleira();
		if(prat!=null) {
			prat.remover(prod);
			prod.setPrateleira(null);
		}
		return prod;
	}

	public static ArrayList<Produto> listarProdutos() {
		return repositorio.getProdutos();
	}
	public static ArrayList<Prateleira> listarPrateleiras() {
		return repositorio.getPrateleiras();
	}
	public static ArrayList<Pessoa> listarUsuarios() {
		return repositorio.getUsuarios();
	}
	
	
	//------Consultas-----------------

	public static ArrayList<Prateleira> consultarPrateleirasVazias(){			
		ArrayList<Prateleira> aux = new  ArrayList<Prateleira>();

		for(Prateleira pt : repositorio.getPrateleiras())
			if(pt.getTotalProdutos()==0)
				aux.add(pt);

		return aux;
	}


	public static ArrayList<Prateleira> consultarPrateleiras3Produtos(){			
		ArrayList<Prateleira> aux = new  ArrayList<Prateleira>();
		for(Prateleira pt : repositorio.getPrateleiras())
			if(pt.getTotalProdutos()==3)
				aux.add(pt);

		return aux;
	}
	public static ArrayList<Produto>  consultarProdutosSemPrateleira(){		
		ArrayList<Produto> aux = new ArrayList<Produto>();
		for(Produto p : repositorio.getProdutos())
			if(p.getPrateleira()==null)
				aux.add(p);

		return aux;
	}

}//class
