package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Experiencia;

public class ExperienciaDAO {

	private static List<Experiencia> experiencias = new ArrayList<Experiencia>();

	public void criarExperiencia(Experiencia experiencia) throws Exception {
		for (Experiencia experienciaLista : experiencias) {
			if (experiencia.getIdExperiencia() == experienciaLista.getIdExperiencia()) {
				throw new Exception("Experience not created!");
			}
		}

		experiencias.add(experiencia);
	}

	public Experiencia buscarExperiencia(long idExperiencia) throws Exception {
		for (Experiencia experienciaLista : experiencias) {
			if (experienciaLista.getIdExperiencia() == idExperiencia) {
				return experienciaLista;
			}
		}
		throw new Exception("Experience not found!");
	}

	public void editarExperiencia(Experiencia experienciaNovo) throws Exception {
		for (int i = 0; i < experiencias.size(); i++) {
			Experiencia experienciaAntigo = experiencias.get(i);
			if (experienciaAntigo.getIdExperiencia() == experienciaNovo.getIdExperiencia()) {
				experiencias.add(i, experienciaAntigo);
				return;
			}
		}
		throw new Exception("Experience not updated!");
	}

	public void excluirCandidato(Experiencia experiencia) {
		experiencias.remove(experiencia);
	}

}
