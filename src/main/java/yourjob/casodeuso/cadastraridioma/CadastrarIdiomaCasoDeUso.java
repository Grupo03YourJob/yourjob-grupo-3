package yourjob.casodeuso.cadastraridioma;

import yourjob.modelo.dao.idioma.IdiomaDAO;
import yourjob.modelo.entidade.idioma.Idioma;

public class CadastrarIdiomaCasoDeUso {

	private IdiomaDAO idiomaDAO;

	public CadastrarIdiomaCasoDeUso(IdiomaDAO idiomaDAO) {
		this.idiomaDAO = idiomaDAO;
	}

	public Idioma cadastrarIdioma(Idioma idioma) {

		return idiomaDAO.inserirIdioma(idioma);

	}

}
