package aplicacao_console;

import modelo.*;
import repositorio.*;

public class MeuTeste {

	public static void main(String[] args) {
		
			Repositorio repositorio = new Repositorio();
			Administrador admin = new Administrador("admin@abc.com", "123", "Gerson");
			Pessoa p1 = new Pessoa("gabriel@abc.com", "123", "Gabriel");
			Pessoa p2 = new Pessoa("iasmin@abc.com", "123", "Iasmin");
			Pessoa p3 = new Pessoa("malu@abc.com", "321", "Malu");
			
			repositorio.adicionarUsuario(p1);
			repositorio.adicionarUsuario(p2);
			repositorio.adicionarUsuario(p3);
			
			
			try {
				Mensagem msg = new Mensagem(p1, p2, "Olá coração!");
				p1.addMensagemSaida(msg);
				p2.addMensagemEntrada(msg);
				repositorio.adicionarMensagem(msg);
							
				System.out.println(msg);
				
				Mensagem msg1 = new Mensagem(p1, p2, "Olá bb!");
				p1.addMensagemSaida(msg1);
				p2.addMensagemEntrada(msg1);
				repositorio.adicionarMensagem(msg1);
				System.out.println(msg1);
				
				Mensagem msg2 = new Mensagem(p1, p2, "Olá flor!");
				p1.addMensagemSaida(msg2);
				p2.addMensagemEntrada(msg2);
				repositorio.adicionarMensagem(msg2);
				System.out.println(msg2);
				
				Mensagem msg3 = new Mensagem(p2, p3, "Não fala que ele é corno!");
				p2.addMensagemSaida(msg3);
				p3.addMensagemEntrada(msg3);
				repositorio.adicionarMensagem(msg3);
				System.out.println(msg3);
				
				Mensagem msg4 = new Mensagem(p3, p1, "Ei fera, acho que vc é um corno da mzr.");
				p3.addMensagemSaida(msg4);
				p1.addMensagemEntrada(msg4);
				repositorio.adicionarMensagem(msg4);
				System.out.println(msg4);
				
				
				System.out.println("______________________CAIXAS DE MENSAGENS_______________________________");
				System.out.println();	
				
				System.out.println(p1.getMensagensSaida());
				System.out.println(p2.getMensagensEntrada());
				
				System.out.println("___________________________ADMIN VIEW__________________________");
				System.out.println();	
				
				System.out.println("******** MENSAGENS DO SISTEMA ********");	
				System.out.println(admin.getMensagensSistema());	
				System.out.println();	
				System.out.println("******** TOTAL DE MENSAGENS ********");	
				System.out.println(admin.getEstatisticas());	

			} catch(Exception e) {
				System.out.println(e);
			}
	}
}

