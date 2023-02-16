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
	public Boolean inserir(MPessoa Mp, Integer prCPF, String prNOME) {

		// Instacia coenexão
		FConexao = Conexao.getInstacia();
		// Conecta
		Connection c = Conexao.conectar();

		try {
			String WSQL = "INSERT INTO `dbpessoa`.`tpessoa` (`BDCPF`, `BDNOME`) VALUES (?,?);";
			PreparedStatement stm = c.prepareStatement(WSQL);

			stm.setInt(1, prCPF);
			stm.setString(2, prNOME);

			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FConexao.fecharConnection();
		return false;
	}

	// UPDATE
	public Boolean alterar(MPessoa p, String prCpf) {
		return false;
	}

	// DELETE
	public Boolean deletar(MPessoa c, String prCpf) {
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
//
//	public void iniConexao() {
//		// Instacia coenexão
//		FConexao = Conexao.getInstacia();
//		// Conecta
//		Connection c = Conexao.conectar();
//	}

}
