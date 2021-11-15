package model.bean;

public class Usuario {

	private long idUsuario;
	private boolean tipoUsuario;
	private String nome;
	private String email;
	private String senha;
	private Endereco endereco;
	private Contato contato;
	private Candidato candidato;
	private Recrutador recrutador;

	public Usuario(boolean tipoUsuario, String nome, String email, String senha, Endereco endereco, Contato contato,
			Candidato candidato, Recrutador recrutador) {
		setTipoUsuario(tipoUsuario);
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setEndereco(endereco);
		setContato(contato);
		setCandidato(candidato);
		setRecrutador(recrutador);
	}

	public boolean isTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Recrutador getRecrutador() {
		return recrutador;
	}

	public void setRecrutador(Recrutador recrutador) {
		this.recrutador = recrutador;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

}
