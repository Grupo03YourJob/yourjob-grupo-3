package yourjob.modelo.dao.endereco;

import java.util.List;

import yourjob.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {

	Endereco inserirEndereco(Endereco endereco);

	Endereco deletarEndereco(Endereco endereco);

	Endereco atualizarRuaEndereco(Endereco endereco, String novoRua);

	Endereco atualizarBairroEndereco(Endereco endereco, String novoBairro);

	Endereco atualizarNumeroEndereco(Endereco endereco, String novoNumero);

	Endereco atualizarCepEndereco(Endereco endereco, String novoCep);

	Endereco atualizarCidadeEndereco(Endereco endereco, String novoCidade);

	Endereco atualizarEstadoEndereco(Endereco endereco, String novoEstado);

	Endereco atualizarReferenciaEndereco(Endereco endereco, String novoReferencia);

	List<Endereco> recuperarEndereco();

	List<Endereco> recuperarEnderecosOrdenadosRuaAscendente();

	List<Endereco> recuperarEnderecosOrdenadosRuaDescendente();

	List<Endereco> recuperarEnderecosOrdenadosBairroAscendente();

	List<Endereco> recuperarEnderecosOrdenadosBairroDescendente();

	List<Endereco> recuperarEnderecosOrdenadosNumeroAscendente();

	List<Endereco> recuperarEnderecosOrdenadosNumeroDescendente();

	List<Endereco> recuperarEnderecosOrdenadosCepAscendente();

	List<Endereco> recuperarEnderecosOrdenadosCepDescendente();

	List<Endereco> recuperarEnderecosOrdenadosEstadoAscendente();

	List<Endereco> recuperarEnderecosOrdenadosEstadoDescendente();

	List<Endereco> recuperarEnderecosOrdenadosReferenciaAscendente();

	List<Endereco> recuperarEnderecosOrdenadosReferenciaDescendente();

}