package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/


import java.util.ArrayList;

import fachada.Fachada;
import modelo.Prateleira;
import modelo.Produto;
import modelo.Pessoa;

public class TesteConsole {
	public TesteConsole() {
	}

	public void cadastrar(){
		try {	
			Produto p;
			Prateleira pt;
			Pessoa usu;
			usu = Fachada.cadastrarUsuario("joao@ifpb", "123");
			usu = Fachada.cadastrarUsuario("maria@ifpb", "123");
			usu = Fachada.login("joao@ifpb", "123");
			p = Fachada.cadastrarProduto("arroz", 3.0);
			p = Fachada.cadastrarProduto("feijao", 5.0);
			p = Fachada.cadastrarProduto("leite", 2.0);
			p = Fachada.cadastrarProduto("carne", 30.0);
			p = Fachada.cadastrarProduto("oleo", 10.0);
			usu = Fachada.logoff("joao@ifpb", "123");
			
			usu = Fachada.login("maria@ifpb", "123");
			pt = Fachada.cadastrarPrateleira(200);
			pt = Fachada.cadastrarPrateleira(300);
			pt = Fachada.cadastrarPrateleira(400);	
			usu = Fachada.logoff("maria@ifpb", "123");
			
			System.out.println("cadastro concluido");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}


	public void atualizar(){
		try{
			Pessoa usu;
			usu = Fachada.login("maria@ifpb", "123");
			Fachada.inserirProdutoPrateleira(1, "arroz");
			Fachada.inserirProdutoPrateleira(1, "feijao");
			Fachada.inserirProdutoPrateleira(2, "leite");	
			Fachada.removerProdutoPrateleira("leite");
			usu = Fachada.logoff("maria@ifpb", "123");
			System.out.println("atualizacao concluido");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}

	public  void excluir(){
		try {
			Pessoa usu;
			usu = Fachada.login("maria@ifpb", "123");
			Fachada.apagarProduto("arroz"); 
			usu = Fachada.logoff("maria@ifpb", "123");
			System.out.println("exclusao concluido");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
		//-----------------------------	
	}

	public void listar(){
		String texto;
		ArrayList<Produto> lista1 = Fachada.listarProdutos();
		texto = "\nListagem de produtos: \n";
		if (lista1.isEmpty())
			texto += "não tem produto cadastrado\n";
		else 	
			for(Produto p: lista1) 
				texto +=  p + "\n"; 
		System.out.println(texto);


		ArrayList<Prateleira> lista2 = Fachada.listarPrateleiras();
		texto = "Listagem de prateleiras: \n";
		if (lista2.isEmpty())
			texto += "não tem prateleira cadastrada\n";
		else 
			for(Prateleira p: lista2) 
				texto +=  p + "\n"; 
		System.out.println(texto);
	}

	public void relatorio(){
		ArrayList<Prateleira> lista = Fachada.consultarPrateleirasVazias();
		String texto = "Prateleiras vazias: \n";
		if (lista.isEmpty())
			texto += "não tem prateleira vazia\n";
		else 	
			for(Prateleira p: lista) 
				texto +=  "id="+ p.getId() + "\n"; 					
		System.out.println(texto);



		ArrayList<Prateleira> lista2 = Fachada.consultarPrateleiras3Produtos();
		texto = "Prateleiras com 3 produtos: \n";
		if (lista2.isEmpty())
			texto += "não tem prateleira\n";
		else 	
			for(Prateleira p: lista2) 
				texto +=  "id="+ p.getId() + "\n"; 					
		System.out.println(texto);



		ArrayList<Produto> produtos = Fachada.consultarProdutosSemPrateleira();
		System.out.println("Listagem de produtos sem prateleira");
		for(Produto p: produtos)
			System.out.println(p.getNome());
	}


	public void testarExcecoes() {
		Pessoa usu;

		try {
			usu = Fachada.login("joao@ifpb", "123");
			Produto p;
			p = Fachada.cadastrarProduto("ovo", 10.0); //exceção
			p = Fachada.cadastrarProduto("ovo", 10.0); //exceção
			System.out.println("teste cadastrar produto falhou");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
		try {
			Produto p;
			p = Fachada.cadastrarProduto("banana", 1.0);
			Fachada.inserirProdutoPrateleira(2, "banana");	
			Fachada.inserirProdutoPrateleira(2, "banana");	//exceção
			System.out.println("teste inserir produto falhou");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
		try {
			Produto p;
			p = Fachada.cadastrarProduto("cerveja", 5.0); 
			Fachada.inserirProdutoPrateleira(2, "cerveja");	
			Fachada.removerProdutoPrateleira("cerveja");	
			Fachada.removerProdutoPrateleira("cerveja");	//exceção
			System.out.println("teste remover produto falhou");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
		try {
			Produto p;
			p = Fachada.cadastrarProduto("guarana", 5.0); 
			Fachada.apagarProduto("guarana");	
			Fachada.apagarProduto("guarana");	//exceção
			System.out.println("teste apagar produto falhou");
		}catch (Exception e) {
			System.out.println("==>"+ e.getMessage());
		}
	}
	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		TesteConsole teste = new TesteConsole();
		teste.cadastrar();
		teste.atualizar();
		teste.excluir();
		teste.listar();
		//teste.relatorio();
		//teste.testarExcecoes();
	}

}
