
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

public class TelaProdutoPrateleira extends JFrame {
	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblNome;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnInserir;
	private DefaultListModel<String> model = new DefaultListModel<String>();	
	private JLabel lblmsg;
	private JButton btnLimpar;
	private JButton button;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaProdutoPrateleira window = new TelaProdutoPrateleira();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaProdutoPrateleira() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Inserir Produto na Prateleira");
		setBounds(100, 100, 273, 229);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblId = new JLabel("Id prateleira");
		lblId.setBounds(19, 56, 102, 14);
		contentPane.add(this.lblId);
		lblNome = new JLabel("Nome do Produto");
		lblNome.setBounds(19, 28, 102, 14);
		contentPane.add(this.lblNome);
		textField = new JTextField();
		textField.setBounds(124, 25, 86, 20);
		contentPane.add(this.textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(124, 53, 40, 20);
		contentPane.add(this.textField_1);
		textField_1.setColumns(10);
		btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textField.getText();
					int id = Integer.parseInt(textField_1.getText());
					
					Fachada.inserirProdutoPrateleira(id, nome);
					
					lblmsg.setText("produto inserido ");
				} catch (NumberFormatException e) {
					lblmsg.setText("campo id deve ser numerico");
				} catch (Exception e) {
					lblmsg.setText(e.getMessage());
				}
			}
		});
		btnInserir.setBounds(19, 101, 102, 23);
		contentPane.add(this.btnInserir);
		lblmsg = new JLabel("");
		lblmsg.setBounds(19, 164, 294, 14);
		contentPane.add(this.lblmsg);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField.requestFocus();
			}
		});
		btnLimpar.setBounds(81, 130, 102, 23);
		contentPane.add(this.btnLimpar);
		
		button = new JButton("Remover");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = textField.getText();	
					
					Fachada.removerProdutoPrateleira(nome);
					
					lblmsg.setText("produto removido ");
				} catch (Exception e1) {
					lblmsg.setText(e1.getMessage());
				}
			}
		});
		button.setBounds(127, 101, 102, 23);
		contentPane.add(button);

	}
}
