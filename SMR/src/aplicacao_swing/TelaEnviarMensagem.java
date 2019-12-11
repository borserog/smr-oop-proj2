package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Mensagem;
import modelo.Prateleira;

public class TelaEnviarMensagem extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JLabel lblNome;
	private JButton btnCriar;
	private JLabel lblmsg;
	private JLabel lblTextoMensagem;
	private JTextField textoMsgField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroPrateleira frame = new TelaCadastroPrateleira();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.icon
	 */
	public TelaEnviarMensagem() {
		setTitle("Cadastrar Prateleira");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 419, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		emailField = new JTextField();
		emailField.setBounds(129, 14, 255, 21);
		contentPane.add(emailField);
		emailField.setColumns(10);

		lblNome = new JLabel("Email Dest.");
		lblNome.setBounds(23, 16, 103, 19);
		contentPane.add(lblNome);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					String textoMsg = textoMsgField.getText();
					String email = emailField.getText();
					Mensagem msg = Fachada.enviarMensagem(email, textoMsg);
					
					lblmsg.setText("Mensagem id="+msg.getMid());
					emailField.setText("");
					emailField.requestFocus();
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());

				}
			}
		});
		btnCriar.setBounds(142, 127, 115, 23);
		contentPane.add(btnCriar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(92, 162, 233, 14);
		contentPane.add(lblmsg);

		lblTextoMensagem = new JLabel("Texto Mensagem");
		lblTextoMensagem.setBounds(23, 49, 103, 19);
		contentPane.add(lblTextoMensagem);

		textoMsgField = new JTextField();
		textoMsgField.setColumns(10);
		textoMsgField.setBounds(129, 47, 266, 60);
		contentPane.add(textoMsgField);
	}
}
