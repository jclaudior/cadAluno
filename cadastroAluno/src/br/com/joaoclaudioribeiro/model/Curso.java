package br.com.joaoclaudioribeiro.model;

public class Curso{
	private int cursoId;
	private String cursoDesc;
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int cursoId, String cursoDesc) {
		super();
		this.cursoId = cursoId;
		this.cursoDesc = cursoDesc;
	}

	public int getCursoId() {
		return cursoId;
	}

	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}

	public String getCursoDesc() {
		return cursoDesc;
	}

	public void setCursoDesc(String cursoDesc) {
		this.cursoDesc = cursoDesc;
	}

	public String toString() {
		return getCursoDesc();
	}
	
	
}
