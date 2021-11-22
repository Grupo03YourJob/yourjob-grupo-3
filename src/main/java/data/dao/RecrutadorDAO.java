package data.dao;

import java.util.List;
import model.bean.Recrutador;

public interface RecrutadorDAO {

	void inserirRecrutador(Recrutador recrutador);

	void deletarRecrutador(Recrutador recrutador);

	void atualizarEmpresaRecrutador(Recrutador recrutador, String novoEmpresa);

	void atualizarAtuacaoRecrutador(Recrutador recrutador, String novoAtuacao);

	List<Recrutador> recuperarRecrutador();

	List<Recrutador> recuperarRecrutadorOrdenadosEmpresaAscendente();

	List<Recrutador> recuperarRecrutadorOrdenadosEmpresaDescendente();

}
