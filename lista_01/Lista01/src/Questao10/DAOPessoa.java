package Questao10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import Questao08.Conexao;

public class DAOPessoa {

	public ArrayList<MPessoa> ListPessoa (MPessoa prL) {

		ArrayList<MPessoa> ListaPessoa = new ArrayList<>();
		Conexao FConexao = new Conexao();
		// Istacia coeexão
		FConexao = Conexao.getInstacia();
		// Connection
		Connection c = Conexao.conectar();
		try {
			String wSQL = "SELECT `tpessoa`.`BDCPF`,`tpessoa`.`BDNOME`,`tpessoa`.`BDIDADE` FROM `dbpessoa`.`tpessoa`;";
			Statement stm = c.prepareStatement(wSQL);
			ResultSet rs = stm.executeQuery(wSQL);

			while (rs.next()) {
				MPessoa le = new MPessoa();

				le.setBDCPF(rs.getInt("BDCPF"));
				le.setBDNOME(rs.getString("BDNOME"));
				le.setBDIDADE(rs.getInt("BDIDADE"));

				ListaPessoa.add(le);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		FConexao.fecharConnection();
		return ListaPessoa;
	}

}
