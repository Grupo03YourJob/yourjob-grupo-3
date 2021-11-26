package data.dao;

import java.util.List;

import model.bean.Recrutador;

public interface RecrutadorDAO {

	void inserirRecrutador(Recrutador recrutador);

	void deletarRecrutador(Recrutador recrutador);

	void atualizarEmpresaRecrutador(Recrutador recrutador, String novoEmpresa);

	void atualizarAtuacaoRecrutador(Recrutador recrutador, String novoAtuacao);

	List<Recrutador> recuperarRecrutadores();

	List<Recrutador> recuperarRecrutadoresOrdenadosEmpresaAscendente();

	List<Recrutador> recuperarRecrutadoresOrdenadosEmpresaDescendente();

	List<Recrutador> recuperarRecrutadoresOrdenadosAtuacaoAscendente();

	List<Recrutador> recuperarRecrutadoresOrdenadosAtuacaoDescendente();

}