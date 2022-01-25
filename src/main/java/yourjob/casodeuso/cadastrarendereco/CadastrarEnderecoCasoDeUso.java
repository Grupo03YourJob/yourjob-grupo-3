package yourjob.casodeuso.cadastrarendereco;

import yourjob.modelo.dao.endereco.EnderecoDAO;
import yourjob.modelo.entidade.endereco.Endereco;

public class CadastrarEnderecoCasoDeUso {

	private EnderecoDAO enderecoDAO;

	public CadastrarEnderecoCasoDeUso(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public Endereco cadastrarEndereco(Endereco endereco) {

		return enderecoDAO.inserirEndereco(endereco);

	}

}
