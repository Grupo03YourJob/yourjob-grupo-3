package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Vaga;

public class VagaDAO {

	private static List<Vaga> vagas = new ArrayList<Vaga>();

	public void criarVaga(Vaga vaga) throws Exception {
		for (Vaga vagaLista : vagas) {
			if (vaga.getIdVaga() == vagaLista.getIdVaga()) {
				throw new Exception("Vacancy not created");
			}
		}

		vagas.add(vaga);
	}

	public Vaga buscarVaga(long idVaga) throws Exception {
		for (Vaga vagaLista : vagas) {
			if (vagaLista.getIdVaga() == idVaga) {
				return vagaLista;
			}
		}
		throw new Exception("Vacancy not found!");
	}

	public void editarVaga(Vaga vagaNovo) throws Exception {
		for (int i = 0; i < vagas.size(); i++) {
			Vaga vagaAntigo = vagas.get(i);
			if (vagaAntigo.getIdVaga() == vagaNovo.getIdVaga()) {
				vagas.add(i, vagaAntigo);
				return;
			}
		}
		throw new Exception("Vacancy not updated!");
	}

	public void excluirCandidato(Vaga vaga) {
		vagas.remove(vaga);
	}

}
