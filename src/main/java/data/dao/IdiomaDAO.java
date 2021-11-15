package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Idioma;

public class IdiomaDAO {

	private static List<Idioma> idiomas = new ArrayList<Idioma>();

	public void criarIdioma(Idioma idioma) throws Exception {
		for (Idioma idiomaLista : idiomas) {
			if (idioma.getIdIdioma() == idiomaLista.getIdIdioma()) {
				throw new Exception("Language not created!");
			}
		}

		idiomas.add(idioma);
	}

	public Idioma buscarIdioma(long idIdioma) throws Exception {
		for (Idioma idiomaLista : idiomas) {
			if (idiomaLista.getIdIdioma() == idIdioma) {
				return idiomaLista;
			}
		}
		throw new Exception("Language not found!");
	}

	public void editarIdioma(Idioma idiomaNovo) throws Exception {
		for (int i = 0; i < idiomas.size(); i++) {
			Idioma idiomaAntigo = idiomas.get(i);
			if (idiomaAntigo.getIdIdioma() == idiomaNovo.getIdIdioma()) {
				idiomas.add(i, idiomaAntigo);
				return;
			}
		}
		throw new Exception("Language not updated!");
	}

	public void excluirIdioma(Idioma idioma) {
		idiomas.remove(idioma);
	}

}
