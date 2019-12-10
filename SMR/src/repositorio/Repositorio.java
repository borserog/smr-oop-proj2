
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
package repositorio;
import java.util.ArrayList;
import java.util.TreeMap;

import modelo.Pessoa;
import modelo.Mensagem;

public class Repositorio {
	private static TreeMap<String,Pessoa> pessoas = new TreeMap<>();
	private static ArrayList<Mensagem> mensagens = new ArrayList<>();
	
	public void adicionarUsuario(Pessoa usuario){
		pessoas.put(usuario.getEmail()+usuario.getSenha(),  usuario); //chave concatenada
	}
	public void removerUsuario(Pessoa usuario){
		pessoas.remove(usuario.getEmail()+usuario.getSenha());
	}
	public Pessoa localizarUsuario(String email, String senha){
		return pessoas.get(email+senha);
	}
	
		
	public void adicionarMensagem(Mensagem mensagem){
		mensagens.add(mensagem);
	}
	public void removerMensagem(Mensagem mensagem){
		mensagens.remove(mensagem);
	}
	public Mensagem localizarMensagem(int mId){
		for(Mensagem mensagem : mensagens){
			if(mensagem.getMid() == mId) {
				return mensagem;
			}
		}
		return null;
	}


	public static ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}
	public static ArrayList<Pessoa> getPessoas() {
		return  
				new ArrayList<Pessoa> (pessoas.values());	//TreeMap --> ArrayList
	}
	public int getTotalMensagens(){
		return mensagens.size();
	}
}

