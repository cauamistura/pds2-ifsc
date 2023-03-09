package Questao09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Questao08.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Q09 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField edCPF;
	private JTextField edNome;
	private JTextField edIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q09 frame = new Q09();
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
	public Q09() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		edCPF = new JTextField();
		edCPF.setBounds(174, 10, 86, 20);
		contentPane.add(edCPF);
		edCPF.setColumns(10);

		edNome = new JTextField();
		edNome.setColumns(10);
		edNome.setBounds(174, 40, 86, 20);
		contentPane.add(edNome);

		edIdade = new JTextField();
		edIdade.setColumns(10);
		edIdade.setBounds(174, 73, 86, 20);
		contentPane.add(edIdade);

		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(118, 13, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(118, 43, 46, 14);
		contentPane.add(lblNome);

		JLabel lblNewLabel_1_1 = new JLabel("Idade:");
		lblNewLabel_1_1.setBounds(118, 76, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		JButton btn = new JButton("Cadastrar");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexao FConexao = new Conexao();
				// Istacia coeexão
				FConexao = Conexao.getInstacia();
				// Connection
				Connection c = Conexao.conectar();

				try {
					String wQuery = "INSERT INTO `dbpessoa`.`tpessoa` (`BDCPF`,`BDNOME`,`BDIDADE`) VALUES (?,?,?);";
					PreparedStatement  stm = c.prepareStatement(wQuery);
					
					stm.setInt	 (1,Integer.valueOf(edCPF.getText()));
					stm.setString(2,edNome.getText());
					stm.setInt   (3,Integer.valueOf(edIdade.getText()));
					
					stm.execute();
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				FConexao.fecharConnection();
			}
		});
		btn.setBounds(143, 104, 89, 23);
		contentPane.add(btn);
	}
}
