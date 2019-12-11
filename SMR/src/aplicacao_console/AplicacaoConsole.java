package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/


import java.util.ArrayList;
import java.util.Scanner;

import fachada.Fachada;
import modelo.*;

public class AplicacaoConsole {
	private Scanner teclado = new Scanner(System.in);

	public AplicacaoConsole() {
		//pre-cadastro
		try{
			TesteConsole teste = new TesteConsole();
			teste.teste1();
			Pessoa u = Fachada.login("joao@ifpb","123");  //usaremos este usuario
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		processarMenu();
	}

	public  void processarMenu() {
		String entrada;
		int opcao;
		System.out.println("\n\n <-- Iniciando execução do Sistema --> ");
		do {
			exibirMenu();
			try{
				entrada = teclado.nextLine();
				opcao = Integer.parseInt(entrada);
				switch (opcao) {
				case 0:	break;
				case 1:	cadastrarUsuario();						break;
				case 2:	cadastrarAdmin();						break;
				case 3:	login();								break;
				case 4: listarPessoasComBusca();				break;
				case 5: listarPessoasSemBusca();				break;
				case 6: listarCaixaEntrada();				    break;
				case 7: listarCaixaSaida();				        break;
				case 8: apagarMensagem();						break;
				case 9: listarMensagemComBusca();				break;
				case 10: espionarMensagens();					break;
				case 11: relatorio1();							break;
				case 12: relatorio2();							break;
				default: System.out.println("Op��o Invalida !! \n");
				}
			}
			catch(NumberFormatException e)	{
				System.out.println("Digite somente n�mero! \n");
				opcao=-1;
			}
			catch(Exception e)	{
				System.out.println("erro:" + e.getMessage());
				opcao=-1;
			}		
		}while (opcao != 0);
		System.out.println("\n <-- At� Breve -->");
	}

	public void exibirMenu() {
		System.out.println("\n\n| - - - - - - - - -  Menu  - - - - - - - - - - - |");
		System.out.println("|  [0]- Sair                                     |");
		System.out.println("|  [1]- Cadastrar usuário                        |");
		System.out.println("|  [2]- Cadastrar Administrador                  |");
		System.out.println("|  [3]- Login						             |");
		System.out.println("|  [4]- Buscar por Pessoas                       |");
		System.out.println("|  [5]- Listar Pessoas                           |");
		System.out.println("|  [6]- Listar Caixa de Entrada                  |");
		System.out.println("|  [7]- Listar Caixa de Saída                    |");
		System.out.println("|  [8]- Apagar Mensagem                          |");
		System.out.println("|  [9]- Buscar por Mensagem (espionando          |");
		System.out.println("|  [10]- Espionar Mensagens                      |");
		System.out.println("|  [11]- Relatório 1 							 |");
		System.out.println("|  [12]- Relatório 2                      		 |");
		System.out.println("| - - - - - - - - - - - - - - - - - - - - - - - -|");
		System.out.print("  Op��o :");
	}


	//	---------------------------------------	
	public void cadastrarUsuario(){
		//	---------------------------------------			
		Pessoa p;
		String nome;
		String email;
		String senha;

		System.out.println("\n---CADASTRO DE USUARIO---");

		System.out.print("Nome do Usuario(ou ENTER para voltar):");
		nome = teclado.nextLine();
		System.out.print("Email do Usuario(ou ENTER para voltar):");
		email = teclado.nextLine();
		System.out.print("Senha do Usuario(ou ENTER para voltar):");
		senha = teclado.nextLine();

		while (!nome.equals("")) {
			try{
				p = Fachada.cadastrarUsuario(nome, senha, email) ;
				System.out.println("--> cadastrado com sucesso ! --> " + p.getNome() +"\n");
			}
			catch(Exception e){
				System.out.println("-->" + e.getMessage());
			}
			System.out.print("Nome do Produto(ou ENTER para voltar):");
			nome = teclado.nextLine();
			System.out.print("Email do Usuario(ou ENTER para voltar):");
			email = teclado.nextLine();
			System.out.print("Senha do Usuario(ou ENTER para voltar):");
			senha = teclado.nextLine();
		}
	}


	//	---------------------------------------	
	public void cadastrarAdmin(){
		//	---------------------------------------			
		System.out.println("\n---CADASTRO DE PRATELEIRA---");

		Administrador ad;
		String nome;
		String email;
		String senha;
		String setor;

		System.out.print("Nome do Admin (ou ENTER para voltar):");
		nome = teclado.nextLine();
		System.out.print("Email do Admin (ou ENTER para voltar):");
		email = teclado.nextLine();
		System.out.print("Senha do Admin (ou ENTER para voltar):");
		senha = teclado.nextLine();
		System.out.print("Setor do Admin (ou ENTER para voltar):");
		setor = teclado.nextLine();

		while (!nome.equals("")) {
			try{				
				ad = Fachada.cadastrarAdministrador(nome, senha, email, setor) ;
				System.out.println("--> cadastrado com sucesso ! --> " + ad.getNome() +"\n");
			}
			catch(Exception e){
				System.out.println("-->" + e.getMessage());
			}

			System.out.print("Nome do Admin (ou ENTER para voltar):");
			nome = teclado.nextLine();
			System.out.print("Email do Admin (ou ENTER para voltar):");
			email = teclado.nextLine();
			System.out.print("Senha do Admin (ou ENTER para voltar):");
			senha = teclado.nextLine();
			System.out.print("Setor do Admin (ou ENTER para voltar):");
			setor = teclado.nextLine();
		}
	}

	//	---------------------------------------	
	public void login(){
		//	---------------------------------------			
		System.out.println("\n---LOGIN---");
		String nome,email;
		System.out.print("Nome do Usuário:");
		nome = teclado.nextLine();	
		System.out.print("Email do Usuário:");
		email = teclado.nextLine();

		try{	
			Fachada.login(nome, email) ;
			System.out.println("--> Login realizado com sucesso !   \n");
		}
		catch(Exception e){
			System.out.println("-->" + e.getMessage());
		}		
	}

	public void listarPessoasSemBusca(){
		//	---------------------------------------
		System.out.println("\n---------inicio--------");
		String texto;

		try{
			ArrayList<Pessoa> lista1 = Fachada.listarPessoas();

			texto = "Listagem de pessoas: \n";
			for(Pessoa p: lista1)
				texto +=  p + "\n";

			System.out.println(texto);
			System.out.println("-----------fim-----------");
		}
		catch(Exception e){
			System.out.println("-->" + e.getMessage());
		}
	}


	//	---------------------------------------	
	public void listarPessoasComBusca() throws Exception
	//	---------------------------------------	
	{
		System.out.println("\n---------inicio--------");
		String texto;
		System.out.print("Termo de busca:");
		String nome = teclado.nextLine();

		try {
			ArrayList<Pessoa> lista1 = Fachada.listarPessoas(nome);
			texto = "Listagem de pessoas: \n";

			for(Pessoa p: lista1)
				texto +=  p + "\n";

			System.out.println(texto);
			System.out.println("-----------fim-----------");
		} catch (Exception e) {
			System.out.println("-->" + e.getMessage());
		}
	}

	//	---------------------------------------	
	public void listarCaixaEntrada()
	//	---------------------------------------	
	{
		System.out.println("\n---------inicio--------");
		String texto;

		try {
			ArrayList<Mensagem> lista1 = Fachada.listarCaixaEntrada();
			texto = "Listagem de pessoas: \n";

			for(Mensagem p: lista1)
				texto +=  p + "\n";

			System.out.println(texto);
			System.out.println("-----------fim-----------");
		} catch (Exception e) {
			System.out.println("-->" + e.getMessage());
		}
	}
	//	---------------------------------------
	public void listarCaixaSaida()
	//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
		String texto;

		try {
			ArrayList<Mensagem> lista1 = Fachada.listarCaixaSaida();
			texto = "Listagem de pessoas: \n";

			for(Mensagem p: lista1)
				texto +=  p + "\n";

			System.out.println(texto);
			System.out.println("-----------fim-----------");
		} catch (Exception e) {
			System.out.println("-->" + e.getMessage());
		}
	}

