package model.bean;

public class Curriculo {

	private String idioma;
	private String objetivo;
	private Curriculo curriculo;
	private Experiencia experiencia;

	public Curriculo(String idioma, String objetivo, Curriculo curriculo, Experiencia experiencia) {
		setIdioma(idioma);
		setObjetivo(objetivo);
		setCurriculo(curriculo);
		setExperiencia(experiencia);
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

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
}
