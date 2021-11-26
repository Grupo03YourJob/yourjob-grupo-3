package model.bean;

import java.util.Date;

public class Candidato extends Usuario {

	private long id;
	private Date dataNascimento;

	public Candidato(String nome, String sobrenome, String senha, TipoGenero genero, Date dataNascimento) {
		super(nome, sobrenome, senha, genero);
		setDataNascimento(dataNascimento);
	}

	public Candidato(long Id, Date dataNascimento) {
		setId(id);
		setDataNascimento(dataNascimento);
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
