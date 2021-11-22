package model.bean;

import java.sql.Date;
import java.util.List;

public class Candidato extends Usuario {

	private long id;
	private Date dataNascimento;
	private Curriculo curriculo;
	private List<Vaga> vagas;

	public Candidato(String nome, String sobrenome, String senha, TipoGenero genero, Date dataNascimento,
			Curriculo curriculo, List<Vaga> vagas) {
		super(nome, sobrenome, senha, genero);
		setDataNascimento(dataNascimento);
		setCurriculo(curriculo);
		setVagas(vagas);
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

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
