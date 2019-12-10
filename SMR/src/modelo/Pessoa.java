package modelo;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Pessoa {
	private String email;
	private String senha;
	private String nome;
	private ImageIcon imagem;
	private ArrayList<Mensagem> caixaEntrada = new ArrayList<Mensagem>();
	private ArrayList<Mensagem> caixaSaida = new ArrayList<Mensagem>();
	 
	public Pessoa(String email, String senha, String nome) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return senha;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addMensagemSaida(Mensagem mensagem) {
		this.caixaSaida.add(mensagem);
	}
	public ArrayList<Mensagem> getMensagensSaida() {
		return this.caixaSaida;
	}
	
	public void addMensagemEntrada(Mensagem mensagem) {
		this.caixaEntrada.add(mensagem);
	}
	public ArrayList<Mensagem> getMensagensEntrada() {
		return this.caixaEntrada;
	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", senha=" + senha + 
				", nome=" + nome + "]";
	}	
}
