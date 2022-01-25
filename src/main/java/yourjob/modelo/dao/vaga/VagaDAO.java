package yourjob.modelo.dao.vaga;

import java.util.List;

import yourjob.modelo.entidade.vaga.Vaga;
import yourjob.modelo.enumeracao.TipoTurno;

public interface VagaDAO {

	Vaga inserirVaga(Vaga Vaga);

	void deletarVaga(Vaga Vaga);

	void atualizarNomeVaga(Vaga Vaga, String novoNome);

	void atualizarAtividadeVaga(Vaga Vaga, String novoAtividade);

	void atualizarSalarioVaga(Vaga Vaga, String novSalario);

	void atualizarRequisitoVaga(Vaga Vaga, String novoRequisito);

	void atualizarTurnoVaga(Vaga Vaga, TipoTurno novoTurno);

	List<Vaga> recuperarVagas();

	List<Vaga> recuperarVagasOrdenadosNomeAscendente();

	List<Vaga> recuperarVagasOrdenadosNomeDescendente();

	List<Vaga> recuperarVagasOrdenadosAtividadeAscendente();

	List<Vaga> recuperarVagasOrdenadosAtividadeDescendente();

	List<Vaga> recuperarVagasOrdenadosSalarioAscendente();

	List<Vaga> recuperarVagasOrdenadosSalarioDescendente();

	List<Vaga> recuperarVagasOrdenadosRequisitoAscendente();

	List<Vaga> recuperarVagasOrdenadosRequisitoDescendente();

	List<Vaga> recuperarVagasOrdenadosTurnoAscendente();

	List<Vaga> recuperarVagasOrdenadosTurnoDescendente();

}