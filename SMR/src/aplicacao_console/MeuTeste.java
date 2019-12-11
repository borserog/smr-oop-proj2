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
				
				System.out.println("______________________CAIXAS DE MENSAGENS_______________________________");
				System.out.println();	
				
				System.out.println("___________________________ENTRADA______________________________________");
				System.out.println(p1.getMensagensEntrada());
				System.out.println("___________________________SAÍDA______________________________________");
				System.out.println(p2.getMensagensSaida());
				
				System.out.println("___________________________ADMIN VIEW__________________________");
				System.out.println();	
				
				System.out.println("******** MENSAGENS DO SISTEMA ********");	
				Fachada.espionarMensagens();
				System.out.println("___________________________________________");
				Fachada.espionarMensagens("corno");
				System.out.println();	
				System.out.println("******** TOTAL DE MENSAGENS ********");	
				System.out.println(Fachada.relatorio1());
				System.out.println("___________________________________________");
				System.out.println(Fachada.relatorio2());

			} catch(Exception e) {
				e.printStackTrace();
			}
	}
}

