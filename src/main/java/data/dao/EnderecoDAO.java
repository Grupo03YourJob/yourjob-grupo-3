package data.dao;

import java.util.List;

import model.bean.Endereco;

public interface EnderecoDAO {

	void inserirEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	void atualizarRuaEndereco(Endereco endereco, String novaRua);

	void atualizarBairroEndereco(Endereco endereco, String bairro);

	void atualizarNumeroEndereco(Endereco endereco, String numero);

	void atualizarCepEndereco(Endereco endereco, String cep);

	void atualizarCidadeEndereco(Endereco endereco, String cidade);

	void atualizarEstadoEndereco(Endereco endereco, String estado);

	void atualizarReferenciaEndereco(Endereco endereco, String referencia);

	List<Endereco> recuperarEndereco();

	List<Endereco> recuperarEnderecoRuaAscendente();

	List<Endereco> recuperarEnderecoRuaDescendente();

	List<Endereco> recuperarEnderecoBairroAscendente();

	List<Endereco> recuperarEnderecoBairroDescendente();

	List<Endereco> recuperarEnderecoNumeroAscendente();

	List<Endereco> recuperarEnderecoNumeroDescendente();

	List<Endereco> recuperarEnderecoCepAscendente();

	List<Endereco> recuperarEnderecoCepDescendente();

	List<Endereco> recuperarEnderecoCidadeAscendente();

	List<Endereco> recuperarEnderecoCidadeDescendente();

	List<Endereco> recuperarEnderecoEstadoAscendente();

	List<Endereco> recuperarEnderecoEstadoDescendente();

	List<Endereco> recuperarEnderecoReferenciaAscendente();

	List<Endereco> recuperarEnderecoReferenciaDescendente();

}