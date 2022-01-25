package yourjob.casodeuso.cadastrarvaga;

import yourjob.modelo.dao.vaga.VagaDAO;
import yourjob.modelo.entidade.vaga.Vaga;

public class CadastrarVagaCasoDeUso {

	private VagaDAO vagaDAO;

	public CadastrarVagaCasoDeUso(VagaDAO vagaDAO) {
		this.vagaDAO = vagaDAO;
	}

	public Vaga cadastrarVaga(Vaga vaga) {

		return vagaDAO.inserirVaga(vaga);

	}

}
