package br.com.joaoclaudioribeiro.model;

public class Periodo {
	private int periodoId;
	private String periodoDesc;

	public Periodo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Periodo(int periodoId, String periodoDesc) {
		super();
		this.periodoId = periodoId;
		this.periodoDesc = periodoDesc;
	}

	public int getPeriodoId() {
		return periodoId;
	}

	public void setPeriodoId(int periodoId) {
		this.periodoId = periodoId;
	}

	public String getPeriodoDesc() {
		return periodoDesc;
	}

	public void setPeriodoDesc(String periodoDesc) {
		this.periodoDesc = periodoDesc;
	}

	
	

}
