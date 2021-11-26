package data.dao;

import java.util.List;

import model.bean.Idioma;
import model.bean.TipoNivel;

public interface IdiomaDAO {

	void inserirIdioma(Idioma idioma);

	void deletarIdioma(Idioma idioma);

	void atualizarNomeIdioma(Idioma idioma, String novoNome);

	void atualizarNivelIdioma(Idioma idioma, TipoNivel novoNivel);

	List<Idioma> recuperarIdiomas();

	List<Idioma> recuperarIdiomasOrdenadosNomeAscendente();

	List<Idioma> recuperarIdiomasOrdenadosNomeDescendente();

	List<Idioma> recuperarIdiomasOrdenadosNivelAscendente();

	List<Idioma> recuperarIdiomasOrdenadosNivelDescendente();

}