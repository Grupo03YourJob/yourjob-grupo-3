package yourjob.modelo.dao.recrutador;

import java.util.List;

import yourjob.modelo.entidade.recrutador.Recrutador;

public interface RecrutadorDAO {

	Recrutador inserirRecrutador(Recrutador recrutador);

	void deletarRecrutador(Recrutador recrutador);

	void atualizarEmpresaRecrutador(Recrutador recrutador, String novoEmpresa);

	void atualizarAtuacaoRecrutador(Recrutador recrutador, String novoAtuacao);

	List<Recrutador> recuperarRecrutadores();

	List<Recrutador> recuperarRecrutadoresOrdenadosEmpresaAscendente();

	List<Recrutador> recuperarRecrutadoresOrdenadosEmpresaDescendente();

	List<Recrutador> recuperarRecrutadoresOrdenadosAtuacaoAscendente();

	List<Recrutador> recuperarRecrutadoresOrdenadosAtuacaoDescendente();

	long recuperarRecrutadorUsuario(long idUsuario);

}