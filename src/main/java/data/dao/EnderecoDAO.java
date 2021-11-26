package data.dao;

import java.util.List;

import model.bean.Endereco;

public interface EnderecoDAO {

	void inserirEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	void atualizarRuaEndereco(Endereco endereco, String novoRua);

	void atualizarBairroEndereco(Endereco endereco, String novoBairro);

	void atualizarNumeroEndereco(Endereco endereco, String novoNumero);

	void atualizarCepEndereco(Endereco endereco, String novoCep);

	void atualizarCidadeEndereco(Endereco endereco, String novoCidade);

	void atualizarEstadoEndereco(Endereco endereco, String novoEstado);

	void atualizarReferenciaEndereco(Endereco endereco, String novoReferencia);

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