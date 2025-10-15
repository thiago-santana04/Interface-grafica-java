package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Classegrafica {

	private JFrame frmAgenda;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtCpf;
	
	private static ArrayList <Contato> agenda = new ArrayList<Contato>();

	//Indica a posição do contato visível na interface
	private static int posicao = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				lerFicheiro();
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

	//ler do ficheiro de dados
	private static void lerFicheiro() {
		ObjectInputStream leituraFicheiro;
		Contato c;
		try {
			leituraFicheiro = new ObjectInputStream(new FileInputStream("agenda.dat"));
			do {
				c = (Contato) leituraFicheiro.readObject();
				agenda.add(c);
			} while (c != null);
		}catch (IOException exc) {}
		catch (ClassNotFoundException el) {} 
	}
	
	//guardar no ficheiro
	private static void escreverFicheiro() {
		ObjectOutputStream escritaFicheiro;
		try {
			escritaFicheiro = new ObjectOutputStream(new FileOutputStream("agenda.dat"));
			for(int i=0; i<agenda.size(); i++)
				escritaFicheiro.writeObject(agenda.get(i));
			escritaFicheiro.close();
		} catch (IOException exc) {
			System.out.println("Erro na escrita de dados!");
		}
	}
	
	//Mostrar contatos
	private void mostrarContato() {
		Contato c = agenda.get(posicao);
		txtNome.setText(c.getNome());
		txtTelefone.setText(c.getTelefone());
		txtEndereco.setText(c.getEndereco());
		txtEmail.setText(c.getEmail());
		txtCpf.setText(c.getCpf());
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgenda = new JFrame();
		frmAgenda.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 16));
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
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(186, 248, 243, 18);
		frmAgenda.getContentPane().add(txtEmail);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCpf.setColumns(10);
		txtCpf.setBounds(186, 300, 243, 18);
		frmAgenda.getContentPane().add(txtCpf);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtTelefone.setText("");
				txtEndereco.setText("");
				txtEmail.setText("");
				txtCpf.setText("");
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNovo.setBounds(654, 92, 95, 39);
		frmAgenda.getContentPane().add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String telefone = txtTelefone.getText();
				String endereco = txtEndereco.getText(); 
				String email = txtEmail.getText();
				String cpf = txtCpf.getText();
				Contato c = new Contato(nome, telefone, endereco, email, cpf);
				agenda.add(c);
			}
		});
		
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.setBounds(654, 163, 95, 39);
		frmAgenda.getContentPane().add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escreverFicheiro();
				System.exit(0);			}
		});
		
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(654, 229, 95, 39);
		frmAgenda.getContentPane().add(btnSair);
		
		JButton btnPrimeiro = new JButton("<<");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posicao = 0;
				mostrarContato();
			}
		});
		
		btnPrimeiro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPrimeiro.setBounds(113, 358, 95, 39);
		frmAgenda.getContentPane().add(btnPrimeiro);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posicao--;
				mostrarContato();
			}
		});
		
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAnterior.setBounds(240, 358, 95, 39);
		frmAgenda.getContentPane().add(btnAnterior);
		
		JButton btnProximo = new JButton(">");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posicao++;
				mostrarContato();
			}
		});
		
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProximo.setBounds(373, 358, 95, 39);
		frmAgenda.getContentPane().add(btnProximo);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posicao = agenda.size() - 1;
				mostrarContato();
			}
		});
		
		btnUltimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUltimo.setBounds(506, 358, 95, 39);
		frmAgenda.getContentPane().add(btnUltimo);
		
		JLabel lblNewLabel_1 = new JLabel("Agenda de contatos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(358, 24, 243, 32);
		frmAgenda.getContentPane().add(lblNewLabel_1);
	}
}
