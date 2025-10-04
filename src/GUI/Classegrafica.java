package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Classegrafica {

	private JFrame frmAgenda;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtemail;
	private JTextField txtcpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classegrafica window = new Classegrafica();
					window.frmAgenda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Classegrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgenda = new JFrame();
		frmAgenda.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 10));
		frmAgenda.setTitle("Agenda");
		frmAgenda.setBounds(100, 100, 930, 470);
		frmAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenda.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(53, 86, 103, 27);
		frmAgenda.getContentPane().add(lblNewLabel);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelefone.setBounds(53, 137, 103, 27);
		frmAgenda.getContentPane().add(lblTelefone);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEndereo.setBounds(53, 188, 103, 27);
		frmAgenda.getContentPane().add(lblEndereo);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(53, 241, 103, 27);
		frmAgenda.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(53, 293, 103, 27);
		frmAgenda.getContentPane().add(lblNewLabel_4);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(186, 93, 243, 18);
		frmAgenda.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(186, 144, 128, 18);
		frmAgenda.getContentPane().add(txtTelefone);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(186, 195, 243, 18);
		frmAgenda.getContentPane().add(txtEndereco);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtemail.setColumns(10);
		txtemail.setBounds(186, 248, 243, 18);
		frmAgenda.getContentPane().add(txtemail);
		
		txtcpf = new JTextField();
		txtcpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcpf.setColumns(10);
		txtcpf.setBounds(186, 300, 243, 18);
		frmAgenda.getContentPane().add(txtcpf);
	}
}
