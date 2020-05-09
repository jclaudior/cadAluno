package br.com.joaoclaudioribeiro.model;

public class Disciplina {
	private int disciplinaId;
	private String disciplinaDesc;
	
	
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Disciplina(int disciplinaId, String disciplinaDesc) {
		super();
		this.disciplinaId = disciplinaId;
		this.disciplinaDesc = disciplinaDesc;
	}


	public int getDisciplinaId() {
		return disciplinaId;
	}


	public void setDisciplinaId(int disciplinaId) {
		this.disciplinaId = disciplinaId;
	}


	public String getDisciplinaDesc() {
		return disciplinaDesc;
	}


	public void setDisciplinaDesc(String disciplinaDesc) {
		this.disciplinaDesc = disciplinaDesc;
	}
	
	public String toString() {
		return getDisciplinaDesc();
	}
	
	
	
}
