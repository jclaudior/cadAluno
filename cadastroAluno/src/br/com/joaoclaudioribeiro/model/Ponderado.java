package br.com.joaoclaudioribeiro.model;

public class Ponderado {
	private int disciplinaId;
	private int matriculaId;
	private String nota;
	private int falta;
	private String semestre;
	
	public Ponderado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ponderado(int disciplinaId, int matriculaId, String nota, int falta, String semestre) {
		super();
		this.disciplinaId = disciplinaId;
		this.matriculaId = matriculaId;
		this.nota = nota;
		this.falta = falta;
		this.semestre = semestre;
	}

	public int getDisciplinaId() {
		return disciplinaId;
	}

	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}

	public int getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(int matriculaId) {
		this.matriculaId = matriculaId;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public int getFalta() {
		return falta;
	}

	public void setFalta(int falta) {
		this.falta = falta;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	
	
	
	
}
