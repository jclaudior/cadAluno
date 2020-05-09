package br.com.joaoclaudioribeiro.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.joaoclaudioribeiro.util.ConnectionFactory;
import br.com.joaoclaudioribeiro.model.Curso;
import br.com.joaoclaudioribeiro.model.Periodo;

public class CursoDAO{
	private PreparedStatement ps;
	private Connection conn;
	private ResultSet rs;
	private Curso curso;
	public CursoDAO() throws Exception{
		try {
			conn = (Connection) ConnectionFactory.getConnection();			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List selectAll( ) throws Exception{
		List<Curso> list = new ArrayList<Curso>();
		try {
			String sql = "SELECT * FROM CAD_CURSO";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int cursoId = rs.getInt("CURSO_ID");
				String cursoDesc = rs.getString("CURSO_DESC");
				list.add(new Curso(cursoId,cursoDesc));
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao consultar Cursos " + e.getMessage());
		}
		return list;
	}
	
	
	public Curso selectCurso(int cursoId) throws Exception{
		try {
			String sql = "SELECT * FROM CAD_CURSO WHERE CURSO_ID = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,cursoId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String cursoDesc = rs.getString("CURSO_DESC");
				curso = new Curso(cursoId,cursoDesc);
			}
			return curso;
		}
		catch(Exception e) {
			throw new Exception("Erro ao consultar id do Curso" + e.getMessage());
		}
	}
}
