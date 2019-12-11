package aplicacao_swing;

import fachada.Fachada;
import modelo.Mensagem;
import modelo.Pessoa;
import sun.text.resources.ar.FormatData_ar_JO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaEspionar extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton button2;
	private JLabel lblBuscaPorPalavra;
	private JTextField palavraChaveField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaListagemSaida frame = new TelaListagemSaida();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaEspionar() {
		
		setTitle("Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 372);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 657, 197);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		button2 = new JButton("Espionar Mensagens");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{

					String texto;
					ArrayList<Mensagem> lista = new ArrayList<Mensagem>();

					if (palavraChaveField.getText().isEmpty())
						lista=Fachada.espionarMensagens();

					else
						lista=Fachada.espionarMensagens(palavraChaveField.getText());
					
					texto = "Listagem da Espionagem: \n";
					if (lista.isEmpty())
						texto += "n�o tem produto cadastrado\n";
					else 	
						for(Mensagem mensagem: lista)
							texto +=  mensagem + "\n";

					textArea.setText(texto);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		button2.setBounds(248, 289, 197, 23);
		contentPane.add(button2);
		
		lblBuscaPorPalavra = new JLabel("Busca por Palavra chave:");
		lblBuscaPorPalavra.setBounds(34, 250, 179, 15);
		contentPane.add(lblBuscaPorPalavra);
		
		palavraChaveField = new JTextField();
		palavraChaveField.setColumns(10);
		palavraChaveField.setBounds(218, 238, 310, 35);
		contentPane.add(palavraChaveField);
	}
}
