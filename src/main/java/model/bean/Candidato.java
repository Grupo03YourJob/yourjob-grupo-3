package model.bean;

import java.util.List;

public class Candidato {

	private long idCandidato;
	private String sobrenomeCandidato;
	private String generoCandidato;
	private String dataNascimentoCandidato;
	private Curriculo curriculo;
	private List<Vaga> vagas;

	public Candidato(String sobrenomeCandidato, String genero, String dataNascimento, Curriculo curriculo,
			List<Vaga> vagas) {
		setSobrenomeCandidato(sobrenomeCandidato);
		setGeneroCandidato(generoCandidato);
		setDataNascimentoCandidato(dataNascimentoCandidato);
		setCurriculo(curriculo);
		setVagas(vagas);
	}

	public String getSobrenomeCandidato() {
		return sobrenomeCandidato;
	}

	public void setSobrenomeCandidato(String sobrenomeCandidato) {
		this.sobrenomeCandidato = sobrenomeCandidato;
	}

	public String getGeneroCandidato() {
		return generoCandidato;
	}

	public void setGeneroCandidato(String generoCandidato) {
		this.generoCandidato = generoCandidato;
	}

	public String getDataNascimentoCandidato() {
		return dataNascimentoCandidato;
	}

	public void setDataNascimentoCandidato(String dataNascimentoCandidato) {
		this.dataNascimentoCandidato = dataNascimentoCandidato;
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

	public long getIdCandidato() {
		return idCandidato;
	}

}
