package data.dao;

import java.util.List;
import model.bean.Idioma;
import model.bean.TipoNivel;

public interface IdiomaDAO {

	void inserirIdioma(Idioma idioma);

	void deletarIdioma(Idioma idioma);

	void atualizarNomeIdioma(Idioma idioma, String novoIdioma);

	void atualizarNivelIdioma(Idioma idioma, TipoNivel novoNivel);

	List<Idioma> recuperarIdioma();

	List<Idioma> recuperarIdiomaPorCurriculo(String idCurriculo);

	List<Idioma> recuperarIdiomaOrdenadosNomeAscendente();

	List<Idioma> recuperarIdiomaOrdenadosNomeDescendente();

}
