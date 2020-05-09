package br.com.joaoclaudioribeiro.dao;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.joaoclaudioribeiro.model.Aluno;
import br.com.joaoclaudioribeiro.util.ConnectionFactory;

public class AlunoDAO {
	private PreparedStatement ps;
	private Connection conn;
	private ResultSet rs;
	private Aluno aluno;
	public AlunoDAO() throws Exception{
		try {
			conn = (Connection) ConnectionFactory.getConnection();			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public int create(Aluno aluno) throws Exception{
		try {
			int ex = checkCadAluno(aluno.getCpfAluno());
			if( ex == 0) {
				String sql ="INSERT INTO CAD_ALUNO (ALUNO_NOME, ALUNO_DT_NASC, ALUNO_CPF,ALUNO_EMAIL,ALUNO_END,ALUNO_MUNIC,ALUNO_UF,ALUNO_CEL) " +
						"VALUES(?,?,?,?,?,?,?,?)";
				ps = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,aluno.getNomeAluno());
				ps.setString(2,aluno.getDataNscAluno());
				ps.setString(3,aluno.getCpfAluno());
				ps.setString(4,aluno.getEmailAluno());
				ps.setString(5,aluno.getEndAluno());
				ps.setString(6,aluno.getMuniAluno());
				ps.setString(7,aluno.getUfAluno());
				ps.setString(8, aluno.getCelularAluno());
				
				ps.executeUpdate();
				
				final ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
				    ex = rs.getInt(1);
				    return ex;
				}
				
				
			}
			else {
				return ex;
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao salvar aluno" + e.getMessage());
		}
		return 0;
	}
	
	public int update(Aluno aluno) throws Exception{
		try {
			int ex = checkCadAluno(aluno.getCpfAluno());
			if( ex != 0) {
				String sql ="UPDATE CAD_ALUNO "+
							"SET ALUNO_NOME = ?, ALUNO_DT_NASC = ?,ALUNO_CPF = ?, ALUNO_EMAIL = ?,ALUNO_END = ?,ALUNO_MUNIC = ?,ALUNO_UF = ?,ALUNO_CEL = ? " +
							"WHERE ALUNO_ID = ?";
				ps = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,aluno.getNomeAluno());
				ps.setString(2,aluno.getDataNscAluno());
				ps.setString(3,aluno.getCpfAluno());
				ps.setString(4,aluno.getEmailAluno());
				ps.setString(5,aluno.getEndAluno());
				ps.setString(6,aluno.getMuniAluno());
				ps.setString(7,aluno.getUfAluno());
				ps.setString(8, aluno.getCelularAluno());
				ps.setInt(9,aluno.getAlunoId());
				ps.executeUpdate();
			
				
				return ex;
			}
			else {
				return ex;
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao salvar aluno" + e.getMessage());
		}
	}
	
	public Aluno select(int RGM) throws Exception{
		try {
			String sql = "SELECT CAD_ALUNO.ALUNO_ID, ALUNO_NOME, ALUNO_DT_NASC,ALUNO_CPF, ALUNO_EMAIL, ALUNO_END, ALUNO_MUNIC, ALUNO_UF, ALUNO_CEL FROM CAD_MATRICULA "+
					"LEFT JOIN "+
					"CAD_ALUNO ON CAD_MATRICULA.ALUNO_ID = CAD_ALUNO.ALUNO_ID "+
					"WHERE MATRICULA_ID = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,RGM);
			rs = ps.executeQuery();
			if(rs.next()) {
				aluno = new Aluno();
				aluno.setAlunoId(rs.getInt("ALUNO_ID"));
				aluno.setNomeAluno(rs.getString("ALUNO_NOME"));
				aluno.setDataNscAluno(rs.getString("ALUNO_DT_NASC"));
				aluno.setCpfAluno(rs.getString("ALUNO_CPF"));
				aluno.setEmailAluno(rs.getString("ALUNO_EMAIL"));
				aluno.setEndAluno(rs.getString("ALUNO_END"));
				aluno.setMuniAluno(rs.getString("ALUNO_MUNIC"));
				aluno.setUfAluno(rs.getString("ALUNO_UF"));
				aluno.setCelularAluno(rs.getString("ALUNO_CEL"));
			}
			return aluno;	
		}catch(Exception e) {
			throw new Exception("Erro ao consultar aluno pelo RGM \n" + e.getMessage());
		}
		
	}
	
	public void delete(int codAluno) throws Exception{
		try {
			String sql = "DELETE FROM CAD_ALUNO WHERE ALUNO_ID=?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,codAluno);
			ps.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception("Erro ao excluir Aluno" + e.getMessage());
		}
	}
	
	public int checkCadAluno(String CPF) throws Exception{
		try {
			String sql = "SELECT * FROM CAD_ALUNO WHERE ALUNO_CPF = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,CPF);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("ALUNO_Id");
				return id;
			}
			else{
				return 0;
			}
		}
		catch(Exception e) {
			throw new Exception("Erro ao Checar Cadsatro Existentes " + e.getMessage());
		}
	}
	
	public int returnId(int RGM) throws Exception {
		try {
			String sql = "SELECT CAD_ALUNO.ALUNO_ID FROM CAD_MATRICULA "+
					"LEFT JOIN "+
					"CAD_ALUNO ON CAD_MATRICULA.ALUNO_ID = CAD_ALUNO.ALUNO_ID "+
					"WHERE MATRICULA_ID = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1,RGM);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("ALUNO_ID");
				return id;
			}
			return 0;	
		}catch(Exception e) {
			throw new Exception("Erro ao consultar id do aluno pelo RGM \n" + e.getMessage());
		}
	}
}
