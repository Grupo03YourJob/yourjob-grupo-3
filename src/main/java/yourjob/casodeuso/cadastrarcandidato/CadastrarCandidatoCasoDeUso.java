package yourjob.casodeuso.cadastrarcandidato;

import yourjob.modelo.dao.candidato.CandidatoDAO;
import yourjob.modelo.entidade.candidato.Candidato;

public class CadastrarCandidatoCasoDeUso {

	private CandidatoDAO candidatoDAO;

	public CadastrarCandidatoCasoDeUso(CandidatoDAO candidatoDAO) {
		this.candidatoDAO = candidatoDAO;
	}

	public Candidato cadastrarCandidato(Candidato candidato) {

		return candidatoDAO.inserirCandidato(candidato);

	}

}
