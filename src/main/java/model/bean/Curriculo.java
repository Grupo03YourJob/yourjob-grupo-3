package model.bean;

public class Curriculo {

	private long idCurriculo;
	private String idioma;
	private String idiomaNivel;
	private String objetivo;
	private String competencia;
	private Formacao formacao;
	private Experiencia experiencia;

	public Curriculo(String idioma, String idiomaNivel, String objetivo, String competencia, Formacao formacao,
			Experiencia experiencia) {
		setIdioma(idioma);
		setIdiomaNivel(idiomaNivel);
		setObjetivo(objetivo);
		setCompetencia(competencia);
		setFormacao(formacao);
		setExperiencia(experiencia);
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getIdiomaNivel() {
		return idiomaNivel;
	}

	public void setIdiomaNivel(String idiomaNivel) {
		this.idiomaNivel = idiomaNivel;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getCompetencia() {
		return competencia;
	}

	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	public long getIdCurriculo() {
		return idCurriculo;
	}

}
