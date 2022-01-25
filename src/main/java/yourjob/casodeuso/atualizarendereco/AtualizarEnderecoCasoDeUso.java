package yourjob.casodeuso.atualizarendereco;

import yourjob.modelo.dao.endereco.EnderecoDAO;
import yourjob.modelo.entidade.endereco.Endereco;

public class AtualizarEnderecoCasoDeUso {

	private EnderecoDAO enderecoDAO;

	public AtualizarEnderecoCasoDeUso(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}

	public Endereco atualizarRuaEndereco(Endereco endereco, String novoRua) {

		return enderecoDAO.atualizarRuaEndereco(endereco, novoRua);

	}

	public Endereco atualizarBairroEndereco(Endereco endereco, String novoBairro) {

		return enderecoDAO.atualizarBairroEndereco(endereco, novoBairro);

	}

	public Endereco atualizarNumeroEndereco(Endereco endereco, String novoNumero) {

		return enderecoDAO.atualizarNumeroEndereco(endereco, novoNumero);

	}

	public Endereco atualizarCepEndereco(Endereco endereco, String novoCep) {

		return enderecoDAO.atualizarCepEndereco(endereco, novoCep);

	}

	public Endereco atualizarCidadeEndereco(Endereco endereco, String novoCidade) {

		return enderecoDAO.atualizarCidadeEndereco(endereco, novoCidade);

	}

	public Endereco atualizarEstadoEndereco(Endereco endereco, String novoEstado) {

		return enderecoDAO.atualizarEstadoEndereco(endereco, novoEstado);

	}

	public Endereco atualizarReferenciaEndereco(Endereco endereco, String novoReferencia) {

		return enderecoDAO.atualizarReferenciaEndereco(endereco, novoReferencia);

	}

}
