package model.bean;

public class Curriculo {

	private int idCurriculo;
	private String idioma;
	private String objetivo;
	private Formacao formacao;
	private Experiencia experiencia;

	public Curriculo(String idioma, String objetivo, Formacao formacao, Experiencia experiencia) {
		setIdioma(idioma);
		setObjetivo(objetivo);
		setFormacao(formacao);
		setExperiencia(experiencia);
	}

	public int getIdCurriculo() {
		return idCurriculo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
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

}
