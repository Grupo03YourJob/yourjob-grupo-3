package model.bean;

import java.util.Date;
import java.util.List;

public class Candidato extends Usuario {

	
	private Date dataNascimentoCandidato;
	private Curriculo curriculo;
	private List<Vaga> vagas;

	public Candidato(String nomeUsuario, String sobrenomeUsuario, String emailUsuario, String senhaUsuario, Endereco endereco,
			Contato contato, String genero, String dataNascimento, Curriculo curriculo,
			List<Vaga> vagas) {
		super(nomeUsuario, sobrenomeUsuario, emailUsuario,senhaUsuario,endereco,contato);
		
		setDataNascimentoCandidato(dataNascimentoCandidato);
		setCurriculo(curriculo);
		setVagas(vagas);
	}

	

	public Date getDataNascimentoCandidato() {
		return dataNascimentoCandidato;
	}

	public void setDataNascimentoCandidato(Date dataNascimentoCandidato) {
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

		
}
