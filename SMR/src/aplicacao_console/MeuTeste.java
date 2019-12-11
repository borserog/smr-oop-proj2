package aplicacao_console;

import fachada.Fachada;
import modelo.*;
import repositorio.*;

import javax.swing.*;

public class MeuTeste {
		
	public static void main(String[] args) {
		try {
				
				Pessoa p1 = Fachada.cadastrarUsuario("gabriel@abc.com", "123", "Gabriel");
				Pessoa p2 = Fachada.cadastrarUsuario("iasmin@abc.com", "123", "Iasmin");
				Pessoa p3 = Fachada.cadastrarUsuario("malu@abc.com", "321", "Malu");
				Administrador admin = Fachada.cadastrarAdministrador("admin@abc.com", "123", "Gerson","Inferno");
				
				Fachada.login(admin.getEmail(), admin.getSenha());
				Fachada.enviarMensagem(p1.getEmail(), "Ol� cora��o!");

				Fachada.enviarMensagem(p2.getEmail(), "Ol� bb!");

				Fachada.enviarMensagem(admin.getEmail(), "Ol� flor!");

				Fachada.enviarMensagem(p3.getEmail(), "N�o fala que ele � corno!");
				
				System.out.println("_______________ LISTAGEM PESSOAS _______________\n");
				System.out.println("******** TODAS ********\n");
				System.out.println(Fachada.listarPessoas());

				System.out.println("******** BUSCANDO ********\n");
				System.out.println(Fachada.listarPessoas("Gerson"));

				System.out.println("_______________ CAIXAS_DE_MENSAGENS _______________\n");

				System.out.println("******** ENTRADA ********\n");
				System.out.println(admin.getMensagensEntrada());

				System.out.println("******** SAÍDA ********\n");
				System.out.println(admin.getMensagensSaida());
				
				System.out.println("_______________ ADMIN VIEW _______________\n");

//				System.out.println("******** ESPIANDO MENSAGENS ********\n");
//				Fachada.espionarMensagens();

				System.out.println("******** BUSCA EMAIL POR PALAVRA CHAVE ********\n");
				Fachada.espionarMensagens("cor");
//
//				System.out.println("******** TOTAL DE MENSAGENS ********\n");
//				System.out.println(Fachada.relatorio1());
//				System.out.println("******** PESSOAS QUE NÃO TEM MENSAGEM NA CAIXA DE ENTRADA ********\n");
//				System.out.println(Fachada.relatorio2());

			} catch(Exception e) {
				e.printStackTrace();
			}
	}
}

