package aplicacao_swing;

import fachada.Fachada;
import modelo.Pessoa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton button;
	private JLabel lblmsg;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JLabel lblSetor;
	private JTextField setorField;
	private JLabel lblFoto;
	private JTextField imagemField;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroAdmin() {
		setTitle("Cadastrar Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nomeField = new JTextField();
		nomeField.setBounds(72, 2, 273, 23);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(72, 37, 211, 23);
		contentPane.add(passwordField);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(13, 8, 46, 14);
		contentPane.add(lblNome);

		lblPreco = new JLabel("Senha");
		lblPreco.setBounds(10, 40, 46, 14);
		contentPane.add(lblPreco);

		lblmsg = new JLabel("");
		lblmsg.setBounds(106, 205, 273, 14);
		contentPane.add(lblmsg);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(13, 80, 46, 14);
		contentPane.add(lblEmail);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(72, 76, 273, 23);
		contentPane.add(emailField);

		button = new JButton("Cadastrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(nomeField.getText().isEmpty() )
						lblmsg.setText("campo vazio");
					else {
						String nome = nomeField.getText();
						String senha = new String( passwordField.getPassword());
						String email = emailField.getText();
						String setor = setorField.getText();
						ImageIcon imagem = new ImageIcon(getClass().getResource(imagemField.getText()));

						Pessoa usuario = Fachada.cadastrarAdministrador(nome, senha, email, imagem, setor);
						lblmsg.setText("cadastrou: "+usuario.getEmail());
						nomeField.setText("");
						passwordField.setText("");
						nomeField.requestFocus();
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		button.setBounds(382, 102, 115, 23);
		contentPane.add(button);
		
		lblSetor = new JLabel("Setor");
		lblSetor.setBounds(13, 126, 46, 14);
		contentPane.add(lblSetor);
		
		setorField = new JTextField();
		setorField.setColumns(10);
		setorField.setBounds(72, 122, 273, 23);
		contentPane.add(setorField);
		
		lblFoto = new JLabel("Foto");
		lblFoto.setBounds(13, 164, 46, 14);
		contentPane.add(lblFoto);
		
		imagemField = new JTextField();
		imagemField.setColumns(10);
		imagemField.setBounds(72, 160, 273, 23);
		contentPane.add(imagemField);

	}
}
