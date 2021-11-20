package data.dao;

import java.util.List;
import model.bean.Idioma;

public interface IdiomaDAO {

	void inserirIdioma(Idioma idioma);

	void deletarIdioma(Idioma idioma);

	void atualizarNovoIdioma(Idioma idioma, String novoIdioma);

	public List<Idioma> recuperarIdioma();

	public List<Idioma> recuperarIdiomaOrdenadosNomeAscendente();

	public List<Idioma> recuperarIdiomaOrdenadosNomeDescendente();

}
