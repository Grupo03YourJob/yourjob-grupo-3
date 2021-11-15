package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Candidato;

public class CandidatoDAO {

	private static List<Candidato> candidatos = new ArrayList<Candidato>();

	public void criarCandidato(Candidato candidato) throws Exception {
		for (Candidato candidatoLista : candidatos) {
			if (candidato.getIdCandidato() == candidatoLista.getIdCandidato()) {
				throw new Exception("Candidate not created!");
			}
		}

		candidatos.add(candidato);
	}

	public Candidato buscarCandidato(long idCandidato) throws Exception {
		for (Candidato candidatoLista : candidatos) {
			if (candidatoLista.getIdCandidato() == idCandidato) {
				return candidatoLista;
			}
		}
		throw new Exception("Candidate not found!");
	}

	public void editarCandidato(Candidato candidatoNovo) throws Exception {
		for (int i = 0; i < candidatos.size(); i++) {
			Candidato candidatoAntigo = candidatos.get(i);
			if (candidatoAntigo.getIdCandidato() == candidatoNovo.getIdCandidato()) {
				candidatos.add(i, candidatoAntigo);
				return;
			}
		}
		throw new Exception("Candidate not updated!");
	}

	public void excluirCandidato(Candidato candidato) {
		candidatos.remove(candidato);
	}
}