	//	---------------------------------------
	public void apagarMensagem(){
		//	---------------------------------------
		System.out.println("\n---LOGIN---");

		System.out.print("idDaMensagem:");
		String idMens = teclado.nextLine();

		try{
			Fachada.apagarMensagem(Integer.parseInt(idMens)) ;
			System.out.println("--> Mensagem excluída com sucesso !   \n");
		}
		catch(Exception e){
			System.out.println("-->" + e.getMessage());
		}
	}


	//	---------------------------------------
	public void listarMensagemComBusca() throws Exception
	//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
		String texto;
		System.out.print("Termo de busca:");
		String nome = teclado.nextLine();

		try {
			ArrayList<Mensagem> lista1 = Fachada.espionarMensagens(nome);
			texto = "Listagem de Mensagens: \n";

			for(Mensagem p: lista1)
				texto +=  p + "\n";

			System.out.println(texto);
			System.out.println("-----------fim-----------");
		} catch (Exception e) {
			System.out.println("-->" + e.getMessage());
		}
	}

	//	---------------------------------------
	public void espionarMensagens()
	//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
		String texto;

		try {
			ArrayList<Mensagem> lista1 = Fachada.espionarMensagens();
			texto = "Listagem de Mensagem: \n";

			for(Mensagem p: lista1)
				texto +=  p + "\n";

			System.out.println(texto);
			System.out.println("-----------fim-----------");
		} catch (Exception e) {
			System.out.println("-->" + e.getMessage());
		}
	}	//	---------------------------------------
	public void relatorio1()
	//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
		String texto;

		try {
			ArrayList<Pessoa> lista1 = Fachada.relatorio1();
			texto = "Listagem de Pessoas: \n";

			for(Pessoa p: lista1)
				texto +=  p + "\n";

			System.out.println(texto);
			System.out.println("-----------fim-----------");
		} catch (Exception e) {
			System.out.println("-->" + e.getMessage());
		}
	}
	//	---------------------------------------
	public void relatorio2()
	//	---------------------------------------
	{
		System.out.println("\n---------inicio--------");
		String texto;

		try {
			ArrayList<Mensagem> lista1 = Fachada.relatorio2();
			texto = "Listagem de Mensagem: \n";

			for(Mensagem p: lista1)
				texto +=  p + "\n";

			System.out.println(texto);
			System.out.println("-----------fim-----------");
		} catch (Exception e) {
			System.out.println("-->" + e.getMessage());
		}
	}

	//  ***********************************************
	public static void main (String[] args)   
	//  ***********************************************
	{
		new AplicacaoConsole();
	}

}
