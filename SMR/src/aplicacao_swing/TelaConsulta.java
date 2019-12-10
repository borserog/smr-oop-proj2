package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Prateleira;
import modelo.Produto;

public class TelaConsulta extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnConsulta_1;
	private JButton btnConsulta_2;
	private JButton btnConsulta_3;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaConsulta frame = new TelaConsulta();
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
	public TelaConsulta() {
		setTitle("Consultar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnConsulta_1 = new JButton("Prateleiras Vazias");
		btnConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String texto;
					ArrayList<Prateleira> lista1 = Fachada.consultarPrateleirasVazias();
					texto = "Listagem de prateleiras vazias: \n";
					if (lista1.isEmpty())
						texto += "não existe";
					else 	
						for(Prateleira p: lista1) 
							texto +=  p + "\n"; 

					textArea.setText(texto);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnConsulta_1.setBounds(414, 13, 271, 23);
		contentPane.add(btnConsulta_1);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 11, 348, 228);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		btnConsulta_2 = new JButton("Produtos sem Prateleira");
		btnConsulta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto;
				ArrayList<Produto> lista1 = Fachada.consultarProdutosSemPrateleira();
				texto = "Listagem de produtos sem prateleira: \n";
				if (lista1.isEmpty())
					texto += "não tem\n";
				else 	
					for(Produto p: lista1) 
						texto +=  p + "\n"; 

				textArea.setText(texto);
			}
		});
		btnConsulta_2.setBounds(414, 47, 271, 23);
		contentPane.add(btnConsulta_2);
		
		btnConsulta_3 = new JButton("Produtos da mesma prateleira do (nome)");
		btnConsulta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("nome do produto");
				textArea.setText("nao implementada");
			}
		});
		btnConsulta_3.setBounds(414, 81, 271, 23);
		contentPane.add(btnConsulta_3);
		
		JButton btnPrateleirasCom = new JButton("Prateleiras com 3 produtos");
		btnPrateleirasCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Prateleira> resultado = Fachada.consultarPrateleiras3Produtos();
				String texto = "Listagem de prateleiras com 3 produtos: \n";
				if (resultado.isEmpty())
					texto += "não existe";
				else 	
					for(Prateleira p: resultado) 
						texto +=  p + "\n"; 

				textArea.setText(texto);
			}
		});
		btnPrateleirasCom.setBounds(414, 146, 271, 23);
		contentPane.add(btnPrateleirasCom);
	}
}
