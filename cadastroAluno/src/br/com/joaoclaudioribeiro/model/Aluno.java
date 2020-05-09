package br.com.joaoclaudioribeiro.model;

public class Aluno {
	private int alunoId;
	private String nomeAluno;
	private String dataNscAluno;
	private String cpfAluno;
	private String emailAluno;
	private String endAluno;
	private String muniAluno;
	private String ufAluno;
	private String celularAluno;
	
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aluno(int alunoId, String nomeAluno, String dataNscAluno, String cpfAluno, String emailAluno,
			String endAluno, String muniAluno, String ufAluno, String celularAluno) {
		super();
		this.alunoId = alunoId;
		this.nomeAluno = nomeAluno;
		this.dataNscAluno = dataNscAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
		this.endAluno = endAluno;
		this.muniAluno = muniAluno;
		this.ufAluno = ufAluno;
		this.celularAluno = celularAluno;
	}

	public int getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(int alunoId) {
		this.alunoId = alunoId;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getDataNscAluno() {
		return dataNscAluno;
	}

	public void setDataNscAluno(String dataNscAluno) {
		this.dataNscAluno = dataNscAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getEndAluno() {
		return endAluno;
	}

	public void setEndAluno(String endAluno) {
		this.endAluno = endAluno;
	}

	public String getMuniAluno() {
		return muniAluno;
	}

	public void setMuniAluno(String muniAluno) {
		this.muniAluno = muniAluno;
	}

	public String getUfAluno() {
		return ufAluno;
	}

	public void setUfAluno(String ufAluno) {
		this.ufAluno = ufAluno;
	}

	public String getCelularAluno() {
		return celularAluno;
	}

	public void setCelularAluno(String celularAluno) {
		this.celularAluno = celularAluno;
	}
	
	
	
	
	
	
}