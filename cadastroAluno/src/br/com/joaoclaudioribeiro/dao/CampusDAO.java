package br.com.joaoclaudioribeiro.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.joaoclaudioribeiro.model.Campus;
import br.com.joaoclaudioribeiro.model.Curso;
import br.com.joaoclaudioribeiro.util.ConnectionFactory;

public class CampusDAO {
	private PreparedStatement ps;
	private Connection conn;
	private ResultSet rs;
	private Campus campus;
	public CampusDAO() throws Exception{
		try {
			conn = (Connection) ConnectionFactory.getConnection();			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List selectAll( ) throws Exception{
		List<Campus> list = new ArrayList<Campus>();
		try {
			String sql = "SELECT * FROM CAD_CAMPUS";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int campusId = rs.getInt("CAMPUS_ID");
				String campusNome = rs.getString("CAMPUS_NOME");
				list.add(new Campus(campusId,campusNome));
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao consultar Cursos " + e.getMessage());
		}
		return list;
	}
	
	public Campus selectIdCampus(String campusDesc) throws Exception{
		try {
			String sql = "SELECT * FROM CAD_CAMPUS WHERE CAMPUS_NOME = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,campusDesc);
			rs = ps.executeQuery();
			if(rs.next()) {
				int cursoId = rs.getInt("CAMPUS_ID");
				campus = new Campus(cursoId,campusDesc);
			}
			return campus;
		}
		catch(Exception e) {
			throw new Exception("Erro ao consultar id Campus" + e.getMessage());
		}
	}

}
