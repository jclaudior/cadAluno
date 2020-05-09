package br.com.joaoclaudioribeiro.model;

public class Campus {
	private int campusId;
	private String campusNome;

	public Campus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Campus(int campusId, String campusNome) {
		super();
		this.campusId = campusId;
		this.campusNome = campusNome;
	}

	public int getCampusId() {
		return campusId;
	}

	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}

	public String getCampusNome() {
		return campusNome;
	}

	public void setCampusNome(String campusNome) {
		this.campusNome = campusNome;
	}

	public String toString() {
		return getCampusNome();
	}
	
	

}
