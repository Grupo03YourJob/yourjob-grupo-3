package model.bean;

public class Idioma {

	private long idIdioma;
	private String nomeIdioma;
	private String nivelIdioma;

	public Idioma(long idIdioma, String nomeIdioma, String nivelIdioma) {
		setNomeIdioma(nomeIdioma);
		setNivelIdioma(nivelIdioma);
	}

	public String getNomeIdioma() {
		return nomeIdioma;
	}

	public void setNomeIdioma(String nomeIdioma) {
		this.nomeIdioma = nomeIdioma;
	}

	public String getNivelIdioma() {
		return nivelIdioma;
	}

	public void setNivelIdioma(String nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}

	public long getIdIdioma() {
		return idIdioma;
	}

}
