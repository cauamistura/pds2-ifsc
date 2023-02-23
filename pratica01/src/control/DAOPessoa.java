package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.*;

public class DAOPessoa {

	private Conexao FConexao;

	private static DAOPessoa FDAOPessoa;

	// INSERT
	public Boolean inserir(MPessoa Mp) {

		// Instacia coenexão
		FConexao = Conexao.getInstacia();
		// Conecta
		Connection c = Conexao.conectar();

		try {
			String WSQL = "INSERT INTO `dbpessoa`.`tpessoa` (`BDCPF`, `BDNOME`) VALUES (?,?);";
			PreparedStatement stm = c.prepareStatement(WSQL);

			stm.setInt(1, Mp.getFCPF());
			stm.setString(2, Mp.getFNome());

			stm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FConexao.fecharConnection();
		return false;
	}

	// UPDATE
	public Boolean alterar(MPessoa Mp) {
		FConexao = Conexao.getInstacia();
		Connection c = Conexao.conectar();
		
		try {
			String wSQL = "UPDATE `dbpessoa`.`tpessoa` SET `BDNOME` = ? WHERE `BDCPF` = ?;";
			PreparedStatement stm = c.prepareStatement(wSQL);
			stm.setString(1, Mp.getFNome());
			stm.setLong(2, Mp.getFCPF());
			stm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Conexao.fecharConnection();
		return false;
	}

	// DELETE
	public Boolean deletar(MPessoa Mp) {
		FConexao = Conexao.getInstacia();
		Connection c = Conexao.conectar();
		
		try {
			String wSQL = "DELETE FROM `dbpessoa`.`tpessoa` WHERE BDCPF = ?;";
			PreparedStatement stm = c.prepareStatement(wSQL);
			stm.setLong(1, Mp.getFCPF());
			stm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Conexao.fecharConnection();
		return false;
	}

	// SELECT
	public ArrayList<MPessoa> ListPessoa() {
		ArrayList<MPessoa> ListaPessoa = new ArrayList<>();
		
		// Instacia coenexão
		FConexao = Conexao.getInstacia();
		// Conecta
		Connection c = Conexao.conectar();

		try {
			Statement stm = c.createStatement();
			String WSQL = "SELECT * FROM TPESSOA";
			ResultSet rs = stm.executeQuery(WSQL);
			
			while (rs.next()) {
				MPessoa FMPessoa = new MPessoa();
				
				FMPessoa.setFCPF(rs.getInt("BDCPF"));
				FMPessoa.setFNome(rs.getString("BDNOME"));
				
				ListaPessoa.add(FMPessoa);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		FConexao.fecharConnection();
		
		return ListaPessoa;
	}
}
