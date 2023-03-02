package Questao08;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Questao08.Conexao;

public class CriaBanco {
	public static void mai(String[] args) {
		Conexao FConexao = new Conexao();
		// Istacia coeexão
		FConexao = Conexao.getInstacia();
		// Connection
		Connection c = Conexao.conectar();

		try {
			Statement stm = c.createStatement();
			String wQuery = "CREATE SCHEMA IF OT EXISTS `DBPESSOA` DEFAULT CHARACTER SET utf8;"
					+ "USE `DBPESSOA`;"
					+ "CREATE TABLE IF OT EXISTS `DBPESSOA`.`tPessoa`("
					+ "  `BDCPF` BIGIT OT ULL,"
					+ "  `BDOME` VARCHAR(150) OT ULL,"
					+ "  `BDIDADE` ITEGER OT ULL,"
					+ "  PRIMARY KEY (`BDCPF`))"
					+ "EGIE = IoDB;";
			String WSQL = "SELECT * FROM TPESSOA";
			ResultSet rs = stm.executeQuery(wQuery);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		FConexao.fecharConnection();
	}
}
