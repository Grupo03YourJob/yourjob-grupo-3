package model.bean;

public class Curriculo {

	private String idioma;
	private String objetivo;

	public Curriculo(String idioma, String objetivo) {
		setIdioma(idioma);
		setObjetivo(objetivo);
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

}
