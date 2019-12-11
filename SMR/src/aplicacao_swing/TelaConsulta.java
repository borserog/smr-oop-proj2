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
import modelo.Mensagem;
import modelo.Pessoa;
import modelo.Prateleira;
import modelo.Produto;

public class TelaConsulta extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnConsulta_1;
	private JButton btnConsulta_2;

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

		btnConsulta_1 = new JButton("Relatório 1");
		btnConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String texto;
					ArrayList<Pessoa> lista1 = Fachada.relatorio1();
					texto = "Listagem de prateleiras vazias: \n";
					if (lista1.isEmpty())
						texto += "não existe";
					else 	
						for(Pessoa p: lista1)
							texto +=  p + "\n"; 

					textArea.setText(texto);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnConsulta_1.setBounds(414, 81, 271, 23);
		contentPane.add(btnConsulta_1);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 11, 378, 236);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		btnConsulta_2 = new JButton("Relatório 2");
		btnConsulta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto;
				ArrayList<Mensagem> lista1 = null;
				try {
					lista1 = Fachada.relatorio2();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				texto = "Listagem de produtos sem prateleira: \n";
				if (lista1.isEmpty())
					texto += "não existe\n";
				else 	
					for(Mensagem m: lista1)
						texto +=  m + "\n";

				textArea.setText(texto);
			}
		});
		btnConsulta_2.setBounds(414, 133, 271, 23);
		contentPane.add(btnConsulta_2);
	}
}
