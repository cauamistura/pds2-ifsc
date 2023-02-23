package vision;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.DAOPessoa;
import model.MPessoa;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VPessoaCAD extends JFrame {

	private JPanel contentPane;
	private JTextField edCPF;
	private JTextField edNome;
	private DAOPessoa FDAOPessoa = new DAOPessoa();
	private MPessoa   FMPessoa    = new MPessoa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPessoaCAD frame = new VPessoaCAD();
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
	public VPessoaCAD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		edCPF = new JTextField();
		edCPF.setBounds(75, 33, 86, 20);
		contentPane.add(edCPF);
		edCPF.setColumns(10);
		
		edNome = new JTextField();
		edNome.setColumns(10);
		edNome.setBounds(75, 64, 86, 20);
		contentPane.add(edNome);
		
		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setBounds(19, 36, 46, 14);
		contentPane.add(lbCPF);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(19, 67, 46, 14);
		contentPane.add(lbNome);
		
		JLabel lbStatus = new JLabel("<AGUARDANDO>");
		lbStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatus.setBounds(19, 110, 142, 14);
		contentPane.add(lbStatus);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMPessoa.setFCPF (Integer.valueOf(edCPF.getText()));
				FMPessoa.setFNome(edNome.getText());
				
				FDAOPessoa.inserir(FMPessoa);
				lbStatus.setText("Inserido com sucesso");
			}
		});
		btnInserir.setBounds(195, 32, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<MPessoa> TListPessoa = new ArrayList<>();
				TListPessoa = FDAOPessoa.ListPessoa();
				for (MPessoa l : TListPessoa) {
					System.out.println("Cpf: " + l.getFCPF() + " Nome: " + l.getFNome());
				}
				lbStatus.setText("Listado com sucesso no terminal");
			}
		});
		btnListar.setBounds(195, 63, 89, 23);
		contentPane.add(btnListar);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMPessoa.setFCPF (Integer.valueOf(edCPF.getText()));
				FMPessoa.setFNome(edNome.getText());
				
				FDAOPessoa.alterar(FMPessoa);
				lbStatus.setText("Editado com sucesso");
			}
		});
		btnUpdate.setBounds(195, 97, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FMPessoa.setFCPF (Integer.valueOf(edCPF.getText()));
				FMPessoa.setFNome(edNome.getText());
				
				FDAOPessoa.deletar(FMPessoa);
				lbStatus.setText("Deletado com sucesso");
			}
		});
		btnExcluir.setBounds(195, 131, 89, 23);
		contentPane.add(btnExcluir);
	}
}
