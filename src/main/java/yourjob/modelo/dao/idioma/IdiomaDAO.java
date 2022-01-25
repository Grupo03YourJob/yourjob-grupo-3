package yourjob.modelo.dao.idioma;

import java.util.List;

import yourjob.modelo.entidade.idioma.Idioma;
import yourjob.modelo.enumeracao.TipoNivel;

public interface IdiomaDAO {

	Idioma inserirIdioma(Idioma idioma);

	void deletarIdioma(Idioma idioma);

	void atualizarNomeIdioma(Idioma idioma, String novoNome);

	void atualizarNivelIdioma(Idioma idioma, TipoNivel novoNivel);

	List<Idioma> recuperarIdiomas();

	List<Idioma> recuperarIdiomasOrdenadosNomeAscendente();

	List<Idioma> recuperarIdiomasOrdenadosNomeDescendente();

	List<Idioma> recuperarIdiomasOrdenadosNivelAscendente();

	List<Idioma> recuperarIdiomasOrdenadosNivelDescendente();

}