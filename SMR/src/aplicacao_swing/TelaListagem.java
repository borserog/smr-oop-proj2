package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import modelo.Pessoa;

public class TelaListagem extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton button1;
	private JButton button2;
	private JButton button;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaListagem frame = new TelaListagem();
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
		setBounds(100, 100, 550, 242);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		button1 = new JButton("Listar Prateleira");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					ArrayList<Prateleira> lista = Fachada.listarPrateleiras();
					
					String texto = "Listagem de prateleiras: \n";
					if (lista.isEmpty())
						texto += "não tem prateleira cadastrada\n";
					else 
						for(Prateleira p: lista) 
							texto +=  p + "\n"; 

					textArea.setText(texto);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		button1.setBounds(63, 180, 115, 23);
		contentPane.add(button1);
		
		textArea = new JTextArea();		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 510, 140);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		button2 = new JButton("Listar Produto");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String texto;
					ArrayList<Produto> lista = Fachada.listarProdutos();
					
					texto = "Listagem de produtos: \n";
					if (lista.isEmpty())
						texto += "não tem produto cadastrado\n";
					else 	
						for(Produto p: lista) 
							texto +=  p + "\n"; 

					textArea.setText(texto);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		button2.setBounds(220, 180, 115, 23);
		contentPane.add(button2);
		
		button = new JButton("Listar Usuario");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto;
				ArrayList<Pessoa> lista = Fachada.listarUsuarios();
				
				texto = "Listagem de usuarios: \n";
				if (lista.isEmpty())
					texto += "não tem usuario cadastrado\n";
				else 	
					for(Pessoa p: lista) 
						texto +=  p + "\n"; 

				textArea.setText(texto);
			}
		});
		button.setBounds(364, 180, 115, 23);
		contentPane.add(button);
	}
}
