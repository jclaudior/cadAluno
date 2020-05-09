package br.com.joaoclaudioribeiro.model;

public class Matricula {
	private int MatriculaId;
	private int AlunoId;
	private int CursoId;
	private int CampusId;
	private int PeriodoId;
	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Matricula(int matriculaId, int alunoId, int cursoId, int campusId, int periodoId) {
		super();
		MatriculaId = matriculaId;
		AlunoId = alunoId;
		CursoId = cursoId;
		CampusId = campusId;
		PeriodoId = periodoId;
	}
	public int getMatriculaId() {
		return MatriculaId;
	}
	public void setMatriculaId(int matriculaId) {
		MatriculaId = matriculaId;
	}
	public int getAlunoId() {
		return AlunoId;
	}
	public void setAlunoId(int alunoId) {
		AlunoId = alunoId;
	}
	public int getCursoId() {
		return CursoId;
	}
	public void setCursoId(int cursoId) {
		CursoId = cursoId;
	}
	public int getCampusId() {
		return CampusId;
	}
	public void setCampusId(int campusId) {
		CampusId = campusId;
	}
	public int getPeriodoId() {
		return PeriodoId;
	}
	public void setPeriodoId(int periodoId) {
		PeriodoId = periodoId;
	}
	
	
}
