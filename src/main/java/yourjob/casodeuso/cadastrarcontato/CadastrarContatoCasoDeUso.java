package yourjob.casodeuso.cadastrarcontato;

import yourjob.modelo.dao.contato.ContatoDAO;
import yourjob.modelo.entidade.contato.Contato;

public class CadastrarContatoCasoDeUso {

	private ContatoDAO contatoDAO;

	public CadastrarContatoCasoDeUso(ContatoDAO contatoDAO) {
		this.contatoDAO = contatoDAO;
	}

	public Contato cadastrarContato(Contato contato) {

		return contatoDAO.inserirContato(contato);

	}

}
