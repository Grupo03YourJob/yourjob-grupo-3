package model.bean;

import java.util.List;

public class Recrutador extends Usuario {

	private long id;
	private String empresa;
	private String atuacao;
	private List<Vaga> vagas;

	public Recrutador(String nome, String sobrenome, String senha, TipoGenero genero, String empresa, String atuacao,
			List<Vaga> vagas) {
		super(nome, sobrenome, senha, genero);
		setEmpresa(empresa);
		setAtuacao(atuacao);
		setVagas(vagas);
	}

	public Recrutador(long id, String empresa, String atuacao) {
		setId(id);
		setEmpresa(empresa);
		setAtuacao(atuacao);
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAtuacao() {
		return atuacao;
	}

	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
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
