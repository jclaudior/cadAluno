package br.com.joaoclaudioribeiro.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.joaoclaudioribeiro.model.Disciplina;
import br.com.joaoclaudioribeiro.util.ConnectionFactory;

public class DisciplinaDAO {
	private PreparedStatement ps;
	private Connection conn;
	private ResultSet rs;
	public DisciplinaDAO() throws Exception{
		try {
			conn = (Connection) ConnectionFactory.getConnection();			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List selectDisciplinaCurso(int cursoId) throws Exception{
		try {
			List<Disciplina> list = new ArrayList<Disciplina>();
			String sql = "SELECT CAD_DISCIPLINA.DISCIPLINA_ID AS DISCIPLINA_ID, CAD_DISCIPLINA.DISCIPLINA_DESC AS DISCIPLINA FROM CAD_DISCIPLINA_CURSO " + 
					"LEFT JOIN " + 
					"CAD_DISCIPLINA ON CAD_DISCIPLINA_CURSO.DISCIPLINA_ID = CAD_DISCIPLINA.DISCIPLINA_ID " + 
					"LEFT JOIN " + 
					"CAD_CURSO ON CAD_DISCIPLINA_CURSO.CURSO_ID = CAD_CURSO.CURSO_ID " + 
					"WHERE CAD_CURSO.CURSO_ID= ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,cursoId);
			rs = ps.executeQuery();
			while(rs.next()) {
				int disciplinaId = rs.getInt("DISCIPLINA_ID");
				String disciplinaDesc = rs.getString("DISCIPLINA");
				list.add(new Disciplina(disciplinaId,disciplinaDesc));
			}
			
			return list;
		}
		catch(Exception e) {
			throw new Exception("Erro ao consultar Disciplina " + e.getMessage());
		}
		
	}
}
