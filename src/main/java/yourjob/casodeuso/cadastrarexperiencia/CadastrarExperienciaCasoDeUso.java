package yourjob.casodeuso.cadastrarexperiencia;

import yourjob.modelo.dao.experiencia.ExperienciaDAO;
import yourjob.modelo.entidade.experiencia.Experiencia;

public class CadastrarExperienciaCasoDeUso {

	private ExperienciaDAO experienciaDAO;

	public CadastrarExperienciaCasoDeUso(ExperienciaDAO experienciaDAO) {
		this.experienciaDAO = experienciaDAO;
	}

	public Experiencia cadastrarExperiencia(Experiencia experiencia) {

		return experienciaDAO.inserirExperiencia(experiencia);

	}

}
