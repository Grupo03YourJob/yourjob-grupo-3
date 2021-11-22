package data.dao;

import java.util.List;

import model.bean.TipoTurno;
import model.bean.Vaga;

public interface VagaDAO {

	void inserirVaga(Vaga vaga);

	void deletarVaga(Vaga vaga);

	void atualizarNomeVaga(Vaga vaga, String novoNome);

	void atualizarAtividadeVaga(Vaga vaga, String novoAtividade);

	void atualizarSalarioVaga(Vaga vaga, String novoSalario);

	void atualizarRequisitoVaga(Vaga vaga, String novoRequisito);

	void atualizarTurnoVaga(Vaga vaga, TipoTurno novoTurno);

	List<Vaga> recuperarVaga();

	List<Vaga> recuperarVagaPorRecrutador(String idRecrutador);

	List<Vaga> recuperarVagaOrdenadosNomeAscendente();

	List<Vaga> recuperarVagaOrdenadosNomeDescendente();

}
