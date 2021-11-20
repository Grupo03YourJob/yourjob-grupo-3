package data.dao;

import java.util.List;
import model.bean.Vaga;

public interface VagaDAO {

	void inserirVaga(Vaga vaga);

	void deletarVaga(Vaga vaga);

	void atualizarNovasVaga(Vaga vaga, String novaVaga);

	public List<Vaga> recuperarVaga();

	public List<Vaga> recuperarVagaOrdenadosNomeAscendente();

	public List<Vaga> recuperarVagaOrdenadosNomeDescendente();

}
