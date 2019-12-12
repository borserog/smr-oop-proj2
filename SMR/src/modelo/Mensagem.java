package modelo;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Mensagem {
	private int mId;
	private Pessoa emitente;
	private Pessoa destinatario;
	private String texto;
	private String data;
	private int TEXTO_MAX = 200;
	String padrao = "dd/MM/yy hh:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(padrao);
	
	public Mensagem(
			int mId,
			Pessoa emitente, 
			Pessoa destinatario, 
			String texto
		) throws Exception {
		
		this.mId = mId;
		this.emitente = emitente;
		
		this.destinatario = destinatario;
		if( texto.length() > this.TEXTO_MAX || texto == null || texto == "" ) {
			throw new Exception("Texto ultrapassa o limite de caracteres");
		}
		this.texto = texto;
		


		this.data = simpleDateFormat.format(new Date());
	}
	
	// TODO getter methods

	public int getMid() {
		return this.mId;
	}
	
	public Pessoa getEmitente() {
		return this.emitente;
	}
	public void setEmitente(Pessoa novoEmitente) {
		this.emitente = novoEmitente;
	}
	
	public Pessoa getDestinatario() {
		return this.destinatario;
	}
	public void setDestinatario(Pessoa novoDestinatario) {
		this.destinatario = novoDestinatario;
	}
	
	public String getTexto() {
		return this.texto;
	}
	public void setTexto(String novoTexto) {
		this.texto = novoTexto;
	}
	
	
	public String getData() {
		return this.data;
	}
	
	@Override
	public String toString() {
		return "\nMENSAGEM:\n"
				+ "Id: " + this.mId + "\n"
				+ "Enviado por: " + this.emitente.getEmail() + "\n"
				+ "Destinatario: " + this.destinatario.getEmail() + "\n"
				+ "Conteudo: " + this.texto + "\n"
				+ "Data: " + this.data +"\n";
	}
}
