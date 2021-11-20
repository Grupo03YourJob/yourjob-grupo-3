package data.dao;

import java.util.List;
import model.bean.Recrutador;

public interface RecrutadorDAO {

	void inserirRecrutador(Recrutador recrutador);

	void deletarRecrutador(Recrutador recrutador);

	void atualizarNovoRecrutador(Recrutador recrutador, String novoRecrutador);

	public List<Recrutador> recuperarRecrutador();

	public List<Recrutador> recuperarRecrutadorOrdenadosNomeAscendente();

	public List<Recrutador> recuperarRecrutadorOrdenadosNomeDescendente();

}
