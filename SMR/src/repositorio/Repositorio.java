
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/
package repositorio;
import java.util.ArrayList;
import java.util.TreeMap;

import modelo.Pessoa;
import modelo.Mensagem;

public class Repositorio {
	private TreeMap<String,Pessoa> pessoas = new TreeMap<>();
	private ArrayList<Mensagem> mensagens = new ArrayList<>();
	
	public void adicionarUsuario(Pessoa usuario){
		pessoas.put(usuario.getEmail()+usuario.getSenha(),  usuario); //chave concatenada
	}
	public void removerUsuario(Pessoa usuario){
		pessoas.remove(usuario.getEmail()+usuario.getSenha());
	}

	public Pessoa localizarUsuario(String email, String senha){
		return pessoas.get(email+senha);
	}

	public Pessoa localizarUsuario(String email){
		String chave = null;
		for (String p : pessoas.keySet()) {
			if (p.contains(email))
				 chave = p;
				
		}
		return pessoas.get(chave);
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


	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}
	public ArrayList<Pessoa> getPessoas() {
		return  
				new ArrayList<Pessoa> (pessoas.values());	//TreeMap --> ArrayList
	}
	public int getTotalMensagens(){
		return mensagens.size();
	}
}

