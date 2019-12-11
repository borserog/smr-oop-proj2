package aplicacao_swing;

import fachada.Fachada;
import modelo.Mensagem;
import modelo.Pessoa;
import modelo.Prateleira;
import modelo.Produto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaListagem extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton button1;
	private JButton button2;
	private JButton button;
	private JLabel lblBuscaUsurioPor;
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
	public TelaListagem() {
		
		setTitle("Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 727, 354);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		button1 = new JButton("Listar Caixa de Entrada");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					ArrayList<Mensagem> lista = Fachada.listarCaixaEntrada();
					
					String texto = "Listagem da caixa de entrada: \n";
					if (lista.isEmpty())
						texto += "n�o tem prateleira cadastrada\n";
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
		button1.setBounds(34, 208, 205, 23);
		contentPane.add(button1);
		
		textArea = new JTextArea();		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 678, 167);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		button2 = new JButton("Listar Caixa de Saída");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String texto;
					ArrayList<Mensagem> lista = Fachada.listarCaixaSaida();
					
					texto = "Listagem da caixa de saída: \n";
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
		button2.setBounds(260, 208, 197, 23);
		contentPane.add(button2);
		
		button = new JButton("Listar Usuario");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto;
				ArrayList<Pessoa> lista = new ArrayList<Pessoa>();

				if (palavraChaveField.getText().isEmpty())
					lista=Fachada.listarPessoas();

				else {
					try {
						lista=Fachada.listarPessoas(palavraChaveField.getText());
					} catch (Exception erro) {
						JOptionPane.showMessageDialog(null,erro.getMessage());
					}
				}
				
				texto = "Listagem de usuarios: \n";
				if (lista.isEmpty())
					texto += "n�o tem usuario cadastrado\n";
				else 	
					for(Pessoa p: lista) 
						texto +=  p + "\n"; 

				textArea.setText(texto);
			}
		});
		button.setBounds(488, 208, 138, 23);
		contentPane.add(button);
		
		lblBuscaUsurioPor = new JLabel("Busca Usuário por Palavra chave:");
		lblBuscaUsurioPor.setBounds(37, 267, 232, 15);
		contentPane.add(lblBuscaUsurioPor);
		
		palavraChaveField = new JTextField();
		palavraChaveField.setColumns(10);
		palavraChaveField.setBounds(287, 257, 310, 35);
		contentPane.add(palavraChaveField);
	}
}
