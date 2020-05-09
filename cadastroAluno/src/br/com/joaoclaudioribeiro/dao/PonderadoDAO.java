package br.com.joaoclaudioribeiro.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.joaoclaudioribeiro.model.Aluno;
import br.com.joaoclaudioribeiro.model.Ponderado;
import br.com.joaoclaudioribeiro.util.ConnectionFactory;
import net.proteanit.sql.DbUtils;

public class PonderadoDAO {
	private PreparedStatement ps;
	private Connection conn;
	private ResultSet rs;
	private Ponderado ponderado;
	
	public PonderadoDAO() throws Exception{
		try {
			conn = (Connection) ConnectionFactory.getConnection();			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void create(Ponderado ponderado) throws Exception{
		try {
				String sql ="INSERT INTO CAD_PONDERADO (DISCIPLINA_ID,MATRICULA_ID,PONDERADO_NOTA,PONDERADO_FALTAS, PONDERADO_SEMEST) " +
						"VALUES(?,?,?,?,?)";
				ps = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,ponderado.getDisciplinaId());
				ps.setInt(2, ponderado.getMatriculaId());
				ps.setString(3,ponderado.getNota());
				ps.setInt(4, ponderado.getFalta());
				ps.setString(5, ponderado.getSemestre());
				
				ps.executeUpdate();
				

		}
		catch(Exception e) {
			throw new Exception("Erro ao salvar Notas e Faltas " + e.getMessage());
		}
	}
	
	public Ponderado select(int RGM, int disciplinaId) throws Exception{
		try {
			String sql = "SELECT PONDERADO_NOTA, PONDERADO_FALTAS, PONDERADO_SEMEST FROM CAD_PONDERADO "+
					"WHERE MATRICULA_ID = ? AND DISCIPLINA_ID = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,RGM);
			ps.setInt(2,disciplinaId);
			rs = ps.executeQuery();
			if(rs.next()) {
				ponderado = new Ponderado();
				ponderado.setDisciplinaId(disciplinaId);
				ponderado.setMatriculaId(RGM);
				ponderado.setNota(rs.getString("PONDERADO_NOTA"));
				ponderado.setFalta(rs.getInt("PONDERADO_FALTAS"));
				ponderado.setSemestre(rs.getString("PONDERADO_SEMEST"));
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar Nota e Faltas Ponderado \n"+e.getMessage());
		}
		return ponderado;
	}
	
	public void update(Ponderado ponderado) throws Exception{
		try {
			String sql ="UPDATE CAD_PONDERADO SET PONDERADO_NOTA = ?,PONDERADO_FALTAS = ?, PONDERADO_SEMEST = ? WHERE DISCIPLINA_ID = ? AND MATRICULA_ID=?";
			
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,ponderado.getNota());
			ps.setInt(2, ponderado.getFalta());
			ps.setString(3, ponderado.getSemestre());
			ps.setInt(4,ponderado.getDisciplinaId());
			ps.setInt(5, ponderado.getMatriculaId());
			ps.executeUpdate();
	
		}
		catch(Exception e) {
			throw new Exception("Erro alterar Notas e Faltas " + e.getMessage());
		}
	}
	
	public void delete(int RGM, int disciplinaId) throws Exception{
		try {
			String sql = "DELETE FROM CAD_PONDERADO WHERE MATRICULA_ID=? AND DISCIPLINA_ID =?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,RGM);
			ps.setInt(2,disciplinaId);
			ps.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception("Erro ao excluir Nota e Faltas" + e.getMessage());
		}
	}
	
	public TableModel boletim(int RGM) throws Exception{
		try {
			String sql = "SELECT " + 
					" CAD_DISCIPLINA.DISCIPLINA_DESC AS DISCIPLINA, CAD_PONDERADO.PONDERADO_NOTA AS NOTA, CAD_PONDERADO.PONDERADO_FALTAS AS FALTAS " + 
					"FROM CAD_MATRICULA " + 
					"LEFT JOIN " + 
					"CAD_ALUNO ON CAD_MATRICULA.ALUNO_ID = CAD_ALUNO.ALUNO_ID " + 
					"LEFT JOIN " + 
					"CAD_CURSO ON CAD_MATRICULA.CURSO_ID = CAD_CURSO.CURSO_ID " + 
					"LEFT JOIN " + 
					"CAD_PONDERADO ON CAD_MATRICULA.MATRICULA_ID = CAD_PONDERADO.MATRICULA_ID " + 
					"INNER JOIN " + 
					"CAD_DISCIPLINA ON CAD_DISCIPLINA.DISCIPLINA_ID =  CAD_PONDERADO.DISCIPLINA_ID " + 
					"WHERE  CAD_MATRICULA.MATRICULA_ID = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,RGM);
			rs = ps.executeQuery();
			while(rs.next()) {
				return  DbUtils.resultSetToTableModel(rs);
				
			}
			return null;
		}
		catch(Exception e) {
			throw new Exception("Erro ao listar Ponderado " + e.getMessage());
		}
	}
}
