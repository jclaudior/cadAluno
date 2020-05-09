package br.com.joaoclaudioribeiro.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.joaoclaudioribeiro.model.Periodo;
import br.com.joaoclaudioribeiro.util.ConnectionFactory;

public class PeriodoDAO {
	private Connection conn;
	private PreparedStatement ps;//permite executar querys
	private ResultSet rs; //tabela
	private Periodo periodo;
	
	public PeriodoDAO() throws Exception{
		try {
			conn = (Connection) ConnectionFactory.getConnection();			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public int selectIdPeriodo(String periodoDesc) throws Exception{
		try {
			String sql = "SELECT * FROM CAD_PERIODO WHERE PERIODO_DESC = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,periodoDesc);
			rs = ps.executeQuery();
			if(rs.next()) {
				int periodoId = rs.getInt("PERIODO_ID");
				return periodoId;
			}
			return 0;
		}
		catch(Exception e) {
			throw new Exception("\nErro ao consultar id Peridouuuuuuuu " + e.getMessage());
		}
	}

}
