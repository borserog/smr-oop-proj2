package modelo;

import java.util.ArrayList;
import javax.swing.ImageIcon;

import repositorio.Repositorio;

/** IS-A Pessoa */
public class Administrador extends Pessoa {
	String setor;

	public Administrador(String email, String senha, String nome, ImageIcon imagem, String setor) {
		super(email, senha, nome, imagem);
		
		this.setor = setor;

	}

	public Administrador(String email, String senha, String nome, String setor) {
		super(email, senha, nome);

		this.setor = setor;

	}
		
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
}
