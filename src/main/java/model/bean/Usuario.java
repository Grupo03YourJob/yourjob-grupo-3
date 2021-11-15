package model.bean;

import java.util.List;

public class Usuario {

	private long idUsuario;
	private boolean tipoUsuario;
	private String nomeUsuario;
	private String emailUsuario;
	private String senhaUsuario;
	private Endereco endereco;
	private Contato contato;
	private List<Candidato> candidatos;
	private List<Recrutador> recrutadores;

	public Usuario(boolean tipoUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario, Endereco endereco,
			Contato contato, List<Candidato> candidatos, List<Recrutador> recrutadores) {
		setTipoUsuario(tipoUsuario);
		setNomeUsuario(nomeUsuario);
		setEmailUsuario(emailUsuario);
		setSenhaUsuario(senhaUsuario);
		setEndereco(endereco);
		setContato(contato);
		setCandidatos(candidatos);
		setRecrutadores(recrutadores);
	}

	public boolean isTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
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

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public List<Recrutador> getRecrutadores() {
		return recrutadores;
	}

	public void setRecrutadores(List<Recrutador> recrutadores) {
		this.recrutadores = recrutadores;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

}
