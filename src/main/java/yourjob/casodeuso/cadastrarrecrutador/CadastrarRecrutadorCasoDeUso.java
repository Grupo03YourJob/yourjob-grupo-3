package yourjob.casodeuso.cadastrarrecrutador;

import yourjob.modelo.dao.recrutador.RecrutadorDAO;
import yourjob.modelo.entidade.recrutador.Recrutador;

public class CadastrarRecrutadorCasoDeUso {

	private RecrutadorDAO recrutadorDAO;

	public CadastrarRecrutadorCasoDeUso(RecrutadorDAO recrutadorDAO) {
		this.recrutadorDAO = recrutadorDAO;
	}

	public Recrutador cadastrarRecrutador(Recrutador recrutador) {

		return recrutadorDAO.inserirRecrutador(recrutador);

	}

}
