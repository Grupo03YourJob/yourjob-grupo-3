package yourjob.modelo.entidade.curriculo;

import java.util.List;

import yourjob.modelo.entidade.experiencia.Experiencia;
import yourjob.modelo.entidade.formacao.Formacao;
import yourjob.modelo.entidade.idioma.Idioma;

public class Curriculo {

	private long id;
	private String objetivo;
	private String habilidade;
	private List<Formacao> formacoes;
	private List<Experiencia> experiencias;
	private List<Idioma> idiomas;

	public Curriculo(String objetivo, String habilidade, List<Formacao> formacoes, List<Experiencia> experiencias,
			List<Idioma> idiomas) {
		setObjetivo(objetivo);
		setHabilidade(habilidade);
		setFormacoes(formacoes);
		setExperiencias(experiencias);
		setIdiomas(idiomas);
	}

	public Curriculo(long id, String objetivo, String habilidade, List<Formacao> formacoes,
			List<Experiencia> experiencias, List<Idioma> idiomas) {
		setId(id);
		setObjetivo(objetivo);
		setHabilidade(habilidade);
		setFormacoes(formacoes);
		setExperiencias(experiencias);
		setIdiomas(idiomas);
	}

	public Curriculo(long id, String objetivo, String habilidade) {
		setId(id);
		setObjetivo(objetivo);
		setHabilidade(habilidade);
	}

	public List<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public List<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
