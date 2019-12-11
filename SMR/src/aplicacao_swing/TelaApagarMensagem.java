
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
import modelo.Mensagem;
import modelo.Produto;

public class TelaApagarMensagem extends JFrame {
	private JPanel contentPane;
	private JLabel lblNome;
	private JTextField idMsg;
	private JButton btnApagar;
	private DefaultListModel<String> model = new DefaultListModel<String>();	
	private JLabel lblmsg;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaApagarMensagem window = new TelaApagarMensagem();
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
	public TelaApagarMensagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Apagar Produto");
		setBounds(100, 100, 345, 175);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		lblNome = new JLabel("ID da Mensagem");
		lblNome.setBounds(12, 28, 143, 19);
		contentPane.add(this.lblNome);
		idMsg = new JTextField();
		idMsg.setBounds(143, 26, 170, 21);
		contentPane.add(this.idMsg);
		idMsg.setColumns(10);
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					int idMsgText = Integer.parseInt(idMsg.getText());
					Mensagem mensagem = Fachada.apagarMensagem(idMsgText);
					lblmsg.setText("Produto excluido com sucesso "+mensagem.getMid());

				} catch (Exception e) {
					lblmsg.setText(e.getMessage());
				}
			}
		});
		btnApagar.setBounds(19, 71, 136, 23);
		contentPane.add(this.btnApagar);
		lblmsg = new JLabel("Mensagem do usuario");
		lblmsg.setBounds(19, 120, 294, 14);
		contentPane.add(this.lblmsg);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idMsg.setText("");
				idMsg.requestFocus();
			}
		});
		btnLimpar.setBounds(172, 71, 141, 23);
		contentPane.add(this.btnLimpar);

	}
}
