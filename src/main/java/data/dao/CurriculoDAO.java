package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Curriculo;

public class CurriculoDAO {

	private static List<Curriculo> curriculos = new ArrayList<Curriculo>();

	public void criarCurriculo(Curriculo curriculo) throws Exception {
		for (Curriculo curriculoLista : curriculos) {
			if (curriculo.getIdCurriculo() == curriculoLista.getIdCurriculo()) {
				throw new Exception("Resume not created!");
			}
		}

		curriculos.add(curriculo);
	}

	public Curriculo buscarCurriculo(long idCurriculo) throws Exception {
		for (Curriculo curriculoLista : curriculos) {
			if (curriculoLista.getIdCurriculo() == idCurriculo) {
				return curriculoLista;
			}
		}
		throw new Exception("Resume not found!");
	}

	public void editarCurriculo(Curriculo curriculoNovo) throws Exception {
		for (int i = 0; i < curriculos.size(); i++) {
			Curriculo curriculoAntigo = curriculos.get(i);
			if (curriculoAntigo.getIdCurriculo() == curriculoNovo.getIdCurriculo()) {
				curriculos.add(i, curriculoAntigo);
				return;
			}
		}
		throw new Exception("Resume not updated!");
	}

	public void excluirCandidato(Curriculo curriculo) {
		curriculos.remove(curriculo);
	}

}
