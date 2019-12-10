package modelo;

import java.util.ArrayList;

import repositorio.Repositorio;

/** IS-A Pessoa */
public class Administrador extends Pessoa {
	private boolean isAdmin = true;
	
	public Administrador(String email, String senha, String nome) {
		super(email, senha, nome);
	}
	
	public ArrayList<Mensagem> getMensagensSistema() {
		return Repositorio.getMensagens();
	}
}
