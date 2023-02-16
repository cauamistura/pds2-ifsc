package vision;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.DAOPessoa;
import model.MPessoa;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VCADPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField edCPF;
	private JTextField edNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCADPessoa frame = new VCADPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VCADPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		edCPF = new JTextField();
		edCPF.setBounds(110, 42, 116, 20);
		contentPane.add(edCPF);
		edCPF.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(25, 14, 46, 14);
		contentPane.add(lbNome);
		
		JLabel lbCPF = new JLabel("Cpf:");
		lbCPF.setBounds(25, 45, 46, 14);
		contentPane.add(lbCPF);
		
		edNome = new JTextField();
		edNome.setColumns(10);
		edNome.setBounds(110, 11, 116, 20);
		contentPane.add(edNome);
		
		JButton btCadastrar = new JButton("CADASTRAR");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(edCPF.getText().isEmpty()) && !(edNome.getText().isEmpty())) {
					DAOPessoa FDAOPessoa   = new DAOPessoa();
					MPessoa	  FModelPessoa = new MPessoa();
					
//					FModelPessoa.setFCpf(edCPF.get);
//					MPessoa.
//					
//					FDAOPessoa.inserir(MPessoa);
				}
			}
		});
		btCadastrar.setBounds(72, 73, 104, 23);
		contentPane.add(btCadastrar);
	}
}
