package br.com.joaoclaudioribeiro.dao;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.joaoclaudioribeiro.model.Aluno;
import br.com.joaoclaudioribeiro.model.Matricula;
import br.com.joaoclaudioribeiro.util.ConnectionFactory;

public class MatriculaDAO {
	private PreparedStatement ps;
	private Connection conn;
	private ResultSet rs;
	private Matricula matricula;
	
	public MatriculaDAO() throws Exception{
		try {
			conn = (Connection) ConnectionFactory.getConnection();			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean create(Matricula matricula) throws Exception{
		try {
			if(checkCadMatricula(matricula.getMatriculaId())) {
				String sql ="INSERT INTO CAD_MATRICULA (MATRICULA_ID, ALUNO_ID, CURSO_ID,CAMPUS_ID,PERIODO_ID) " +
						"VALUES(?,?,?,?,?)";
				ps = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,matricula.getMatriculaId());
				ps.setInt(2,matricula.getAlunoId());
				ps.setInt(3,matricula.getCursoId());
				ps.setInt(4,matricula.getCampusId());
				ps.setInt(5,matricula.getPeriodoId());
				
				ps.executeUpdate();
				
				return true;
			}else {
				return false;
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao criar matricula \n" + e.getMessage());
		}
		
	}
	
	public boolean update(Matricula matricula) throws Exception{
		try {
			if(!checkCadMatricula(matricula.getMatriculaId())) {
				String sql ="UPDATE CAD_MATRICULA SET MATRICULA_ID = ?, ALUNO_ID = ?, CURSO_ID = ?,CAMPUS_ID = ?,PERIODO_ID = ? " +
						"WHERE MATRICULA_ID = ?";
				ps = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,matricula.getMatriculaId());
				ps.setInt(2,matricula.getAlunoId());
				ps.setInt(3,matricula.getCursoId());
				ps.setInt(4,matricula.getCampusId());
				ps.setInt(5,matricula.getPeriodoId());
				ps.setInt(6,matricula.getMatriculaId());
				ps.executeUpdate();
				
				return true;
			}else {
				return false;
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao atualizar matricula \n" + e.getMessage());
		}
		
	}
	public Matricula select(int RGM) throws Exception{
		try {
			String sql = "SELECT ALUNO_ID, CURSO_ID, CAMPUS_ID, PERIODO_ID FROM CAD_MATRICULA "+
					"WHERE MATRICULA_ID = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,RGM);
			rs = ps.executeQuery();
			if(rs.next()) {
				matricula = new Matricula();
				matricula.setMatriculaId(RGM);
				matricula.setAlunoId(rs.getInt("ALUNO_ID"));
				matricula.setCursoId(rs.getInt("CURSO_ID"));
				matricula.setCampusId(rs.getInt("CAMPUS_ID"));
				matricula.setPeriodoId(rs.getInt("PERIODO_ID"));
			
			}
			return matricula;	
		}catch(Exception e) {
			throw new Exception("Erro ao consultar matricula pelo RGM \n" + e.getMessage());
		}
		
	}
	
	public boolean checkCadMatricula(int matriculuaId) throws Exception{
		try {
			String sql = "SELECT * FROM CAD_MATRICULA WHERE MATRICULA_ID = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,matriculuaId);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false;
			}
			else{
				return true;
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao Checar Matriculas Existentes \n" + e.getMessage());
		}
	}

}
