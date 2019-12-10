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
import modelo.Administrador;
import modelo.Pessoa;
import repositorio.Repositorio;
import javax.swing.ImageIcon;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();
	private static Pessoa logado;
	private static int idmensagem=0;	//autoincremento

	public static Pessoa login(String email, String senha) throws  Exception {
		if(logado != null) {
			throw new Exception("Um usuario já está logado: " + logado.getEmail());
		}
			
		Pessoa usuario = repositorio.localizarUsuario(email,senha);
		if( usuario == null ) {
			throw new Exception("Email ou senha inválidos");
		}
			
		logado = usuario;
		return usuario;
	}
	public static void logoff(String email, String senha) throws  Exception {
		if( logado == null ) {
			throw new Exception("Nenhum usuario está logado no momento");
		}
				
		Pessoa usuario = repositorio.localizarUsuario(email,senha);
		if( usuario == null ) {
			throw new Exception("Email ou senha inválidos");
		}
			
		if( usuario != logado) {
			throw new Exception("Este não é o usuário logado");
		}	
		logado = null; 
	}
	public static Pessoa getLogado() {
		return logado;
	}
	public static Pessoa cadastrarUsuario(
			String email, 
			String senha, 
			String nome, 
			ImageIcon imagem) 
			throws  Exception{
		
		Pessoa usuario = repositorio.localizarUsuario(email,senha);
		if ( usuario != null ) {
			throw new Exception("Usuário " + email + " já cadastrado");
		}
		
		usuario = new Pessoa(email, senha, nome, imagem);
		
		repositorio.adicionarUsuario(usuario);
		
		return usuario;
	}
	public static Pessoa cadastrarAdministrador(
			String email, 
			String senha, 
			String nome, 
			ImageIcon imagem,
			String setor) 
			throws  Exception{
		
		Pessoa admin = repositorio.localizarUsuario(email,senha);
		if ( admin != null ) {
			throw new Exception("Usuário " + email + " já cadastrado");
		}
		
		admin = new Administrador(email, senha, nome, imagem, setor);
		
		repositorio.adicionarUsuario(admin);
		
		return admin;
	}
	
	public static ArrayList<Pessoa> listarPessoas(String termoBusca) {
		ArrayList<Pessoa> retorno;
		for (Pessoa pessoa :: repositorio.getPessoas()) {
			if (pessoa.getNome().equals(termoBusca)) {
				retorno.add(pessoa);
			}
		}
		throws Exception {
			if (retorno.size() == 0)
				throw new Exception("Não encontramos usuário com o seguinte termo de busca: "+termoBusca);
		}
		return retorno;
	}
	
	public static ArrayList<Pessoa> listarPessoas() {
		return repositorio.getPessoas();
	}	
	
	public static Mensagem enviarMensagem (String emailDestinatário, String textoMensagem) {
		throws Exception {
			if (logado == null)
				throw new Exception("Você precisa estar logado para enviar mensagem");			
		}
		
		idMensagem++;
		Mensagem msg = new Mensagem(idMensagem, logado.getEmail(), emailDestinatário, textoMensagem);
		repositorio.adicionarMensagem(msg);
		return msg;
	}
	
	public static ArrayList<Mensagem> listarCaixaEntrada() {
		throws Exception {
			if (logado == null)
				throw new Exception("Você precisa estar logado para listar mensagens");			
		}
		
		return logado.getMensagensEntrada();
	}
	
	public static ArrayList<Mensagem> listarCaixaSaida() {
		throws Exception {
			if (logado == null)
				throw new Exception("Você precisa estar logado para listar mensagens");			
		}
		
		return logado.getMensagensSaida();
	}
	
	
	public static Mensagem apagarMensagem(int idMensagem) {
		Mensagem remover = repositorio.localizarMensagem(idMensagem);		
		throws Exception {
			if (remover == null || !remover.getEmitente().getNome().equals(logado.getNome()) && !remover.getDestinatario().getNome().equals(logado.getNome()))
				throw new Exception("Nenhuma mensagem encontrada com esse id");			
		}
		
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
