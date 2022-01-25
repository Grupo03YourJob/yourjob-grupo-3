package yourjob.casodeuso.cadastrarformacao;

import yourjob.modelo.dao.formacao.FormacaoDAO;
import yourjob.modelo.entidade.formacao.Formacao;

public class CadastrarFormacaoCasoDeUso {

	private FormacaoDAO formacaoDAO;

	public CadastrarFormacaoCasoDeUso(FormacaoDAO formacaoDAO) {
		this.formacaoDAO = formacaoDAO;
	}

	public Formacao cadastrarFormacao(Formacao formacao) {

		return formacaoDAO.inserirFormacao(formacao);

	}

}
