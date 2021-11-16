package model.bean;

import java.util.List;

public class Recrutador extends Usuario {

	private long idRecrutador;
	private String empresaRecrutador;
	private String atuacaoEmpresaRecrutador;
	private List<Vaga> vagas;

	public Recrutador(String nomeUsuario, String sobrenomeUsuario, String emailUsuario, String senhaUsuario, Endereco endereco,
			Contato contato, String empresaRecrutador, String atuacaoEmpresaRecrutador, List<Vaga> vagas) {
		
		super(nomeUsuario,sobrenomeUsuario,emailUsuario,senhaUsuario,endereco,contato);
		setAtuacaoEmpresaRecrutador(atuacaoEmpresaRecrutador);
		setVagas(vagas);
	}

	public String getEmpresaRecrutador() {
		return empresaRecrutador;
	}

	public void setEmpresaRecrutador(String empresaRecrutador) {
		this.empresaRecrutador = empresaRecrutador;
	}

	public String getAtuacaoEmpresaRecrutador() {
		return atuacaoEmpresaRecrutador;
	}

	public void setAtuacaoEmpresaRecrutador(String atuacaoEmpresaRecrutador) {
		this.atuacaoEmpresaRecrutador = atuacaoEmpresaRecrutador;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public long getIdRecrutador() {
		return idRecrutador;
	}

}
